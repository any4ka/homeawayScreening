import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Anna Kruglyanskaya on 2/9/2016.
 */
public class WebAppTest {
    //Define Objects
    WebElement allProductLink() {
        return driver.findElement(By.xpath("//a[contains(.,'All Product')]"));
    }

    @FindBy(how = How.NAME, using = "s")
    WebElement searchBox;

    @FindBy(how = How.LINK_TEXT, using = "Apple iPhone 4S 16GB SIM-Free – Black")
    WebElement product;

    @FindBy(how = How.XPATH, using = "//*[@id=\"single_product_page_container\"]/div[1]/div[2]/form/div[2]/div[1]")
    WebElement addToCartButton;

    @FindBy(how = How.ID, using = "fancy_notification_content")
    WebElement confirmationOverlay;

    @FindBy(how = How.XPATH, using = "//*[@id=\"fancy_notification_content\"]/span")
    WebElement productConfirmation;

    @FindBy(how = How.XPATH, using = "//*[@id=\"fancy_notification_content\"]/a[1]")
    WebElement goToCheckoutButton;

    WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
    }

    @BeforeClass(alwaysRun = true)
    public void setUpDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        driver.get("http://store.demoqa.com/");
        allProductLink().wait();
        Assert.assertTrue(allProductLink().isDisplayed());
        searchBox.sendKeys("Apple 4s" + Keys.ENTER);
        Assert.assertTrue(product.isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}
