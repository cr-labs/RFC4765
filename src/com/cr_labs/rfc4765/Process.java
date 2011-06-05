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
 * Implements 4.2.7.4 the Process Class of RFC4765.
 * 
 * @author jim
 *
 */
public class Process {

	private String 		ident;
	private String 		name;
	private int 		pid;
	private String 		path;
	private String[] 	arg;
	private String[] 	env;

	
	/**
	 * Instantiate a Process object and set everything
	 * 
	 * @param ident A unique identifier for the process; see Section 3.2.9. If there is none, pass in null and the value will be set to the RFC default value "0", or just pass in "0".
	 * @param name REQUIRED. The name of the program being executed. This is a short name; path and argument information are provided elsewhere.
	 * @param pid The process identifier of the process.
	 * @param path The full path of the program being executed or null if none is provided.
	 * @param arg A command-line argument to the program. This is an array because per the RFC, multiple arguments may be specified (they are assumed to have occurred in the same order they are provided). If there are no args, use either an empty array or null.
	 * @param env An environment string associated with the process; generally of the format "VARIABLE=value". This is an array because per the RFC, multiple environment strings may be specified. If there are no env variables, use either an empty array or null.
	 */
	public Process(String ident, String name, int pid, String path, String arg[], String env[]) 
	throws IllegalArgumentException {
		if (name == null)
			throw new IllegalArgumentException("Cannot instantiate Process: 'name' is required by the RFC");
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;
		this.name = name;
		this.pid = pid;
		this.path = path;
		if (this.arg == null)
			this.arg = new String[0];
		else
			this.arg = arg;
		if (this.env == null)
			this.env = new String[0];
		else
			this.env = env;
	}



	/**
	 * @return the arg entries or an empty array if there are none
	 */
	public String[] getArg() {
		return arg;
	}



	/**
	 * @return the env entries or an empty array if there are none
	 */
	public String[] getEnv() {
		return env;
	}

	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the path or null if there is none
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Process] ");
		sb.append("ident="+ident);
		sb.append(" name="+name);
		sb.append(" pid="+pid);
		sb.append(" path="+path);
		if (arg != null)
			for (int i = 0; i < arg.length; i++)
				sb.append(" arg["+i+"]="+arg[i]);
		if (env != null)
			for (int i = 0; i < env.length; i++)
				sb.append(" env["+i+"]="+env[i]);
		return sb.toString();
	}
	
}
