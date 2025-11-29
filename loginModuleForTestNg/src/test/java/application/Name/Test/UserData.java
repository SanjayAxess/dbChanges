package application.Name.Test;

import org.testng.annotations.DataProvider;

public class UserData {

	@DataProvider
	public Object[][] testData2(){
		
		String data[][]= { {"Phone1","Apple","17pro"},
				           {"PHone2","Samsung","A15"},
				           {"PHone3","Redmi","11pro"},
				           {"PHone4","Oppo","13M",},
				           {"PHone5","Reno","Classic"}};
		return data;                                                  // multiple Data provider here
	
	}
	
	
	// we try to do fail this DataProvider4 ,Because we need to check for testNG.xml.Failure / file   
	
	
	@DataProvider
	public Object[][] testData4(){
		
		String data4[][]= { {"Phone1","ultta","abcde"},
				           {"PHone2","Pultta","12345"},
				           {"PHone3","Crasy","00exe"},
				           {"PHone4","Oppo","13M",},
				           {"PHone5","Reno","Classic"}};
		return data4;                                                  // multiple Data provider here
	
	}
	
	
	
	
	// WE Can Use Multiple Data Provider here
	/*
	@DataProvider
	public Object[][] testData3(){
		
		String data[][]= { {"Phone1","Apple","17pro"},
				           {"PHone2","Samsung","A15"},
				           {"PHone3","Redmi","11pro"},
				           {"PHone4","Oppo","13M",},
				           {"PHone5","Reno","Classic"}};
		return data;                                                  // multiple Data provider here
	
	}
	
	@DataProvider
	public Object[][] testData1(){
		
		String data[][]= { {"Phone1","Apple","17pro"},
				           {"PHone2","Samsung","A15"},
				           {"PHone3","Redmi","11pro"},
				           {"PHone4","Oppo","13M",},
				           {"PHone5","Reno","Classic"}};
		return data;                                                  // multiple Data provider here
	
	}
	
	*/
	
}
