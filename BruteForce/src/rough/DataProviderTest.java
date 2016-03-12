package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="registerData")
	public void testRegister(String username, String password,
							String email, String city){
		// selenium code
		// username
		// password
		// email
		// city
		
		System.out.println(username +" -- "+password +" -- "+email+" -- "+city);
		
	}
	
	@DataProvider
	public Object[][] registerData(){
		// rows - number of times test has to be repeated
		// col - parameters in data
		Object[][] data = new Object[3][4];
		
		// first row
		data[0][0]="User1";
		data[0][1]="Pass1";
		data[0][2]="email1";
		data[0][3]="city1";
		
		// second row
		data[1][0]="User2";
		data[1][1]="Pass2";
		data[1][2]="email2";
		data[1][3]="city2";
		
		// third row
		data[2][0]="User3";
		data[2][1]="Pass3";
		data[2][2]="email3";
		data[2][3]="city3";
		
		return data;
	}
}
