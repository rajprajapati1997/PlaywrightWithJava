Feature: Product Search
  As a nopCommerce user
  I want to search for products
  So that I can find items I am interested in

  Scenario: Search for an existing product
    Given I open the nopCommerce demo homepage
    When I enter "laptop" in the search box
    And I click the search button
    Then I should see search results for "laptop"

  Scenario: Search for a non-existent product
    Given I open the nopCommerce demo homepage
    When I enter "xyznotfound" in the search box
    And I click the search button
    Then I should see search results for "xyznotfound"

  Scenario: Search with an empty query
    Given I open the nopCommerce demo homepage
    When I enter "" in the search box
    And I click the search button
    Then I should see search results for ""
