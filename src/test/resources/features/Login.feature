Feature: Login and UI Elements

  Scenario: Successful login with valid credentials
    Given I open the nopCommerce demo homepage
    When I click on the "Log in" link
    And I enter email "testuser@demo.com" and password "Test@123"
    And I click the "Log in" button
    Then I should see "My account" in the header

  Scenario: Search for a product
    Given I open the nopCommerce demo homepage
    When I enter "laptop" in the search box
    And I click the search button
    Then I should see search results for "laptop"

  Scenario: Interact with different UI elements
    Given I open the nopCommerce demo homepage
    When I select "Books" from the top menu
    And I sort products by "Price: Low to High"
    And I add the first book to the cart
    Then the shopping cart should have 1 item
