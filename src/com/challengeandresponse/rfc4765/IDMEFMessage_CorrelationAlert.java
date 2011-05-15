package com.challengeandresponse.rfc4765;

import org.joda.time.DateTime;

/**
 * 4.2.2.2. The CorrelationAlert Class
 * 
 * The CorrelationAlert class carries additional information related to the
 * correlation of alert information. It is intended to group one or more
 * previously-sent alerts together, to say "these alerts are all related".
 * 
 * @author jim
 * 
 */
public class IDMEFMessage_CorrelationAlert extends IDMEFMessage_Alert {

	private CorrelationAlert correlationAlert;

	/**
	 * @param correlationAlert
	 *            REQUIRED CorrelationAlert object
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
	public IDMEFMessage_CorrelationAlert(
			CorrelationAlert correlationAlert,
			String messageID,
			Analyzer analyzer, 
			DateTime createTime,
			Classification classification, 
			DateTime detectTime,
			DateTime analyzerTime, 
			Source source,
			Target target,
			Assessment assessment, 
			AdditionalData[] additionalData)
		throws IllegalArgumentException {
		
		super(messageID, analyzer, createTime, classification, detectTime, analyzerTime, source, target, assessment, additionalData);

		if (correlationAlert == null)
			throw new IllegalArgumentException("Cannot instantiate IDMEFMessage_CorrelationAlert: 'correlationAlert' is required by the RFC");

		this.correlationAlert = correlationAlert;
	}

	public CorrelationAlert getCorrelationAlert() {
		return this.correlationAlert;
	}

	public String toString() {
		return "\n\r[IDMEFMessage_CorrelationAlert] correlationAlert="+correlationAlert+" "+super.toString();
	}
	
}
