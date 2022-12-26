package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Assignment1 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkBoxOption1= driver.findElement(By.id("checkBoxOption1"));

//        checkBoxOption1.click();
//        Assert.assertTrue(checkBoxOption1.isSelected());
//
//        checkBoxOption1.click();
//        Assert.assertFalse(checkBoxOption1.isSelected());
//
//        List<WebElement> allCheckboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
//
//        Assert.assertEquals(allCheckboxes.size(), 3);
//
//        driver.quit();


    }
}
