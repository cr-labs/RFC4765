package com.cr_labs.rfc4765;

/*
Copyright (C) 2007-2011 by Challenge/Response LLC
Copyright (C) 2011 by Jim Youll, successor copyright holder

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Contact: jim@cr-labs.com
*/


/**
 * Implements Section 4.2.7.2. The Node Class of RFC4765
 * 
 * @author jim
 * @version 0.1
 */

public class Node {
	
	private String 		ident;
	private Category 	category;
	private String 		location;
	private String 		name;
	private Address[] 	address;

	public static enum Category {
		UNKNOWN (0),
		ADS (1),
		AFS (2),
		CODA	(3),
		DFS (4),
		DNS (5),
		HOSTS (6),
		KERBEROS (7),
		NDS (8),
		NIS (9),
		NISPLUS (10),
		NT (11),
		WFW (12);
		private final int cat;
		Category(int cat) {
			this.cat = cat;
		}
		public int getValue() {
			return this.cat;
		}
	}


	/**
	 * Instantiate a Node object and populate it.
	 * 
	 * Either name or address must be provided. If only address is provided (and name is null), the address string is copied into the 'name' field also.
	 * 
	 * @param ident	A unique identifier for the node; see Section 3.2.9. If not providing, use null and this will be set to the RFC default value "0"
	 * @param category The "domain" from which the name information was obtained, if relevant. If not setting this, use null and the field will be set to the RFC default value "UNKNOWN". See the static ENUM "Category" of this class for allowed values.
	 * @param location	The location of the equipment or null if not reporting this information.
	 * @param name		The name of the equipment. This information MUST be provided if no Address information is given.
	 * @param address	The network or hardware address of the equipment. Unless a name (above) is provided, at least one address must be specified. If not reporting address, use null and this will be set to an empty array (provided a name has been set)
	 * 
	 * @throws IllegalArgumentException if both address and name are omitted.
	 */
	public Node(String ident, Category category, String location, String name, Address[] address) 
	throws IllegalArgumentException {
		if ((name == null) && (address == null))
			throw new IllegalArgumentException("Cannot instantiate Node: the RFC requires that either name or address (or both) must be provided");
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;
		if (category == null)
			this.category = Category.UNKNOWN;
		else
			this.category = category;
		this.name = name;
		if (address == null)
			this.address = new Address[0];
		else
			this.address = address;
	}
	
	/**
	 * This is a simplified constructor that creates an RFC-compliant Address[] when given a single Address object
	 */
	public Node(String ident, Category category, String location, String name, Address address) 
	throws IllegalArgumentException {
		// create the object, using an empty string as its name (to pass muster in the constructor)
		// then replace the empty Address[] with the array
		this (ident,category,location,(String) (name != null ? name : ""),(Address[]) null);
		Address[] a = new Address[1];
		a[0] = address;
		this.address = a;
		if (this.name == "")
			this.name = null;
	}
	
	
	
	/**
	 * @return all the addresses registered, or an empty array if there are none
	 */
	public Address[] getAddress() {
		return address;
	}

	public Category getCategory() {
		return category;
	}

	/**
	 * @return the integer value encoded by the Category, per the RFC
	 */
	public int getCategoryValue() {
		return category.getValue();
	}

	public String getIdent() {
		return ident;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Node] ");
		sb.append("ident="+ident);
		sb.append(" category="+category);
		sb.append(" location="+location);
		sb.append(" name="+name);
		if (address != null)
			for (int i = 0; i < address.length; i++)
				sb.append(" address["+i+"]="+address[i]);
		return sb.toString();
	}

}
