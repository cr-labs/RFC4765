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
 * Implements the Service class 4.2.7.5 of RFC4765
 * 
 * @author jim
 *
 */
public class Service {
	
	private String 	ident;
	private int 	ipVersion;
	private int 	ianaProtocolNumber;
	private String 	ianaProtocolName;
	
	private String 	name;
	private int 	port;
	private String 	portlist;
	private String 	protocol;
	
	
	/**
	 * Use null for unused values (or 0 for ints). If ident is null, it will be set to the TFC default value "0"
	 * @param ident
	 * @param ipVersion
	 * @param ianaProtocolNumber
	 * @param ianaProtocolName
	 * @param name
	 * @param port
	 * @param portlist
	 * @param protocol
	 */
	
	public Service(String ident, int ipVersion, int ianaProtocolNumber, String ianaProtocolName,
			String name, int port, String portlist, String protocol) {
		
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;
		this.ipVersion = ipVersion;
		this.ianaProtocolNumber = ianaProtocolNumber;
		this.ianaProtocolName = ianaProtocolName;
		this.name = name;
		this.port = port;
		this.portlist = portlist;
		this.protocol = protocol;
	}


	/**
	 * @return the ianaProtocolName
	 */
	public String getIanaProtocolName() {
		return ianaProtocolName;
	}

	/**
	 * @return the ianaProtocolNumber
	 */
	public int getIanaProtocolNumber() {
		return ianaProtocolNumber;
	}

	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the ipVersion
	 */
	public int getIpVersion() {
		return ipVersion;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}


	/**
	 * @return the portlist
	 */
	public String getPortlist() {
		return portlist;
	}


	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Service] ");
		sb.append("ident="+ident);
		sb.append(" ipVersion="+ipVersion);
		sb.append(" ianaProtocolNumber="+ianaProtocolNumber);
		sb.append(" ianaProtocolName="+ianaProtocolName);
		sb.append(" name="+name);
		sb.append(" port="+port);
		sb.append(" portlist="+portlist);
		sb.append(" protocol="+protocol);
		return sb.toString();
	}
	


}
