package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpcomingWebinar {

	private final HtmlElement root;
	
	public UpcomingWebinar(WebDriver driver, String date, String title) {
		this.root = new HtmlElement(driver, By.xpath(String.format(ROOT, date, title)));
	}
	
	public static Condition<UpcomingWebinar, Boolean> isDisplayed() {
		return new Condition<UpcomingWebinar, Boolean>() {
			public Boolean of(UpcomingWebinar webinar) {
				return webinar.displayed();
			}
		};
	}
	
	private boolean displayed() {
		return root.isDisplayed();
	}
	
	private static final String ROOT = "//*[contains(@class, 'openWebinar') and .//*[@class='myWebinarDate' and contains(text(), '%s')] and .//*[contains(@class, 'title') and .//*[text()='%s']]]";
}
