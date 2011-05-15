package com.challengeandresponse.rfc4765;

/**
 * Implements 4.2.6.3. of RFC4765, the Confidence class.
 * Confidence may be expressed as low/med/high, or as a double precision point numeric value.
 * 
 * <p>Non-RFC extensions to the class:<br />
* This implementation extends the RFC's by permitting numeric confidence values
 * in the range of {-1.00 .. 1.00}. The RFC permits only the positive range {0.00 .. 1.00}.
 * C/R implementations allow negative assertions (e.g. "-1.00 means ' i assert with full
 * confidence that this is NOT true'). The methods 'getRfc4765NumericRating' and
 * 'getNonRfc4765NumericRating' are provided so that callers can get a value that suits
 * their needs (RFC-compliant ratings of < 0.00 are reported as 0.00, indicating no confidence).
 * <P>Additionally the confidence Ranks X_NEG_LOW(10000), X_NEG_MEDIUM(10001), X_NEG_HIGH(10002) are provided for non-numeric negative assertions
 * of low, medium, and high confidence that the asserted statement is NOT true.
 * 
 * @author jim
 *
 */

public class Confidence {

	private Rank	rating;
	private double 	numericRating;
	
	public static enum Rank {
		LOW (0), MEDIUM (1), HIGH (2), NUMERIC (3),
		X_NEG_LOW (10000), X_NEG_MEDIUM (10001), X_NEG_HIGH (10002);
		private final int rankCode;
		Rank(int rc) {
			this.rankCode = rc;
		}
		public int getValue() {
			return this.rankCode;
		}
	}


	public Confidence() {
		rating = Rank.LOW;
		numericRating = 0.0d;
	}
	
	public Confidence(Rank rank) {
		rating = rank;
		numericRating = 0.0d;
	}
	
	public Confidence(double numericRating) {
		rating = Rank.NUMERIC;
		this.numericRating = numericRating;
	}
	
	/**
	 * Sets the numeric confidence rating to the provided value, and also sets the rating type to RANK_NUMERIC.
	 * @param nv The value
	 */
	public void setNumericRating(double nv)
	throws IllegalArgumentException {
		if ((nv < -1.0d) || (nv > 1.0d))
			throw new IllegalArgumentException("Cannot instantiate Confidence: Value out of range. Legal values: -1.0 .. 1.0");
		numericRating = nv;
		rating = Rank.NUMERIC;
	}
	
	/**
	 * Return RFC-compliant confidence rating, range from (0.00 to 1.00). If the stored value is < 0.00, then 0.00 is returned)
	 * @return an RFC4765 numeric confidence value
	 */
	public double getRFCNumericRating() {
		return Math.max(0.0d,numericRating);
	}
	
	/**
	 * Return confidence rating, range is that supported by this API (-1.00 to 1.00), spanning a confidence negative assertion to a confident positive assertion
	 * @return The SK-compatible numeric confidence value
	 */
	public double getSKNumericRating() {
		return numericRating;
	}
	
	public void setRating(Rank newRating) {
		rating = newRating;
	}
	
	/**
	 * @return the rating as one of the enum Rank values
	 */
	public Rank getSKRating() {
		return rating;
	}

	/**
	 * @return the confidence rating in the range supported by the RFC (non-RFC values are returned as LOW)
	 */
	public Rank getRFCRating() {
		if (rating.getValue() >= Rank.X_NEG_LOW.getValue())
			return Rank.LOW;
		else
			return rating;
	}
	
	
	/**
	 * @return the integer value of the Rating, whether as defined in the RFC or an extension
	 */
	public int	getSKRatingValue() {
		return rating.getValue();
	}
	
	/**
	 * @return the integer value of the Rating, including only RFC4765 values. Non-RFC values (X_*) are returned as LOW.
	 */
	public int	getRFCRatingValue() {
			return getRFCRating().getValue();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\r[Confidence] ");
		sb.append("rank="+rating);
		if (rating == Rank.NUMERIC)
			sb.append(" value="+numericRating);
		return sb.toString();
	}
	
}
