package testComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser").toLowerCase(Locale.ROOT);

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string

        String jsonContent = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

        //String to HashMap- Jackson Datbind

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;

        //{map, map}

    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";


    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }
}
