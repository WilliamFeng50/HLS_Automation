package testcases.OQ_019;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;

@Epic("Regression Tests")
@Feature("OQ_019 Test Cases")
public class OQ_019_TC19 extends BaseTest {
	PatientPage patientPage;
	TestResultPage testResultPage;
	String patient = "1990101503 PD";
	String testResultID;
	String today;
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickHomeTab();
		homePage.clickPatientTab();
		homePage.clickOnSearch(patient);
		patientPage.clickOnRecordLink(patient);
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		
	}
		
	@Test(priority = 1, description = "OQ_019 Test case 19: TC-19.01")
	@Step("step 1. Select the active patient, add new test result")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Select an active patient, not be flagged Special Case, add new test results, confirm the patient information is showing, the type is In-Treatment")
	public void Ts1901(Method method) {
		startTest(method.getName(), "Select an active patient, not be flagged Special Case, add new test results, confirm the patient information is showing, the type is In-Treatment");
		patientPage.clickOnNewTestResult();
		
		String [] labels = {"Patient", "Initials", "DOB", "Patient Status", "Type"};
		Map<String, String> info = new HashMap<String, String>();
		info = testResultPage.getpatientInformation();
		for (String name: labels) {
		    String value = info.get(name).toString();
		    Reporter.log("The information of patient: " + name + ": " + value, true);
		}
		Assert.assertTrue(info.get("Type").toString().equals("In-Treatment"));
	}	
	
	@Test(priority = 2, description = "OQ_019 Test case 19: TC-19.02")
	@Step("step 2. click on save button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on save button, should be showing 'You must enter a value' in Test Date")
	public void Ts1902(Method method) {
		startTest(method.getName(), "Test Date message validation");
		testResultPage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Test Date: You must enter a value"));
	}	
	
	@Test(priority = 3, description = "OQ_019 Test case 19: TC-19.03")
	@Step("step 3. Input a test date with today, click on save button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on save button, should be showing WBC is required")
	public void Ts1903(Method method) {
		startTest(method.getName(), "Click on save button, should be showing WBC is required");
		testResultPage.newTestResult("", "", "", "", "", "", today, "", "");
		testResultPage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("WBC is required") && super.isTextShowing("Please enter either ANC or GRC values"));
	}	
			
	@Test(priority = 4, description = "OQ_019 Test case 19: TC-19.04")
	@Step("step 4. Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 36, ANC 60, GRC 60, click on save button, confirm showing 3 warning messages")
	public void Ts1904(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 36, ANC 60%, GRC% 60, click on save button, confirm showing 3 warning messages");
		driver.navigate().refresh();
		super.waitForSleep(4000);
		testResultPage.newTestResult("36", "", "60", "", "60", "", today, "", "");
		testResultPage.clickOnSaveBtn();
				
		Assert.assertTrue(super.isTextShowing("WBC is greater than or equal to 25. Press save to continue.") && super.isTextShowing("ANC is greater than or equal to 20. Press save to continue."));
	}	
	
	@Test(priority = 5, description = "OQ_019 Test case 19: TC-19.05")
	@Step("step 5. Click the “Save” button again")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the “Save” button again, confirm that values have been autocompleted, ANC: 21.60, GRC: 21.60")
	public void Ts1905(Method method) {
		startTest(method.getName(), "Click the “Save” button again, confirm that values have been autocompleted, ANC: 21.60, GRC: 21.60");
		String anc;
		String grc;
		testResultPage.clickOnSaveBtn();
		testResultID = testResultPage.getTestResultId();
		anc = homePage.getFormText("ANC");
		grc = homePage.getFormText("GRC");
		
		Assert.assertTrue(anc.equals("21.60")&&grc.equals("21.60"));
	}	
	
	
	@Test(priority = 6, description = "OQ_019 Test case 19: TC-19.06")
	@Step("step 6. Click on Test Result link, Scroll down to the Test Results section")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Test Results section. Confirm that the information presented reflects the information entered")
	public void Ts1906(Method method) {
		startTest(method.getName(), "Scroll down to the Test Results section. Confirm that the information presented reflects the information entered");
		Map<String, String> results = new HashMap<String, String>();
		
		testResultPage.clickOnPatientLink(patient);
		patientPage.clickSubsectionDisplayBtn("Treatment");
		String lastTestDate = patientPage.getBloodLastTestDate();
		
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		results = patientPage.getTestResultValues(testResultID);
		String wbc = results.get("WBC").toString();
		String anc = results.get("ANC").toString();
		String grc = results.get("GRC").toString();
		
		Assert.assertTrue(wbc.equals("36.00") && anc.equals("21.60" )&& grc.equals("21.60") && lastTestDate.equals(super.getToday("M/d/yyyy")));
	}	
	
	@Test(priority = 7, description = "OQ_019 Test case 19: TC-19.07")
	@Step("step 7. Click on Activity Hstory link, Scroll down to the Activity Hstory  section")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Activity Hstory section. Confirm that an activity has been created for the subject Blood Test with the test date")
	public void Ts1907(Method method) {
		startTest(method.getName(), "Scroll down to the Activity Hstory section. Confirm that an activity has been created for the subject Blood Test with the test date");
		Map<String, String> results = new HashMap<String, String>();
		homePage.moveToSectionForm("Activity History");
		results = patientPage.getActivityValues(testResultID);
		
		String subject = results.get("Subject").toString();
		String createDate = results.get("Create Date").toString();
		Assert.assertTrue(subject.equals("Blood Test") && createDate.equals(super.getToday("M/d/yyyy")));
	}	
		
}
