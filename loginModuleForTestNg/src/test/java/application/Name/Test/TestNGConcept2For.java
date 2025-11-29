package application.Name.Test;

import org.testng.annotations.Test;

public class TestNGConcept2For {

	@Test(dataProviderClass = UserData.class , dataProvider = "testData2")
	public void login(String ProductName , String BrandName, String ModelName) {
		
		System.out.println(ProductName +" "+ BrandName+" "+ ModelName );
	}
	
	@Test
    public void logout() {
		
		System.out.println("Logout iS Running ");
	}
}
