package com.cr_labs.rfc4765;

public class ToolAlert {

	private String name;

	private String command;

	private String[] alertIdent;

	private String[] analyzerID;

	/**
	 * 
	 * @param name
	 *            REQUIRED reason for grouping the alerts together, for example,
	 *            the name of a particular tool..
	 * @param command
	 *            optional command or operation that the tool was asked to
	 *            perform, for example, a BackOrifice ping.
	 * @param alertIdent
	 *            REQUIRED list of alert identifiers that are related to this
	 *            alert.
	 * @param analyzerID
	 *            optional Because alert identifiers are only unique across the
	 *            alerts sent by a single analyzer, the optional "analyzerid"
	 *            attribute of "alertident" should be used to identify the
	 *            analyzer that a particular alert came from.
	 * 
	 * @throws IllegalArgumentException
	 *             if one or more required parameters is missing
	 */

	public ToolAlert(String name, String command, String[] alertIdent, String analyzerID[])
			throws IllegalArgumentException {
		if ((name == null) || (alertIdent == null))
			throw new IllegalArgumentException(
					"Cannot instantiate ToolAlert: 'name' and 'alertIdent' are required by the RFC");

		this.name = name;
		this.command = command;
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
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[ToolAlert] ");
		sb.append("name="+name);
		sb.append(" command="+command);
		if (alertIdent != null)
			for (int i = 0; i < alertIdent.length; i++)
				sb.append(" alertIdent["+i+"]="+alertIdent[i]);
		if (analyzerID != null)
			for (int i = 0; i < analyzerID.length; i++)
				sb.append(" analyzerID["+i+"]="+analyzerID[i]);
		return sb.toString();
	}
	
	
	
}
