package testcases.OQ_004;

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
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_004 Test cases")
public class OQ_004_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	EditParticipantsPage editParticipantsPage;
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_004 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_004 Test case 1: TC-01.02")
	@Step("Step 2. Click on New button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on New button, new participant page is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Click on New button, new participant page is displayed");
		participantsPage.clickOnNewBtn();
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_004 Test case 1: TC-01.03")
	@Step("Step 3. Select record type as Institution, click on continue")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Select record type as Institution, click on continue, the Participant edit page is displayed")
	public void Ts0103(Method method) {
		startTest(method.getName(), "Select record type as Institution, click on continue, the Participant edit page is displayed");
		participantsPage.selectRecordType("Institution");
		participantsPage.clickOnContinueBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}

	@Test(priority = 4, description = "OQ_004 Test case 1: TC-01.04")
	@Step("Step 4. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0104(Method method) {
		String[] fields = new String[] {"Name","Phone", "Fax", "Territory", "Address 1", "City", "Province", "Postal Code", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 5, description = "OQ_004 Test case 1: TC-01.05")
	@Step("Step 5. The Territory values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Territory values in the drop down list are properly displayed")
	public void Ts0105(Method method) {
		String[] fields = new String[] {"--None--", "BC/NW Terr./Nunavut/Yukon", "Alberta", "Ontario West", "Ontario Est", "Ontario Ottawa", "Quebec West", "Quebec East", "Nova Scotia", "Atlantic", "Saskatchewan", "Unknown"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Territory values in the drop down list are properly displayed");
		super.clickOnDropDownListBtn("Territory");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Territory", fields[i]);
			System.out.println("the result is: " + result);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
		}
		Assert.assertTrue(result);		
	}
		
	@Test(priority = 6, description = "OQ_004 Test case 1: TC-01.06")
	@Step("Step 6. Confirm the Participant record type is Institution")
	@Severity(SeverityLevel.NORMAL)
	@Description("Confirm the Participant record type is Institution, the value is properly displayed")
	public void Ts0106(Method method) {
		startTest(method.getName(), "Confirm the Participant record type is Institution, the value is properly displayed");
		String type = participantsPage.getRecordType();
		Assert.assertEquals(type, "Institution");	
	}
		
	@Test(priority = 7, description = "OQ_004 Test case 1: TC-01.07")
	@Step("Step 7. Input institution information as request, click save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Input institution information as request, click save button, The information presented reflects the information entered ")
	public void Ts0107(Method method) {
		startTest(method.getName(), "input institution information as request, click save button, The information presented reflects the information entered");
		editParticipantsPage.newInstitution("Royal Victoria Hospital", "(514) 111-3958", "(514) 111-3985", "Quebec East", "English", "RVH Reception", "Montreal", "Québec", "H3A 1A1");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 8, description = "OQ_004 Test case 1: TC-01.08")
	@Step("Step 8. Edit the participant information, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Edit the participant information, click on save button, Confirm that the error message is showing")
	public void Ts0108(Method method) {
		startTest(method.getName(), "Edit the participant information, click on save button, Confirm that the error message is showing");
		participantsPage.clickOnEditBtn();
		editParticipantsPage.editParticipant("5141119090", "Fido");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Please Enter a Service Provider and/or cell phone for the SMS Alert and make sure either FAX and/or Email has also been selected as preferred communication") );
	}
	
	@Test(priority = 9, description = "OQ_004 Test case 1: TC-01.09")
	@Step("Step 9. Check Preferred communication email field, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Check Preferred communication email field, click on save button, Confirm that the error message is showing")
	public void Ts0109(Method method) {
		startTest(method.getName(), "Check Preferred communication email field, click on save button, Confirm that the error message is showing");
		participantsPage.checkPreferredEmail();
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Please enter an email address for alerts"));
	}
		
}

