package application.Name.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import FBPageObjectModel.HomePage1stStep;

public class Cartpagetest extends BaseClassPageInitialTest {
	
	HomePage1stStep home;
	
	@Test
	public void ClickOnCartLinks() {
		
		home = new HomePage1stStep(super.driver);
		home.clickOnCart();
				
	}
	

}
