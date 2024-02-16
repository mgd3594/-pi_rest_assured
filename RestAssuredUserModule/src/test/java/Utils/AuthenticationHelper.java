package Utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AuthenticationHelper {
	protected RequestSpecification basicauth(String username,String password) {
		return RestAssured.given().auth().preemptive().basic(username, password);
		
	}
	
}
