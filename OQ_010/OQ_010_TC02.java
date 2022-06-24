package testcases.OQ_010;

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
@Feature("OQ_010 Test cases")
public class OQ_010_TC02 extends BaseTest {
	ParticipantsPage participantsPage;
	EditParticipantsPage editParticipantsPage;
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_010 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));
	}

	@Test(priority = 2, description = "OQ_010 Test case 2: TC-02.02")
	@Step("Step 2. Click on New button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on New button, new participant page is displayed")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Click on New button, new participant page is displayed");
		participantsPage.clickOnNewBtn();
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_010 Test case 2: TC-02.03")
	@Step("Step 3. Select record type as Laboratory, click on continue")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Select record type as Laboratory, click on continue, the Participant edit page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "Select record type as Laboratory, click on continue, the Participant edit page is displayed");
		participantsPage.selectRecordType("Laboratory");
		participantsPage.clickOnContinueBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}

	@Test(priority = 4, description = "OQ_010 Test case 2: TC-02.04")
	@Step("Step 4. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0204(Method method) {
		String[] fields = new String[] {"Name", "Address 1", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Salutation", "First Name", "Last Name", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
		
	@Test(priority = 5, description = "OQ_010 Test case 2: TC-02.05")
	@Step("Step 5. The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0205(Method method) {
		String[] fields = new String[] {"--None--", "English","French"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The the Communication Language values in the drop down list are properly displayed");
		super.clickOnDropDownListBtn("Communication Language");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Communication Language", fields[i]);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_010 Test case 2: TC-02.06")
	@Step("Step 6. The Preferred method of communicationn values in the drop down field are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Preferred method of communicationn values in the drop down field are properly displayed")
	public void Ts0206(Method method) {
		String[] fields = new String[] {"Telephone", "Fax", "Email", "Pager", "Letter"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Preferred method of communicationn values in the drop down field are properly displayed");
		participantsPage.clickOnMethod();
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Preferred method of communication",fields[i]);
			System.out.println(i + ":" + value);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
		}
		Assert.assertTrue(result);		
	}	
		
	@Test(priority = 7, description = "OQ_010 Test case 2: TC-02.07")
	@Step("Step 7. Input pharmacy information as request, click save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Input pharmacy information as request, click save button, The information presented reflects the information entered ")
	public void Ts0207(Method method) {
		startTest(method.getName(), "input pharmacy information as request, click save button, The information presented reflects the information entered");
		editParticipantsPage.newLaboratory("Alpha Laboratories", "Alpha Laboratories", "French", "Telephone", "4161111568", "4161111548", "MR.", "Michael", "Walker");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 8, description = "OQ_010 Test case 2: TC-02.08")
	@Step("Step 8. Edit the participant information, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Edit the participant information, click on save button, Confirm that the error message is showing")
	public void Ts0208(Method method) {
		startTest(method.getName(), "Edit the participant information, click on save button, Confirm that the error message is showing");
		participantsPage.clickOnEditBtn();
		editParticipantsPage.editParticipant("5141119090", "Fido");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Please Enter a Service Provider and/or cell phone for the SMS Alert and make sure either FAX and/or Email has also been selected as preferred communication") );
	}
	
	@Test(priority = 13, description = "OQ_010 Test case 2: TC-02.13")
	@Step("Step 13. Check Preferred communication email field, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Check Preferred communication email field, click on save button, Confirm that the error message is showing")
	public void Ts0213(Method method) {
		startTest(method.getName(), "Check Preferred communication email field, click on save button, Confirm that the error message is showing");
		participantsPage.checkPreferredEmail();
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Please enter an email address for alerts"));
	}
		
	@Test(priority = 14, description = "OQ_010 Test case 2: TC-02.14")
	@Step("Step 14. Enter the email address in Email for Alerts field, then click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Enter the email address in Email for Alerts field, then click on save button, the error message disappared, and saved successfully")
	public void Ts0214(Method method) {
		startTest(method.getName(), "Enter the email address in Email for Alerts field, then click on save button, the error message disappared, and saved successfully");
		participantsPage.inputAlertEmail("wfeng@cloudpipe.ca");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	
}

