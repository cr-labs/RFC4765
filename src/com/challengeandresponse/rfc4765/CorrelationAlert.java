package com.challengeandresponse.rfc4765;

public class CorrelationAlert {

	private String 		name;
	private String[] 	alertIdent;
	private String[] 	analyzerID;

	/**
	 * 
	 * @param name
	 *            REQUIRED reason for grouping the alerts together, for example, a particular correlation method
	 * @param alertIdent
	 *            REQUIRED list of alert identifiers that are related to this alert.
	 * @param analyzerID
	 *            optional Because alert identifiers are only unique across the
	 *            alerts sent by a single analyzer, the optional "analyzerid"
	 *            attribute of "alertident" should be used to identify the
	 *            analyzer that a particular alert came from.
	 * 
	 * @throws IllegalArgumentException
	 *             if one or more required parameters is missing
	 */

	public CorrelationAlert(String name, String[] alertIdent, String analyzerID[])
			throws IllegalArgumentException {
		if ((name == null) || (alertIdent == null))
			throw new IllegalArgumentException(
					"Cannot instantiate CorrelationAlert: 'name' and 'alertIdent' are required by the RFC");

		this.name = name;
		this.alertIdent = alertIdent;
		this.analyzerID = analyzerID;
	}

	/**
	 * @return the alertIdent
	 */
	public String[] getAlertIdent() {
		return alertIdent;
	}

	/**
	 * @return the analyzerID or null if there is none
	 */
	public String[] getAnalyzerID() {
		return analyzerID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[CorrelationAlert] ");
		sb.append("name="+name);
		if (alertIdent != null)
			for (int i = 0; i < alertIdent.length; i++)
				sb.append("alertIdent["+i+"]="+alertIdent[i]);
		if (analyzerID != null)
			for (int i = 0; i < analyzerID.length; i++)
				sb.append("analyzerID["+i+"]="+analyzerID[i]);
		return sb.toString();
	}
	
	
}
