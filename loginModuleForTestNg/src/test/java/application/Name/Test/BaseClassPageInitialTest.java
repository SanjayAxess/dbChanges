package application.Name.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FBPageObjectModel.Cart3rdPage;
import FBPageObjectModel.HomePage1stStep;
import FBPageObjectModel.LoginPage2ndStep;

public class BaseClassPageInitialTest {
	WebDriver driver;
	HomePage1stStep home;
	LoginPage2ndStep login;
	Cart3rdPage cart;
	
	@BeforeMethod
    public void LaunchAndNevigateToLoginPage() {
		driver.get("https://www.automationexercise.com/");
		System.out.println("BeforeMethod is Running");

	}
	
	
	@AfterMethod
	public void closingBrowser () throws InterruptedException {
		System.out.println("AfterMethod is Running");

	}
	
	@BeforeClass
	public void openBrowserurl() {

    	driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Beforeclass is Working");
	}
	
	@AfterClass
    public void closeBrowserurl() throws InterruptedException {
	
    	Thread.sleep(5000);
		driver.close();
		System.out.println("Afterclass is Working");

   } 

}
