package stepdefinitions;
import Utils.ExcelReader;
import Utils.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getStepDefinitionPage extends JsonReader{
	
	private RequestSpecification requestSpec;
	private Response response;
	ExcelReader.UserData userData = ExcelReader.readUserData();
	int userId = userData.getUserId();
	String username = userData.getUsername();
	
@Given("User provides Basic authentication credentials")
public void user_provides_basic_authentication_credentials() {
	String username = "Numpy@gmail.com";
    String password = "tim123";
    RestAssured.baseURI="https://userapi-8877aadaae71.herokuapp.com/uap";
    //requestSpec = given()
          //  .header("Authorization", "Basic " + RestAssured.baseURI)
           // .auth().preemptive().basic(username, password);
   requestSpec = RestAssured.given() .auth().preemptive().basic(username, password);
    
}

@Given("User creates Get request with users Endpoint")
public void user_creates_get_request_with_users_endpoint(){
		System.out.println("User creates get request with /user Endpoint");
			response=requestSpec.get("/users");
}

@When("User sends GET request")
public void user_sends_get_request() {
    
}

@Then("User receives {int} OK status with all users list")
public void user_receives_ok_status_with_all_users_list(int statusCode) {
	System.out.println("Received response with status code: " + response.getStatusCode());
    
	response.then().statusCode(statusCode);
}

@Given("User creates Get request with userID Endpoint")
public void user_creates_get_request_with_user_id_endpoint(){
	
    response = requestSpec.get("/user/{userId}", userId);
    System.out.println(response.statusCode());
	
}

@When("User sends GET request with valid user id")
public void user_sends_get_request_with_valid_user_id() {
    
}

@Then("User receives {int} OK status")
public void user_receives_ok_status(Integer int1) {
    
}

@Given("User creates Get request with userFirstName Endpoint")
public void user_creates_get_request_with_user_first_name_endpoint() {
	
	
    response = requestSpec.get("users/username/{userFirstName}", username);
    System.out.println(response.statusCode());
}

@When("User sends GET request with valid first name")
public void user_sends_get_request_with_valid_first_name() {
   
}

@Given("User creates Get request with invalid users Endpoint to fetch all users")
public void user_creates_get_request_with_invalid_users_endpoint_to_fetch_all_users() {
    
}

@When("User sends invalid GET request to fetch all users")
public void user_sends_invalid_get_request_to_fetch_all_users() {
    
}

@Then("User receives {int} Bad Request")
public void user_receives_bad_request1(Integer int1) {
    
}

@Given("User creates Get request with Invalid userID Endpoint")
public void user_creates_get_request_with_invalid_user_id_endpoint() {
    
}

@When("User sends GET request with Invalid user id")
public void user_sends_get_request_with_invalid_user_id() {
    
}

@Then("User receives {int} Bad request")
public void user_receives_bad_request(Integer int1) {
    
}

@Given("User creates Get request with numeric userFirstName Endpoint")
public void user_creates_get_request_with_numeric_user_first_name_endpoint() {
    
}

@When("User sends GET request with numeric values in first name")
public void user_sends_get_request_with_numeric_values_in_first_name() {
    
}

@Then("User receives {int} Not found")
public void user_receives_not_found(Integer int1) {
   
}

@Given("User creates Get request with Invalid userFirstName Endpoint")
public void user_creates_get_request_with_invalid_user_first_name_endpoint() {
    
}

@When("User sends GET request with Invalid first name")
public void user_sends_get_request_with_invalid_first_name() {
   
}


}