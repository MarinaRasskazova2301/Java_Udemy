package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.name("courses"));

        System.out.println("There are " + table.findElements(By.tagName("tr")).size() + " rows in table");
        System.out.println("There are " + table.findElements(By.cssSelector("tr th")).size() + " columns in table");
        System.out.println("The text in 2d row is: ");

        List<WebElement> tableRow2 = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        tableRow2.stream().map(cell -> cell.getText()).forEach(cellText -> System.out.print(cellText + " "));

        driver.quit();

    }
}
