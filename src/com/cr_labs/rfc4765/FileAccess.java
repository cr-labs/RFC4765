package com.cr_labs.rfc4765;

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
