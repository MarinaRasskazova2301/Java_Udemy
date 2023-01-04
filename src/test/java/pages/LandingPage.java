package pages;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        System.out.println("landing page constructor");
        if (driver==null){
            System.out.println("driver inlanding page constructor is null");
        }
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement userEmailInput;

    @FindBy(id="userPassword")
    WebElement passwordInput;

    @FindBy(id="login")
    WebElement submit;

       public void loginApplication (String email, String password){

        userEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
    }

    public void goTo(){
         driver.get("https://rahulshettyacademy.com/client/");
       }
}
