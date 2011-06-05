package com.cr_labs.rfc4765;

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

