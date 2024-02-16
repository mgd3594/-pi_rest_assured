@Post_feature
Feature: User module with POST request
  Background: 
    Given User provides Basic authentication credentials for post request
  Scenario: To post multiple users
  	Given User User creates Post request with requestbody from jsonFilePath
    When User sends POST request for usermodule
    Then User validate the response
  	