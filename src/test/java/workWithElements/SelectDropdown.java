package workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
    public static void main(String[] args) {

//System.SetProperty("webdriver.chrome.driver", "/path"); - optional
//System.SetProperty("webdriver.gecko", "/path"); - optional
//System.SetProperty("webdriver.edge", "/path"); - optional
        WebDriver driver = new ChromeDriver();
//        WebDriver driver=new FirefoxDriver();
//        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.7.0");
        WebElement staticDropdown = driver.findElement(By.xpath("//select[contains(@id, 'DropDownListCurrency')]"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(2);
       String dropdownText= dropdown.getFirstSelectedOption().getText();
        System.out.println(dropdownText);
        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.quit();
    }
}
