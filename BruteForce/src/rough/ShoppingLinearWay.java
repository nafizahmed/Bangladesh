package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

	public class ShoppingLinearWay {		
		public static WebDriver driver;
		public static final String SEARCHTEXT = "T-shirts";
		
			
		public static void main(String[] args) {
		
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://ebfs.bruteforcesolution.net/ebfs");
			driver.manage().window().maximize();
			// search for T-shirt
			driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(SEARCHTEXT);
			// click on the search button
			driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
			
			// mouse over to  "add-to-cart"
			WebElement ele = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]"));
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			
			
			// click on add-to-cart
			driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")).click();
			// click on "proceed to checkout"
			driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
			
			// fill up new customer registration form
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys("shhhoaib@gmail.com");
			driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("bxhA816L");
			driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
			driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("Shoaib");
			driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys("Muhammad");
			
			// select the drop down key for days
			WebElement days = driver.findElement(By.xpath("//*[@id='days']"));
			Select select1 = new Select(days);
			select1.selectByValue("1");
			
			// select the drop down key for months
			WebElement months = driver.findElement(By.xpath("//*[@id='months']"));
			Select select2 = new Select(months);
			select2.selectByValue("3");
			
			// select the drop down key for years
			WebElement years = driver.findElement(By.xpath("//*[@id='years']"));
			Select select3 = new Select(years);
			select3.selectByValue("1965");
			
			
			// fill in text box for first name
			driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Shoaib");//*[@id='address1']
			// fill in text box for last name
			driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Muhammad");
			// fill in text box for address 1st line
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("1227 white plains road");
			// fill in text box for address 2nd line
			driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("apt# 430");
			// fill text box for city
			driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Bronx");
			
			// select drop down key for state
			WebElement state = driver.findElement(By.xpath("//*[@id='id_state']"));
			Select select4 = new Select(state);
			select4.selectByVisibleText("New York");
			
			// fill in text box for zip code
			driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("10472");
			
			// select drop down key for country
			WebElement country = driver.findElement(By.xpath("//*[@id='id_country']"));
			Select select5 = new Select(country);
			select5.selectByValue("21");
			
			// fill in text box for phone
			driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("917-257-1685");			
			// click on save button
			driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
			
			
			// click on terms of service button
			driver.findElement(By.xpath("//*[@id='cgv']")).click();
			// choose a payment method link
			driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
			// click on confirm order button
			driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
		
		}
}
