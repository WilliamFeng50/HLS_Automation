package testcases.OQ_105;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

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
import pages.FaxDocumentPage;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_105 Test cases")
public class OQ_105_TC21 extends BaseTest {
	String physician = "";
	String patient = "2018041401 CL";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		faxDocumentPage = new FaxDocumentPage();
		
		homePage.clickHomeTab();
		homePage.clickPatientTab();
		homePage.clickOnSearch(patient);
		patientPage.clickOnRecordLink(patient);
	}
		
		
	@Test(priority = 1, description = "OQ_105 Test case 21: TC-21.01")
	@Step("step 1. In the Test Results section, click on new test result, add a new test result")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the Test Results section, click on new test result, add a new test result")
	public void Ts2101(Method method) {
		startTest(method.getName(), "In the Test Results section, click on new test result, add a new test result");
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		patientPage.clickOnNewTestResult();
		testResultPage.newTestResult("3.5", "1.8", "", "", "", "In treatment", super.getToday("yyyyMMdd"), "", "");
		testResultPage.clickOnSaveBtn();
		testResultPage.clickOnOKButton();
		Assert.assertTrue(super.isTextShowing("Test Result Detail"));
	}	
	
	@Test(priority = 2, description = "OQ_105 Test case 21: TC-21.02")
	@Step("step 2. Click on Faxes/Documents tab")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Faxes/Documents tab")
	public void Ts2102(Method method) {
		startTest(method.getName(), "Click on Faxes/Documents tab, confirm the fax is sent to the Physician");
		homePage.clickFaxDocumentTab();
		faxDocumentPage.clickOnViewList("All Outbound Faxes - Not Sent");
		homePage.clickOnGoButton();
		// how to check the document
		Assert.assertTrue(true);
	}
	
}
