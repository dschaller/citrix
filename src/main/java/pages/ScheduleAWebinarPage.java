package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.DatePicker;
import framework.HtmlPage;

public class ScheduleAWebinarPage extends HtmlPage {

	public ScheduleAWebinarPage(WebDriver driver) {
		super(driver, PAGE_ADDRESS);
	}

	public ScheduleAWebinarPage setTitle(String webinarTitle) {
		element(TITLE_FIELD).whenDisplayed().click();
		element(TITLE_FIELD).sendKeys(webinarTitle);
		return this;
	}
	
	public ScheduleAWebinarPage setStartDate(int day) {
		new DatePicker(driver).open().selectDay(day);
		return this;
	}
	
	public void schedule() {
		element(SCHEDULE_BUTTON).whenDisplayed().click();
	}
	
	@Override
	protected boolean loaded() {
		return element(BODY).isDisplayed();
	}

	private static final String PAGE_ADDRESS = "https://global.gotowebinar.com/schedule.tmpl";
	private static final By BODY = By.id("schedule");
	private static final By TITLE_FIELD = By.id("name");
	private static final By SCHEDULE_BUTTON = By.id("schedule.submit.button");
}
