package fkPageObjectModelFolder;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	

	@FindBy(xpath = ".//input[@name='q']")
	private WebElement searchBar;

	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterProductNameIntoSearchBar(String product) {
		searchBar.sendKeys(product);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	
	
}
