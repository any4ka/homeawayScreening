
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Anna Kruglyanskaya on 2/9/2016.
 */
public class WebAppTest {
    WebDriver driver;
    WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
    }

    //Define Objects
    //@FindBy(how = How.XPATH, using = "//a[contains(.,'All Product')]")
    WebElement allProductLink() {
        return driver.findElement(By.xpath("//a[contains(.,'All Product')]"));
    }

    // @FindBy(how = How.NAME, using = "s")
    WebElement searchBox() {
        return driver.findElement(By.xpath("//input[@class='search']"));
    }

    // @FindBy(how = How.LINK_TEXT, using = "Apple iPhone 4S 16GB SIM-Free – Black")
    WebElement product() {
        return driver.findElement(By.xpath("//a[contains(.,'Apple iPhone 4S 16GB SIM-Free – Black')]"));
    }

    WebElement productTitle() {
        return driver.findElement(By.xpath("//h1[@class='prodtitle']"));
    }

    //@FindBy(how = How.XPATH, using = "//*[@id=\"single_product_page_container\"]/div[1]/div[2]/form/div[2]/div[1]")
    WebElement addToCartButton() {
        return driver.findElement(By.xpath("//input[@value='Add To Cart']"));
    }

    // @FindBy(how = How.ID, using = "fancy_notification_content")
    WebElement confirmationOverlay() {
        return driver.findElement(By.id("fancy_notification_content"));
    }

    // @FindBy(how = How.XPATH, using = "//*[@id=\"fancy_notification_content\"]/span")
    WebElement productConfirmation() {
        return driver.findElement(By.xpath("//span[contains(.,'You just added \"Apple iPhone 4S 16GB SIM-Free - Black\" to your cart.')]"));
    }

    //@FindBy(how = How.XPATH, using = "//*[@id=\"fancy_notification_content\"]/a[1]")
    WebElement goToCheckoutButton() {
        return driver.findElement(By.xpath("//a[@class='go_to_checkout']"));
    }

    WebElement continueButton() {
        return driver.findElement(By.xpath("//span[contains(.,'Continue')]"));
    }

    WebElement countryDropdown() {
        return driver.findElement(By.id("current_country"));
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @BeforeClass(alwaysRun = true)
    public void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10000);
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        driver.get("http://store.demoqa.com/");
        waitForElement(searchBox());
        searchBox().sendKeys("Apple 4s" + Keys.ENTER);

        waitForElement(product());
        Assert.assertTrue(product().getText().contains("Apple iPhone 4S 16GB SIM-Free – Black"));
        product().click();

        waitForElement(productTitle());
        Assert.assertTrue(productTitle().getText().contains("Apple iPhone 4S 16GB SIM-Free – Black"));

        addToCartButton().click();
        waitForElement(confirmationOverlay());
        //Explicit Wait
        Thread.sleep(10000);
        waitForElement(goToCheckoutButton());
        goToCheckoutButton().click();

        waitForElement(continueButton());
        continueButton().click();

        waitForElement(countryDropdown());
        Select select = new Select(countryDropdown());
        select.selectByVisibleText("USA");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}
