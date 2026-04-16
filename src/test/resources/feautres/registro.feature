Feature: User Registration

  Scenario: Successful registration with valid data
    Given the user navigates to the register page
    When the user fills the form with first name "Daniel4", last name "Huatuco4", email "202313516@cibertec.pe4", phone "987654321" and password "Test@12345"
    And accepts the privacy policy
    And clicks on continue
    Then the user should see the message "Your Account Has Been Created!"