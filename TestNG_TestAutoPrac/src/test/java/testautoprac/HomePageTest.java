package testautoprac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends Hooks{
	

	public HomePage home;
	
	@Test(description="Enter values in TextBox fields", dataProviderClass = TestData.class, dataProvider = "textBoxData", priority=0)
	public void enterTextBoxValues(String name, String email, String mobile) {
		
		home=new HomePage(driver);
		home.enterName(name);
		home.enterMail(email);
		home.enterPhone(mobile);
		
	}
	@Test(description="Enter values in RadioButton and CheckBox fields", dataProviderClass = TestData.class, dataProvider = "radioCheckData", priority=1)
	public void enterRadioCheckBoxValues(String genderValue, String[] daysToSelect) throws InterruptedException {
		home=new HomePage(driver);
		home.selectGender(genderValue);
		
		home.selectDaysCheckBox(daysToSelect);
	}

@Test(description="Verifying AlertButton Functionality", priority=2)
	public void acceptAlert() {
		home=new HomePage(driver);
		home.clickAlert();
	}

@Test(description="Verifying Table", priority=3)
public void CheckTable() {
	home=new HomePage(driver);
	home.verifyStaticTableDisplay();
	
}
}