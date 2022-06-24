package testcases.OQ_005;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
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
@Feature("OQ_005 Test cases")
public class OQ_005_TC01 extends BaseTest {
	PatientPage patientPage;
	String patient = "2018041801 EB";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_005 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_005 Test case 1: TC-01.02")
	@Step("Step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_005 Test case 1: TC-01.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_005 Test case 1: TC-01.04")
	@Step("Step 4. Scroll down to the Participants section, hover over the Institution's name")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants section, hover over the Institution's name, the popup of physician's details are displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, hover over the Institution's name, the popup of physician's details are displayed");
		patientPage.clickSubsectionDisplayBtn("Participants");
		homePage.hoverOverLink("Institution");
		Assert.assertTrue(super.isTextShowing("Territory"));
	}	
	
	@Test(priority = 5, description = "OQ_005 Test case 1: TC-01.05")
	@Step("Step 5. Confirm that the institution information is properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the institution information is properly displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Confirm that the institution information is properly displayed");
		Map<String, String> institution = new HashMap<String, String>();
		institution = patientPage.getInstitutionInformation();
		for (String name: institution.keySet()) {
		    String key = name.toString();
		    String value = institution.get(name).toString();
		    Reporter.log("The details of Institution are: " + key + " " + value, true);
		}
		Assert.assertTrue(institution.size()>0);
	}	
	
}
