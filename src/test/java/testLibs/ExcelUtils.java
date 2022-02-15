package testLibs;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getTableArray(String fileName, String sheetName) throws Exception {   
       String[][] data = null;     

        try{
	        FileInputStream fis = new FileInputStream(fileName);

		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		    XSSFSheet sh = wb.getSheet(sheetName);
		
		    XSSFRow row = sh.getRow(0);
		
		    int noOfRows = sh.getPhysicalNumberOfRows();
		
		    int noOfCols = row.getLastCellNum();
		
		    XSSFCell cell;
		
		    data = new String[noOfRows-1][noOfCols];
		
		    for(int i =1; i<noOfRows;i++){
		
		         for(int j=0;j<noOfCols;j++){
		
		               row = sh.getRow(i);
		
		               cell= row.getCell(j);
		
		               data[i-1][j] = cell.getStringCellValue();
		
		           }
		
		    }

        }catch (Exception e) {
               System.out.println("The exception is: " +e.getMessage());
        }
            return data;
    }
}
