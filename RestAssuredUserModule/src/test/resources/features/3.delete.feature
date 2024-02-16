@delete_feature
Feature: Delete User Information
Background: 
    Given User provides Basic authentication credentials for delete user
  Scenario: Verify Delete request of user module with deleting by UserID
    Given Base url with valid delete endpoint
    And User provides valid user id
    When User creates delete request with endpoint deleteuser
    And User sends DELETE request to delete user with valid user id
    Then User receives a successful response
