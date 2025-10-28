package task_OrangeHRM;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider

	public Object[][] validData() {
		
		Object obj[][] = {{ "Admin", "admin123" }} ;
		return obj;

	}

	@DataProvider

	public Object[][] invalidData() {

		Object obj[][] = { { "Ajisha", "axess123" } };
		return obj;

	}

}
