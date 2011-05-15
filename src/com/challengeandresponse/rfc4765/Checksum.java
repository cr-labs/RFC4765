package com.challengeandresponse.rfc4765;

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
