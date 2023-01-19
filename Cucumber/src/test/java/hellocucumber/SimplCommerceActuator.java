package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SimplCommerceActuator {
    private WebDriver driver;
    private WebDriverWait wait;

    public void initSession(String webDriver, String path,Boolean data){
        webDriver = "webdriver.chrome.driver";
//        path = "C:\\Users\\Owner\\Desktop\\selenium\\chromedriver.exe";
        path = "C:\\Users\\Liork\\s\\chromedriver.exe";
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        long timeoutInSeconds=(long) 40;
        this.wait = new WebDriverWait(driver, timeoutInSeconds);


        // launch website -> localhost
        driver.get("http://localhost:5000/");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cookieConsent\"]/div/div/div/button")).click();
        if(data)
            driver.findElement(By.xpath("/html/body/div[4]/div[5]/form/div/div[3]/button")).click();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    /**
     * insert product name in search feaild and click on search.
     * parameters:
     * product - String: product name
     * assert_- Boolean: if true -> this action happend befor deletion of the product from the store and it is exist
     *                   if false -> this action  append after the product deleted and it doesnt exist
     */
    public void goToProduct(String product,Boolean assert_) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Query\"]"))).sendKeys(product);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/button")).click();
        WebElement element = driver.findElement(By.cssSelector("small.badge-results"));
        String expectedText;
        String actualText = element.getText();
        if(assert_){
            expectedText = "1 Results";
            assertEquals(actualText,expectedText);
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/div/a/img")).click();
        }
        else {
            expectedText = "0 Results";
            assertEquals(actualText,expectedText);

        }
    }

    /**
     * add  a  product to the compare list - mid level the product is not in the compare list yet
     * parameters: None
     */
    public void addProductToCompare() {
        driver.findElement(By.cssSelector(".add-to-comparison")).click();

    }


    /**
     * close the driver session
     * parameters: None
     */
    public void terminateDriver() {
        driver.quit();
    }

    /**
     * add  a  product to the compare list - final - the product is in the compate list
     * parameters: None
     */
    public void ClickOnCompare() {
        long timeoutInSeconds=(long) 40;

        this.wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopModal\"]/div/div/div[3]/a"))).click();
    }

    /**
     * navigate to the log in window
     * parameters: None
     */
    public void goToLogIn() {
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/a")).click();

    }

    /**
     * enter the email and password in order to log in the store
     * parameters:
     * String - adminEmail - email
     * String- password: password
     */
    public void EnterLogInInfo(String adminEmail, String adminPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Email\"]"))).sendKeys(adminEmail);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(adminPassword);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/section/form/div[5]/div/button")).click();
    }

    /**
     * open the dashboard main menu
     * parameters: None
     */
    public void GoToDashboard() {
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a\n")).click();

    }

    /**
     * open the catalog menu
     * parameters: None
     */
    public void openCatalog() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")).click();

    }
    /**
     * choose the products tab in catalog menu
     * parameters: None
     */
    public void productInCatalog() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/ul/li[1]/a\n")).click();
    }
    /**
     * press delete the selected product from the menu
     * parameters: None
     */
        public void DeleteProduct() {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/table/tbody[1]/tr[19]/td[10]/button[2]"))).click();
            }
    /**
     * press ok for delete the selected product from the menu
     * parameters: None
     */

    public void ClickOnOK() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/button[2]"))).click();

    }
    /**
     * navigate to the home page
     * parameters: None
     */

    public void AdminToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logoutForm\"]/ul/li[1]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/a/img"))).click();
    }


}
