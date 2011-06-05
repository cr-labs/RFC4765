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
 * Implements 4.2.7.6.3 the Inode class of RFC4765
 * Per the RFC:<br />
 * number, major-device, and minor-device must be given together; c-major-device and c-minor-device must be given together.<br />
 * 
 * @author jim
 *
 */

public class Inode {

	private DateTime	changeTime;
	private int			number;
	private int			majorDevice;
	private int			minorDevice;
	private int			cMajorDevice;
	private int			cMinorDevice;
	
	
	/**
	 * Instantiate an Inode object, enforcing RFC rules about data that must be present in sets.
	 * 
	 * Per the RFC:<br />
	 * number, major-device, and minor-device must be given together; c-major-device and c-minor-device must be given together.<br />
	 * 
	 * @param changeTime optional time of the last inode change, given by the st_ctime element of "struct stat".
	 * @param number optional inode number. Use -1 if not reporting this value.
	 * @param majorDevice optional major device number of the device the file resides on. Use -1 if not reporting this value.
	 * @param minorDevice optional minor device number of the device the file resides on. Use -1 if not reporting this value.
	 * @param cMajorDevice optional major device of the file itself, if it is a character special device. Use -1 if not reporting this value.
	 * @param cMinorDevice optional minor device of the file itself, if it is a character special device. Use -1 if not reporting this value.
	 * 
	 * @throws IllegalArgumentException if the above rules are not followed.
	 */

	public Inode(DateTime changeTime, int number, int majorDevice, int minorDevice, int cMajorDevice, int cMinorDevice) {
		// test for conditionally-required data
		if ( (number != -1) || (majorDevice != -1) || (minorDevice != -1))
			if ( (number == -1) || (majorDevice == -1) || (minorDevice == -1))
				throw new IllegalArgumentException("Cannot instantiate Inode: the RFC requires that 'number', 'majorDevice' and 'minorDevice' must be given together if any of them is present");		
		if ( (cMajorDevice != -1) || (cMinorDevice != -1))
			if ((cMajorDevice == -1) || (cMinorDevice == -1))
				throw new IllegalArgumentException("Cannot instantiate Inode: the RFC requires that 'cMajorDevice' and 'cMinorDevice' must be given together if any of them is present");		
		
		this.changeTime = changeTime;
		this.number = number;
		this.majorDevice = majorDevice;
		this.minorDevice = minorDevice;
		this.cMajorDevice = cMajorDevice;
		this.cMinorDevice = cMinorDevice;
	}


	/**
	 * @return the changeTime or null of none was provided
	 */
	public DateTime getChangeTime() {
		return changeTime;
	}


	/**
	 * @return the cMajorDevice or -1 if none was provided
	 */
	public int getCMajorDevice() {
		return cMajorDevice;
	}


	/**
	 * @return the CMinorDevice or -1 if none was provided
	 */
	public int getCMinorDevice() {
		return cMinorDevice;
	}


	/**
	 * @return the majorDevice or -1 if none was provided
	 */
	public int getMajorDevice() {
		return majorDevice;
	}


	/**
	 * @return the minorDevice or -1 if none was provided
	 */
	public int getMinorDevice() {
		return minorDevice;
	}


	/**
	 * @return the number or -1 if none was provided
	 */
	public int getNumber() {
		return number;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Inode] ");
		sb.append(" changeTime="+changeTime);
		sb.append(" number="+number);
		sb.append(" majorDevice="+majorDevice);
		sb.append(" minorDevice="+minorDevice);
		sb.append(" cMajorDevice="+cMajorDevice);
		sb.append(" cMinorDevice="+cMinorDevice);
		return sb.toString();
	}
	
	
	
}
