package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups={"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void submitOrder() {

       landingPage.loginApplication("mar4@gmail.com", "12354@qwE");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");


    }


}
