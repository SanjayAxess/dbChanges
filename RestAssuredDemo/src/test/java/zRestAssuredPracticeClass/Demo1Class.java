package zRestAssuredPracticeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1Class {

/*	
	@Test
	public void getPetByID() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/123";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getStatusLine());
		
		response.then().statusCode(200).and().contentType("application/Json");
		
		//[Assert.assertEquals(200,response.getStatusCode());]
        org.testng.Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.asPrettyString());
		
		
	}
	
	*/
	
	
	@Test
	public void postUplodPetImage() throws IOException {
	
		
		/*
		String payload ="{\r\n"
				+ "  \"id\": 123,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 11,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 12,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "[no cookies]\r\n"
				+ ")";
	
	// 1 start , this way to do also test/ eppadium use  pannalam
		RestAssured.given().baseUri("https://petstore.swagger.io/").contentType(ContentType.JSON).body(payload)
		.when().post("/v2/pet")
		.then()
		.assertThat()
		.statusLine("HTTP/1.1 200 OK")
		.statusCode(200);   
	// 1 end, this way to do also test/ eppadium use  pannalam
	///
	///
	 */
		
		/*
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(payload);
		Response response = request.post();
		request.then().statusLine("HTTP/1.1 200 OK");
		
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		*/
		
		
		// 3 start , this way to do also test/ eppadium use  pannalam
		
		File fileF1 = new File("C:\\Users\\MATHANRAJI\\eclipse-workspace\\RestAssuredDemo\\src\\test\\resources\\jsonFIleFolder\\postPayload.json");
		String payload = new String (Files.readAllBytes(Paths.get(fileF1.getAbsolutePath())));
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(payload);
		Response response = request.post();
		request.then().statusLine("HTTP/1.1 200 OK");
		
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		// 3 end , this way to do also test/ eppadium use  pannalam
		
	}
	
	
	/*
	
	@Test
	public void putPet() {
		
		String payload ="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
	
		RestAssured.baseURI="https://petstore.swagger.io/#/";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(payload);
		Response response = request.put();
		
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
	}
	
	*/
	
	/*
	
	@Test
	public void putPet() {
		
		String payload ="";
	
		RestAssured.baseURI="https://petstore.swagger.io/#/pet/deletePet";
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(payload);
		Response response = request.delete();
		
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
	}
	*/
	
}
