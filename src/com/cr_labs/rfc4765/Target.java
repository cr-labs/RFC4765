package com.cr_labs.rfc4765;

/**
 * Implements the Target class of RFC 4765 section 4.2.4.4
 * 
 * <p>
 *  The Target class contains information about the possible target(s) of
   the event(s) that generated an alert.  An event may have more than
   one target (e.g., in the case of a port sweep).
   </p>
 * 
 * </p>
 * @author jim
 *
 */
public class Target {
	
	private String ident;
	private DecoyRank decoy;
	private String iface;

	private Node node;
	private User user;
	private Process process;
	private Service service;
	private com.cr_labs.rfc4765.File file;
	
	
	/**
	 * UNKNOWN -- Accuracy of target information unknown<br />
	 * YES -- Target is believed to be a decoy<br />
	 * NO -- Target is believed to be "real"<br />
	 * 
	 * @author jim
	 */
	public static enum DecoyRank {
		UNKNOWN (0), YES (1), NO (2);
		private final int decoyCode;
		DecoyRank(int dr) {
			this.decoyCode = dr;
		}
		public int getValue() {
			return this.decoyCode;
		}
	}
	
	/**
	 * 
	 * @param ident
	 * @param decoy optional DecoyRank value. See DecoyRank for possible values.
	 * @param ainterface optional analyzer interface on which this source was seen
	 * @param node optional information about the host or device at which the event(s) is/are being directed
	 * @param user optional information about the user at which the event(s) is/are being directed
	 * @param process optional information about the process at which the event(s) is/are being directed
	 * @param service optional information about the service involved in the event(s)
	 * @param file optional information about file(s) involved in the event(s)
	 */
	public Target(String ident, DecoyRank decoy, String ainterface, 
			Node node, User user, Process process, Service service, com.cr_labs.rfc4765.File file) {
		if (ident == null)
			this.ident = "0";
		else
			this.ident = ident;	
		if (decoy == null)
			this.decoy = DecoyRank.UNKNOWN;
		else
			this.decoy = decoy;
		this.iface = ainterface;
		this.node = node;
		this.user = user;
		this.process = process;
		this.service = service;
		this.file = file;
	}

	/**
	 * @return the decoy
	 */
	public DecoyRank getDecoy() {
		return decoy;
	}

	/**
	 * @return the RFC-specified integer value for decoy
	 */
	public int getDecoyValue() {
		return decoy.getValue();
	}

	/**
	 * @return the file
	 */
	public com.cr_labs.rfc4765.File getFile() {
		return file;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Target] ");
		sb.append("ident="+ident);
		sb.append(" decoy="+decoy);
		sb.append(" iface="+iface);
		sb.append(" node="+node);
		sb.append(" user="+user);
		sb.append(" process="+process);
		sb.append(" service="+service);
		sb.append(" file="+file);
		return sb.toString();
	}
	
	

}
