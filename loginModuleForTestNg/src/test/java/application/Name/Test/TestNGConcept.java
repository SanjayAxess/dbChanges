package application.Name.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGConcept {

	
		
	
	
	@Test(dataProviderClass = UserData.class,  dataProvider = "testData2")
	public void signUp (String ProductName , String BrandName, String ModelName) {
		
		System.out.println("Phone Details is : "+ ProductName + "Brand Detalai is : "+ BrandName + "Model Is : "+ ModelName );
	}
	
	

	@Test(dataProviderClass = UserData.class,  dataProvider = "testData4")
	public void signUps (String ProductNames , String BrandNames, String ModelNames) {
		
		System.out.println("Phone Details is : "+ ProductNames + "Brand Detalai is : "+ BrandNames + "Model Is : "+ ModelNames );
	}
	
	
	
	/*

	@Test(dataProvider = "testData1")
	public void signUp (String ProductName , String BrandName, String ModelName) {
		
		System.out.println("Phone Details is : "+ ProductName + "Brand Detalai is : "+ BrandName + "Model Is : "+ ModelName );
	}
	 */
}
