package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[value='user']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

        driver.findElement(By.id("okayBtn")).click();
        Select typeOfWorkerDropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
        typeOfWorkerDropdown.selectByVisibleText("Consultant");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.urlContains("angularpractice/shop"));

        List<WebElement> addButtonsAll = driver.findElements(By.cssSelector("div.card button.btn"));

        addButtonsAll.stream().forEach(addButton -> addButton.click());
        driver.findElement(By.cssSelector("a.nav-link.btn-primary")).click();

    }
}
