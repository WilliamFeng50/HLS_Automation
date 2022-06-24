package testcases.OQ_002;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_002 Test cases")
public class OQ_002_TC03 extends BaseTest {
	PatientPage patientPage;
	ParticipantsPage participantsPage;
	
	String patient = "2018041801 EB";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_002 Test case 3: TC-03.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0301(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_002 Test case 3: TC-03.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0302(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_002 Test case 3: TC-03.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0303(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_002 Test case 3: TC-03.04")
	@Step("step 4. Scroll down to the Participants section, click the physician's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0304(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, click on the physician's name, the Participant page is displayed");
		patientPage.clickSubsectionDisplayBtn("Participants");
		patientPage.clickOnParticipantLink("Physician");
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 5, description = "OQ_002 Test case 3: TC-03.05")
	@Step("step 4.Confirm that the following related lists are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following related lists are properly displayed")
	public void Ts0305(Method method) {
		startTest(method.getName(), "Confirm that the following related lists are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] titles = {"Patients", "NRDB Patients", "Locations", "Additional Location Access", "Scheduled Reports", "Activity History", "Participant History" };
		titleList = participantsPage.getRelatedTitleList();
		result = titleList.equals(Arrays.asList(titles));
		Assert.assertTrue(result);
	}
	
	@Test(priority = 6, description = "OQ_002 Test case 3: TC-03.06")
	@Step("step 5.Confirm that the following fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following fields are properly displayed")
	public void Ts0306(Method method) {
		startTest(method.getName(), "Confirm that the following fields are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] titles = {"Physician Information", "Communication Information", "Additional Information", "CSAN Pronto", "Legacy Fields", "System Information"};
		titleList = participantsPage.getFieldsList();
		result = titleList.equals(Arrays.asList(titles));
		Assert.assertTrue(result);
	}
}
