package testcases.OQ_003;

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
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_003 Test cases")
public class OQ_003_TC01 extends BaseTest {
	PatientPage patientPage;
	String patient = "2006041101 MR";
	String physicianName = "ANTHONY LANG";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_003 Test case 1: TC-01.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_003 Test case 1: TC-01.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_003 Test case 1: TC-01.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_003 Test case 1: TC-01.04")
	@Step("step 4. Click the Edit button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the Edit button, the Edit Patient page is displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Click the Edit button, the Edit Patient page is displayed");
		patientPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Patient Edit"));
	}	
	
	@Test(priority = 5, description = "OQ_003 Test case 1: TC-01.05")
	@Step("step 5. Click the Physician Lookup button next to the Physician field")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the Physician Lookup button, confirm that the search popup arrears")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Click the Physician Lookup button, confirm that the search popup arrears");
		patientPage.clickOnLookup("Physician");
		Assert.assertTrue(super.isTextShowing("Lookup"));
	}	
	
	@Test(priority = 6, description = "OQ_003 Test case 1: TC-01.06")
	@Step("step 6. Enter the physician's name and click the Go! button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Enter the physician's name and click the Go! button, the search result table is displayed")
	public void Ts0106(Method method) {
		startTest(method.getName(), "Enter the physician's name and click the Go! button, the search result table is displayed");
		homePage.clickOnSearch(physicianName);
		Assert.assertTrue(!super.isTextShowing("No records were found based on your criteria"));
	}	
	
	@Test(priority = 7, description = "OQ_003 Test case 1: TC-01.07")
	@Step("step 7. Click the physician's name to select")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the physician's name to select, the Edit Patient page is displayed")
	public void Ts0107(Method method) {
		startTest(method.getName(), "Click the physician's name to select, the Edit Patient page is displayed");
		homePage.selectSearchResult(physicianName);
		Assert.assertTrue(super.isTextShowing("Patient Edit"));
	}	
	
	@Test(priority = 9, description = "OQ_003 Test case 1: TC-01.09")
	@Step("step 9. Scroll down to the participants section, confirm the physician has been correctly assigned to the patient")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the participants section, confirm the physician has been correctly assigned to the patient")
	public void Ts0109(Method method) {
		startTest(method.getName(), "Scroll down to the participants section, confirm the physician has been correctly assigned to the patient");
		String result = patientPage.getPhysicianName();
		Assert.assertEquals(result, physicianName);
	}	
}
