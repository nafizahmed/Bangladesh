package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

import util.TestUtil;
import framework.AddToCartPage;
import framework.BasePage;
import framework.HomePage;

public class ShippingChargeTest extends BasePage{
	
	public static void main(String[] args) {
		
		//   --preconditions--
		// runmode has to be set to yes
		// item has to be added  to cart
		
		// checking  runmode
		if(!TestUtil.isExecutable("ShippingChargeTest", BasePage.xls1))
			throw new SkipException("Runmode set to NO");
		
		// adding item to cart
		HomePage h = new HomePage();
		AddToCartPage a = h.clickOnSearch();
		a.addToCart();
		
		// verify that shipping charge exist
		WebElement e = driver.findElement(By.xpath("//*[@id='total_shipping']"));
		String shippingCharge = e.getText();
		System.out.println("shippingCharge is ==> "+e.getText());
		
		Assert.assertTrue(e.getText().contains(shippingCharge), "shippingCharge not found!");
			
		driver.close();
	}

}
