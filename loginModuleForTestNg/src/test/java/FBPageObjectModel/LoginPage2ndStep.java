package FBPageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage2ndStep {
	
	public WebDriver driver;           // 
	
	//  1 rule is create the private variable  like ()
	
                                                                                /* 
                                                                                   @FindBy(xpath = ".//a[text()=' Signup / Login']")
                                                                                   private WebElement LoginOrSignUpBtn;	
                                                                                   it is place to Home Page class 
                                                                                */
   // step 1 is create private variables for login test
   
   @FindBy(xpath = ".//form[@action='/login']//input[@name='email']")
   private WebElement enterEmailAddressBox;
   
   
   @FindBy(xpath = ".//input[@name='password']")    // @FindBy (name = "password")
   private WebElement enterPassWordBox;
   
   
   @FindBy(xpath = ".//button[text()='Login']")
   private WebElement loginBtn;
   
   // for signup test
   
   @FindBy(name = "name")
   private WebElement enterNmeBox;
   
   
   @FindBy(xpath = ".//form[@action=\"/signup\"]//input[@type='email']")    
   private WebElement enterWithEmailAdressBox;
   
   
   @FindBy(xpath = ".//button[text()='Signup']")
   private WebElement signUpBtn;
   
   
   

      // step 2 create Constructor with InitElements
   
   public LoginPage2ndStep(WebDriver driver) {
	   PageFactory.initElements(driver,this);
	   
   }
	   
	   
	
      // step 3  is we have to create a Methods
	   
	    public void enterEmail(String email) {
		   enterEmailAddressBox.sendKeys(email);
	    }
   
	    public void enterPassWord(String password) {
		   enterPassWordBox.sendKeys(password);
        }
	   
	   public void clickOnLogin() {
		   loginBtn.click();
	    }

	   
	   // next test for signupbtn
	   
	   public void enterNameintoTheBox(String sName) {
		   enterNmeBox.sendKeys(sName);
	   }
	   
	   public void enteremailintoTheBox(String sEmail) {
		   enterWithEmailAdressBox.sendKeys(sEmail);
	   }
   
	   
	   public void clickSignUpButton() {
		   signUpBtn.click();
		   
	   }
   
   
}
