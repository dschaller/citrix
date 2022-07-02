package framework;

/**
 * Conditions of {@link HtmlElement HtmlElements}.
 * 
 * @author derekschaller
 *
 */
public class HtmlElementCondition {

	/**
	 * Indicates if an {@link HtmlElement} is displayed.
	 */
	public static Condition<HtmlElement, Boolean> isDisplayed() {
		return new Condition<HtmlElement, Boolean>() {
			public Boolean of(HtmlElement subject) {
				return subject.isDisplayed();
			}
		};
	}

	/**
	 * Indicates if an {@link HtmlElement} is not displayed.
	 */
	public static Condition<HtmlElement, Boolean> isNotDisplayed() {
		return new Condition<HtmlElement, Boolean>() {
			public Boolean of(HtmlElement subject) {
					return !subject.isDisplayed();
			}
		};
	}
}
