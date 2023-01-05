package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class E2ETest {

    @Test
    public void buyProduct() throws InterruptedException {

        String productName = "ZARA COAT 3";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //  driver.get("https://rahulshettyacademy.com/client/");
        LandingPage landingPage = new LandingPage(driver);
        if (landingPage.driver == null) {
            System.out.println("Driver on landing page is null---");
            driver.quit();
        }
        landingPage.goTo();

        landingPage.loginApplication("mari4@gmail.com", "1234@qwE");

        ProductCatalogue productCatalogue = landingPage.loginApplication("mari4@gmail.com", "1234@qwE");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cardPage = productCatalogue.goToCardPage();

        // CartPage cardPage=new CartPage(driver);
        Thread.sleep(1000);
        Boolean match = cardPage.isProductDisplayed(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cardPage.goToCheckout();
        checkoutPage.selectCountry("ind", "India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String actualConfirmationMessage = confirmationPage.getConfirmationMessage();


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
        //   String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
          Assert.assertTrue(actualConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }


}
