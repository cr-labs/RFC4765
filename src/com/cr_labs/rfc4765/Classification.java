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
 * Implements 4.2.4.2 the Classification class of RFC4765.
 * 
 * The Classification class provides the "name" of an alert, or other
 * information allowing the manager to determine what it is. This name is chosen
 * by the alert provider.
 * 
 * @author jim
 * 
 */
public class Classification {
	private String ident;
	private String text; 
	
	private Reference[] reference;
	
	
	/**
	 * Instantiate and populate a Classification object.
	 * 
	 * @param ident optional unique identifier for this classification. Use null and the default value "0" will be set.
	 * @param text  REQUIRED text identifying the Alert message.
	 * @param reference zero or more information about the message printing to external documentation sites that will provide background information about the alert. If not providing this information, use null and an empty array will be created.
	 * 
	 * @throws IllegalArgumentException if the required text field is null
	 */
	public Classification(String ident, String text, Reference[] reference)
	throws IllegalArgumentException {
		if (text == null)
			throw new IllegalArgumentException("Cannot instantiate Classification: 'text' is required by the RFC");
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;
		this.ident = ident;
		this.text = text;
		if (reference == null)
			this.reference = new Reference[0];
		else
			this.reference = reference;
	}

	/**
	 * @return the ident or the default value "0" if there is none
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the reference records, if any, or an empty array if there are none
	 */
	public Reference[] getReference() {
		return reference;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Classification] ");
		sb.append("ident="+ident+" text="+text);
		if (reference != null)
			for (int i = 0; i < reference.length; i++) 
				sb.append(" reference["+i+"]="+reference[i]);
		return sb.toString();
	}
	
	
	
}
