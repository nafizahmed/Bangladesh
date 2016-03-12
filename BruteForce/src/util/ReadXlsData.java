package util;

import util.Xls_Reader;

public class ReadXlsData {

	public static void main(String[] args) {
		
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\xls\\TestCases.xlsx");	
		// x is pointing towards TestCases.xlsx	
		// second parameter is pointing towards the sheet name given
		getData(x,"Test Data");	
		
	}   
	
	// return the test data from a test in a 2 dim array
	public static Object[][] getData(Xls_Reader xls , String testCaseName){
		 // if the sheet is not present
		 if(! xls.isSheetExist(testCaseName)){
			xls=null;
			return new Object[1][0];
		}
			
		
		int rows = xls.getRowCount(testCaseName);
		int cols = xls.getColumnCount(testCaseName);
		//System.out.println("Rows are -- "+ rows);
		//System.out.println("Cols are -- "+ cols);
		
		
	   Object[][] data =new Object[rows-1][cols];
		for(int rowNum=2;rowNum<=rows;rowNum++){
			for(int colNum=0;colNum<cols;colNum++){
				//System.out.print(xls.getCellData(testCaseName, colNum, rowNum) + " -- ");
				data[rowNum-2][colNum] = xls.getCellData(testCaseName, colNum, rowNum);
			}
			System.out.println();
		} 
		return data; 	
	} 
}