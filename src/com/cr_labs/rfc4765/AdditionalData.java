package com.cr_labs.rfc4765;

import org.joda.time.DateTime;

/**
 * Implements 4.2.4.6 the AdditionalData class of RFC4765
 * 
 * @author jim
 * 
 */

public class AdditionalData {
	private Type adType;
	private Object data;
	private String meaning;

	public static enum Type {
		BOOLEAN(0), BYTE(1), CHARACTER(2), DATE_TIME(3), INTEGER(4), NTPSTAMP(5), 
		PORTLIST(6), REAL(7), STRING(8), BYTE_STRING(9), XMLTEXT(10);

		private final int typeCode;

		Type(int t) {
			this.typeCode = t;
		}

		public int getValue() {
			return this.typeCode;
		}
	}

	/**
	 * Java doesn't really do untyped data, so we accept the passed-in data
	 * value as any Object and simply provide this along with the adType, for
	 * further interpretation later<br />
	 * Typing is enforced in this constructor as follows:<br />
	 * <li>BOOLEAN: a java Boolean object
	 * <li>BYTE: a java Byte object
	 * <li>CHARACTER: a java Character object
	 * <li>DATE_TIME: a JodaTime DateTime object
	 * <li>INTEGER: a java Integer object
	 * <li>NTPSTAMP: a String (in this release, this is not tested for NTP
	 * compliance)
	 * <li>PORTLIST: an array of Integer objects
	 * <li>REAL: a java Double object
	 * <li>STRING: a java String object
	 * <li>BYTE_STRING: an array of Byte objects
	 * <li>XMLTEXT: a java String object
	 * 
	 * @param adType
	 *            REQUIRED data type
	 * @param data
	 *            REQUIRED the actual data
	 * @param meaning
	 *            optional string describing the meaning of the element content
	 *            or null if not reporting a 'meaning'
	 * 
	 * @throws IllegalArgumentException
	 *             if the required adType and data are not both provided, or if
	 *             the provided data object is inconsistent with the stated
	 *             adType
	 */

	public AdditionalData(Type adType, Object data, String meaning)
			throws IllegalArgumentException {

		if ((adType == null) || (data == null))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: both adType and data are required");

		// test data types for consistency
		if ((adType == Type.BOOLEAN) && (!(data instanceof Boolean)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: BOOLEAN adType requires Boolean data object");
		else if ((adType == Type.BYTE) && (!(data instanceof Byte)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: BYTE adType requires Byte data object");
		else if ((adType == Type.CHARACTER) && (!(data instanceof Character)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: CHARACTER adType requires Character data object");
		else if ((adType == Type.DATE_TIME) && (!(data instanceof DateTime)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: DATE_TIME adType requires Joda DateTime data object");
		else if ((adType == Type.INTEGER) && (!(data instanceof Integer)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: INTEGER adType requires Integer data object");
		else if ((adType == Type.NTPSTAMP) && (!(data instanceof String)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: NTPSTAMP adType requires String data object (NTP formatting is not checked");
		else if ((adType == Type.PORTLIST) && (!(data instanceof Integer[])))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: PORTLIST adType requires Integer[] data object");
		else if ((adType == Type.REAL) && (!(data instanceof Double)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: REAL adType requires Double data object");
		else if ((adType == Type.STRING) && (!(data instanceof String)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: STRING adType requires String data object");
		else if ((adType == Type.BYTE_STRING) && (!(data instanceof Byte[])))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: BYTE_STRING adType requires Byte[] data object");
		else if ((adType == Type.XMLTEXT) && (!(data instanceof String)))
			throw new IllegalArgumentException(
					"Cannot instantiate AdditionalData: XMLTEXT adType requires String data object");

		this.adType = adType;
		this.data = data;
		this.meaning = meaning;
	}

	/**
	 * @return the adType
	 */
	public Type getAdType() {
		return adType;
	}

	/**
	 * @return the RFC-provided integer value for the adType
	 */
	public int getAdTypeVale() {
		return adType.getValue();
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}

	
	
	public String toString() {
		String result ="\n\r[AdditionalData] adType="+adType+" meaning="+meaning+" data=";
		
		if (data == null)
			result += "null";
		else if (adType == Type.BOOLEAN)
			result += (Boolean) data;	
		else if (adType == Type.BYTE)
			result += (Byte) data;	
		else if (adType == Type.CHARACTER)
			result += (Character) data;	
		else if (adType == Type.DATE_TIME)
			result += (DateTime) data;	
		else if (adType == Type.INTEGER)
			result += (Integer) data;	
		else if (adType == Type.NTPSTAMP)
			result += (String) data;
		else if (adType == Type.PORTLIST) {
			Integer[] ia = (Integer[]) data;
			for (int i = 0; i< ia.length; i++)
				result += i+":"+ia[i]+" ";
		}
		else if (adType == Type.REAL)
			result += (Double) data;
		else if (adType == Type.STRING)
			result += (String) data;	
		else if (adType == Type.BYTE_STRING) {
			Byte[] ba = (Byte[]) data;
			for (int i = 0; i< ba.length; i++)
				result += i+":"+ba[i]+" ";
		}
		else if (adType == Type.XMLTEXT)
			result += (String) data;

		return result;
	}

}
