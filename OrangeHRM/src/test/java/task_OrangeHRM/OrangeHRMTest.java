package task_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class OrangeHRMTest extends Hooks {

	public LoginPage login;
	public DashBoardPage DashBoard;

	@Test(dataProviderClass = TestData.class, dataProvider = "invalidData", priority = 1)
	public void loginWithInvalidCredentials(String UserName, String Password) {

		login = new LoginPage(driver);
		Assert.assertEquals(login.verifyLoginText(), false);
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText(),
				"Invalid credentials");

	}

	@Test(dataProviderClass = TestData.class, dataProvider = "validData", priority = 2)
	public void loginWithValidCredentials(String UserName, String Password) throws InterruptedException {

		login = new LoginPage(driver);
		login.enterUserName(UserName);
		login.enterPassword(Password);
		login.clickLoginButton();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText(),
				"Dash board");

	}

	@Test(priority = 3, dependsOnMethods = "loginWithValidCredentials")
	public void verifyLogoinDashBoardPage() {

		DashBoard = new DashBoardPage(driver);
		Assert.assertEquals(DashBoard.LogoDB(), false);
	}

}
