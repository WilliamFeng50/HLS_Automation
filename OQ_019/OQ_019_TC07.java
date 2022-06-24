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
public class OQ_019_TC07 extends BaseTest {
	PatientPage patientPage;
	TestResultPage testResultPage;
	String patient = "2018041801 EB";
	String testResultID;
	String today;
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickOnSearch(patient);
		patientPage.clickOnRecordLink(patient);
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
	}
		
	@Test(priority = 1, description = "OQ_019 Test case 07: TC-07.01")
	@Step("Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 1, ANC 0.4, GRC 0.4, click on save button, confirm the values have ben autocompleted for ANC%:40, GRC%:40, test result alert status: Red")
	public void Ts0701(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 1, ANC 0.4, GRC 0.4, click on save button, confirm the values have ben autocompleted for ANC%:40, GRC%:40, test result alert status: Red");
		String status;
		String anc;
		String grc;
		patientPage.clickOnNewTestResult();
		testResultPage.newTestResult("1", "0.4", "", "0.4", "", "", today, "", "");
		testResultPage.clickOnSaveBtn();

		status = testResultPage.getTestResultAlertStatus();
		anc = testResultPage.getANCPercentValue();
		grc = testResultPage.getGRCPercentValue();
		testResultID = testResultPage.getTestResultId();
		
		Assert.assertTrue(status.equalsIgnoreCase("Red") && anc.equals("40.00%") && grc.equals("40.00%"));
	}	
		
}
