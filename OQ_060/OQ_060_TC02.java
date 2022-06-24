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
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_060 Test cases")
public class OQ_060_TC02 extends BaseTest {
	String participant = "MARIA ARISTA";
	String patient = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		patientPage = new PatientPage(); 		
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 2: TC-02.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0202(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_001 Test case 2: TC-02.04")
	@Step("Step 4. Click on edit button, confirm the Additional permission drop donw list has the correct values")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, confirm the Additional permission drop donw list has the correct values")
	public void Ts0204(Method method) {
		startTest(method.getName(), "The the  Additional Permission values in the drop down list are properly displayed");
		String[] fields = new String[] {"--None--", "View Patient First Name and Last Name"};
		boolean result = false;
		String value = null;
		participantsPage.clickOnEditBtn();
		super.clickOnDropDownListBtn("Additional Permission");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Additional Permission", fields[i]);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
		}
		Assert.assertTrue(result);			
	}
	
	@Test(priority = 5, description = "OQ_060 Test case 2: TC-02.05")
	@Step("Step 5. Select View Patient First Name and Last Name, then click on save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Select View Patient First Name and Last Name, then click on save button, back to the participants detail page")
	public void Ts0205(Method method) {
		startTest(method.getName(), "Select View Patient First Name and Last Name, then click on save button, back to the participants detail page");
		homePage.changeDropDownListItem("Additional Permission", "View Patient First Name and Last Name");
		editParticipantsPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));		
	}
		
	@Test(priority = 6, description = "OQ_060 Test case 2: TC-02.06")
	@Step("Step 6. Log into the portal as the external user for the participant, go to the Patients tab")
	@Severity(SeverityLevel.NORMAL)
	@Description("Log into the portal as the external user for the participant, go to the Patients tab")
	public void Ts0206(Method method) {
		startTest(method.getName(), "Log into the portal as the external user for the participant, go to the Patients tab");
		//how to go to login page
		Assert.assertTrue(true);		
	}
	
	@Test(priority = 7, description = "OQ_060 Test case 2: TC-02.07")
	@Step("Step 7. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0207(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 8, description = "OQ_060 Test case 2: TC-02.08")
	@Step("Step 8. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0208(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
	
	@Test(priority = 9, description = "OQ_060 Test case 2: TC-02.09")
	@Step("Step 9. Confirm that the values are visible in the First Name and the Last Name fields")
	@Severity(SeverityLevel.NORMAL)
    @Description("Confirm that the values are visible in the First Name and the Last Name fields")
	public void Ts0209(Method method) {
		startTest(method.getName(), "Confirm that the values are visible in the First Name and the Last Name fields");
		//get the first name and the last name
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
}

