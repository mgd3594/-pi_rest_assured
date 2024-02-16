@Get_operations
Feature: User module with GET request

  Background: 
    Given User provides Basic authentication credentials

  @Get_001
  Scenario: Verify Get request to fetch all users
    Given User creates Get request with users Endpoint
    When User sends GET request
    Then User receives 200 OK status with all users list

  @Get_002
  Scenario: Verify Get request to fetch by User ID
    Given User creates Get request with userID Endpoint
    When User sends GET request with valid user id
    Then User receives 200 OK status

  @Get_003
  Scenario: Verify Get request to fetch by USER First Name
    Given User creates Get request with userFirstName Endpoint
    When User sends GET request with valid first name
    Then User receives 200 OK status

  @Get_004
  Scenario: Verify Get request to fetch all users with Invalid request
    Given User creates Get request with invalid users Endpoint to fetch all users
    When User sends invalid GET request to fetch all users
    Then User receives 400 Bad Request

  @Get_005
  Scenario: Verify Get request to fetch by Invalid User ID
    Given User creates Get request with Invalid userID Endpoint
    When User sends GET request with Invalid user id
    Then User receives 400 Bad request

  @Get_006
  Scenario: Verify Get request to fetch user with numeric values in First Name
    Given User creates Get request with numeric userFirstName Endpoint
    When User sends GET request with numeric values in first name
    Then User receives 404 Not found

  @Get_007
  Scenario: Verify Get request to fetch user with Invalid First Name
    Given User creates Get request with Invalid userFirstName Endpoint
    When User sends GET request with Invalid first name
    Then User receives 400 Bad Request
