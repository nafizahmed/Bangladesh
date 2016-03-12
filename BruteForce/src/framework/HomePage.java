package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage
{
	
	public AddToCartPage clickOnSearch()
	{
		driver.manage().window().maximize();
		driver.get("http://ebfs.bruteforcesolution.net/ebfs");
		input("input_search", "T-shirts");
		click("button_searchButton");
		
		return new AddToCartPage();
	}	
}
