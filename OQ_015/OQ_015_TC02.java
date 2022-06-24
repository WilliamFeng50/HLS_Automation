package testcases.OQ_015;

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
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_015 Test Cases")
public class OQ_015_TC02 extends BaseTest {
	ParticipantsPage participantsPage;
	MailPage mailPage;
	String participant = "KARIM BENIN";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		mailPage = new MailPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_015 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_015 Test case 2: TC-02.02")
	@Step("Step 2. Enter the LCC's name, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the LCC's name, click on search button, the Participant should be showing in the search result")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Enter the LCC's name, click on search button, the Participant should be showing in the search result");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}	
	
	@Test(priority = 3, description = "OQ_015 Test case 2: TC-02.03")
	@Step("Step 3.In the Participants section, click on the LCC's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the LCC's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the LCC's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_015 Test case 2: TC-02.04")
	@Step("Step 4. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_015 Test case 2: TC-02.05")
	@Step("Step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0205(Method method) {
		String[] fields = new String[] {"Salutation","First Name", "Last Name", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_015 Test case 2: TC-02.06")
	@Step("Step 6. The Territory values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Territory values in the drop down list are properly displayed")
	public void Ts0206(Method method) {
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
	
		
	@Test(priority = 7, description = "OQ_015 Test case 2: TC-02.07")
	@Step("Step 7: The Province values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Province values in the drop down list are properly displayed")
	public void Ts0207(Method method) {
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
	
	@Test(priority = 8, description = "OQ_015 Test case 2: TC-02.08")
	@Step("Step 8: The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0208(Method method) {
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
	
	@Test(priority = 9, description = "OQ_015 Test case 2: TC-02.09")
	@Step("Step 9: The Preferred method of communicationn values in the drop down field are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Preferred method of communicationn values in the drop down field are properly displayed")
	public void Ts0209(Method method) {
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
	
	
	@Test(priority = 10, description = "OQ_015 Test case 2: TC-02.10")
	@Step("Step 10: The the  Additional Permission values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the  Additional Permission values in the drop down list are properly displayed")
	public void Ts0210(Method method) {
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
	
	@Test(priority = 11, description = "OQ_015 Test case 2: TC-02.11")
	@Step("Step 11: Edit the First Name, then click save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Edit the First Name with Anne Edit, then click save button")
	public void Ts0211(Method method) {
		startTest(method.getName(), "Edit the First Name with Anne Edit, then click save button");
		homePage.editField("First Name", "Anne Edit");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 12, description = "OQ_015 Test case 2: TC-02.12")
	@Step("Step 12: Edit the participant information, click on save button")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Edit the participant information, click on save button, Confirm that the error message is showing")
	public void Ts0212(Method method) {
		startTest(method.getName(), "Edit the participant information, click on save button, Confirm that the error message is showing");
		participantsPage.clickOnEditBtn();
		homePage.editField("Last Name", "Turnbull Edit");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Please Enter a Service Provider and/or cell phone for the SMS Alert and make sure either FAX and/or Email has also been selected as preferred communication"));
		
	}
	
	@Test(priority = 16, description = "OQ_015 Test case 2: TC-02.16")
	@Step("Step 16. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0216(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 17, description = "OQ_015 Test case 2: TC-02.17")
	@Step("Step 17: Enter information in the Additional Information field, click on save button")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Enter information in the Additional Information field, click on save button")
	public void Ts0217(Method method) {
		startTest(method.getName(), "Enter information in the Additional Information field, click on save button");
		homePage.editField("Additional Information", "I can update this field");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("I can update this field"));
	}
		
}

