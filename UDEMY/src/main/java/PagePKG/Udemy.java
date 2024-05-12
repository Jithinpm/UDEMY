package PagePKG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Udemy {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"APjFqb\"]")
	WebElement Search;
	
	@FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a")
	WebElement udemy;
	
	@FindBy(xpath = "//*[@id=\"search-form-autocomplete--2061\"]")
	WebElement udemySearch;
	
	@FindBy (xpath = "//*[@id=\"__next\"]/div/div/div[4]/div[2]/form/button/svg")
	WebElement Searchclick;
	
	@FindBy (xpath = "//*[@id=\"u142-popper-trigger--764\"]/div[2]/div[1]/div/h3/a")
	WebElement cucumber;
	
	@FindBy (xpath = "//*[@id=\"main-content-anchor\"]/div[1]/div/div/div[3]/div/h1")
	WebElement Coursetitle;
	
	
	
	public Udemy(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void Test1(String value1, String value2)
	{
		Search.sendKeys(value1);
	
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
		
		udemy.click();
		
		String ExpectedURL = "https://www.udemy.com/topic/automation-testing/";
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ExpectedURL,ActualURL, "Not opened the expected URL");
		
		udemySearch.click();
		udemySearch.sendKeys(value2);
		Searchclick.click();
		cucumber.click();
		
		String Expectedtitle ="Cucumber 7.0 BDD for  Selenium & Appium with Live Projects";
		String Actualtitle = driver.getTitle();
		
		Assert.assertEquals(Expectedtitle, Actualtitle, "Not open the Expected page");
		
		Assert.assertTrue(Coursetitle.isDisplayed());
			 
	}

}
