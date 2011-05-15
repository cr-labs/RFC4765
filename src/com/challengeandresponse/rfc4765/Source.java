package com.challengeandresponse.rfc4765;


/**
 * Implements RFC4765 Section 4.2.4.3 Source class
 * 
 *  <p>The Source class contains information about the possible source(s) of
 *  the event(s) that generated an alert.  An event may have more than
 *  one source (e.g., in a distributed denial-of-service attack).
 *  </p>
 *  
 * @author jim
 *
 */
public class Source {
	
	private String 		ident;
	private SpoofedRank spoofed;
	private String 		iface;

	private Node 		node;
	private User 		user;
	private Process 	process;
	private Service 	service;
	
	
	public static enum SpoofedRank {
		UNKNOWN (0), YES (1), NO (2);
		private final int spoofedCode;
		SpoofedRank(int sr) {
			this.spoofedCode = sr;
		}
		public int getValue() {
			return this.spoofedCode;
		}
	}
	
	/**
	 * ainterface, node, user, process, and service are all optional.<br />
	 * ident will default to the RFC-specified value "0" if null.<br />
	 * spoofed will default to "UNKNOWN" if null.<br />
	 * 
	 * @param ident optional unique identifier for this source
	 * @param spoofed optional indication of whether the source is, as far as the analyzer can determine, a spoofed address used for hiding the real origin of the attack. See SpoofedRank for possible values.
	 * @param ainterface optional analyzer interface on which this source was seen
	 * @param node Information about the host or device that appears to be causing the events
	 * @param user Information about the user that appears to be causing the event(s).
	 * @param process Information about the process that appears to be causing the event(s)
	 * @param service Information about the network service involved in the event(s)
	 */
	public Source(String ident, SpoofedRank spoofed, String ainterface, Node node, User user, Process process, Service service) {
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;	
		if (spoofed == null)
			this.spoofed = SpoofedRank.UNKNOWN;
		else
			this.spoofed = spoofed;
		this.iface = ainterface;
		this.node = node;
		this.user = user;
		this.process = process;
		this.service = service;
		
	}

	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * @return the interface
	 */
	public String getInterface() {
		return iface;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @return the process
	 */
	public Process getProcess() {
		return process;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @return spoofed
	 */
	public SpoofedRank getSpoofed() {
		return spoofed;
	}

	/**
	 * @return the RFC specified integer value for spoofed
	 */
	public int getSpoofedValue() {
		return spoofed.getValue();
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Source] ");
		sb.append("ident="+ident);
		sb.append(" spoofed="+spoofed);
		sb.append(" iface="+iface);
		sb.append(" node="+node);
		sb.append(" user="+user);
		sb.append(" process="+process);
		sb.append(" service="+service);
		return sb.toString();
	}
	
	

}
