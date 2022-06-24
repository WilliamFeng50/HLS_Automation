package testcases.OQ_005;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_005 Test cases")
public class OQ_005_TC03 extends BaseTest {
	PatientPage patientPage;
	ParticipantsPage participantsPage;
	
	String patient = "2018041801 EB";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_005 Test case 3: TC-03.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0301(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_005 Test case 3: TC-03.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0302(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_005 Test case 3: TC-03.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0303(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_005 Test case 3: TC-03.04")
	@Step("step 4. Scroll down to the Participants section, click the Institution's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Participants section, click on the Institution's name, the Participant page is displayed")
	public void Ts0304(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, click on the Institution's name, the Participant page is displayed");
		patientPage.clickSubsectionDisplayBtn("Participants");
		patientPage.clickOnParticipantLink("Institution");
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 5, description = "OQ_005 Test case 3: TC-03.05")
	@Step("step 5.Confirm that the following related lists are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following related lists are properly displayed")
	public void Ts0305(Method method) {
		startTest(method.getName(), "Confirm that the following related lists are properly displayed");
		String [] labels = {"Name", "Participant Record Type", "Phone", "Fax", "Territory", "Clinical Coordinator", "Communication Language", "Address 1", "City", "Postal Code" };
		
		Map<String, String> fieldMap = new HashMap<String, String>();
		fieldMap = homePage.getFormText(labels);
		for (String name: fieldMap.keySet()) {
		    String key = name.toString();
		    String value = fieldMap.get(name).toString();
		    Reporter.log("The information for the displaying fields are: " + key + " " + value, true);
		}
		Assert.assertTrue(fieldMap.size()>0);
	}

}
