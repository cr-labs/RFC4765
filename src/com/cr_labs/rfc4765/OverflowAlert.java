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


public class OverflowAlert {

	private String program;

	private int size;

	private byte[] buffer;

	/**
	 * 
	 * @param program
	 *            REQUIRED the program that the overflow attack attempted to run
	 *            (NOTE: this is not the program that was attacked).
	 * @param size
	 *            optional size, in bytes, of the overflow (i.e., the number of
	 *            bytes the attacker sent), or -1 of not providing this info
	 * @param buffer
	 *            optional Some or all of the overflow data itself (dependent on
	 *            how much the analyzer can capture), or null if not providing
	 *            this info
	 * @throws IllegalArgumentException
	 *             if one or more required parameters is missing
	 */

	public OverflowAlert(String program, int size, byte[] buffer)
			throws IllegalArgumentException {
		if (program == null)
			throw new IllegalArgumentException(
					"Cannot instantiate OverflowAlert: 'program' is required by the RFC");

		this.program = program;
		this.size = size;
		this.buffer = buffer;
	}

	/**
	 * @return the buffer = some or all of the overflow data itself, or null if
	 *         this information was not provided
	 */
	public byte[] getBuffer() {
		return buffer;
	}

	/**
	 * @return the program that the overflow attack attempted to run (NOT the
	 *         program that was attacked)
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @return the size, in bytes, of the overflow, or -1 if this information is
	 *         not provided
	 */
	public int getSize() {
		return size;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[OverflowAlert] ");
		sb.append("program="+program);
		sb.append(" size="+size);
		sb.append(" buffer=");
		if (buffer != null)
			for (int i = 0; i < buffer.length; i++)
				sb.append(buffer[i]);
		return sb.toString();
	}
	
	
}
