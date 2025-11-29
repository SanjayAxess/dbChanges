package aPOMTestFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;


import fkPageObjectModelFolder.HomePage;
import fkPageObjectModelFolder.ProductPage;

public class ProductTest extends BaseClassTest {
	
	// @Test
	public void productSelect() throws InterruptedException {
		HomePage home = new HomePage(super.driver);
		home.enterProductNameIntoSearchBar("laptop");
		
		ProductPage product = new ProductPage(super.driver);
		product.clickOnBrand();
		product.clickOnApple();
		//product.clickOn2Brand();
		//product.clickOnMore();
		//product.clickOnSamsung();
		product.clickOnLowToHighprice();
		Thread.sleep(3000);
		product.clickOnFirstProduct();
		
		Thread.sleep(5000);
		
		 // Handle Multiple Windows usingIndexMethod
	   
	        
			Set<String> windowHandles = driver.getWindowHandles();
	        List<String> tabs = new ArrayList<>(windowHandles);
	        driver.switchTo().window(tabs.get(1));
	        
	        Thread.sleep(5000);
		
		// AddToCartNavigatePage cart = new AddToCartNavigatePage(super.driver);
		// cart.clickOnThecart();
		
	}

}
