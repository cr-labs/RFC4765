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
 * Implements 4.2.7.6.4 the Checksum Class of RFC4765
 * 
 * @author jim
 *
 */

public class Checksum {

	private Algorithm algorithm;
	private String value;
	private String key;
		
	public static enum Algorithm {
		MD4 (0), MD5 (1), SHA1 (2), SHA2_256 (3), SHA2_384 (4),
		SHA2_512 (5), CRC_32 (6), HAVAL (7), TIGER (8), GOST (9);
		private final int algorithmCode;
		Algorithm(int f) {
			this.algorithmCode = f;
		}
		public int getValue() {
			return this.algorithmCode;
		}
	}

	
	/**
	 * Instantiate and populate a Checksum object.
	 * 
	 * @param algorithm REQUIRED the cryptographic algorithm used for the computation of the checksum
	 * @param value REQUIRED value of the checksum
	 * @param key OPTIONAL key to the checksum, if appropriate
	 * 
	 * @throws IllegalArgumentException if the required algorithm or value parameters are not both provided
	 */
	public Checksum(Algorithm algorithm, String value, String key)
	throws IllegalArgumentException {
		if ( (algorithm == null) || (value == null))
			throw new IllegalArgumentException("Both algorithm and value are required");
		this.algorithm = algorithm;
		this.value = value;
		this.key = key;
	}


	/**
	 * @return the algorithm
	 */
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * @return the RFC-defined integer value for the algorithm
	 */
	public int getAlgorithmValue() {
		return algorithm.getValue();
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Checksum] ");
		sb.append("algorithm="+algorithm);
		sb.append(" value="+value);
		sb.append(" key="+key);
		return sb.toString();
	}
	
	
}
