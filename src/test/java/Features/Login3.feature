@Chrome
Feature: Login 3 Feature
  Just to test a login functionality


  Scenario: Login with valid credentials
    Given I navigate to login page in "chrome"
    And I enter user name admin and password admin
    And click login button
    Then I should see user form