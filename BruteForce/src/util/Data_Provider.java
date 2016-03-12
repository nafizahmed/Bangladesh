package util;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

// all data providers for all tests
public class Data_Provider {
	
	@DataProvider(name="regTestDataProvider")
	public static Object[][] getData(){
		Object data[][] = new Object[2][3];
		
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="xyz@gmail.com";
		
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="abc@gmail.com";
		
		return data;
	}
	
	
	@DataProvider(name="loginTestDataProvider")
	
	public static Object[][] getData2(){
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\xls\\Login.xlsx");	
		int rows=xls.getRowCount("Sheet1");
		int cols=xls.getColumnCount("Sheet1");
		//System.out.println("Rows are -- "+ rows);
		//System.out.println("Cols are -- "+ cols);
		
		Object data[][] = new Object[rows-1][cols];
		
		for(int rNum=2;rNum<=rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				//System.out.println(xls.getCellData("Sheet1", cNum, rNum));
				data[rNum-2][cNum] = xls.getCellData("Sheet1", cNum, rNum);			
			}
	}
	return data;
}
	
	
	/*
	@DataProvider(name="loginTestDataProvider")
	public static Object[][] getLoginData(){
		Object data[][] = new Object[2][2];
		
		data[0][0]="U3";
		data[0][1]="P3";
		
		data[1][0]="U4";
		data[1][1]="P5";
		
		return data;
	}
	
	@DataProvider(name="sampleDataProvider")
	public static Object[][] xyzData(Method m){
		Object data[][] = null;
		
		if(m.getName().equals("testA")){
		data = new Object[2][2];
		data[0][0]="U5";
		data[0][1]="P5";
		
		data[1][0]="U6";
		data[1][1]="P6";
		}else if(m.getName().equals("testB")){
			data = new Object[2][3];
			
			data[0][0]="U9";
			data[0][1]="P9";
			data[0][2]="test@gmail.com";

			
			data[1][0]="U10";
			data[1][1]="P10";
			data[1][2]="temp@gmail.com";
		}
		return data;
	}
	
*/
}
