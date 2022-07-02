package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.HtmlPage;

public class GoToWebinarLoginPage extends HtmlPage {

	public GoToWebinarLoginPage(WebDriver driver) {
		super(driver, PAGE_ADDRESS);
	}
	
	public GoToWebinarLoginPage enterUsername(String username) {
		element(USERNAME_FIELD).whenDisplayed().sendKeys(username);
		return this;
	}
	
	public GoToWebinarLoginPage enterPassword(String password) {
		element(PASSWORD_FIELD).whenDisplayed().sendKeys(password);
		return this;
	}
	
	public void signIn() {
		element(SIGN_IN_BUTTON).whenDisplayed().click();
	}

	@Override
	protected boolean loaded() {
		return element(CREDENTIALS_FORM).isDisplayed();
	}

	private static final String PAGE_ADDRESS = "https://global.gotowebinar.com/webinars.tmpl";
	private static final By CREDENTIALS_FORM = By.id("credentials");
	private static final By USERNAME_FIELD = By.id("emailAddress");
	private static final By PASSWORD_FIELD = By.id("password");
	private static final By SIGN_IN_BUTTON = By.id("submit");
}
