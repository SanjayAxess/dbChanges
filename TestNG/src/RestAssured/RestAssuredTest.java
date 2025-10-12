package RestAssured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class RestAssuredTest {
    @Test
    public void GetCall(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RequestSpecification http = RestAssured.given();

    }

}
