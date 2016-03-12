package framework;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage{
	
	public void choosePaymentMethod() throws InterruptedException{
	
		// click on terms of service button
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		System.out.println("line 11 in PaymentPage");
		// choose a payment method link
		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
		// click on confirm order button
		driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
		//					         //*[@id='cart_navigation']/button
				

	}
}
