package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker {
	
	private final WebDriver driver;
	
	public DatePicker(WebDriver driver) {
		this.driver = driver;
	}
	
	public DatePicker open() {
		new HtmlElement(driver, OPEN_WINDOW_BUTTON).whenDisplayed().click();
		new HtmlElement(driver, WINDOW).whenDisplayed();
		return this;
	}
	
	public DatePicker selectDay(int day) {
		if (day < getCurrentDay()) throw new RuntimeException("Cannot select a disabled day");
		By dayToSelect = By.xpath(String.format(DAY_FOR, day));
		new HtmlElement(driver, dayToSelect).whenDisplayed().click();
		new HtmlElement(driver, WINDOW).whenNotDisplayed();
		return this;
	}
	
	private int getCurrentDay() {
		return Integer.valueOf(new HtmlElement(driver, CURRENT_DAY).whenDisplayed().getText());
	}
	
	private static final By OPEN_WINDOW_BUTTON = By.className("ui-datepicker-trigger");
	private static final By WINDOW = By.id("ui-datepicker-div");
	private static final String DAY_FOR = "//*[@data-handler='selectDay' and ./*[text()='%d']]";
	private static final By CURRENT_DAY = By.xpath("//*[contains(@class, 'ui-datepicker-today')]");
}
