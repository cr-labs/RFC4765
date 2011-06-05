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
 * Implements 7.3.1 the UserId class of RFC4765
 * @author jim
 *
 */
public class UserId {
	
	private String 	ident;
	private Type 	type;
	private String 	tty;
	private String 	name;
	private String 	number;

	
	public static enum Type {
		CURRENT_USER (0), ORIGINAL_USER (1), TARGET_USER (2), USER_PRIVS (3),
		CURRENT_GROUP(4), GROUP_PRIVS (5), OTHER_PRIVS (6);
		private final int typeCode;
		Type(int t) {
			this.typeCode = t;
		}
		public int getValue() {
			return this.typeCode;
		}
	}
	
	/**
	 * 
	 * @param ident the ident for this, or null to set the value to the RFC-specified default of "0"
	 * @param type
	 * @param tty
	 * @param name user name
	 * @param number user number
	 */
	public UserId(String ident, Type type, String tty, String name, String number) {
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;	
		if (type == null)
			this.type = Type.ORIGINAL_USER;
		else
			this.type = type;
		this.tty = tty;
		this.name = name;
		this.number = number;
	}

	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @return the tty
	 */
	public String getTty() {
		return tty;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @return the RFC integer value for the type
	 */
	public int getTypeValue() {
		return type.getValue();
	}	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[UserId] ");
		sb.append("ident="+ident);
		sb.append(" type="+type);
		sb.append(" tty="+tty);
		sb.append(" name="+name);
		sb.append(" number="+number);
		return sb.toString();
	}
	

}
