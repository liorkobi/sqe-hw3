package hellocucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features")


public class storeTest {
    private String ADMIN_EMAIL = "admin@simplcommerce.com";
    private String ADMIN_PASSWORD = "1qazZAQ!";
    private String PRODUCT = "Esprit Ruffle Shirt";

    //Email: admin@simplcommerce.com Password: 1qazZAQ!
//  Esprit Ruffle Shirt
    private SimplCommerceActuator store;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\liork\\s\\chromedriver.exe";

    public storeTest() {
        store = new SimplCommerceActuator();
        store.initSession(webDriver, path);
    }

    public void SelectProductTest() {
        store.goToProduct(PRODUCT);
        store.addProductToCompare();
        store.ClickOnCompare();

    }
    public void DeleteProductTest() {
        store.goToLogIn();
        store.EnterLogInInfo(ADMIN_EMAIL,ADMIN_PASSWORD);
        store.GoToDashboard();
        store.openCatalog();
        store.productInCatalog();
        store.DeleteProduct(PRODUCT);
        store.ClickOnOK();

    }

}