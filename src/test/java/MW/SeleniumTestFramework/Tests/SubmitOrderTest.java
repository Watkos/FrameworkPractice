package MW.SeleniumTestFramework.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MW.AbstractComponents.AbstractComponent;
import MW.SeleniumTestFramework.TestComponens.BaseTest;
import MW.pageObjects.LandingPage;
import MW.pageObjects.PlaceOrder;
import MW.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
 	String productName = "ZARA";
@Test(dataProvider = "getData", groups = "Purchases")
public void SubmitOrder(HashMap<String, String> input) throws IOException
{
		ProductCatalogue productCatalogue = landingPage.loginApplication("auo15024@cdfaq.com", "Testy123");
		AbstractComponent abstractComponent = productCatalogue.addProductToCart(input.get("productName"));
		abstractComponent.GoToCart();
		Assert.assertTrue(productCatalogue.CartMatchCheck(input.get("productName")));
		productCatalogue.ClickCheckout();
		productCatalogue.SelectCountry();
		productCatalogue.ClickPlaceOrder();
		Assert.assertTrue(productCatalogue.FinalCheck().contains("THANKYOU"));
	}

@Test(dependsOnMethods= {"SubmitOrder"})
public void OrderHistoryTest()
{
	landingPage.loginApplication("auo15024@cdfaq.com", "Testy123");
	PlaceOrder placeOrder = new PlaceOrder(driver);
	placeOrder.OrderListTest(productName);
}

@DataProvider
public Object [][] getData()
{
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("productName", "ADIDAS");
	
	HashMap<String, String> map1 = new HashMap<String, String>();
	map1.put("productName", "ZARA");
	
	return new Object[][] {{map}, {map1}};
}
}
