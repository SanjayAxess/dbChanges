package aPOMTestFolder;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import fkPageObjectModelFolder.AddToCartNavigatePage;
import fkPageObjectModelFolder.HomePage;
import fkPageObjectModelFolder.ProductPage;

public class BaseClassTest {
	
	WebDriver driver;
	HomePage home;
	ProductPage page;
	AddToCartNavigatePage cart;
	
	@BeforeMethod
	public void launchaAndNavigateUrlPage() {
		driver.get("https://www.flipkart.com");
		
		
	}
	@AfterMethod
	public void closeTheUrl() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	
	 @BeforeClass   // @BeforeTest    //
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	 @AfterClass    // @AfterTest
	public void quiteBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
