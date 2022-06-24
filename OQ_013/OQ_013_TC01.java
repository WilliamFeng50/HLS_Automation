package testcases.OQ_013;

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
@Epic("Regression Tests")
@Feature("OQ_013 Tests")
public class OQ_013_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	EditParticipantsPage editParticipantsPage;
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_013 Test case 1: TC-01.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_013 Test case 1: TC-01.02")
	@Step("Step 2: Click on New button,new participant is opened")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on New button,new participant is opened")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Click on New button,new participant is opened");
		participantsPage.clickOnNewBtn();
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_013 Test case 1: TC-01.03")
	@Step("Step 3: Select LCC, then click next button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("select record type as LCC, click on next, New Participant: LCC window is opened")
	public void Ts0103(Method method) {
		startTest(method.getName(), "select record type as LCC, click on next, New Participant: LCC window is opened");
		participantsPage.selectRecordType("LCC");
		participantsPage.clickOnContinueBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}

	@Test(priority = 4, description = "OQ_013 Test case 1: TC-01.04")
	@Step("Step 4: Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0104(Method method) {
		String[] fields = new String[] {"Salutation","First Name", "Last Name", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 5, description = "OQ_013 Test case 1: TC-01.05")
	@Step("Step 5: The Salutation values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Salutation values in the drop down list are properly displayed")
	public void Ts0105(Method method) {
		String[] fields = new String[] {"--None--", "MR.", "MS.", "MRS.", "DR."};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Salutation values in the drop down list are properly displayed");
		participantsPage.clickOnSalutationBtn();
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Salutation", fields[i]);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_013 Test case 1: TC-01.06")
	@Step("Step 6: The Province values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Province values in the drop down list are properly displayed")
	public void Ts0106(Method method) {
		String[] fields = new String[] {"--None--", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Northwest Territories", "Nunavut", "Yukon"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Province values in the drop down list are properly displayed");
		participantsPage.clickOnProvince();
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Province", fields[i]);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
			
		}
		Assert.assertTrue(result);		
	}	
			
	@Test(priority = 8, description = "OQ_013 Test case 1: TC-01.09")
	@Step("Step 8: The Preferred method of communicationn values in the drop down field are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Preferred method of communicationn values in the drop down field are properly displayed")
	public void Ts0108(Method method) {
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
	
	@Test(priority = 9, description = "OQ_013 Test case 1: TC-01.08")
	@Step("Step 9: The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0109(Method method) {
		String[] fields = new String[] {"--None--", "English","French"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The the Communication Language values in the drop down list are properly displayed");
		participantsPage.clickOnLanguageBtn();
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
	
	@Test(priority = 10, description = "OQ_013 Test case 1: TC-01.10")
	@Step("Step 10: The the  Additional Permission values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the  Additional Permission values in the drop down list are properly displayed")
	public void Ts0110(Method method) {
		String[] fields = new String[] {"--None--", "View Patient First Name and Last Name"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The the  Additional Permission values in the drop down list are properly displayed");
		participantsPage.clickOnPermission();
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
	
	@Test(priority = 11, description = "OQ_013 Test case 1: TC-01.11")
	@Step("Step 11: Input participant information as request, click save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Input participant information as request, click save button, The information presented reflects the information entered ")
	public void Ts0111(Method method) {
		startTest(method.getName(), "input participant information as request, click save button, The information presented reflects the information entered");
		editParticipantsPage.newLCC("MS.","Karim", "Benin", "English", "Telephone", "5141119090", "5141114000","Karim Benin");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 12, description = "OQ_013 Test case 1: TC-01.12")
	@Step("Step 12: Edit the participant information, click on save button")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Edit the participant information, click on save button, Confirm that the error message is showing")
	public void Ts0112(Method method) {
		startTest(method.getName(), "Edit the participant information, click on save button, Confirm that the error message is showing");
		participantsPage.clickOnEditBtn();
		editParticipantsPage.editParticipant("5141119090", "Bell");
		homePage.clickOnSaveBtn();
		String result = "";
		Assert.assertEquals(result, "Please Enter a Service Provider and/or cell phone for the SMS Alert and make sure either FAX and/or Email has also been selected as preferred communication");
		
	}
	
	@Test(priority = 13, description = "OQ_013 Test case 1: TC-01.13")
	@Step("Step 13: Check Preferred communication email field, click on save button")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Check Preferred communication email field, click on save button, Confirm that the error message is showing")
	public void Ts0113(Method method) {
		startTest(method.getName(), "Check Preferred communication email field, click on save button, Confirm that the error message is showing");
		homePage.clickOnCancelBtn();
		participantsPage.clickOnEditBtn();
		participantsPage.checkPreferredEmail();
		homePage.clickOnSaveBtn();
		String result = "";
		Assert.assertEquals(result, "Please enter an email address for alerts");
		
	}
	
	@Test(priority = 14, description = "OQ_013 Test case 1: TC-01.14")
	@Step("Step 13: Enter your email address in Email for Alerts field, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Enter your email address in Email for Alerts field, click on save button, Confirm the participant is saved successfully")
	public void Ts0114(Method method) {
		startTest(method.getName(), "Enter your email address in Email for Alerts field, click on save button, Confirm the participant is saved successfully");
		participantsPage.inputAlertEmail("cloudpipeTest@gmail.com");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("was saved."));
	}
		
}

