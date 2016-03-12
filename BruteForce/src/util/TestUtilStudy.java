package util;

import java.util.Hashtable;

public class TestUtilStudy {
	
	
	public static boolean isExecutable(String testName, Xls_Reader xls){
		// rNum=2;as long as rNum<=number of rows in Test Cases sheet
		for(int rNum=2;rNum<=xls.getRowCount("Test Cases");rNum++){			
			if(testName.equals(xls.getCellData("Test Cases", "TCID", rNum))){
						//      xls.getCellData(sheetName, colName, rowNum)
						// from sheet name ==> Test Cases
						// from colum name ==> TCID
						// from   	rNum   ==> 1  ==> LoginTest
						// from    	rNum   ==> 2  ==> ChangePicTest
						// from	 	rNum   ==> 3  ==> FindaFriendTest
						//			rNum   ==> 4  ==> SearchTest								
				if(xls.getCellData("Test Cases", "Runmode", rNum).equals("Y"))
				    //xls.getCellData(sheetName, colName, rowNum)
					// 			sheet  ==> Test Cases
					//      	colum  ==> Runmode
					//      	rNum   ==> 1
					//      	rNum   ==> 2
					//     	 	rNum   ==> 3
					//			rNum   ==> ...		
// the way this whole thiing happens is..
// Episode 1) Test Cases sheet --> TCID    column --> LoginTest row 
// Episode 1) Test Cases sheet --> Runmode column --> LoginTest row
					
// Episode 2) Test Cases sheet --> TCID    column --> ChangePicTest row 
// Episode 2) Test Cases sheet --> Runmode column --> ChangePicTest row
					
// Episode 3) Test Cases sheet --> TCID    column --> FindaFriendTest row 
// Episode 3) Test Cases sheet --> Runmode column --> FindaFriendTest row
					
// Episode 4) Test Cases sheet --> TCID    column --> SearchTest row 
// Episode 4) Test Cases sheet --> Runmode column --> SearchTest row
					return true;
				else
					return false;
			}	
		}
		return false;				
	}
	
	public static Object[][] getData(String testName,Xls_Reader xls){
		System.out.println("**************");
		// find the test in the xls file
		// find number of col in the test
		// find number of rows in the test
		// print the data of the test
		// put the data in object array
		int testCaseStartIndex=0;
		
		for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
			if(testName.equals(xls.getCellData("Test Data", 0, rNum))){
							// xls.getCellData(sheetName, colNum, rowNum)
				testCaseStartIndex=rNum;
				break;
			}
			
		}
		System.out.println("Test Starts from - "+ testCaseStartIndex);
		
		int colStartIndex=testCaseStartIndex+1;
		int cols=0;
		while(!xls.getCellData("Test Data", cols, colStartIndex).equals("")){
			cols++;
		}
		System.out.println("Total cols are  - "+cols);
		
		int dataStartIndex=testCaseStartIndex+2;
		int rows=0;
		while(!xls.getCellData("Test Data", 0, (dataStartIndex+rows)).equals("")){
			rows++;
		}
		System.out.println("Total rows are - "+rows);
		
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table = null;
		
		for(int rNum=dataStartIndex;rNum<(dataStartIndex+rows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartIndex), xls.getCellData("Test Data", cNum, rNum));
			 // table.put(key, value)  key-value  pair for hash table in above line
				//System.out.print(xls.getCellData("Test Data", cNum, rNum)+" -- ");
			}
			System.out.println();
			data[rNum-dataStartIndex][0]=table;
		}
		
		//System.out.println();
				
		return data;

	}

}
