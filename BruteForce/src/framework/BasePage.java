package framework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import framework.TopMenu;



//import com.qtpselenium.facebook.pages.inbox.TopMenu;
import util.Xls_Reader;

public class BasePage {

	public static WebDriver driver = null;
	public static Properties CONFIG =null;
	public static Properties OR =null;
	public static Xls_Reader xls1= new Xls_Reader(System.getProperty("user.dir")+"//src//xls//TestCases.xlsx");
	public static boolean isLoggedIn=false;
	
	public String chromeDriverPath = System.getProperty("user.dir")+"\\chromedriver.exe";
	public String configFilePath = System.getProperty("user.dir")+"\\src\\config\\config.properties";
	public String ORFilePath = System.getProperty("user.dir")+"\\src\\config\\OR.properties";
	
	public BasePage(){
		if(driver==null){
		// initialize the properties file
		CONFIG= new Properties();
		OR = new Properties();
		
		try{
			// config
			FileInputStream fis = new FileInputStream(configFilePath);
			CONFIG.load(fis);
			
			// OR
			fis = new FileInputStream(ORFilePath);
			OR.load(fis);
			}catch(Exception e){
				// error
				return;
			}
			System.out.println(CONFIG.getProperty("browser"));
			if(CONFIG.getProperty("browser").equals("Mozilla"))
				this.driver=new FirefoxDriver();
			else if(CONFIG.getProperty("browser").equals("IE"))
				this.driver=new InternetExplorerDriver();
			else if(CONFIG.getProperty("browser").equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				this.driver=new ChromeDriver();
			}
			// implicit wait for the whole app
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			}		
		}  
	
		// click
		public static void click(String xpathKey){
			try{
		        driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
			}catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
				// report error
			}
		}
		
		
		// input
		public static void input(String xpathKey, String text){
			try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(text);
			}catch(Exception e){
				// report error
				e.printStackTrace();
			}
		}
	
	
		// just navigate to BruteForce home page
		public HomePage navigateToBruteForce(){
			driver.navigate().to("http://Ebfs.bruteforcesolution.net/ebfs");
			return new HomePage();
		}
		
	
		// select		
		// verification
		public boolean isElementPresent(String xpathKey){
			try{
				driver.findElement(By.xpath(OR.getProperty(xpathKey)));
			}catch(Exception e){
				return false;
			}		
			return true;
		}
		
		
		// finds the link on page
		public boolean isLinkPresent(String linkText){
			try{
				driver.findElement(By.linkText(linkText));
			}catch(Exception e){
				return false;
			}		
			return true;
		}
		
		
		// take screenshot
		public static void takeScreenshot(String fileName) {

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		// validate
		public boolean validateTitle(String expectedTitleKey){
			String expectedTitle=OR.getProperty(expectedTitleKey);
			String actualTitle=driver.getTitle();
			
			if(expectedTitle.equals(actualTitle))
				return true;
			else
				return false;
			// Assert.assertTrue(validate("Title"), "Title did not match");
		}
		
		public boolean validateText(String expectedText, String xpathKey){
			String actualText=driver.findElement(By.xpath(OR.getProperty(xpathKey))).getText();
			if(actualText.equals(expectedText))
				return true;
			else 
				return false;
			
			//Assert.assertTrue(session.validateText("xxxx", "leadOwner"), "leadOwner not present");
			
		}
}

	
