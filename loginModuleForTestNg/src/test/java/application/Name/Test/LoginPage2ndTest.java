package application.Name.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FBPageObjectModel.HomePage1stStep;
import FBPageObjectModel.LoginPage2ndStep;

public class LoginPage2ndTest extends BaseClassPageInitialTest {
	
	
	public WebDriver driver ;
	public HomePage1stStep home;
	public LoginPage2ndStep login ;

	@Test (description = " Test Case Id : forExample 1245")
	public void checkLoginWithValidCredentials() {
		

		home = new HomePage1stStep(super.driver);      // object creation 1
		home.clickOnLoginOrSighnUpBtn();
		
		login = new LoginPage2ndStep(super.driver);    // object creation  2

		login.enterEmail("jagadeesmic2020@gmail.com");
		login.enterPassWord("12345678910");
		
		//login.clickOnLogin(); 
		
		
	}
	
	@Test
	public void checkSignUpWIthValidCredentials() {
		

		home = new HomePage1stStep(super.driver);      // object creation 1
		home.clickOnLoginOrSighnUpBtn();
		
		login = new LoginPage2ndStep(super.driver);    // object creation  2
		
		login.enterNameintoTheBox("JAGADEESSWARAN M");
		login.enteremailintoTheBox("mathanmix@gmail.com");
		login.clickSignUpButton();

		// need to check with same page 
		// after  the class
	}
	
	public void checkWIthValidIputsCredentials () {
		
	}
	
		
	
		
	
	
	
}
