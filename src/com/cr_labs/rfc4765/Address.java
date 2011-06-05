package com.cr_labs.rfc4765;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Implements 4.2.7.2.1 of RFC4765, the address class, with some local
 * interpretation to overcome ambiguities in the spec. In particular, the
 * passed-in address may be any of the valid types and may also be a host name
 * that this class will attempt to resolve via DNS and then the numeric address
 * will be stored in the class in addition to the originally provided 'address'
 * value (the host name)
 * <p>
 * Valid args that resolve to an IP address include:<br />
 * <li>host.name.tlc
 * <li>www.xxx.yyy.zzz
 * <li>www.xxx.yyy.zzz/netmask
 * <li>ipv6 address
 * <li>ipv6 address/netmask
 * <li>per the RFC, the netmask may be in either /xx or /aaa.bbb.ccc.eee format
 * 
 * <p>
 * NB: The netmask is not presently tested for valid form, it is merely captured
 * and stored as presented.
 * 
 * <p>
 * <strong>Non-RFC extensions to the class:</strong><br />
 * This implementation extends the RFC by adding the Category "X_YOU" (value 10000) permitting
 * a peer to tell a federated peer that it is, itself, causing a problem or needs to adjust in some way
 * with regard to the reporting peer.
 * <p>
 * Example usage of this case would be to submit an Alert Message having a node whose
 * Address has a category of 'X_YOU', and an Action having a category of
 * X_RATE_LIMIT_BPS (and then using AdditionalData to report the new rate limit, as
 * needed by the X_RATE_LIMIT_BPS extension to the Action class). When the Category is
 * X_YOU, no further address is required, but the address field should be populated for compliance
 * with the RFC. We suggest filling the field with either an identifier for the host
 * that is being addressed (e.g. its IP address), or the constant "YOU". Recipients that can interpret the 
 * Category X_YOU should ignore the address field. Recipients that cannot interpret 
 * the Category X_YOU should ignore the entire message.
 * 
 * 
 * 
 * 
 * @author jim
 * 
 */
public class Address {

	private String		ident;
	private Category	category;
	private String 		vlanName;
	private String		vlanNum;
	private String		address;
	private String		netmask;
	private InetAddress	inetAddress;

	public static enum Category {
		UNKNOWN (0),
		ATM (1),
		EMAIL (2),
		LOTUS_NOTES	(3),
		MAC (4),
		SNA (5),
		VM (6),
		IPV4_ADDR (7),
		IPV4_ADDR_HEX (8),
		IPV4_NET (9),
		IPV4_NET_MASK (10),
		IPV6_ADDR (11),
		IPV6_ADDR_HEX (12),
		IPV6_NET (13),
		IPV6_NET_MASK (14),
		X_YOU (10000);

		private final int cat;
		Category(int cat) {
			this.cat = cat;
		}
		public int getValue() {
			return this.cat;
		}
	}


	/**
	 * Instantiate an address object and set its values.
	 * If the value passed in is a host name and the category indicates and IPV4 or IPV6 address, the name or number
	 * will be resolved to an address and the value stored in the object. If a host name cannot be resolved,
	 * an IllegalArgumentException is thrown. Note that the netmask part is NOT CHECKED for validity in this release
	 * in the case of an address/netmask.
	 * 
	 * @param ident optional:. if null, the ident will be set to the RFC-default of "0"
	 * @param address required per the RFC (and EXPANDING on it), this may be a host name, an IP address, IP address/netmask, or other permitted type. If category is an ipv4 or v6 address, it is looked up and saved in the object
	 * @param category optional type of address represented. if null, this will be set to the RFC-defined default UNKNOWN
	 * @param vlanName optional name of the Virtual LAN to which the address belongs or null if not reporting this
	 * @param vlanNum optional number of the Virtual LAN to which the address belongs or null if not reporting this
x	 * 
	 * @throws IllegalArgumentException if 'address' is not provided, or if 'category' indicates an ipv4 or ipv6 address, but 'address' is not a valid address or if an address/netmask combo cannot be parsed as expected
	 */
	public Address(String ident, String address, Category category, String vlanName, String vlanNum)
	throws IllegalArgumentException {
		if (address == null)
			throw new IllegalArgumentException("Cannot instantiate Address: 'address' is required by the RFC");

		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;

		if (category == null)
			this.category = Category.UNKNOWN;
		else
			this.category = category;

		this.vlanName = vlanName;
		this.vlanNum = vlanNum;

		// init address to default value ( then overwrite below in the case of an address/netmask ), and set netmask and inetAddress to null as they are only filled if appropriate
		this.address = address.trim();
		this.netmask = null;
		this.inetAddress = null; // is only set if _address is a host name or ip address, null otherwise

		// if this is an address or host name, try to look it up via Java's java.net.getByName() method, which accepts either string-versions of addresses, or host names
		// if the presented address cannot be encoded, then an exception will be thrown and we can reject the proffered address through our own exception
		switch (category) {
		// if it's an address + netmask (separated by a slash), parse them apart
		case IPV4_NET:
		case IPV4_NET_MASK:
		case IPV6_NET:
		case IPV6_NET_MASK:
			String[] splitAddress = address.split("/");
			if (splitAddress.length != 2)
				throw new IllegalArgumentException("Address+netmask "+address+" could not be converted to "+category);
			this.address = splitAddress[0];
			this.netmask = splitAddress[1];
			// if an address+mask were processed, fall through to convert the address into the inetAddress field
			// if it's an address without a mask, then we switch in at this point and just convert the string address/name to an address
		case IPV4_ADDR:
		case IPV4_ADDR_HEX:
		case IPV6_ADDR:
		case IPV6_ADDR_HEX:
			try {
				this.inetAddress = InetAddress.getByName(this.address);
			}
			catch (UnknownHostException uhe) {
				throw new IllegalArgumentException("Address "+address+" could not be converted to "+category+" "+uhe.getMessage());
			}
			break;
		default:
		}
	}

	/**
	 * @return the string version of the address (could be an IP address or something else) or null if none was set
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the category or the default value UNKNOWN if no category was set. Returned values may be from the RFC or our extensions
	 */
	public Category getSKCategory() {
		return category;
	}

	/**
	 * @return an RFC4765 compliant category, UNKNOWN if the category was a non-RFC X_* value, or UNKNOWN if no category was set
	 */
	public Category getRFCCategory() {
		if (category.getValue() >= Category.X_YOU.getValue())
			return Category.UNKNOWN;
		else
			return category;
	}


	/**
	 * @return the integer value for the category, whether in the RFC or an X_* extension
	 */
	public int getSKCategoryValue() {
		return category.getValue();
	}

	/**
	 * @return the integer value for the category. If the category is not in the RFC, return the value of UNKNOWN instead
	 */
	public int getRFCCategoryValue() {
		return getRFCCategory().getValue();
	}


	/**
	 * @return the ident or the default value "0" if none was set
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the inetAddress if the address is an IPV4 or IPV6 address, otherwise return null
	 */
	public InetAddress getInetAddress() {
		return inetAddress;
	}

	/**
	 * @return the netmask if one was set, or null if none was set
	 */
	public String getNetmask() {
		return netmask;
	}

	/**
	 * @return the vlanName or null if none was set
	 */
	public String getVlanName() {
		return vlanName;
	}

	/**
	 * @return the vlanNum or null if none was set
	 */
	public String getVlanNum() {
		return vlanNum;
	}


	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("\n\r[Address] ");
		result.append("ident="+ident);
		result.append(" category="+category);
		result.append(" vlanName="+vlanName);
		result.append(" vlandNum="+vlanNum);
		result.append(" address="+address);
		result.append(" netmask="+netmask);
		result.append(" inetAddress="+inetAddress);

		return result.toString();
	}
}
