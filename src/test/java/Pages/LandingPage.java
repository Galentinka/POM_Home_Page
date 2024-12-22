package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchTextBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='content']/h3")
    private WebElement featureText;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterProduct(String ProductText) {
        searchTextBox.sendKeys(ProductText);
    }

    public ProductPage clickOnSearchButton() {
        searchButton.click();
        return new ProductPage(driver);
    }

    public ProductPage navigateToProductPage(String ProductText) {
        searchTextBox.sendKeys(ProductText);
        searchButton.click();
        return new ProductPage(driver);
    }

    public boolean displayStatusOfFeatureText() {
        boolean status = featureText.isDisplayed();
        return status;
    }
}
