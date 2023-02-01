package MW.SeleniumTestFramework.Tests;

import java.io.IOException;
import java.time.Duration;
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
import org.testng.annotations.Test;

import MW.AbstractComponents.AbstractComponent;
import MW.SeleniumTestFramework.TestComponens.BaseTest;
import MW.SeleniumTestFramework.TestComponens.Retry;
import MW.pageObjects.LandingPage;
import MW.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest{

@Test //(groups = "ErrorHandling", retryAnalyzer = Retry.class)
public void ErrorValidations() throws IOException
{
		landingPage.loginApplication("auo15024@cdfaq.com", "Tey123");
		Assert.assertEquals(landingPage.ErrorCheck(), "Incorrect email or password.");
}
}