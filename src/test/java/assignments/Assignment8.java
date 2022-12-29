package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Assignment8 {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement autosuggestiveDropdown = driver.findElement(By.cssSelector("input#autocomplete"));
        String textEnterInDropdown="ar";
        autosuggestiveDropdown.sendKeys(textEnterInDropdown);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-1 li")));
        List<WebElement> autosuggestDropdownItems = driver.findElements(By.cssSelector("#ui-id-1 li"));

        Actions a = new Actions(driver);

        String countryName="Bulgaria";
        for (WebElement item : autosuggestDropdownItems) {
            if (item.getText().equalsIgnoreCase(countryName)) {
                a.moveToElement(item).click().build().perform();
                break;
            }
        }

          Assert.assertEquals(autosuggestiveDropdown.getAttribute("value"), countryName);
        driver.quit();
    }
}

