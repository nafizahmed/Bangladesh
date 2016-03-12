package testCases;

import org.testng.SkipException;

import util.TestUtil;
import framework.BasePage;
import framework.HomePage;

public class SearchTest {

	public static void main(String[] args) {

		// checking  runmode
		if(!TestUtil.isExecutable("SearchTest", BasePage.xls1))
			throw new SkipException("Runmode set to NO");
		
		// searching
		HomePage h = new HomePage();
		h.clickOnSearch();
		
	}

}
