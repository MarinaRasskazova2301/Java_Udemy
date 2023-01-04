package workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String name="Maryna";
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        String alertText=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(alertText, "Hello "+name+", share this practice page and share your knowledge");
    }
}
