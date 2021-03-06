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


import java.util.Vector;

/**
 * Implements the User class per RFC4765 Section 4.2.7.3:<br />
 * The User class is used to describe users.  It is primarily used as a "container" class for the UserId aggregate class
 * 
 * @author jim
 */
public class User {
	
	private String 		ident;
	private Category 	category;
	private Vector <UserId> userid;

	/**
	 * Categories per RFC:<br />
	 * UNKNOWN -- unknown<br />
	 * APPLICATION -- An application user<br />
	 * OS-DEVICE -- An operating system or device user<br />
	 * 
	 * @author jim
	 */
	public static enum Category {
		UNKNOWN (0), APPLICATION (1), OS_DEVICE (2);
		private final int categoryCode;
		Category(int c) {
			this.categoryCode = c;
		}
		public int getValue() {
			return this.categoryCode;
		}
	}
	
	/**
	 * @param ident the ident for this, or null to set the value to the RFC-specified default of "0"
	 * @param category
	 * @param userid a Vector of UserIDs. Check the other constructor for use with single user IDs.
	 * @throws IllegalArgumentException if the required UsedId is not provided
	 */
	public User(String ident, Category category, Vector<UserId> userid)
	throws IllegalArgumentException {
		if (userid == null)
			throw new IllegalArgumentException("Cannot instantiate User: 'userid' is required by the RFC");
		this.userid = userid;

		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;	
		if (category == null)
			this.category = Category.UNKNOWN;
		else
			this.category = category;
	}

	/**
	 * Convenience constructor for cases where there's just a single userid in a User record.
	 * @param ident the ident for this, or null to set the value to the RFC-specified default of "0"
	 * @param category
	 * @param userid a single userId. This constructor builds the requisite vector and adds this userId to it.
	 * @throws IllegalArgumentException if the required UsedId is not provided
	 */
	public User(String ident, Category category, UserId userid)
	throws IllegalArgumentException {
		this(ident,category, new Vector<UserId>());
		this.userid.add(userid);
	}
	
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return the RFC defined integer value for the category
	 */
	public int getCategoryValue() {
		return category.getValue();
	}
	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the userid
	 */
	public Vector<UserId> getUserids() {
		return userid;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[User] ");
		sb.append("ident="+ident);
		sb.append(" category="+category);
		if (userid != null)
			for (UserId u : userid) 
				sb.append(" userid="+u);
		return sb.toString();
	}

	
	

}
