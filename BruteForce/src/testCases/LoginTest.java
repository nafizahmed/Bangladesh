package testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import util.Data_Provider;
import util.TestUtil;
import framework.AddToCartPage;
import framework.BasePage;
import framework.HomePage;
import framework.RegistrationSignInPage;

public class LoginTest{

	@Test(dataProviderClass = Data_Provider.class, dataProvider="loginTestDataProvider")
	public void doLogIn(String userName, String password){
		// check runmode
		if(!TestUtil.isExecutable("LoginTest", BasePage.xls1))
			throw new SkipException("Runmode set to NO");

								
		HomePage h = new HomePage();
		AddToCartPage a = h.clickOnSearch();
		RegistrationSignInPage r = a.addToCart();
		r.doSignIn(userName, password);
				
	} 

}   
