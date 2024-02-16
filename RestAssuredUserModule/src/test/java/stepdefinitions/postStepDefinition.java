package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basic;

public class postStepDefinition {
    private Response response;
    private int userId;
    private String username;

    @Given("User provides Basic authentication credentials for post request")
    public void user_provides_basic_authentication_credentials_for_post_request() {
        String username = "Numpy@gmail.com";
        String password = "tim123";
        baseURI = "https://userapi-8877aadaae71.herokuapp.com";
        authentication = basic(username, password);
    }

    @Given("User User creates Post request with requestbody from jsonFilePath")
    public void user_user_creates_post_request_with_requestbody_from_json_file_path() {
        // JSON data provided directly
        String jsonData = "{\n" +
                "    \"user_first_name\": \"sivaKishore\",\n" +
                "    \"user_last_name\": \"Ma\",\n" +
                "    \"user_contact_number\": \"9655443312\",\n" +
                "    \"user_email_id\": \"siva123@gmail.com\",\n" +
                "    \"userAddress\": {\n" +
                "      \"plotNumber\": \"s-m\",\n" +
                "      \"street\": \"sa lane\",\n" +
                "      \"state\": \"saintlouis\",\n" +
                "      \"country\": \"MO\",\n" +
                "      \"zipCode\": \"61146\"\n" +
                "    }\n" +
                "}";

        response = given()
                .contentType("application/json")
                .body(jsonData)
                .when()
                .post("/uap/createusers")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        // Extract user ID and username from the response
        userId = response.jsonPath().getInt("user_id");
        username = response.jsonPath().getString("user_first_name");
    }

    @When("User sends POST request for usermodule")
    public void user_sends_post_request_for_usermodule() {
        
        // Write user ID and username to an Excel file
        writeDataToExcel(userId, username);
    }

    @Then("User validate the response")
    public void user_validate_the_response() {
        System.out.println("Response code: " + response.getStatusCode());
    }

    // Method to write user ID and username to an Excel file
    private void writeDataToExcel(int userId, String username) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("User Data");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("User ID");
            headerRow.createCell(1).setCellValue("Username");

            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(userId);
            dataRow.createCell(1).setCellValue(username);

            // Write the workbook content to a file
            try (FileOutputStream fileOut = new FileOutputStream("userdata.xlsx")) {
                workbook.write(fileOut);
                System.out.println("User data written to userdata.xlsx file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to write user data to file: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to create Excel workbook: " + e.getMessage());
        }
    }
}
