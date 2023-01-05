package pages;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponent {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    @FindBy(css =".hero-primary")
    WebElement confirmationMessage;

    By confirmationMessageBy=By.cssSelector(".hero-primary");

    public String getConfirmationMessage(){
        waitForElementToAppear(confirmationMessageBy);
        return confirmationMessage.getText();
    }

}
