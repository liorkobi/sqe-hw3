package hellocucumber;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private static List<SimplCommerceActuator> allMoodles;
    private static SimplCommerceActuator moodle;
    private String webDriver = "webdriver.chrome.driver";
//    private String path = "C:\\Users\\Owner\\Desktop\\selenium\\chromedriver.exe";
    private String path = "C:\\Users\\Liork\\s\\chromedriver.exe";


    public void moodleInit() {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allMoodles == null){
            allMoodles = new ArrayList<>();
        }
        commerceActuator = new SimplCommerceActuator();
        commerceActuatorList.add(commerceActuator);
        commerceActuator.initSession(webDriver, path,data);
    }
    @Given("^User is on Home Page$")
    public void init(){
        moodleInit(true);
    }
    @When("^User Navigate to Product \"([^\"]*)\" Page$")
    public void selectProduct(String product){
        commerceActuator.goToProduct(product,true);
    }
    @And("^User click on Add to Compare$")
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
    }

    //---------------------------------compere--------------------------

    @Given("^Admin user is logged in$")
    public void AdminLogIn(){
        moodle.goToLogIn();
        moodle.EnterLogInInfo("admin@simplcommerce.com","1qazZAQ!");
    }

    @When("^User Navigate to Dashboard Page$")
    public void DashboardNavigate(){
        moodle.GoToDashboard();
    }

    @And("^User click on Add to Catalog menu$")
    public void CatalogMenu(){
        moodle.openCatalog();
    }
    @And("^User click on Products$")
    public void Products(){
        moodle.productInCatalog();
    }
    @And("^User click on Delete product $")
    public void DeleteProduct(){
        commerceActuator.DeleteProduct();
    }
    @And("^User click on Ok$")
    public void OK(){
        moodle.ClickOnOK();
    }

    @Then("^Message displayed The product has been deleted$")
    public void DeletemessageDisplayed(){
        System.out.println("Message displayed Successfully");
    }
    @And("^Admin is on Home Page$")
    public void returnToHomePage(){
        commerceActuator.AdminToHome();
    }
    @And("^Admin Navigate to Product \"([^\"]*)\" Page not exist$")
    public void verifyDeletion(String product){
        commerceActuator.goToProduct(product,false);
//        terminate();
    }

    @And("^Admin is loggedIn in new page$")
    public void loggedInnNewPage(){
        moodleInit(false);
        AdminLogIn();

    }
    @Then("^User refresh compere products page$")
    public void refresh() {
        String url= commerceActuatorList.get(1).getURL();
        commerceActuatorList.get(1).refresh(url);
    }
    @And("^There is no products in page$")
    public void noProducts() {
        commerceActuatorList.get(1).assertNoProducts();
        terminate();
    }

    private void terminate(){
        System.out.println("in terminate");
        for(SimplCommerceActuator m : allMoodles)
            m.terminateDriver();
    }


}
