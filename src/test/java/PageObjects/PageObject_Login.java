package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PageObject_Login {

	WebDriver driver;

	public PageObject_Login(WebDriver driver) {
		this.driver = driver;
	}

	// Login related locators
	@FindBy(how = How.ID, using = "username")
	private WebElement username;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	private WebElement login_button;

	@FindBy(how = How.XPATH, using = "//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")
	private WebElement LoggedInMessage;

	// Logout related locators
	@FindBy(how = How.XPATH, using = "//a[@class='button secondary radius']/i")
	private WebElement LogoutButtonElement;

	@FindBy(how = How.XPATH, using = "//*[@id='flash' and @class='flash success']")
	private WebElement LogoutSuccessMessage;

	// Methods
	public void SetUsername(String usernamefiled) {
		username.sendKeys(usernamefiled);
	}

	public void SetPasswrod(String passwordfield) {
		password.sendKeys(passwordfield);
	}

	public void ClickLoginButton() {
		login_button.click();
		Reporter.log("you have cliced the login button .", true);
	}

	public void AfterLogin() {
		String message = LoggedInMessage.getText();
		System.out.println("The Logged in Message is :" + message);

	}

	// Logout Method

	public void logoutbutton() {
		LogoutButtonElement.click();
	}

	public boolean LogoutSuccess() {
		String message = LogoutSuccessMessage.getText();
		System.out.println("Logged out message : " + message);
		return LogoutSuccessMessage.isDisplayed();
	}

	// Business Method
	public boolean LoginPage(String usernamefiled, String passwordfield) {
		SetUsername(usernamefiled);
		SetPasswrod(passwordfield);
		ClickLoginButton();
		String Expected = "Welcome to the Secure Area. When you are done click logout below.";
		String actual = LoggedInMessage.getText();
		System.out.println("value captured from the element :" + actual);
		// Validation
		if (Expected.equals(actual)) {
			System.out.println("You are logged in Successfully");
		} else {
			System.out.println("Loging Failed");
		}
		return LoggedInMessage.isDisplayed();
		// System.out.println(loginPageVerification);
		// return LoggedInMessage.isDisplayed();

	}

	public boolean Logout() {
		logoutbutton();
		LogoutSuccess();
//		String expected = "You logged out of the secure area!";
//		String actual = LogoutSuccessMessage.getText();
//		System.out.println("value captured from the element :" + actual);
//		 if (expected.equals(actual)) {
//		 System.out.println("You are logged out Successfully");
//		 } else {
//		 System.out.println("Logged out fail");
//		 }
		return LogoutSuccessMessage.isDisplayed();

	}

}
