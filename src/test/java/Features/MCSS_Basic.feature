@Firefox
Feature: MCSS Basic Flow
  For initial test purpose


  Scenario: Change mailing address
    Given Navigate to MCSS login pages in "firefox"
    And Login with contact ID "1460584"
    And Select account "0806268281" in selection page
    Then Verify the account ID in landing page
    And Click on Account Settings
    And Expand Addresses
    And Click on Edit Email Address
    And Fill all the mandatory address fields
    And Click on Save button



