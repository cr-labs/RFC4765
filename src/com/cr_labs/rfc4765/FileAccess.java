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


public class FileAccess {
	
	private UserId userid;
	private Permission[] permission;
	
	
	public static enum Permission {
		NOACCESS (0), READ (1), WRITE (2), EXECUTE (3), SEARCH (4),
		DELETE (5), EXECUTEAS (6), CHANGEPERMISSIONS (7), TAKEOWNERSHIP (8);
		private final int permissionCode;
		Permission(int p) {
			this.permissionCode = p;
		}
		public int getValue() {
			return this.permissionCode;
		}
	}

	
	/**
	 * Instantiate a FileAccess object.
	 * 
	 * @param userId REQUIRED user (or group) to which these permissions apply
	 * @param permission REQUIRED  Level of access allowed
	 * 
	 * @throws IllegalArgumentException if either userId or permission is omitted/null
	 */
	public FileAccess(UserId userId, Permission[] permission)
	throws IllegalArgumentException {
		if ((userId == null) || (permission == null))
			throw new IllegalArgumentException("Cannot instantiate FileAccess: 'userId' and 'permission' are required by the RFC");
		
		this.userid = userId;
		this.permission = permission;
	}


	/**
	 * @return the permission
	 */
	public Permission[] getPermission() {
		return permission;
	}


	/**
	 * @return the userid
	 */
	public UserId getUserid() {
		return userid;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[FileAccess] ");
		sb.append("userid="+userid);
		if (permission != null)
			for (int i = 0; i < permission.length; i++)
				sb.append(" permission["+i+"]="+permission[i]);
		return sb.toString();
	}
	
	


}
