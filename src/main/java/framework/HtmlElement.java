package framework;

import static tests.TestBase.TIMEOUT_MAXIMUM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a element within an {@link HtmlPage}.
 * 
 * @author derekschaller
 *
 */
public class HtmlElement {
	private final WebDriver driver;
	private final By locator;

	public HtmlElement(WebDriver driver, By locator) {
		this.driver = driver;
		this.locator = locator;
	}
	
	/**
	 * Indicates if an HTML element is displayed.
	 */
	public boolean isDisplayed() {
		try {
			return element().isDisplayed();
		} catch(NoSuchElementException ignored) {
			return false;
		}
	}

	/**
	 * Clicks an HTML element.
	 */
	public void click() {
		element().click();
	}
	
	/**
	 * Sends a specified string to an HTML element.
	 * 
	 * @param keys the string to send
	 */
	public void sendKeys(String keys) {
		element().sendKeys(keys);
	}

	/**
	 * Gets the text of an HTML element.
	 */
	public String getText() {
		return element().getText();
	}
	
	/**
	 * Waits until an HTML element is displayed.
	 * 
	 * Note: The maximum wait time is {@value tests.TestBase#TIMEOUT_MAXIMUM} seconds.
	 */
	public HtmlElement whenDisplayed() {
		new WebDriverWait(driver, TIMEOUT_MAXIMUM).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(locator).isDisplayed();
			}
		});
		return this;
	}
	
	/**
	 * Waits until an HTML element is not displayed.
	 * 
	 * Note: The maximum wait time is {@value tests.TestBase#TIMEOUT_MAXIMUM} seconds.
	 */
	public HtmlElement whenNotDisplayed() {
		new WebDriverWait(driver, TIMEOUT_MAXIMUM).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return !driver.findElement(locator).isDisplayed();
			}
		});
		return this;
	}
	
	/**
	 * @return a {@link WebElement} representing the HTML element.
	 */
	private WebElement element() {
		return driver.findElement(locator);
	}
}
