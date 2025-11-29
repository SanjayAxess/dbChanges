package application.Name.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FBPageObjectModel.HomePage1stStep;
import FBPageObjectModel.LoginPage2ndStep;

public class HomePage1Test extends BaseClassPageInitialTest {
	// WebDriver driver;  need to delete why because we call in this driver for globally  inside the base class
	HomePage1stStep home;
	
	
	@Test
	public void signUpOrLoginBtnLink () {
		
		home = new HomePage1stStep(super.driver);
		//home.clickOnCart();   // need to find locators after class
		home.clickOnTestCases();
	}
	
	
	
	
	
	

}
