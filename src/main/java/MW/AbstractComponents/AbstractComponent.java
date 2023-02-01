package MW.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MW.pageObjects.PlaceOrder;
import MW.pageObjects.ProductCatalogue;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath="//button[@class='btn btn-custom']")
	static
	List<WebElement> border;	
	
	public void WaitForElementToDisappear(By disappearWait)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(disappearWait));
	}
	
	public void WaitForToast(WebElement toastMessage)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(toastMessage));
	}
	
	public static List<WebElement> getBorderList()
	{
	return border;
	}
	
	public void GoToCart()
	{
		List<WebElement> borderButtons = getBorderList();
		WebElement cartButton = borderButtons.stream().filter(button->button.getText().contains("Cart")).findFirst().orElse(null);
		cartButton.click();
	}
	
	public void WaitForErrorMessage(WebElement errorMessage)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(errorMessage));
	}
	public void GoToOrders()
	{
		List<WebElement> borderButtons = getBorderList();
		WebElement ordersButton = borderButtons.stream().filter(button->button.getText().contains("ORDERS")).findFirst().orElse(null);
		ordersButton.click();
	}
}
	
