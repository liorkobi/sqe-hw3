Feature:product

  Scenario Outline: Testing a case where a user adds a product to the compare list
    Given User is on Home Page
    When User Navigate to Product <Product> Page
    And User click on Add to Compare
    Then Message displayed The product has been added to comparison items
    And User click on Compare
    And User in Compare products page
    Examples:
      | Product   |
      | "Esprit Ruffle Shirt" |

  Scenario Outline: Testing a case where an admin deletes a product
    Given Admin user is logged in
    When User Navigate to Dashboard Page
    And User click on Add to Catalog menu
    And User click on Products
    And User click on Delete product
    And User click on Ok
    Then Message displayed The product has been deleted
    And Admin is on Home Page
    And Admin Navigate to Product <Product> Page not exist

    Examples:
      | Product   |
      | "Esprit Ruffle Shirt" |


  Scenario Outline: Testing a case where a user adds a product to the compare list and then the admin delete it
    Given User is on Home Page
    When User Navigate to Product <Product> Page
    And User click on Add to Compare
    And Message displayed The product has been added to comparison items
    And User click on Compare
    And User in Compare products page
    And Admin is loggedIn in new page
    And User Navigate to Dashboard Page
    And User click on Catalog menu
    And User click on Products
    And User click on Delete product <Product>
    And User click on Ok
    And Message displayed The product has been deleted
    Then User refresh compere products page
    And There is no products in page

    Examples:
      | Product   |
      | "Esprit Ruffle Shirt" |
