package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement inputName = driver.findElement(By.xpath("//form[contains(@class, 'ng-pristine')]//input[@name='name']"));
        WebElement inputEmail = driver.findElement(By.xpath("//form[contains(@class, 'ng-pristine')]//input[@name='email']"));
        WebElement inputPassword = driver.findElement(By.id("exampleInputPassword1"));
        WebElement checkboxLoveIceCream = driver.findElement(By.id("exampleCheck1"));
        Select dropdownGender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        WebElement radiobuttonStudentEmploymentStatus = driver.findElement(By.id("inlineRadio1"));
        WebElement inputDateOtBirth = driver.findElement(By.xpath("//form[contains(@class, 'ng-pristine')]//input[@name='bday']"));
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[contains(@class,'btn-success')]"));

        inputName.sendKeys("Maryna");
        inputEmail.sendKeys("111@gmail.com");
        inputPassword.sendKeys("123456");
        checkboxLoveIceCream.click();
        dropdownGender.selectByVisibleText("Female");
        radiobuttonStudentEmploymentStatus.click();
        inputDateOtBirth.sendKeys("01231983");
        buttonSubmit.click();

        WebElement alertSuccess = driver.findElement(By.xpath("//div[contains(@class,'alert')]"));
        Assert.assertEquals(alertSuccess.getText().split("\n")[1], "Success! The Form has been submitted successfully!.");
        //System.out.println(alertSuccess.getText().split("\n")[1]);
        //Assert.assertEquals(text,"×\n" + "Success! The Form has been submitted successfully!.");
        driver.quit();
    }
}