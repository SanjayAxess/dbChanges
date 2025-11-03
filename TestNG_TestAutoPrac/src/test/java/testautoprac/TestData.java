package testautoprac;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider
	public Object[][] textBoxData() {
		
		Object obj[][] = {{"Muhammad", "a@abc.com", "0123456789"}};
		return obj;

	}
	
	@DataProvider
	public Object[][] radioCheckData() {
		
		Object obj[][] = {{"female", new String[]{"sunday", "tuesday", "friday"}}};
		return obj;

	}
}
