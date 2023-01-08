package pages;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrdersPage extends AbstractComponent {
    WebDriver driver;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public Boolean isOrderDisplayed(String productName) {


        waitForElementToAppear(productNames.get(0));
        System.out.println("number of orders is "+productNames.size());
        Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;

    }
}
