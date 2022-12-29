package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        int checkboxIndex = 1;
        String labelXpath = "//legend[text()='Checkbox Example']/parent::fieldset/label[" + checkboxIndex + "]";
        String checkBoxXpath = labelXpath + "/input";
        WebElement labelChosen = driver.findElement(By.xpath(labelXpath));
        WebElement checkboxChosen = driver.findElement(By.xpath(checkBoxXpath));

        checkboxChosen.click();
        String labelText = labelChosen.getText();

        Select dropdownExample = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdownExample.selectByVisibleText(labelText);

        driver.findElement(By.id("name")).sendKeys(labelText);
        driver.findElement(By.id("alertbtn")).click();

        String alertText=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertTrue(alertText.contains(labelText));
        driver.quit();
    }

}
