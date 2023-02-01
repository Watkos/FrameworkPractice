package MW.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MW.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List <WebElement> products;
	
	@FindBy(id="toast-container")
	WebElement toastMessage;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkoutButton;
	
	@FindBy(xpath="//div[@class='form-group']/input")
	WebElement countrySelector;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeOrderButton;
	
	@FindBy(css=".hero-primary")
	WebElement finalText;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> suggestions;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> prodInCart;
	
	By disappearWait = By.xpath("//ngx-spinner");
	By addToCart = By.xpath("div/div/button[@class='btn w-10 rounded']");
	
	public List<WebElement> getProductList()
	{
	return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement chosenProduct = getProductList().stream().filter(product->product.getText().contains(productName)).findFirst().orElse(null);
		return chosenProduct;
	}
	
	public AbstractComponent addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		WaitForToast(toastMessage);
		WaitForElementToDisappear(disappearWait);
		return new AbstractComponent(driver);
	}
	
	public Boolean CartMatchCheck(String productName)
	{
		return prodInCart.stream().anyMatch(p->p.getText().contains(productName));
	}
	
	public void ClickCheckout()
	{
		checkoutButton.click();
	}
	
	public void SelectCountry()
	{
		countrySelector.sendKeys("Pol");
		WebElement country = suggestions.stream().filter(suggest->suggest.getText().equalsIgnoreCase("poland")).findFirst().orElse(null);
		country.click();
	}
	
	public void ClickPlaceOrder()
	{
		placeOrderButton.click();
	}
	
	public String FinalCheck()
	{
		String primary = finalText.getText();
		return primary;
	}
}
	
