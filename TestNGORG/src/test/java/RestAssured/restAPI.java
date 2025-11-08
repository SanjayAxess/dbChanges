package RestAssured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class restAPI {
    @Test(enabled = true)
    public void GetMethod() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.get("/posts/1");
        String responseBody = response.prettyPrint();
        System.out.println("RESPONSE BODY" + responseBody);
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

    @Test(enabled = false)
    public void PostMethod() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userID", 11);
        jsonObject.put("id", 101);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);
         httpRequest
                .when()
                    .post("/posts")
                .then()
                    .statusCode(201)
                .log().all();
    }

}
