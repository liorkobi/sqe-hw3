package hellocucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private static List<SimplCommerceActuator> allMoodles;
    private static SimplCommerceActuator moodle;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\liork\\s\\chromedriver.exe";


    public void moodleInit() {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allMoodles == null){
            allMoodles = new ArrayList<>();
        }
        moodle = new SimplCommerceActuator();
        allMoodles.add(moodle);
        moodle.initSession(webDriver, path);
    }
    @Given("^User is on Home Page$")
    public void init(){
        moodleInit();
    }

    @When("^User Navigate to Product Page$")
    public void selectProduct(String product){
        moodle.goToProduct(product);
    }

    @And("^User click AddToCompare$")
    public void addToCompare(){
        moodle.addProductToCompare();
    }

    @Then("^Message displayed The product has been added to comparison items$")
    public void messageDisplayed(){
        System.out.println("Message displayed Successfully");
    }
    @And("^User click on Compare$")
    public void ClickCompare(){
        moodle.ClickOnCompare();
    }
    @And("^User in Compare products page$")
    public void CompareProductsPage(){
        System.out.println("Product added Successfully");
        terminate();
    }

    private void terminate(){
        System.out.println("in terminate");
        for(SimplCommerceActuator m : allMoodles)
            m.terminateDriver();
    }



}
