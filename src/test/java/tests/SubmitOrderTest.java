package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

   // String productName;

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

//        ProductCatalogue productCatalogue = landingPage.loginApplication("mari4@gmail.com", "1234@qwE");
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
      //  productName=input.get("product");
        CartPage cardPage = productCatalogue.goToCardPage();

        Thread.sleep(1000);
        Boolean match = cardPage.isProductDisplayed(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cardPage.goToCheckout();
        checkoutPage.selectCountry("ind", "India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String actualConfirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(actualConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dataProvider = "getData", dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest(HashMap<String,String> input) throws InterruptedException {

//        ProductCatalogue productCatalogue = landingPage.loginApplication("mari4@gmail.com", "1234@qwE");
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        OrdersPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.isOrderDisplayed(input.get("product")));
    }

//    @DataProvider
//    public Object[][] getData() {
//        return new Object[][]{{"mari4@gmail.com", "1234@qwE", "ZARA COAT 3"},
//                {"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"}};
//    }


    @DataProvider
	  public Object[][] getData() throws IOException {
//          HashMap<String,String> map = new HashMap<String,String>();
//          map.put("email", "anshika@gmail.com");
//          map.put("password", "Iamking@000");
//          map.put("product", "ZARA COAT 3");
//
//          HashMap<String,String> map1 = new HashMap<String,String>();
//          map1.put("email", "shetty@gmail.com");
//          map1.put("password", "Iamking@000");
//          map1.put("product", "ADIDAS ORIGINAL");
          List<HashMap<String,String>>  data=getJsonDataToMap(System.getProperty("user.dir") + "//src//data//PurchaseOrder.json");
	    return new Object[][]  {{data.get(0)}, {data.get(1)} };

	  }



}
