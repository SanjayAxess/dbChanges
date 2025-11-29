package aPOMTestFolder;



import org.testng.annotations.Test;

import fkPageObjectModelFolder.HomePage;


public class Hometest extends BaseClassTest{
	//HomePage home;
	//ProductPage product;

    @Test (description = "DemoTest id : 12345")
	public void productSearchBox() {
		HomePage home = new HomePage(super.driver);
		home.enterProductNameIntoSearchBar("iphone");
	}
	
}
