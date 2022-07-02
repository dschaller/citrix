package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.HtmlPage;
import framework.UpcomingWebinar;

public class MyWebinarsPage extends HtmlPage {

	public MyWebinarsPage(WebDriver driver) {
		super(driver, PAGE_ADDRESS);
	}

	public void scheduleAWebinar() {
		element(SCHEDULE_A_WEBINAR_BUTTON).whenDisplayed().click();
	}
	
	public UpcomingWebinar getWebinar(String onDate, String withTitle) {
		return new UpcomingWebinar(driver, onDate, withTitle);
	}
	
	@Override
	protected boolean loaded() {
		return element(BODY).isDisplayed();
	}

	private static final String PAGE_ADDRESS = "https://global.gotowebinar.com/webinars.tmpl";
	private static final By BODY = By.id("myWebinars");
	private static final By SCHEDULE_A_WEBINAR_BUTTON = By.id("scheduleWebinar");
}
