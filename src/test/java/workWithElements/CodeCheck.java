package workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CodeCheck {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");



        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500)");



        System.out.println("Total No of rows: " + driver.findElements(By.cssSelector(".left-align tr")).size());

        System.out.println(

                "Total No of columns: " + driver.findElements(By.cssSelector(".left-align tr:nth-child(1) th")).size());



        List<WebElement> secondRow = driver.findElements(By.cssSelector(".left-align tr:nth-child(3) td"));

        System.out.println(secondRow.get(1).getText() + " with " + secondRow.get(0).getText()

                + " on Udemy. Available in " + secondRow.get(2).getText() + "$");



        driver.quit();



    }



}






