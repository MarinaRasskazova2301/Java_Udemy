package assignments;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowsId=driver.getWindowHandles();
        Iterator<String> iterator=windowsId.iterator();

        String parentId=iterator.next();
        String childId=iterator.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
}
