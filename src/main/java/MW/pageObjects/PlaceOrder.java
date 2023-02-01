package MW.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MW.AbstractComponents.AbstractComponent;


public class PlaceOrder extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='container table-responsive py-5']/table/tbody/tr/td[2]")
	List <WebElement> orders;
	
	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean OrderListTest(String productName)
	{
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		abstractComponent.GoToOrders();
		Boolean checkOrders = orders.stream().anyMatch(ord->ord.getText().contains(productName));
		return checkOrders;
	}
}
