Feature:product


  Scenario: Testing a case where a user adds a product to the compare list
    Given Admin user is logged in
    When User Navigate to Dashboard Page
    And User click on Add to Catalog menu
    And User click on Products
    And User click on Delete product
    And User click on Ok
    Then Message displayed The product has been deleted


  Scenario: Testing a case where a user adds a product to the compare list
    Given User is on Home Page
    When User Navigate to Product Page
    And User click on Add to Compare
    Then Message displayed The product has been added to comparison items
    And User click on Compare
    And User in Compare products page
