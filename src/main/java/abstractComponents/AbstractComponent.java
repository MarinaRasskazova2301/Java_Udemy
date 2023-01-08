package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.OrdersPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "button[routerlink='/dashboard/myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public void waitForElementToDisappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public CartPage goToCardPage() {
        waitForElementToAppear(orderHeader);
        cartHeader.click();
        return new CartPage(driver);
    }
    public OrdersPage goToOrdersPage() throws InterruptedException {
        waitForElementToAppear(orderHeader);
        orderHeader.click();
        Thread.sleep(1000);
        OrdersPage ordersPage = new OrdersPage(driver);

        return ordersPage;

    }


}
