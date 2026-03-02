package task_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginPage {
	
	@FindBy (name="username")
	private WebElement userNameTextBox;
	
	@FindBy (name="password")
	private WebElement passWordTextBox;

	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//h5[normalize-space()='Login']")
	private WebElement loginText;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	private WebElement logo;
	
	
	WebDriver driver;
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		}


	public void enterUserName(String UserName) {
		userNameTextBox.sendKeys(UserName);
	}
	
	public void enterPassword(String Password) {
		passWordTextBox.sendKeys(Password);
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickForgotPassword() {
		forgotPasswordLink.click();
	}
	
	public boolean verifyLoginText() {
		
		if(loginText.getText()=="Login")
			return true;
		else
			return false;
	}

	public boolean checklogo() {
		if(logo.getAttribute("alt")=="company-branding")
		return true;
		else
			return false;
	}
}
