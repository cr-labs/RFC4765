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
 * 4.2.3. The Heartbeat Class
 * 
 * Analyzers use Heartbeat messages to indicate their current status to
 * managers. HeartbeatTracker are intended to be sent in a regular period, say, every
 * ten minutes or every hour. The receipt of a Heartbeat message from an
 * analyzer indicates to the manager that the analyzer is up and running; lack
 * of a Heartbeat message (or more likely, lack of some number of consecutive
 * Heartbeat messages) indicates that the analyzer or its network connection has
 * failed.
 * 
 * All managers MUST support the receipt of Heartbeat messages; however, the use
 * of these messages by analyzers is OPTIONAL. Developers of manager software
 * SHOULD permit the software to be configured on a per-analyzer basis to
 * use/not use Heartbeat messages.
 * 
 * @author jim
 * 
 */
public class IDMEFMessage_Heartbeat 
extends IDMEFMessage {

		private String 				messageID;
		private Analyzer 			analyzer;
		private DateTime 			createTime;
		private int					heartbeatInterval;
		private DateTime 			analyzerTime;
		private AdditionalData[] 	additionalData;
		
		
		/**
		 * Use null for values not being provided, or -1 for ints. Note that some fields are required per the RFC.
		 * 
		 * @param messageID optional unique identifier for the heartbeat; see Section 3.2.9.
		 * @param analyzer REQUIRED Identification information for the analyzer that originated the alert
		 * @param createTime REQUIRED time the heartbeat was created.
		 * @param analyzerTime optional current time on the analyzer (see Section 6.3).
		 * @param heartbeatInterval optional interval in seconds at which heartbeats are generated or -1 if not specifying
		 * @param additionalData optional information that does not fit into the data model.
		 * 
		 * @throws IllegalArgumentException if a required parameter is not present.
		 */
		public IDMEFMessage_Heartbeat(
				String messageID,
				Analyzer analyzer,
				DateTime createTime,
				DateTime analyzerTime,
				int heartbeatInterval,
				AdditionalData[] additionalData
				)
		throws IllegalArgumentException {
		
			// check for presence of required objects
			if ( (analyzer == null) || (createTime == null) )
				throw new IllegalArgumentException("Cannot instantiate IDMEFMessage_Heartbeat: 'analyzer' and 'createTime' are required by the RFC.");

			// bind all objects, instance <- args
			this.messageID = messageID;
			this.analyzer = analyzer;
			this.createTime = createTime;
			this.analyzerTime = analyzerTime;
			this.heartbeatInterval = heartbeatInterval;
			this.additionalData = additionalData;
		}



		/**
		 * @return the additionalData or null if none was provided
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
		 * @return the createTime
		 */
		public DateTime getCreateTime() {
			return createTime;
		}

		/**
		 * @return the analyzerTimeor null if none was provided
		 */
		public DateTime getAnalyzerTime() {
			return analyzerTime;
		}

		/**
		 * @return the heartbeat interval in seconds, or -1 if no heartbeat interval is set
		 */
		public int	getHeartbeatInterval() {
			return this.heartbeatInterval;
		}
		
		/**
		 * @return the messageID
		 */
		public String getMessageID() {
			return messageID;
		}

		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\n\r[IDMEFMessage_Heartbeat] ");
			sb.append(" messageID="+messageID);
			sb.append(" analyzer="+analyzer);
			sb.append(" createTime="+createTime);
			sb.append(" heartbeatInterval="+heartbeatInterval);
			sb.append(" analyzerTime="+analyzerTime);
			if (additionalData != null)
				for (int i = 0; i < additionalData.length; i++) 
					sb.append(" additionalData["+i+"]="+additionalData[i]);
			sb.append(super.toString());
			return sb.toString();
		}
		
		
	}
