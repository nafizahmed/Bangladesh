package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddToCartPage extends BasePage
{
	
	public RegistrationSignInPage addToCart(){

		// mouse over to  "add-to-cart"
		WebElement ele = driver.findElement(By.xpath(OR.getProperty("mouse_overTo_AddToCart")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
				
		// click on add-to-cart button
		driver.findElement(By.xpath(OR.getProperty("button_AddToCart"))).click();
		// click on "proceed to checkout" button
		driver.findElement(By.xpath(OR.getProperty("button_ProceedToCheckout"))).click();
	
		/* verify that  shipping charge exist
		WebElement e = driver.findElement(By.xpath("//*[@id='total_shipping']"));
		System.out.println("AddToCart line 25 ==> "+e.getText());
		shipping = e.getText();
		*/

		return new RegistrationSignInPage();
	}
}
