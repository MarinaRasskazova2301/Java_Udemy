package workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement roundTripRadiobutton = driver.findElement(By.cssSelector("input[value='RoundTrip']"));
        WebElement departDateDatepicker=driver.findElement(By.id("Div1"));


        //For this datepicker:
        // style="display: block; opacity: 0.5;"  - if opacity=0.5 - it is disabled, if 1 - enabled
        Assert.assertTrue(departDateDatepicker.getAttribute("style").contains("0.5"));

        roundTripRadiobutton.click();
        Assert.assertTrue(departDateDatepicker.getAttribute("style").contains("1"));






        WebElement seniorCitizenCheckbox=driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]"));
        seniorCitizenCheckbox.click();


        Assert.assertTrue(roundTripRadiobutton.isSelected());
        Assert.assertTrue(seniorCitizenCheckbox.isSelected());

        driver.quit();


    }
}
