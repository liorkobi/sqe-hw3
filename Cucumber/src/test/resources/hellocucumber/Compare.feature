Feature: A set of scenarios for testing the "Add to compare" module

  Scenario: Testing how a case where a user adds a product to the compare list
    Given User is on Home Page
    When User Navigate to Product Page
    And User click on Add to Compare
    Then Message displayed The product has been added to comparison items
    And User click on Compare
    And User in Compare products page





