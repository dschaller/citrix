package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents an HTML page.
 * 
 * @author derekschaller
 *
 */
public abstract class HtmlPage {

	protected final WebDriver driver;
	private final String urlAddress;
	
	/**
	 * @param urlAddress the URL address of the HTML page
	 */
	public HtmlPage(WebDriver driver, String urlAddress) {
		this.driver = driver;
		this.urlAddress = urlAddress;
	}
	
	/**
	 * Navigates to an HTML Page's URL address.
	 */
	public void go() {
		driver.get(urlAddress);
	}
	
	/**
	 * Indicates if an HTML page is loaded.
	 */
	public static Condition<HtmlPage, Boolean> isLoaded() {
		return new Condition<HtmlPage, Boolean>() {
			public Boolean of(HtmlPage subject) {
				return subject.loaded();
			}
		};
	}
	
	/**
	 * Indicates if an HTML page is not loaded.
	 */
	public static Condition<HtmlPage, Boolean> isNotLoaded() {
		return new Condition<HtmlPage, Boolean>() {
			public Boolean of(HtmlPage subject) {
				return !subject.loaded();
			}
		};
	}

	/**
	 * Convenience method for creating {@link HtmlElement HtmlElements}.
	 * @param locator the {@link By} locator of the element
	 * @return a {@link HtmlElement} for the specified locator
	 */
	protected HtmlElement element(By locator) {
		return new HtmlElement(driver, locator);
	}
	
	/**
	 * Criteria for an HTML page to be loaded.
	 */
	protected abstract boolean loaded();
}
