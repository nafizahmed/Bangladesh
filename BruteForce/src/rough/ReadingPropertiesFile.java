package rough;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingPropertiesFile {

	public static void main(String[] args) {
		
		// this file just illustrates how to read properties file
		// This file has nothing to do with this projects
		// except learning  processes
		
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\config\\config.properties";
		System.out.println("line 12 in ReadingPropertiesFile ==> "+System.getProperty("user.dir"));
		System.out.println("line 13 in ReadingPropertiesFile ==> "+path);
		
		try{
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}catch(Exception e){
			// error
			return;
		}	
		
		System.out.println("line 23 in ReadingPropertiesFile ==> "+prop.getProperty("testSiteURL"));
		System.out.println("line 24 in ReadingPropertiesFile, example of property not found ==> "+prop.getProperty("xxxxxxx"));
		
	}
}
