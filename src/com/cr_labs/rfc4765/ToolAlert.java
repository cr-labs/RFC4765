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
