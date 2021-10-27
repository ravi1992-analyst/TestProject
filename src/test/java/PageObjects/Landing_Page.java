package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Landing_Page {

	WebDriver driver;
	
	public Landing_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='example']/h2")
	private WebElement LandingPageVerification;
	
	
	//Methods
	public boolean checkLandingPage() {
	String TextVerification =	LandingPageVerification.getText();
//	System.out.println(TextVerification);
//	return LandingPageVerification.isDisplayed();
		String Expected = "Login Page";
	String Actual = TextVerification;
	if (Expected.equals(Actual)) {
		System.out.println("You are Landded in the login Page:");
	}else{
		System.out.println("Landing on the Login page is failed:");
		
	}
	return LandingPageVerification.isDisplayed();
	}
	
}
