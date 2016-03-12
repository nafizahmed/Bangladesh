package testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import util.Data_Provider;
import util.TestUtil;
import framework.AddToCartPage;
import framework.BasePage;
import framework.HomePage;
import framework.PaymentPage;
import framework.RegistrationSignInPage;

public class ShoppingTest extends BasePage{

		
		@Test(dataProviderClass = Data_Provider.class, dataProvider="loginTestDataProvider")
		public void shopTillYouDrop(String userName, String password) throws InterruptedException{
		// this is end-to-end test for a purchase (purchase start to finish)
		
		// check runmode
		if(!TestUtil.isExecutable("ShoppingTest", BasePage.xls1))
			throw new SkipException("Runmode set to NO");
		
		HomePage h = new HomePage();
		AddToCartPage a = h.clickOnSearch();
		RegistrationSignInPage r = a.addToCart();
		PaymentPage p = r.doSignIn(userName, password);
		p.choosePaymentMethod();
		driver.close();
		
		
	
		// return null - if login is not success
		// return LandingPage - if login is success
		/*
		public PaymentMethodPage doLogin(String userName, String Password){
			driver.get(CONFIG.getProperty("testSiteLandingPageURL"));
			//System.out.println(isElementPresent("//*[@id='email']"));
			input("EMAIL", userName);
			input("PASSWORD", Password);
			click("LOGIN_BUTTON");
			return PaymentMethodPage();
		*/
	} 

}
