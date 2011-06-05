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


import org.joda.time.DateTime;

/**
 * Implements the File class 4.2.7.6 of RFC4765
 * @author jim
 *
 */
public class File {
	
	private String 			ident;
	private Category 		category;
	private FSType 			fsType;
	private String 			fileType;
	
	private String			name;
	private String			path;
	
	private DateTime 		createTime;
	private DateTime 		modifyTime;
	private DateTime 		accessTime;
	private int				dataSize;
	private int				diskSize;
	private FileAccess[]	fileAccess;
	private Linkage[]		linkage;
	private Inode			inode;
	private Checksum[]		checksum;
	
	
	public static enum Category {
		CURRENT (0), ORIGINAL (1);
		private final int categoryCode;
		Category(int c) {
			this.categoryCode = c;
		}
		public int getValue() {
			return this.categoryCode;
		}
	}

	public static enum FSType {
		UFS (0), EFS (1), NFS (2), AFS (3), NTFS (4),
		FAT16 (5), FAT32 (6), PCFS (7), JOLIET (8), ISO9660 (9);
		private final int fstypeCode;
		FSType(int f) {
			this.fstypeCode = f;
		}
		public int getValue() {
			return this.fstypeCode;
		}
	}

	
	
	/**
	 * Instantiate a new File object per RFC 
	 * 
	 * @param ident optional ident per the RFC. If null, will be set to the RFC default "0"
	 * @param category	REQUIRED context for the information being provided.
	 * @param fsType	optional type of file system the file resides on.
	 * @param fileType	optional type of file, as a mime-type.
	 * @param name	REQUIRED The name of the file to which the alert applies, not including the path to the file.
	 * @param path REQUIRED The full path to the file, including the name.  The path name should be represented in as "universal" a manner as possible, to facilitate processing of the alert.
	 * @param createTime optional time the file was created
	 * @param modifyTime optional time the file was last modified
	 * @param accessTime optional time the file was last accessed
	 * @param dataSize optional size of the data, in bytes.
	 * @param diskSize optional physical space on disk consumed by the file, in bytes
	 * @param fileAccess	optional array of FileAccess permissions onthe file, or null. If null, an empty array will be stored and return by get() methods
	 * @param linkage		optional array of Linkage objects for the file. If null, an empty array will be stored and returned by get() methods
	 * @param inode			optional inode information for this file (relevant to Unix).
	 * @param checksum		optional array of checksum information for the file.
	 * 
	 * @throws IllegalArgumentException if the required category, name, and path are not provided
	 */
	
	public File(String ident, Category category, FSType fsType, String fileType,
			String name, String path, DateTime createTime, DateTime modifyTime, DateTime accessTime,
			int dataSize, int diskSize,
			FileAccess[] fileAccess, Linkage[] linkage, Inode inode, Checksum[] checksum)
	throws IllegalArgumentException {
		
		if (name == null)
			throw new IllegalArgumentException("Cannot instantiate File: 'name' is required by the RFC");
		if (path == null)
			throw new IllegalArgumentException("Cannot instantiate File: 'path' is required by the RFC");
		if (category == null)
			throw new IllegalArgumentException("Cannot instantiate File: 'category' is required by the RFC");
		
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;
		
		this.category = category;
		this.fsType = fsType;
		this.fileType = fileType;

		this.name = name;
		this.path = path;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.accessTime = accessTime;
		this.dataSize = dataSize;
		this.diskSize = diskSize;
		if (fileAccess == null)
			this.fileAccess = new FileAccess[0];
		else
			this.fileAccess = fileAccess;
		if (linkage == null)
			this.linkage = new Linkage[0];
		else
			this.linkage = linkage;
		this.inode = inode;
		if (checksum == null)
			this.checksum = new Checksum[0];
		else
			this.checksum = checksum;
	
	}

	
	/**
	 * @return the ident
	 */
	public String getItent() {
		return ident;
	}
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * @return the RFC integer value for the category
	 */
	public int getCategoryValue() {
		return category.getValue();
	}
	
	/**
	 * @return the fsType
	 */
	public FSType getFSType() {
		return fsType;
	}
	
	/**
	 * @return the RFC integer value for the category
	 */
	public int getFSTypeValue() {
		return fsType.getValue();
	}
	
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	
	
	
	/**
	 * @return the accessTime
	 */
	public DateTime getAccessTime() {
		return accessTime;
	}

	/**
	 * @return the checksum
	 */
	public Checksum[] getChecksum() {
		return checksum;
	}

	/**
	 * @return the createTime
	 */
	public DateTime getCreateTime() {
		return createTime;
	}

	/**
	 * @return the dataSize
	 */
	public int getDataSize() {
		return dataSize;
	}

	/**
	 * @return the diskSize
	 */
	public int getDiskSize() {
		return diskSize;
	}

	/**
	 * @return the fileAccess
	 */
	public FileAccess[] getFileAccess() {
		return fileAccess;
	}

	/**
	 * @return the inode
	 */
	public Inode getInode() {
		return inode;
	}

	/**
	 * @return the linkages
	 */
	public Linkage[] getLinkage() {
		return linkage;
	}

	/**
	 * @return the modifyTime
	 */
	public DateTime getModifyTime() {
		return modifyTime;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[File] ");
		sb.append("ident="+ident);
		sb.append(" category="+category);
		sb.append(" fsType="+fsType);
		sb.append(" fileType="+fileType);
		sb.append(" name="+name);
		sb.append(" path="+path);
		sb.append(" createTime="+createTime);
		sb.append(" modifyTime="+modifyTime);
		sb.append(" accessTime="+accessTime);
		sb.append(" dataSize="+dataSize);
		sb.append(" diskSize="+diskSize);
		sb.append(" fileAccess="+fileAccess);
		sb.append(" linkage="+linkage);
		sb.append(" inode="+inode);
		sb.append(" checksum="+checksum);
		return sb.toString();
	}

	
	
}
