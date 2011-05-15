package com.challengeandresponse.rfc4765;

/**
 * Implements the Action class 4.2.6.2 of RFC4765
 * 
 * <p>
 * Non-RFC extensions are these additional categories:<br />
 * <li>X_INFO (10000) Corresponds with the Impact severity "INFO" and indicates that no action was taken, that information 
 * received by this manager is just being passed ahead to a peer.
 * <li>X_BLOCK_REMOVED (10001) to indicate that a block was REMOVED for some
 * source
 * <li>X_RATE_LIMITED_BPS (10002) to indicate that data from the source was
 * THROTTLED to a number of BITS PER SECOND. If X_RATE_LIMITED_BPS is the Action Category, then there MUST be an
 * AdditionalData entry in the Alert Message whose Meaning is "X_RATE_LIMITED_BPS", whose datatype is Integer,
 * and whose value is the number of bits per second to which the source was limited
 * <li>X_RATE_LIMITED_MPS (10003) to indicate that data from the source was
 * THROTTLED to a number of MESSAGES PER SECOND. If X_RATE_LIMITED_MPS is the Action Category, then there MUST be an
 * AdditionalData entry in the Alert Message whose Meaning is "X_RATE_LIMITED_MPS", whose datatype is Integer,
 * and whose value is the number of messages per second to which the source was limited. The meaning of "message" is
 * presumed to be understood between the originator and recipient of this message and should be generally presumed to
 * indicate some "whole" semantic unit bigger than a bit and smaller than an entire conversation... like, well, a message :)
 * <li>X_RATE_UNLIMITED (10004) to indicate that previously established rate limits were removed
 * 
 * @author jim
 */
public class Action {

	private Category category;
	
	/** 
	 * The type of action taken.
	 */
	public static enum Category {
		BLOCK_INSTALLED (0), NOTIFICATION_SENT (1), TAKEN_OFFLINE (2), OTHER (3),
		X_INFO (10000),
		X_BLOCK_REMOVED (10001), 
		X_RATE_LIMITED_BPS (10002), X_RATE_LIMITED_MPS (10003), X_RATE_UNLIMITED (10004);
		private final int categoryCode;
		Category(int c) {
			this.categoryCode = c;
		}
		public int getValue() {
			return this.categoryCode;
		}
	}

	
	/**
	 * Instantiate and populate an Impact object.
	 * @param category 		The type of action taken. Use 'null' if not reporting a category, and it will be set to the RFC default value 'other'
	 */
	public Action(Category category) {
		this.category = category;
		if (category == null)
			this.category = Category.OTHER;
		else
			this.category = category;
	}


	/**
	 * @return an RFC4765-compatible category (extension X_* categories are returned as OTHER)
	 */
	public Category getRFCCategory() {
		if (category.getValue() >= Category.X_BLOCK_REMOVED.getValue())
			return Category.OTHER;
		else
			return category;
	}


	/**
	 * @return the category, whether RFC4765-based or an extension (X_*)
	 */
	public Category getSKCategory() {
		return category;
	}

	/**
	 * @return an RFC4765-compatible integer value for the category code (extension X_* categories are returned as the value of OTHER)
	 */
	public int getRFCCategoryValue() {
		return getRFCCategory().getValue();
	}

	/**
	 * @return the integer value for the category code, whether RFC-compliant or one of our extensions
	 */
	public int getSKCategoryValue() {
		return category.getValue();
	}
	
	
	public String toString() {
		return "\n\r[Action] category="+category;
	}

}
