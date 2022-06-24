package testcases.OQ_019;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.BloodTestEntryPage;
import pages.PatientPage;
import testLibs.BaseTest;

@Epic("Regression Tests")
@Feature("OQ_019 Test Cases")
public class OQ_019_TC20 extends BaseTest {
	BloodTestEntryPage bloodTestEntryPage;
	PatientPage patientPage;
	String patient = "1988032201";
	String today;
	String testResultID;
	
	@BeforeClass
	@Description("From the Blood Test Entry tab, click on Add Row button, add new test results")
	public void beforeClass() {
		bloodTestEntryPage = new BloodTestEntryPage();
		patientPage = new PatientPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickHomeTab();
		homePage.clickBloodTestEntryTab();
		bloodTestEntryPage.clickOnAddRowBtn();
		
	}
		
	@Test(priority = 1, description = "OQ_019 Test case 20: TC-20.01")
	@Step("Step 1: Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 30, ANC% 80, GRC% 80, click on save button, confirm the values have ben autocompleted for ANC 24, GRC 24")
	public void Ts2001(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 30, ANC% 80, GRC% 80, click on save button, confirm the values have ben autocompleted for ANC 24, GRC 24");
		String wbc = "30";
		String anc = "";
		String ancP = "80";
		String grc = "";
		String grcP = "80";

		bloodTestEntryPage.newTestResult(patient, "", today, wbc, anc, ancP, grc, grcP, "Entered from Blood Test Entry page");
	
		Assert.assertTrue(bloodTestEntryPage.verifyBackgroundColor(wbc, anc, grc));		
	}	
		
	@Test(priority = 2, description = "OQ_019 Test case 20: TC-20.02")
	@Step("Step 2: From the patient page, confirm the test information presented reflects the entered")
	@Severity(SeverityLevel.BLOCKER)
    @Description("From the patient page, confirm the test information presented reflects the entered")
	public void Ts2002(Method method) {
		startTest(method.getName(), "From the patient page, confirm the test information presented reflects the entered");
		Map<String, String> results = new HashMap<String, String>();
		
		homePage.clickPatientTab();
		homePage.clickOnSearch(patient);
		patientPage.clickOnRecordLink(patient);
		
		patientPage.clickSubsectionDisplayBtn("Treatment");
		String lastTestDate = patientPage.getBloodLastTestDate();
		
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		testResultID = patientPage.getTestResultId(2);
		results = patientPage.getTestResultValues(testResultID);
		String wbc = results.get("WBC").toString();
		String anc = results.get("ANC").toString();
		String grc = results.get("GRC").toString();
		
		Assert.assertTrue(wbc.equals("30.00") && anc.equals("24.00" )&& grc.equals("24.00") && lastTestDate.equals(super.getToday("M/d/yyyy")));
	}	
	
	@Test(priority = 3, description = "OQ_019 Test case 20: TC-20.03")
	@Step("step 3. Click on Activity Hstory link, Scroll down to the Activity Hstory  section")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Activity Hstory section. Confirm that an activity has been created for the subject Blood Test with the test date")
	public void Ts2003(Method method) {
		startTest(method.getName(), "Scroll down to the Activity Hstory section. Confirm that an activity has been created for the subject Blood Test with the test date");
		Map<String, String> results = new HashMap<String, String>();
		homePage.moveToSectionForm("Activity History");
		results = patientPage.getActivityValues(testResultID);
		
		String subject = results.get("Subject").toString();
		String createDate = results.get("Create Date").toString();
		Assert.assertTrue(subject.equals("Blood Test") && createDate.equals(super.getToday("M/d/yyyy")));
	}	
}
