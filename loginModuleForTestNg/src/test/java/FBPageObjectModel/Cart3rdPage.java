package FBPageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart3rdPage {
	
	public WebDriver driver ;
	
	
	@FindBy (xpath = ".//u[text()='here']")
	private WebElement clickHereToGoSearchProducts ;
	
	public Cart3rdPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
		public void clickOnHere() {
			clickHereToGoSearchProducts.click();
		}
	

}
