package com.cr_labs.rfc4765;

import org.joda.time.DateTime;

/**
 * Implements IMDEF-Message type "Alert" 4.2.2 of RFC4765
 * @author jim
 * @version 0.1
 */

public class IDMEFMessage_Alert
extends IDMEFMessage {

	private String 			messageID;
	private Analyzer 		analyzer;
	private DateTime 		createTime;
	private DateTime 		detectTime;
	private DateTime 		analyzerTime;
	private Source[] 		source;
	private Target[] 		target;
	private Classification 	classification;
	private Assessment 		assessment;
	private AdditionalData[]	additionalData;


	/**
	 * then calls the full-on constructor. Use null for values not being provided. Note that some are required (per the RFC).
	 * 
	 * @param messageID optional unique identifier for the alert; see Section 3.2.9.
	 * @param analyzer REQUIRED Identification information for the analyzer that originated the alert
	 * @param createTime REQUIRED time the alert was created.  Of the three times that may be provided with an Alert, this is the only one that is required.
	 * @param classification  REQUIRED "name" of the alert, or other information allowing the manager to determine what it is.
	 * @param detectTime optional time the event(s) leading up to the alert was detected.  In the case of more than one event, the time the first event was detected.
	 * @param analyzerTime optional current time on the analyzer (see Section 6.3).
	 * @param source optional sources of the event(s) leading up to the alert.
	 * @param target optional targets of the event(s) leading up to the alert.
	 * @param assessment optional information about the impact of the event, actions taken by the analyzer in response to it, and the analyzer's confidence in its evaluation.
	 * @param additionalData optional information included by the analyzer that does not fit into the data model.
	 * 
	 * @throws IllegalArgumentException if a required argument is not present.
	 */
	public IDMEFMessage_Alert(
			String messageID,
			Analyzer analyzer,
			DateTime createTime,
			Classification classification,
			DateTime detectTime,
			DateTime analyzerTime,
			Source[] source,
			Target[] target,
			Assessment assessment,
			AdditionalData[] additionalData
	)
	throws IllegalArgumentException {
		super();

		// check for presence of required objects
		if ( (analyzer == null) || (createTime == null) || (classification == null))
			throw new IllegalArgumentException("Cannot instantiate IDMEFMessage_Alert: 'analyzer', 'createTime', and 'classification' are required by the RFC.");

		this.messageID = messageID;
		this.analyzer = analyzer;
		this.createTime = createTime;
		this.detectTime = detectTime;
		this.analyzerTime = analyzerTime;
		this.source = source;
		this.target = target;
		this.classification = classification;
		this.assessment = assessment;
		this.additionalData = additionalData;
	}



	/**
	 * A shorthand constructor that doesn't require arrays for Source and Target, but that creates these and
	 * then calls the full-on constructor. Use null for values not being provided. Note that some are required (per the RFC).
	 * 
	 * @param messageID optional unique identifier for the alert; see Section 3.2.9.
	 * @param analyzer REQUIRED Identification information for the analyzer that originated the alert
	 * @param createTime REQUIRED time the alert was created.  Of the three times that may be provided with an Alert, this is the only one that is required.
	 * @param classification  REQUIRED "name" of the alert, or other information allowing the manager to determine what it is.
	 * @param detectTime optional time the event(s) leading up to the alert was detected.  In the case of more than one event, the time the first event was detected.
	 * @param analyzerTime optional current time on the analyzer (see Section 6.3).
	 * @param source optional single source of the event leading up to the alert.
	 * @param target optional single target of the event leading up to the alert.
	 * @param assessment optional information about the impact of the event, actions taken by the analyzer in response to it, and the analyzer's confidence in its evaluation.
	 * @param additionalData optional information included by the analyzer that does not fit into the data model.
	 * 
	 * @throws IllegalArgumentException if a required argument is not present.
	 */
	public IDMEFMessage_Alert(
			String messageID,
			Analyzer analyzer,
			DateTime createTime,
			Classification classification,
			DateTime detectTime,
			DateTime analyzerTime,
			Source source,
			Target target,
			Assessment assessment,
			AdditionalData[] additionalData
	)
	throws IllegalArgumentException {
		super();

		// check for presence of required objects
		if ( (analyzer == null) || (createTime == null) || (classification == null))
			throw new IllegalArgumentException("Cannot instantiate IDMEFMessage_Alert: 'analyzer', 'createTime', and 'classification' are required by the RFC.");

		Source[] s = new Source[1];
		Target[] t = new Target[1];
		s[0] = source;
		t[0] = target;

		this.messageID = messageID;
		this.analyzer = analyzer;
		this.createTime = createTime;
		this.detectTime = detectTime;
		this.analyzerTime = analyzerTime;
		this.source = s;
		this.target = t;
		this.classification = classification;
		this.assessment = assessment;
		this.additionalData = additionalData;
	}



	/**
	 * @return the additionalData
	 */
	public AdditionalData[] getAdditionalData() {
		return additionalData;
	}

	/**
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * @return the analyzerTime
	 */
	public DateTime getAnalyzerTime() {
		return analyzerTime;
	}

	/**
	 * @return the assessment
	 */
	public Assessment getAssessment() {
		return assessment;
	}

	/**
	 * @return the classification
	 */
	public Classification getClassification() {
		return classification;
	}

	/**
	 * @return the createTime
	 */
	public DateTime getCreateTime() {
		return createTime;
	}

	/**
	 * @return the detectTime
	 */
	public DateTime getDetectTime() {
		return detectTime;
	}

	/**
	 * @return the messageID
	 */
	public String getMessageID() {
		return messageID;
	}

	/**
	 * @return the source
	 */
	public Source[] getSource() {
		return source;
	}

	/**
	 * @return the target
	 */
	public Target[] getTarget() {
		return target;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[IDMEFMessage_Alert] ");
		sb.append("messageID="+messageID);
		sb.append(" analyzer="+analyzer);
		sb.append(" createTime="+createTime);
		sb.append(" detectTime="+detectTime);
		sb.append(" analyzerTime="+analyzerTime);
		if (source != null)
			for (int i = 0; i < source.length; i++)
				sb.append(" source["+i+"]="+source[i]);
		if (target != null)
			for (int i = 0; i < target.length; i++)
				sb.append(" target["+i+"]="+target[i]);
		sb.append(" classification="+classification);
		sb.append(" assessment="+assessment);
		if (additionalData != null)
			for (int i = 0; i < additionalData.length; i++) 
				sb.append(" additionalData["+i+"]="+additionalData[i]);
		sb.append(super.toString());
		return sb.toString();
	}


}
