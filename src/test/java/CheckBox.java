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
        roundTripRadiobutton.click();

        WebElement seniorCitizenCheckbox=driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]"));
        seniorCitizenCheckbox.click();


        Assert.assertTrue(roundTripRadiobutton.isSelected());
        Assert.assertTrue(seniorCitizenCheckbox.isSelected());

        driver.quit();


    }
}
