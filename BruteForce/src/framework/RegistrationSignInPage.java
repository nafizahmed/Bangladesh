package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import util.Data_Provider;

public class RegistrationSignInPage extends BasePage{
	/*
	public PaymentPage fillInRegistrationForm(){
		
		// preconditions - 
		/*
		// fill up new customer registration form
					// fill in input text box for  email
					driver.findElement(By.xpath(OR.getProperty("input_email"))).sendKeys(CONFIG.getProperty("defaultEmail"));
					// fill in input text box for password
					driver.findElement(By.xpath(OR.getProperty("input_password"))).sendKeys(CONFIG.getProperty("defaultPassword"));
					//  click on button to select gender
					driver.findElement(By.xpath(OR.getProperty("select_gender"))).click();
					// fill in input text box for first name
					driver.findElement(By.xpath(OR.getProperty("input_FirstNameCustomer"))).sendKeys(CONFIG.getProperty("firstName"));
					// fill in input text box for last name
					driver.findElement(By.xpath(OR.getProperty("input_LastNameCustomer"))).sendKeys(CONFIG.getProperty("lastName"));
					
					// select the drop down key for days
					WebElement days = driver.findElement(By.xpath(OR.getProperty("dropDown_days")));
					Select select1 = new Select(days);
					select1.selectByValue("1");
					
					// select the drop down key for months
					WebElement months = driver.findElement(By.xpath(OR.getProperty("dropDown_months")));
					Select select2 = new Select(months);
					select2.selectByValue("3");
					
					// select the drop down key for years
					WebElement years = driver.findElement(By.xpath(OR.getProperty("dropDown_years")));
					Select select3 = new Select(years);
					select3.selectByValue("1965");
					
					
					// fill in input text box for first name
					driver.findElement(By.xpath(OR.getProperty("input_FirstNameAddress"))).sendKeys(CONFIG.getProperty("firstName"));
					// fill in input text box for last name
					driver.findElement(By.xpath(OR.getProperty("input_LastNameAddress"))).sendKeys(CONFIG.getProperty("lastName"));
					// fill in input text box for address 1st line
					driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("1227 white plains road");
					// fill in input text box for address 2nd line
					driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("apt# 430");
					// fill input text box for city
					driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Bronx");
					
					// select drop down key for state
					WebElement state = driver.findElement(By.xpath("//*[@id='id_state']"));
					Select select4 = new Select(state);
					select4.selectByVisibleText("New York");
					
					// fill in input text box for zip code
					driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("10472");
					
					// select drop down key for country
					WebElement country = driver.findElement(By.xpath("//*[@id='id_country']"));
					Select select5 = new Select(country);
					select5.selectByValue("21");
					
					// fill in input text box for phone
					driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("917-257-1685");			
					// click on save button
					driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
		// End filling up customer registration form
		
		return new PaymentPage();
	}
	
	*/
	
	//public PaymentPage doSignIn(){
	@Test(dataProviderClass = Data_Provider.class, dataProvider="loginTestDataProvider")
	
	public PaymentPage doSignIn(String username, String password){
		
			
		// click on "ALREADY REGISTERED" "Click here" link
				driver.findElement(By.xpath(OR.getProperty("goTo_LoginForm"))).click();
				// fill in the email text box
				driver.findElement(By.xpath(OR.getProperty("input_Login_email"))).sendKeys(username);
				// fill in the password text box
				driver.findElement(By.xpath(OR.getProperty("input_Login_password"))).sendKeys(password);
				// click on Sign in button
				driver.findElement(By.xpath(OR.getProperty("button_submitLogin"))).click();
		// End Sign in
		
		return  new PaymentPage();
	}
}
