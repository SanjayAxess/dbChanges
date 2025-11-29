package AssuredDemoPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoRA1HomeClass {
	WebDriver driver;
	
	@FindBy(xpath = ".//input[@name='q']")
	private WebElement searchBar;

	public DemoRA1HomeClass (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterProductNameIntoSearchBar(String product) {
		searchBar.sendKeys(product);
		searchBar.sendKeys(Keys.ENTER);
	}

}
