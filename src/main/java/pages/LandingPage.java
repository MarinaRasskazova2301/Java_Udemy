package pages;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponent {


    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "userEmail")
    WebElement userEmailInput;

    @FindBy(id = "userPassword")
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut'")
    WebElement errorMessage;

    public ProductCatalogue loginApplication(String email, String password) {

        userEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new ProductCatalogue(driver);
    }

    public String getErrorMessage() {
        waitForElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
