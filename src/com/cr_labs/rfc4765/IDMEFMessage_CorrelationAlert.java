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
