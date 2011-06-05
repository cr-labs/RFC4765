package com.cr_labs.rfc4765;


/**
 * Implements 4.2.7.6.2 Linkage Class of RFC4765
 * @author jim
 *
 */

public class Linkage {

	private String name;
	private String path;
	private com.cr_labs.rfc4765.File file;
	private Category category;
	
	
	public static enum Category {
		HARD_LINK (0), MOUNT_POINT (1), REPARSE_POINT (2), SHORTCUT (3), STREAM (4), SYMBOLIC_LINK (5);
		private final int categoryCode;
		Category(int c) {
			this.categoryCode = c;
		}
		public int getValue() {
			return this.categoryCode;
		}
	}
	

	/**
	 * Instantiate a Linkage object, enforcing RFC rules for required content.
	 * Either a path and name, or the file, must be provided. The RFC is not clear on this, but this
	 * class also requires that the category be set.
	 * 
	 * @param category REQUIRED type of object that the link describes
	 * @param name CONDITIONALLY REQUIRED name of the file system object, not including the path. Use null if not reporting this.
	 * @param path CONDITIONALLY REQUIRED full path to the file system object, including the name. Use null if not reporting this.
	 * @param file CONDITIONALLY REQUIRED A File element may be used in place of the name and path elements if additional information about the file is to be included.
	 * 
	 * @throws IllegalArgumentException if RFC-required content is not present 
	 */
	public Linkage (Category category, String name, String path, com.cr_labs.rfc4765.File file) {
		if ( (file == null) &&  ((path == null) || (name == null)) )
			throw new IllegalArgumentException("Cannot instantiate Linkage: the RFC requires that 'file' and/or ('path' & 'name') must be present");
		if (category == null)
			throw new IllegalArgumentException("Cannot instantiate Linkage: 'category' is required by the RFC");

		this.category = category;
		this.name = name;
		this.path = path;
		this.file = file;
	}


	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return the RFC-assigned integer value for the category
	 */
	public int getCategoryValue() {
		return category.getValue();
	}

	/**
	 * @return the file or null if none was set
	 */
	public com.cr_labs.rfc4765.File getFile() {
		return file;
	}


	/**
	 * @return the name or null if none was set
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the path or null if none was set
	 */
	public String getPath() {
		return path;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Linkage] ");
		sb.append("name="+name);
		sb.append(" path="+path);
		sb.append(" file="+file);
		sb.append(" category="+category);
		return sb.toString();
	}
	
}
