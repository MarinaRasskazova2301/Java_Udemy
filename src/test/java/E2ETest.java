import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductCatalogue;

import java.time.Duration;
import java.util.List;

public class E2ETest {

    @Test
    public void buyProduct() {

        String productName = "ZARA COAT 3";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      //  driver.get("https://rahulshettyacademy.com/client/");
        LandingPage landingPage = new LandingPage(driver);
landingPage.goTo();
       // landingPage.goTo();
        landingPage.loginApplication("mari4@gmail.com", "1234@qwE");

        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
          List<WebElement> products=productCatalogue.getProductList();
          productCatalogue.addProductToCart(productName);

//        driver.findElement(By.id("userEmail")).sendKeys("mari4@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("1234@qwE");
//        driver.findElement(By.id("login")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//
//        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

//        WebElement prod = products.stream()
//                .filter(product -> product
//                        .findElement(By.cssSelector("b"))
//                        .getText().equals(productName))
//                .findFirst()
//                .orElse(null);

//        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
     //   Thread.sleep(1000L);
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        System.out.println("List of products ->");
        cartProducts.stream().forEach(pr -> System.out.println(pr.getText()));

        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        driver.findElement(By.cssSelector("div.user__address input")).sendKeys("ind");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        List<WebElement> countriesList = driver.findElements(By.cssSelector("span.ng-star-inserted"));

        System.out.println("Countries->");
        countriesList.stream().forEach(c -> System.out.println(c.getText()));

        WebElement searchedCountry = countriesList.stream().filter(country -> country.getText().equals("India")).findFirst().get();

        searchedCountry.click();

        driver.findElement((By.cssSelector(".action__submit"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }


}
