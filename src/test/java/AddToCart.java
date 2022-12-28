import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AddToCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] productsAddToCart = {"Almonds", "Orange", "Potato", "Cashews"};

        List<WebElement> allProductsList = driver
                .findElements(By.cssSelector("div.products-wrapper div.product h4"));

        List<String> productNamesList = new ArrayList<>();

        for (int i = 0; i < allProductsList.size(); i++) {

            String[] productName = allProductsList.get(i).getText().split(" -");
            System.out.println(productName[0]);
            productNamesList.add(productName[0]);
        }
        List<String> itemsNeededList = Arrays.asList(productsAddToCart);

        int count=0;
        for (int i = 1; i < productNamesList.size(); i++) {
            if (itemsNeededList.contains(productNamesList.get(i))) {
                driver.findElements(By.xpath(" //div[@class='product-action']/button")).get(i).click();
                count++;
                if (count == productsAddToCart.length) {
                    break;
                }
            }

        }

    }
}
