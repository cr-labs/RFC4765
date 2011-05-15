package com.challengeandresponse.rfc4765;

import org.joda.time.DateTime;

/**
 * 4.2.2.3. The OverflowAlert Class
 * 
 * The OverflowAlert carries additional information related to buffer overflow
 * attacks. It is intended to enable an analyzer to provide the details of the
 * overflow attack itself.
 * 
 * 
 * @author jim
 * 
 */
public class IDMEFMessage_OverflowAlert extends IDMEFMessage_Alert {

	private OverflowAlert overflowAlert;

	/**
	 * @param overflowAlert
	 *            REQUIRED OverflowAlert object
	 * @param messageID
	 *            optional unique identifier for the alert; see Section 3.2.9.
	 * @param analyzer
	 *            REQUIRED Identification information for the analyzer that
	 *            originated the alert
	 * @param createTime
	 *            REQUIRED time the alert was created. Of the three times that
	 *            may be provided with an Alert, this is the only one that is
	 *            required.
	 * @param classification
	 *            REQUIRED "name" of the alert, or other information allowing
	 *            the manager to determine what it is.
	 * @param detectTime
	 *            optional time the event(s) leading up to the alert was
	 *            detected. In the case of more than one event, the time the
	 *            first event was detected.
	 * @param analyzerTime
	 *            optional current time on the analyzer (see Section 6.3).
	 * @param source
	 *            optional single source of the event leading up to the alert.
	 * @param target
	 *            optional single target of the event leading up to the alert.
	 * @param assessment
	 *            optional information about the impact of the event, actions
	 *            taken by the analyzer in response to it, and the analyzer's
	 *            confidence in its evaluation.
	 * @param additionalData
	 *            optional information included by the analyzer that does not
	 *            fit into the data model.
	 * 
	 * @throws IllegalArgumentException
	 *             if a required argument is not present.
	 */
	public IDMEFMessage_OverflowAlert(OverflowAlert overflowAlert,
			String messageID, Analyzer analyzer, DateTime createTime,
			Classification classification, DateTime detectTime,
			DateTime analyzerTime, Source source, Target target,
			Assessment assessment, AdditionalData[] additionalData)
			throws IllegalArgumentException {
		super(messageID, analyzer, createTime, classification, detectTime,
				analyzerTime, source, target, assessment, additionalData);

		if (overflowAlert == null)
			throw new IllegalArgumentException(
					"Cannot instantiate IDMEFMessage_OverflowAlert: 'overflowAlert' is required by the RFC");

		this.overflowAlert = overflowAlert;
	}

	public OverflowAlert getOverflowAlert() {
		return this.overflowAlert;
	}
	
	public String toString() {
		return "\n\r[IDMEFMessage_OverflowAlert] overflowAlert="+overflowAlert+" "+super.toString();
	}


}
