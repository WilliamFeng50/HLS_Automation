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
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;

@Epic("Regression Tests")
@Feature("OQ_019 Test Cases")
public class OQ_019_TC24 extends BaseTest {
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
		
	@Test(priority = 1, description = "OQ_019 Test case 24: TC-24.01")
	@Step("step 1. Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 2, ANC 1, GRC 1, click on save button, confirm showing 3 warning messages")
	public void Ts2401(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 2, ANC 1, GRC 1, click on save button, confirm showing 3 warning messages");
		String anc;
		String grc;
		String status;
		testResultPage.newTestResult("2", "1", "", "1", "", "", today, "", "");
		testResultPage.clickOnSaveBtn();

		testResultID = testResultPage.getTestResultId();
		status = testResultPage.getTestResultAlertStatus();
		anc = testResultPage.getANCPercentValue();
		grc = testResultPage.getGRCPercentValue();
		
		Assert.assertTrue(status.equalsIgnoreCase("Red")&&anc.equals("50.00%")&&grc.equals("50.00%"));
	}	
		
}
