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



/**
 * Implements Section 4.2.4.1 Analyzer Class of RFC4765
 * @author jim
 * @version 0.1
 */

public class Analyzer {
	private String analyzerID;
	private String name;
	private String manufacturer;
	private String model;
	private String version;
	private String aclass;
	private String ostype;
	private String osversion;
	
	private com.cr_labs.rfc4765.Node node;
	private com.cr_labs.rfc4765.Process process;
	private Analyzer originalAnalyzer;
	
	
	/**
	 * Instantiate an Analyzer object and set all its values
	 * @param analyzerID	Optional but for interop with Challenge Response tools, this is strongly encouraged and is ideally the protocol-dependent contact address of the Analyzer. RFC says: Unique identifier for the analyzer; see Section 3.2.9., use null if there is none and this will be set to the RFC default value "0"
	 * @param name			Optional explicit name for the analyzer that may be easier to understand than the analyzerid, use null if there is none
	 * @param manufacturer	Optional manufacturer of the analyzer software and/or hardware, use null if there is none
	 * @param model			Optional model name/number of the analyzer software and/or hardware.
	 * @param version		Optional version number of the analyzer software and/or hardware.
	 * @param aclass		Optional class of analyzer software and/or hardware.
	 * @param ostype		Optional Operating system name.  On POSIX 1003.1 compliant systems, this is the value returned in utsname.sysname by the uname() system call, or the output of the "uname -s" command.
	 * @param osversion		Optional Operating system version.  On POSIX 1003.1 compliant systems, this is the value returned in utsname.release by the uname() system call, or the output of the "uname -r" command.
	 * @param node			Optional Information about the host or device on which the analyzer resides (network address, network name, etc.) or null if not reporting this information
	 * @param process		Optional Information about the process in which the analyzer is executing, or null if not reporting this information.
	 * @param originalAnalyzer Optional Information about the analyzer from which the message may have gone through.  The idea behind this mechanism is that when a manager receives an alert and wants to forward it to another analyzer, it needs to substitute the original analyzer information with its own.  To preserve the original analyzer information, it may be included in the new analyzer definition. This will allow analyzer path tracking. Use null if there is no antecedent analyzer to pass forward or if not reporting.
	 */
	public Analyzer(String analyzerID, String name, String manufacturer, String model, String version, 
			String aclass, String ostype, String osversion, Node node, Process process, Analyzer originalAnalyzer) {
		if (analyzerID == null)
			this.analyzerID = "0";
		else
			this.analyzerID = analyzerID;
		this.name = name;
		this.manufacturer = manufacturer;
		this.model = model;
		this.version = version;
		this.aclass = aclass;
		this.ostype = ostype;
		this.osversion = osversion;
		this.node = node;
		this.process = process;
		this.originalAnalyzer = originalAnalyzer;
	}



	/**
	 * @return the aclass or null if there is none
	 */
	public String getAclass() {
		return aclass;
	}

	/**
	 * @return the analyzerID
	 */
	public String getAnalyzerID() {
		return analyzerID;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the ostype
	 */
	public String getOstype() {
		return ostype;
	}

	/**
	 * @return the osversion
	 */
	public String getOsversion() {
		return osversion;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the original analyzer or null if there is none
	 */
	public Analyzer getOriginalAnalyzer() {
		return originalAnalyzer;
	}

	/**
	 * @return the node or null if there is none
	 */
	public com.cr_labs.rfc4765.Node getNode() {
		return node;
	}

	/**
	 * @return the process or null if there is none
	 */
	public com.cr_labs.rfc4765.Process getProcess() {
		return process;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\r[Analyzer] ");
		sb.append("analyzerID="+analyzerID);
		sb.append(" name="+name);
		sb.append(" manufacturer="+manufacturer);
		sb.append(" model="+model);
		sb.append(" version="+version);
		sb.append(" aclass="+aclass);
		sb.append(" ostype="+ostype);
		sb.append(" osversion="+osversion);
		sb.append(" node="+node);
		sb.append(" process="+process);
		sb.append("original analyzer="+originalAnalyzer);
		return sb.toString();
	}
	

}
