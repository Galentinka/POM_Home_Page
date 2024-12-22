package TestCases;

import Pages.LandingPage;
import Pages.ProductPage;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PresenceOfElementTest extends TestBase {

    public PresenceOfElementTest() {
        super();
    }

    public WebDriver driver;
    public LandingPage landingPage;
    public ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = initializeBrowser();
        landingPage = new LandingPage(driver);
    }

    @Test
    public void verifyPresenceOfElementAndNavigateToOtherPage() {

        landingPage.displayStatusOfFeatureText();
        productPage = landingPage.navigateToProductPage("HP");
        Assert.assertTrue(productPage.displayStatusOfHPLaptop());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
