package stepdefinitions;

import io.restassured.response.Response;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import Utils.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class deletestepdefinition {
    private RequestSpecification requestSpec;
    private Response response;
    ExcelReader.UserData userData = ExcelReader.readUserData();
    int userId = userData.getUserId();

    @Given("User provides Basic authentication credentials for delete user")
    public void user_provides_basic_authentication_credentials_for_delete_user() {
        String username = "Numpy@gmail.com";
        String password = "tim123";
        baseURI = "https://userapi-8877aadaae71.herokuapp.com";
        authentication = basic(username, password);
        requestSpec = given();
    }

    @Given("Base url with valid delete endpoint")
    public void base_url_with_valid_delete_endpoint() {
        System.out.println("User creates delete request with /user Endpoint " + userId);
        requestSpec = given().pathParam("userId", userId); // Set the path parameter
        response = requestSpec.delete("/deleteuser/{userId}"); // Send the DELETE request and store the response
    }

    @Given("User provides valid user id")
    public void user_provides_valid_user_id() {
        // This step can be used to provide additional context or verification
    }

    @When("User creates delete request with endpoint deleteuser")
    public void user_creates_delete_request_with_endpoint_deleteuser() {
        // This step can be used to describe the action of creating the DELETE request
    }

    @When("User sends DELETE request to delete user with valid user id")
    public void user_sends_delete_request_to_delete_user_with_valid_user_id() {
        // This step can be used to describe the action of sending the DELETE request
    }

    @Then("User receives a successful response")
    public void user_receives_a_successful_response() {
        // Depending on your test scenario, you might want to assert on the response status code or body
        response.then().statusCode(200);
    }
}
