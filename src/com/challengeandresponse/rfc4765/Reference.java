package com.challengeandresponse.rfc4765;

import java.net.URL;

/**
 * Implements the Reference Class 4.2.7.1 of RFC4765
 * 
 * @author jim
 *
 */
public class Reference {
	private Origin origin;
	private String meaning;
	private String name;
	private URL url;
	
	
	public static enum Origin {
		UNKNOWN (0), VENDOR_SPECIFIC (1), USER_SPECIFIC (2), BUGTRAQID (3), CVE (4), OSVDB (5);
		private final int originCode;
		Origin(int o) {
			this.originCode = o;
		}
		public int getValue() {
			return this.originCode;
		}
	}

	
	/**
	 * Instantiate and populate a Reference object.
	 * 
	 * @param origin REQUIRED source from which the name of the alert originates.
	 * @param meaning optional meaning of the reference, as understood by the alert provider
	 * @param name REQUIRED  name of the alert, from one of the origins listed below.
	 * @param url REQUIRED URL at which the manager (or the human operator of the manager) can find additional information about the alert.
	 * 
	 * @throws IllegalArgumentException if the required name, origin or URL are not provided
	 */
	public Reference(Origin origin, String meaning, String name, URL url)
	throws IllegalArgumentException {
		if ( (origin == null) || (meaning == null) || (url == null))
			throw new IllegalArgumentException("Cannot instantiate Reference: 'origin', 'meaning' and 'url' are required by the RFC");
		
		this.origin = origin;
		this.meaning = meaning;
		this.name = name;
		this.url = url;
	}


	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the origin
	 */
	public Origin getOrigin() {
		return origin;
	}

	/**
	 * @return the RFC integer value of the origin code
	 */
	public int getOriginValue() {
		return origin.getValue();
	}

	/**
	 * @return the _url
	 */
	public URL getUrl() {
		return url;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Reference] ");
		sb.append("origin="+origin);
		sb.append(" meaning="+meaning);
		sb.append(" name="+name);
		sb.append(" url="+url);
		return sb.toString();
	}
	
	
}

