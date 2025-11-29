package fkPageObjectModelFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddToCartNavigatePage {
  
	public static WebDriver driver;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addToTheCart;

	
	
	public AddToCartNavigatePage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

   	
	public void clickOnThecart() {
		addToTheCart.click();
		
	}
		
		
	
}
