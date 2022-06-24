package testcases.OQ_019;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.EditPatientPage;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;

@Epic("Regression Tests")
@Feature("OQ_019 Test Cases")
public class OQ_019_TC29 extends BaseTest {
	PatientPage patientPage;
	TestResultPage testResultPage;
	EditPatientPage editPatientPage;
	
	String patient = "1990101503 PD";
	String testResultID;
	String today;
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		editPatientPage = new EditPatientPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickHomeTab();
		homePage.clickPatientTab();
		homePage.clickOnSearch(patient);
		
		
	}
		
	@Test(priority = 1, description = "OQ_019 Test Test case 29: TC-29.01")
	@Step("step 1. On the patient detail page, click on the New Test Result button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("On the patient detail page, click on the New Test Result button, the New Test Result page is showing")
	public void Ts2901(Method method) {
		startTest(method.getName(), "On the patient detail page, click on the New Test Result button, the New Test Result page is showing");
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		patientPage.clickOnNewTestResult();
		Assert.assertTrue(super.isTextShowing("New Test Result"));
	}	
	
	@Test(priority = 2, description = "OQ_019 Test case 29: TC-29.02")
	@Step("step 2. Input Test Date, WBC, ANC%, GRC%, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 60, ANC% 60, GRC% 60, click on save button, confirm showing 3 warning messages")
	public void Ts2902(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 60, ANC% 60, GRC% 60, click on save button, confirm showing 3 warning messages");
		testResultPage.newTestResult("36", "", "60", "", "60", "", today, "", "");
		testResultPage.clickOnSaveBtn();
				
		Assert.assertTrue(super.isTextShowing("WBC is greater than or equal to 25. Press save to continue.") && super.isTextShowing("ANC is greater than or equal to 20. Press save to continue."));
	}	
	
	@Test(priority = 3, description = "OQ_019 Test case 29: TC-29.03")
	@Step("step 3. Click the “Save” button again")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the “Save” button again, confirm that values have been autocompleted, ANC: 21.60, GRC: 21.60")
	public void Ts2903(Method method) {
		startTest(method.getName(), "Click the “Save” button again, confirm that values have been autocompleted, ANC: 21.60, GRC: 21.60");
		String anc;
		String grc;
		testResultPage.clickOnSaveBtn();
		testResultID = testResultPage.getTestResultId();
		anc = homePage.getFormText("ANC");
		grc = homePage.getFormText("GRC");
		
		Assert.assertTrue(anc.equals("21.60")&&grc.equals("21.60"));
	}	
	
	@Test(priority = 4, description = "OQ_019 Test case 29: TC-29.04")
	@Step("step 4. Click on the Faxes and Documents tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Faxes and Documents tab, confirm that a new outbound fax is created for the test result")
	public void Ts2904(Method method) {
		startTest(method.getName(), "Click on the Faxes and Documents tab, confirm that a new outbound fax is created for the test result");
		homePage.clickFaxDocumentTab();
		//more details to check the fax document
	}
	
}
