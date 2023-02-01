package MW.SeleniumTestFramework.Tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MW.AbstractComponents.AbstractComponent;
import MW.pageObjects.LandingPage;
import MW.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String productName = "ADIDAS";
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("auo15024@cdfaq.com", "Testy123");
		List<WebElement> products = driver.findElements(By.xpath("//h5"));
		List <WebElement> chosenProduct = products.stream().filter(product->product.getText().contains("ADIDAS")).toList();
		WebElement c = chosenProduct.get(0);
		System.out.println(c);
		c.findElement(By.xpath("following-sibling::button[2]")).click();
		//prod.findElement(By.xpath("//div/div/button[2]")).click();
		//chosenProduct.findElement(By.xpath("//parent::div/button[@class='btn w-10 rounded']")).click();
		
		//AbstractComponent abstractComponent = productCatalogue.addProductToCart(productName);
		//abstractComponent.GoToCart();
		Assert.assertTrue(productCatalogue.CartMatchCheck(productName));
		productCatalogue.ClickCheckout();
		productCatalogue.SelectCountry();
		productCatalogue.ClickPlaceOrder();
		Assert.assertTrue(productCatalogue.FinalCheck().contains("THANKYOU"));
		driver.close();
	
		//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client");		
		//driver.findElement(By.id("userEmail")).sendKeys("auo15024@cdfaq.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Testy123");
		//driver.findElement(By.id("login")).click();
		//driver.manage().window().maximize();
		//List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		//WebElement chosenProduct = products.stream().filter(product->product.getText().contains(buying)).findFirst().orElse(null);
		//chosenProduct.findElement(By.xpath("//div/div/button[@class='btn w-10 rounded']")).click();
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner")));
		
		//String addMessage = driver.findElement(By.id("toast-container")).getText();
		//if (addMessage.contains("Added To Cart"))
			//{
			//	System.out.println("The message has appeared");
			//}
		//List<WebElement> border = driver.findElements(By.xpath("//button[@class='btn btn-custom']"));
		//WebElement cartButton = border.stream().filter(button->button.getText().contains("Cart")).findFirst().orElse(null);
		//cartButton.click();
		//List<WebElement> prodInCart = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		//Boolean check = prodInCart.stream().anyMatch(p->p.getText().contains(buying));
		//Assert.assertTrue(check);
		//driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		//driver.findElement(By.xpath("//div[@class='form-group']/input")).sendKeys("Pol");
		//List<WebElement> suggestions = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));
		//WebElement country = suggestions.stream().filter(suggest->suggest.getText().equalsIgnoreCase("poland")).findFirst().orElse(null);
		//country.click();
		//driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		//String primary = driver.findElement(By.cssSelector(".hero-primary")).getText();
		//Assert.assertTrue(primary.contains("THANKYOU"));

	}

}
