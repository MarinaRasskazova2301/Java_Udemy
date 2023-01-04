package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public AbstractComponent(WebDriver driver) {

        System.out.println("constructor");
        this.driver=driver;
        if (driver==null){
            System.out.println("driver in constructor is null");
        }
    }

    public void waitForElementToAppear(By findBy){
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    }
    public void waitForElementToDisappear(WebElement element){
      //  wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
