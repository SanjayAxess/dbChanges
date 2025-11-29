package zRestAssuredPracticeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class Demo2ClassFileReading {
	
	
	@Test
	public void postUplodPetImage1() throws IOException {
		
		
		File fileF1 = new File("C:\\Users\\MATHANRAJI\\eclipse-workspace\\RestAssuredDemo\\src\\test\\resources\\jsonFIleFolder\\postPayload.json");
		String payload = new String (Files.readAllBytes(Paths.get(fileF1.getAbsolutePath())));
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(payload);
		
		
		Response response = request.post();
		
		
		response.then().body("id", equalTo(123));           // check 12/11/2025 video  11.43 am time and check Jmeter
		
		response.then().body("category.id", equalTo(11)); 
		
		response.then().body("category.name", equalTo("string")); 
		
		response.then().body("tags[0].id", equalTo(12));   // comparing tags with array[] , Arrays always starts with zero (0)
		
		request.then().statusLine("HTTP/1.1 200 OK");
		
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		
	
	}
}
