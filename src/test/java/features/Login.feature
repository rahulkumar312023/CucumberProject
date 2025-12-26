Feature: Login feature

  Scenario: User should able to login with valid credentials
    Given User should be on the login page
    And User enter username on the username field
    And User enter password on the password field
    When User click on the login button
    Then User should navigate to product page
