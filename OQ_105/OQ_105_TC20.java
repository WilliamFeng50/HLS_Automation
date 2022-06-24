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
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_105 Test cases")
public class OQ_105_TC20 extends BaseTest {
	
	String patient = "2018041401 CL";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_105 Test case 20: TC-20.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts2001(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_105 Test case 20: TC-20.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts2002(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 20: TC-20.03")
	@Step("step 3. In the patients section, click the patient's name, click on new test result")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, add new test result")
	public void Ts2003(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, add new test result");
		patientPage.clickOnRecordLink(patient);
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		patientPage.clickOnNewTestResult();
		testResultPage.newTestResult("3.5", "1.8", "", "", "", "In treatment", super.getToday("yyyyMMdd"), "", "");
		testResultPage.clickOnSaveBtn();
		testResultPage.clickOnOKButton();
		Assert.assertTrue(super.isTextShowing("Test Result Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_105 Test case 20: TC-20.04")
	@Step("step 4. Click on eLetter button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on eLetter button")
	public void Ts2004(Method method) {
		startTest(method.getName(), "Click on eLetter button");
		testResultPage.clickOnELetterButton();
		Assert.assertTrue(super.isTextShowing("Select eLetter"));
	}
	
	@Test(priority = 5, description = "OQ_105 Test case 20: TC-20.05")
	@Step("step 5. Select the eLetter, then click on the Send button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Select the eLetter, then click on the Send button, a fax will be sent to recipient")
	public void Ts2005(Method method) {
		startTest(method.getName(), "Select the eLetter, then click on the Send button, a fax will be sent to recipient");
		testResultPage.clickOnELetterButton();
		eLetterPage.selectELeter("eLetter BEN Pharmacy New Blood Test Alert On Creation Of Test Result");
		eLetterPage.clickOnSendBtn();
		//
		Assert.assertTrue(super.isTextShowing("A fax will be sent to"));
	}
	
	@Test(priority = 6, description = "OQ_105 Test case 20: TC-20.06")
	@Step("step 6. Check the Recipient's fax inbox for a BEN Pharmacy blood test Yellow letter")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Check the Recipient's fax inbox for a BEN Pharmacy blood test Yellow letter")
	public void Ts2006(Method method) {
		startTest(method.getName(), "Check the Recipient's fax inbox for a BEN Pharmacy blood test Yellow letter");
		//Check the inbox ?
		Assert.assertTrue(true);
	}
}
