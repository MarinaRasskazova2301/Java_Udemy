import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropdownWithButtons {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropdownPassengers = driver.findElement(By.id("divpaxinfo"));
        dropdownPassengers.click();

        WebElement addAdultButton = driver.findElement(By.id("hrefIncAdt"));
        Thread.sleep(1000L);
        clickButtonMultipleTimes(driver, addAdultButton, 3);

        WebElement subtractAdultButton = driver.findElement(By.id("hrefDecAdt"));
        clickButtonMultipleTimes(driver, subtractAdultButton, 2);
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(dropdownPassengers.getText(), "2 Adult");
        driver.quit();
    }


    static void clickButtonMultipleTimes(WebDriver driver, WebElement button, int times) {
        for (int i = 0; i < times; i++) {
            button.click();
        }

    }

}
