Feature: User Registration

  Scenario: Register a new user with valid details
    Given I open the nopCommerce demo homepage
    When I click on the "Register" link
    And I select gender "Male"
    And I enter first name "Raj" and last name "Prajapati"
    And I enter email "raj.qa.demo+1@gmail.com"
    And I enter password "Test@123" and confirm password "Test@123"
    And I click the "Register" button
    Then I should see "Your registration completed" message
