package testcases.OQ_060;

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
import pages.EditParticipantsPage;
import pages.LocationPage;
import pages.LookupPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_060 Test cases")
public class OQ_060_TC04 extends BaseTest {
	String participant = "MARIA ARISTA";
	String locationName = "";
	String patient = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		patientPage = new PatientPage(); 
		locationPage = new LocationPage();
		lookupPage = new LookupPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 4: TC-04.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0401(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 4: TC-04.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0402(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0403(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_060 Test case 4: TC-04.04")
	@Step("Step 4. Scroll down to the Additional Location Access section, click the New Additional Location Access button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Additional Location Access section, click the New Additional Location Access button")
	public void Ts0404(Method method) {
		startTest(method.getName(), "Scroll down to the Additional Location Access section, click the New Additional Location Access button");
		homePage.moveToSectionForm("Additional Location Access");
		participantsPage.clickOnNewAdditionalLocationAccessButton();
		Assert.assertTrue(super.isTextShowing("Additional Location Access Edit"));		
	}
		
	@Test(priority = 5, description = "OQ_060 Test case 4: TC-04.05")
	@Step("Step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0405(Method method) {
		String[] fields = new String[] {"Location","Participant"};
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_060 Test case 4: TC-04.06")
	@Step("Step 6. Confirm that theParticipant field indicates the selected Participant")
	@Severity(SeverityLevel.NORMAL)
    @Description("Confirm that theParticipant field indicates the selected Participant")
	public void Ts0406(Method method) {
		startTest(method.getName(), "Confirm that theParticipant field indicates the selected Participant");
		String value = locationPage.getParticipant();
		Assert.assertTrue(value.equalsIgnoreCase(participant));
	}	
	
	@Test(priority = 7, description = "OQ_060 Test case 4: TC-04.07")
	@Step("Step 7. Click the Location Lookup button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click the Location Lookup button, confirm that the Lookup popup is opened")
	public void Ts0407(Method method) {
		startTest(method.getName(), "Click the Location Lookup button, confirm that the Lookup popup is opened");
		locationPage.clicOnLocatioLookupButton();
		Assert.assertTrue(super.isTextShowing("Lookup"));
	}
	
	@Test(priority = 8, description = "OQ_060 Test case 4: TC-04.08")
	@Step("Step 8. In the search field, enter the location's name and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the search field, enter the location's name and click the Go! button")
	public void Ts0408(Method method) {
		startTest(method.getName(), "In the search field, enter the location's name and click the Go! button");
		lookupPage.lookup(locationName);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}
	
	@Test(priority = 9, description = "OQ_060 Test case 4: TC-04.09")
	@Step("Step 9. In the results list, click the location's name to select it")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the results list, click the location's name to select it, back to location edit page")
	public void Ts0409(Method method) {
		startTest(method.getName(), "In the results list, click the location's name to select it, back to location edit page");
		lookupPage.selectResultName(locationName);
		Assert.assertTrue(super.isTextShowing("Additional Location Access Edit"));
	}

	@Test(priority = 10, description = "OQ_060 Test case 4: TC-04.10")
	@Step("Step 10. Click on save button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on save button, the participant page is displayed for the selected participant")
	public void Ts0410(Method method) {
		startTest(method.getName(), "Click on save button, the participant page is displayed for the selected participant");
		locationPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 11, description = "OQ_060 Test case 4: TC-04.11")
	@Step("Step 11. Scroll down to the Additional Location Access section, then click on the added location name")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Additional Location Access section, then click on the added location name, the location page is displayed")
	public void Ts0411(Method method) {
		startTest(method.getName(), "Scroll down to the Additional Location Access section, then click on the added location name, the location page is displayed");
		homePage.moveToSectionForm("Additional Location Access");
		homePage.clickOnTableLink(locationName);
		Assert.assertTrue(super.isTextShowing("Location Detail"));		
	}
	
	@Test(priority = 12, description = "OQ_060 Test case 4: TC-04.12")
	@Step("Step 12. Scroll down to the Patients section, get the patient name")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Patients section, get the patient name")
	public void Ts0412(Method method) {
		startTest(method.getName(), "Scroll down to the Patients section, get the patient name");
		homePage.moveToSectionForm("Patients");
		// need to login the external user
		Assert.assertTrue(true);		
	}
	
}

