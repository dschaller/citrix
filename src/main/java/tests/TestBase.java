package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import framework.Condition;
import framework.Configuration;

public class TestBase {
	
	protected final WebDriver driver = new FirefoxDriver();
	protected final Configuration configuration = new Configuration();
	
	/**
	 * Convenience method to make assertions easy to read in test cases and make them poll in case of network lag.
	 * @param subject	the subject to evaluate against
	 * @param condition the condition that will be evaluated
	 */
	protected <T, F> void assertThat(final T subject, final Condition<T, F> condition) {
		ExpectedCondition<F> subjectsConditionIsSatisfied = new ExpectedCondition<F>() {
			public F apply(WebDriver driver) {
				return condition.of(subject);
			}
		};
		new WebDriverWait(driver, TIMEOUT_MAXIMUM).until(subjectsConditionIsSatisfied);
	}
	
	/**
	 * Always quit the driver after the test class has finished.
	 */
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	public static final int TIMEOUT_MAXIMUM = 10;
}
