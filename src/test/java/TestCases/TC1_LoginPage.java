package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Landing_Page;
import PageObjects.PageObject_Login;
import Utilities.BrowserManager;

public class TC1_LoginPage {
	WebDriver driver = null;
	
	@Test
	@Parameters({"browser","url"})
	public void t_01_validating_Url(String browser, String url) {
		driver = BrowserManager.getDriver(browser, url);
		Landing_Page obj1 = PageFactory.initElements(driver, Landing_Page.class);
		Assert.assertTrue(obj1.checkLandingPage());
		driver.quit();
		
	}
	
	@Test
	@Parameters({"browser","url"})
	public void t_02_login(String browser, String url) {
		driver = BrowserManager.getDriver(browser,url);
		PageObject_Login obj = PageFactory.initElements(driver, PageObject_Login.class);
		Assert.assertTrue(obj.LoginPage("tomsmith", "SuperSecretPassword!"));
		driver.quit();	
	}
	
	@Test
	@Parameters({"browser","url"})
	public void t_03_Validating_logout(String browser, String url) {
		driver = BrowserManager.getDriver(browser,url);
		PageObject_Login obj1 = PageFactory.initElements(driver, PageObject_Login.class);
		obj1.LoginPage("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(obj1.Logout());
		driver.quit();	
	}
	
	

}
