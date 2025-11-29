package FBPageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1stStep {

	// step 1 i created private variables . (private WebElement productsLink ; )
	
	WebDriver driver ;
	
	
	@FindBy (xpath = ".//a[text()=' Home']")
	private WebElement hometitleLink ; 
	
	
	@FindBy (xpath = ".//a[text()=' Products']")
	private WebElement productstitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Cart']")
	private WebElement carttitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Signup / Login']")
	private WebElement signUpOrLoginBtntitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Test Cases']")
	private WebElement testCasestitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Test Cases']")
	private WebElement apiTesttitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Video Tutorials']")
	private WebElement videoTutorialstitleLink ; 
	
	@FindBy (xpath = ".//a[text()=' Contact us']")
	private WebElement contactUslstitleLink ; 
	
	
	
	
	
	// step 2  created constructor class
	
	public HomePage1stStep(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
		
	}
	public void clickOnHomeBtn() {
		hometitleLink.click();
	}

	
	public void clickOnProduct() {
		productstitleLink.click();
	}
	
	public void clickOnCart() {
		carttitleLink.click();
	}
	
	public void clickOnLoginOrSighnUpBtn() {
		signUpOrLoginBtntitleLink.click();
	}
	
    public void clickOnTestCases() {
		testCasestitleLink.click();
	}

    public void clickOnApiTesting() {
		apiTesttitleLink.click();
	}
    
    public void clickOnVideoTutorials() {
	videoTutorialstitleLink.click();
    }
    
    public void clickOnContactUs() {
	contactUslstitleLink.click();
    }

	
	
	
	
}
