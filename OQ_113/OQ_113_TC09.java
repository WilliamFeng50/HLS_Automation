package testcases.OQ_113;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ELetterPage;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_113 Test cases")
public class OQ_113_TC09 extends BaseTest {
	String testResultId = "";
	String patient = "2003030603 GD";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_113 Test case 09: TC-09.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0901(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_113 Test case 09: TC-09.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0902(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_113 Test case 09: TC-09.03")
	@Step("step 3. In the patients section, click the patient's name, add new test result")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, add new test result")
	public void Ts0903(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, add new test result");
		patientPage.clickOnRecordLink(patient);
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		patientPage.clickOnNewTestResult();
		testResultPage.newTestResult("21", "15", "", "15", "", "In treatment", super.getToday("yyyyMMdd"), "", "");
		testResultPage.clickOnSaveBtn();
		testResultId = testResultPage.getTestResultInformation("Test Result ID");
		testResultPage.clickOnPatientLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_113 Test case 09: TC-09.04")
	@Step("step 4. Scroll down to the test result section, confirm the test result has been created")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the test result section, confirm the test result has been created")
	public void Ts0904(Method method) {
		startTest(method.getName(), "Scroll down to the test result section, confirm the test result has been created");
		Map<String, String> details = new HashMap<String, String>();
		String testDate = "";
		String wbc = "";
		String anc = "";
		String grc = "";
		String type = "";
		
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		details = patientPage.getTestResultValues(testResultId);
		testDate = details.get("Test Date");
		wbc = details.get("WBC");
		anc = details.get("ANC");
		grc = details.get("GRC");
		type =  details.get("Type");
		Assert.assertTrue(wbc.equals("21.00") && anc.equals("15.00") && grc.equals("15.00") && type.equals("In-treatment"));
	}
	
}