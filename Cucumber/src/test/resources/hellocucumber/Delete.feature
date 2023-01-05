Feature: A set of scenarios for testing the "Delete product from store" module

  Scenario: Testing how a case where a user adds a product to the compare list
    Given Admin user is logged in
    When User Navigate to Dashboard Page
    And User click on Add to Catalog menu
    And User click on Products
    And User click on Delete product
    And User click on Ok
    Then Message displayed The product has been deleted

