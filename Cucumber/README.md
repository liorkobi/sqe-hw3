# Testing $$*TODO* software name$$ using Cucumber
This directory contains the cucumber files for testing the $$*TODO* module name$$ module of the $$*TODO* software name$$ application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

$$*TODO*: Make sure that the text inside the feature files is informative and self-explanatory. This includes the "Feature: ...", "Scenario: ...", and "Given/When/Then ..." lines. See the "example.feature" file for an example.$$

## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.

## bugs
1 bug was found - when a user adds a product to its compare list, then the admin delete the product from the store the product doesn't disappear from the compare list. 
for this reason the third scenario in the feature file fails. 
