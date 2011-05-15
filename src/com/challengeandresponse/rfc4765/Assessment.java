package com.challengeandresponse.rfc4765;

/**
 * Implements 4.2.4.5.  The Assessment Class of RFC4765
 * The Assessment class is used to provide the analyzer's assessment of an event -- its impact, actions taken in response, and confidence.
 * 
 * @author jim
 */

public class Assessment {
	private Impact 		impact;
	private Action 		action;
	private Confidence	confidence;


	/**
	 * Instantiate an Assessment object and populate its contained objects
	 * 
	 * @param impact 		Optional Impact object. Use null if not reporting Impact.
	 * @param action		Optional Action object. Use null if not reporting Action.
	 * @param confidence 	Optional Confidence object. Use null if not reporting Confidence.
	 */
	public Assessment(Impact impact, Action action, Confidence confidence) {
		this.impact = impact;
		this.action = action;
		this.confidence = confidence;
	}


	/**
	 * @return the action object or null if there is none
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * @return the confidence object or null if there is none
	 */
	public Confidence getConfidence() {
		return confidence;
	}


	/**
	 * @return the impact object or null if there is none
	 */
	public Impact getImpact() {
		return impact;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Assessment] ");
		sb.append("Impact="+impact);
		sb.append(" Action="+action);
		sb.append(" Confidence="+confidence);
		return sb.toString();
	}


}
