package pages;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "div.user__address input")
    WebElement countryDropdown;

    @FindBy(css = "span.ng-star-inserted")
    List<WebElement> countriesList;

    //driver.findElement((By.cssSelector(".action__submit"))).click();
    @FindBy(css = ".action__submit")
    WebElement placeOrderButton;

    By countriesBy = By.cssSelector(".ta-results");


    public void selectCountry(String countryNamePart, String countryName) throws InterruptedException {
        countryDropdown.sendKeys(countryNamePart);
        Thread.sleep(1000);
        waitForElementToAppear(countriesBy);

        System.out.println("Countries->");
        countriesList.stream().map(WebElement::getText).forEach(System.out::print);

        WebElement searchedCountry = countriesList.stream()
                .filter(country -> country.getText().equals(countryName))
                .findFirst().get();

        System.out.println(" searched country " + searchedCountry.getText());
        searchedCountry.click();
    }

    public ConfirmationPage submitOrder() {
        placeOrderButton.click();
        return new ConfirmationPage(driver);
    }

}
