package com.cr_labs.rfc4765;

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
public class IDMEFMessage_ToolAlert extends IDMEFMessage_Alert {

	private ToolAlert toolAlert;

	/**
	 * @param toolAlert
	 *            REQUIRED ToolAlert object
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
	public IDMEFMessage_ToolAlert(ToolAlert toolAlert,
			String messageID, Analyzer analyzer, DateTime createTime,
			Classification classification, DateTime detectTime,
			DateTime analyzerTime, Source source, Target target,
			Assessment assessment, AdditionalData[] additionalData)
			throws IllegalArgumentException {
		super(messageID, analyzer, createTime, classification, detectTime,
				analyzerTime, source, target, assessment, additionalData);

		if (toolAlert == null)
			throw new IllegalArgumentException(
					"Cannot instantiate IDMEFMessage_ToolAlert: 'toolAlert' is required by the RFC");

		this.toolAlert = toolAlert;
	}

	public ToolAlert getToolAlert() {
		return this.toolAlert;
	}

	public String toString() {
		return "\n\r[IDMEFMessage_ToolAlert] toolAlert="+toolAlert+" "+super.toString();
	}

}
