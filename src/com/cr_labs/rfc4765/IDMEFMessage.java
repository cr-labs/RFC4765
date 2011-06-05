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
 * Implements the IDMEF-Message base class, 4.2.1 of RFC4765, having only the
 * attribute "version"
 * 
 * <p>Subclasses of IDMEF-Message are at this writing, "Alert" and "Heartbeat". As
 * of this writing, the RFC specifies that applications specifying a value for
 * "Version" must specify the value to "1.0". That value is forced here and is
 * not changeable. Class is abstract so that only subclasses can be
 * instantiated, as the spec seems to not anticipate that this class would ever
 * contain more than basic common fields for many message types.
 * 
 * <p>
 * All IDMEF messages are instances of the IDMEF-Message class; it is the
 * top-level class of the IDMEF data model, as well as the IDMEF DTD. There are
 * currently two types (subclasses) of IDMEF-Message: Alert and Heartbeat.
 * 
 * 
 * @author jim
 * @version 0.1
 */

public abstract class IDMEFMessage {

	/**
	 * As of this writing, the RFC specifies that applications specifying a
	 * value for "Version" must specify the value to "1.0" so that value is
	 * forced here and is not changeable.
	 */
	public static final String VERSION = "1.0";

	private String version;

	public IDMEFMessage() {
		this.version = VERSION;
	}

	public String getVersion() {
		return this.version;
	}

	
	public String toString() {
		return "\n\r[IDMEFMessage] version="+version;
	}
	
}

