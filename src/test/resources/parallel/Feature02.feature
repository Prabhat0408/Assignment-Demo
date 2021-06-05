Feature: API Tests

  Scenario: Validate Latest Launch Get Request
    Given Make a get call to fetch latest launch data
    Then Verify the status code 200
    And Verify if the response contains the following info
      | success | true           |
      | name    | CRS-22 & IROSA |
    Then Retrieve only one LaunchID

  Scenario: Validate Latest Launch Get Request-Negative Case when path is wrong
    Given Make a get call to fetch latest launch data with wrong context path
    Then Verify the status code 404

  Scenario: Validate only one Launch Get Request data
  	Given Make a get call to fetch latest launch data
    Then Make a get call to Retrieve One LaunchID Data
    Then Verify the status code 200
    And Verify if the response contains the following info
      | success | true           |
      | name    | CRS-22 & IROSA |
