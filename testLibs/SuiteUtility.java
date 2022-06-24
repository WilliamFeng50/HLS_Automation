package testLibs;

public class SuiteUtility {	
	
	public static boolean checkToRunUtility(Read_XLS xls, String sheetName, String ToRun, String testCase){
				
		boolean Flag = false;		
		if(xls.retrieveToRunFlag(sheetName,ToRun,testCase).equalsIgnoreCase("y")){
			Flag = true;
		}
		else{
			Flag = false;
		}
		return Flag;		
	}
	
	public static String[] checkToRunUtilityOfData(Read_XLS xls, String sheetName, String ColName){		
		return xls.retrieveToRunFlagTestData(sheetName,ColName);		 	
	}
 
	public static Object[][] GetTestDataUtility(Read_XLS xls, String sheetName){
	 	return xls.retrieveTestData(sheetName);	
	}
 
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, int rowNum, String Result){			
		return xls.writeResult(sheetName, ColName, rowNum, Result);		 	
	}
 
	public static void WriteResultUtility(Read_XLS xls, String sheetName, String ColName, String rowName, String Result){			
		 xls.writeResult(sheetName, ColName, rowName, Result);		 	
	}
	
}