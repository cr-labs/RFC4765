package com.challengeandresponse.rfc4765;

/**
 * Implements the Impact class 4.2.6.1 of RFC4765
 * 
 * @author jim
 *
 */
public class Impact {

	private Severity severity;
	private Completion completion;
	private Type type;
	
	
	/** 
	 * An estimate of the relative severity of the event.  The permitted values are shown below.  There is no default value.
	 */
	public static enum Severity {
		INFO (0), LOW (1), MEDIUM (2), HIGH (3);
		private final int severityCode;
		Severity(int s) {
			this.severityCode = s;
		}
		public int getValue() {
			return this.severityCode;
		}
	}

	
	/** 
	 * An indication of whether the analyzer believes the attempt that the event describes was successful or not.  The permitted values are shown below.  There is no default value.
	 */
	public static enum Completion {
		FAILED (0), SUCCEEDED (1);
		private final int completionCode;
		Completion(int c) {
			this.completionCode = c;
		}
		public int getValue() {
			return this.completionCode;
		}
	}
	
	
	/** 
	 * The type of attempt represented by this event, in relatively broad categories.  The permitted values are shown below.  The default value is "other".
	 * <pre>
	 *  +------+---------+--------------------------------------------------+
	 *	| Rank | Keyword | Description                                      |
   	 *	+------+---------+--------------------------------------------------+
   	 *	|    0 | admin   | Administrative privileges were attempted or obtained     |
     *	|      |         |                                                  |
   	 *	|    1 | dos     | A denial of service was attempted or completed   |
     *	|      |         |                                                  |
   	 *	|    2 | file    | An action on a file was attempted or completed   |
   	 *	|      |         |                                                  |
   	 *	|    3 | recon   | A reconnaissance probe was attempted or completed   |
   	 *	|      |         |                                                  |
   	 *	|    4 | user    | User privileges were attempted or obtained       |
   	 *	|      |         |                                                  |
   	 *	|    5 | other   | Anything not in one of the above categories      |
   	 *	+------+---------+--------------------------------------------------+
	 * </pre>
	 */
	public static enum Type {
		ADMIN (0), DOS (1), FILE (2), RECON (3), USER (4), OTHER (5);
		private final int typeCode;
		Type(int t) {
			this.typeCode = t;
		}
		public int getValue() {
			return this.typeCode;
		}
	}
	
	
	/**
	 * Instantiate and populate an Impact object.
	 * @param severity 		The Severity per the RFC, or null if severity is not reported
	 * @param completion	The reporters estimate of the success or failure of the reported event, or null if completion is not reported
	 * @param type			The type of event. Use null if not reporting and type will be set to the RFC default value of 'other'
	 */
	public Impact(Severity severity, Completion completion, Type type) {
		this.severity = severity;
		this.completion = completion;
		if (type == null)
			this.type = Type.OTHER;
		else
			this.type = type;
	}


	/**
	 * @return the completion
	 */
	public Completion getCompletion() {
		return completion;
	}

	/**
	 * @return the RFC integer value for the completion code
	 */
	public int getCompletionValue() {
		return completion.getValue();
	}

	/**
	 * @return the severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * @return the RFC integer value for the severity code
	 */
	public int getSeverityValue() {
		return severity.getValue();
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * @return the RFC integer value for the type code
	 */
	public int getTypeValue() {
		return type.getValue();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Impact] ");
		sb.append("severity="+severity);
		sb.append(" completion="+completion);
		sb.append(" type="+type);
		return sb.toString();
	}
	
	
}
