package testLibs;

public interface AppConstants {

	public static final String url = "https://csan--huat.my.salesforce.com";
	public static final String userName = "wfeng@csan.ca";
	public static final String passWord = "Cloud@2022";
	public static final String baseBrowser = "Chrome";
	public static final String confirmedRedAlertFlag = "/resource/NVS_Clozaril_Resources/NVS_Clozaril_Resources/ICONS/Confirmed_Red_Alert.png";
	public static final String alertEmail = "cloudTest@gmail.com";
	
	//SheetName to check CaseToRun flag against test case.
	public static final String SheetName = "TestCasesList";
	//Name of column In TestCasesList Excel sheet.
	public static final String ToRunColumnNameTestCase = "CaseToRun";
	//Name of column In Test Case Data sheets.
	public static final String ToRunColumnNameTestData = "DataToRun";
	
	public static final String YellowAlert = "/img/msg_icons/warning24.png";
	public static final String RedAlert = "/img/msg_icons/error24.png";
	public static final String GreenAlert = "/img/msg_icons/confirm24.png";
	public static final String FlashingYellow = "/resource/NVS_Clozaril_Resources/NVS_Clozaril_Resources/ICONS/TestResult_Status_FlashingYellow.jpg";
}
