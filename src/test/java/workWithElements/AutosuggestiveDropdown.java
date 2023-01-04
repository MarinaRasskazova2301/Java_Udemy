package workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement autosuggestDropdown= driver.findElement(By.id("autosuggest"));
        autosuggestDropdown.sendKeys("ind");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='India']")).click();
        driver.quit();
    }
}
