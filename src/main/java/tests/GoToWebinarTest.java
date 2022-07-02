package tests;

import java.util.Calendar;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.HtmlPage;
import framework.UpcomingWebinar;
import pages.GoToWebinarLoginPage;
import pages.MyWebinarsPage;
import pages.ScheduleAWebinarPage;

public class GoToWebinarTest extends TestBase {
	
	GoToWebinarLoginPage goToWebinarLoginPage = new GoToWebinarLoginPage(driver);
	MyWebinarsPage myWebinarsPage = new MyWebinarsPage(driver);
	ScheduleAWebinarPage scheduleAWebinarPage = new ScheduleAWebinarPage(driver);
	
	@BeforeMethod(alwaysRun = true)
	public void signIntoAccount() {
		goToWebinarLoginPage.go();
		assertThat(goToWebinarLoginPage, HtmlPage.isLoaded());
	}
	
	@Test
	public void scheduleGoToWebinar() {
		int dayOfWebinar = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+3;
		
		goToWebinarLoginPage.enterUsername(configuration.getProperty(USER_NAME))
							.enterPassword(configuration.getProperty(PASSWORD))
							.signIn();
		assertThat(myWebinarsPage, HtmlPage.isLoaded());
		myWebinarsPage.scheduleAWebinar();
		scheduleAWebinarPage.setTitle(WEBINAR_TITLE);
		scheduleAWebinarPage.setStartDate(dayOfWebinar);
		scheduleAWebinarPage.schedule();
		assertThat(scheduleAWebinarPage, HtmlPage.isNotLoaded());
		myWebinarsPage.go();
		UpcomingWebinar webinar = myWebinarsPage.getWebinar(String.valueOf(dayOfWebinar), WEBINAR_TITLE);
		assertThat(webinar, UpcomingWebinar.isDisplayed());
	}
	
	private static final String WEBINAR_TITLE = "Test Webinar";
	private static final String USER_NAME = "user.name";
	private static final String PASSWORD = "user.password";
}
