package testcases.OQ_017;

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
import pages.EditParticipantsPage;
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_017 Test Cases")
public class OQ_017_TC01 extends BaseTest {
	String participant = "APOTEX";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_017 Test case 1: TC-01.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_017 Test case 1: TC-01.02")
	@Step("Step 2: From the View dropdown list, select Generic Companies")
	@Severity(SeverityLevel.BLOCKER)
	@Description("From the View dropdown list, select Generic Companies, A list of LCCs is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From the View dropdown list, select Generic Companies, A list of LCCs is displayed");
		homePage.selectViewListItem("Generic Companies");
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_017 Test case 1: TC-01.03")
	@Step("Step 3.In the Participants section, click on the generic company's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the generic company's name, the Participant page is displayed")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the Participants section, click on the generic company's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_017 Test case 1: TC-01.04")
	@Step("Step 4. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_017 Test case 1: TC-01.05")
	@Step("Step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0105(Method method) {
		String[] fields = new String[] {"Name", "Address 1", "Communication Language", "Fax", "Salutation", "First Name", "Last Name", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_017 Test case 1: TC-01.06")
	@Step("Step 6. The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0106(Method method) {
		String[] fields = new String[] {"English","French"};
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
		
	@Test(priority = 7, description = "OQ_017 Test case 1: TC-01.07")
	@Step("Step 7. The Preferred method of communicationn values in the drop down field are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Preferred method of communicationn values in the drop down field are properly displayed")
	public void Ts0107(Method method) {
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
	
	@Test(priority = 8, description = "OQ_017 Test case 1: TC-01.08")
	@Step("Step 8. The Province values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Province values in the drop down list are properly displayed")
	public void Ts0108(Method method) {
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
	
	@Test(priority = 9, description = "OQ_017 Test case 1: TC-01.08")
	@Step("Step 9. The Salutation values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Salutation values in the drop down list are properly displayed")
	public void Ts0109(Method method) {
		String[] fields = new String[] {"MR.", "MS.", "MRS.", "DR."};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Salutation values in the drop down list are properly displayed");
		super.clickOnDropDownListBtn("Salutation");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Salutation", fields[i]);
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
	
		
	@Test(priority = 10, description = "OQ_017 Test case 1: TC-01.10")
	@Step("Step 10. Change the First Name with  Robert Edit, then click save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Change the First Name with  Robert Edit, then click save button, The information presented reflects the name entered")
	public void Ts0110(Method method) {
		startTest(method.getName(), "Change the First Name with  Robert Edit, then click save button, The information presented reflects the name entered");
		editParticipantsPage.editParticipantField("First Name", "Robert Edit");
		homePage.clickOnSaveBtn();
		String result = homePage.getFormText("First Name");
		Assert.assertEquals(result, "Robert Edit");
	}
}

