package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimplCommerceActuator {
    private WebDriver driver;
    private WebDriverWait wait;

    public void initSession(String webDriver, String path){
        webDriver = "webdriver.chrome.driver";
        path = "C:\\Users\\Owner\\Desktop\\selenium\\chromedriver.exe";
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
        driver.findElement(By.xpath("/html/body/div[4]/div[5]/form/div/div[3]/button")).click();



        /*
            If we wanted to test the web application on different devices -
                1. Open the web app
                2. Right click -> click inspect
                3. Click on the phone icon at the top left corner of the inspect window (the app changes preview format at this point)
                4. Locate the dimensions drop-down list at the top of the web app and choose device
                5. Copy dimensions size (on the right side of the drop-down list)
                   -> driver.manage().window().setSize(new Dimension(width, height));
         */

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void goToProduct(String product) {
        driver.findElement(By.xpath("//img[@alt='" + product + "']")).click();
    }

    public void addProductToCompare() {
        driver.findElement(By.cssSelector(".add-to-comparison")).click();

    }



    public void terminateDriver() {
        // close all the driver windows
        // another option - to close a browser window: driver.close();
        driver.quit();
    }

    public void ClickOnCompare() {
        long timeoutInSeconds=(long) 40;

        this.wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopModal\"]/div/div/div[3]/a"))).click();
    }

    public void goToLogIn() {
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/a")).click();

    }

    public void EnterLogInInfo(String adminEmail, String adminPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Email\"]"))).sendKeys(adminEmail);

        // locate the password input box and enter password
        // $x("//*[@name='password' and @type='password']")
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(adminPassword);

        // locate Log in button and press
        // $x("//*[@id='loginbtn']")
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/section/form/div[5]/div/button")).click();
    }
    public void GoToDashboard() {
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a\n")).click();

    }
    public void openCatalog() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")).click();

    }
    public void productInCatalog() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/ul/li[1]/a\n")).click();
    }
        public void DeleteProduct(String product) {
        WebDriverWait wait=new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/table/tbody[1]/tr[19]/td[10]/button[2]"))).click();

        }

    public void ClickOnOK() {
        WebDriverWait wait=new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/button[2]"))).click();

    }






}
