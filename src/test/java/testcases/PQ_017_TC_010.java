package testcases;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;

public class PQ_017_TC_010 extends BaseTest {
	PatientPage patientPage;
	TestResultPage testResultPage;
	
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		
		super.waitForSleep(5000);
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "PQ_017 Test case 1: TC-010.01")
	@Step("step 1. click on Patient tab, select Clozaril (All) from List view dropdown")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Patient page should appear and a list of all Clozaril patients")
	public void Ts0101(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is opened");
		homePage.clickPatientTab();
		patientPage.clickOnListViewBtn();
		patientPage.clozarilAllView();
		Assert.assertTrue(super.isTextShowing("Sorted by Patient Status"));

	}

	@Test(priority = 2, description = "PQ_017 Test case 1: TC-010.02")
	@Step("step 2. search all status of active and preferred language of English patient, select a patient and open the profile")
	@Severity(SeverityLevel.BLOCKER)
    @Description("all status of active patient should be showing in the list, open the patient profile")
	public void Ts0102(Method method) {
		startTest(method.getName(), "click on New button,new participant is opened");
		patientPage.search("Active");
		patientPage.clickOnRecordLink();
		Assert.assertTrue(super.isTextShowing("Test Results"));
	}

	@Test(priority = 3, description = "PQ_017 Test case 1: TC-010.03")
	@Step("step 3. Click on the Test results hyperlink at the top of the patient profile")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Test results hyperlink at the top of the patient profile, Test results section openes")
	public void Ts0103(Method method) {
		startTest(method.getName(), "click on New button,new participant is opened");
		testResultPage.clickOnTestResultLink();
		Assert.assertTrue(super.isTextShowing("Sorted by Test Date"));
	}	
	
	@Test(priority = 4, description = "PQ_017 Test case 1: TC-010.04")
	@Step("step 4. input test data and click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("input test data and click on save button, New Test result template now includes the test date, WBC and ANC entered and a RED alert icon in the Test result alert")
	public void Ts0104(Method method) {
		startTest(method.getName(), "click on New button,new participant is opened");
		testResultPage.clickOnNewTestResultLink();
		testResultPage.newTestResult("20220207", "3.2", "1.49","");
		testResultPage.clickOnSaveBtn();
		testResultPage.clickOnOkBtn();
		testResultPage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Test Result Alert"));
	}	
	
}
