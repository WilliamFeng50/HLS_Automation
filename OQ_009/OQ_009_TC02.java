package testcases.OQ_009;

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
@Feature("OQ_009 Test cases")
public class OQ_009_TC02 extends BaseTest {
	String participant = "Pharmaprix 119739";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_009 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_009 Test case 2: TC-02.02")
	@Step("Step 2. Enter the Pharmacy's name, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the Pharmacy's name, click on search button, the Participant should be showing in the search result")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Enter the Pharmacy's name, click on search button, the Participant should be showing in the search result");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}	
	
	@Test(priority = 3, description = "OQ_009 Test case 2: TC-02.03")
	@Step("Step 3.In the Participants section, click on the Pharmacy's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the Pharmacy's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the Pharmacy's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_009 Test case 2: TC-02.04")
	@Step("Step 4. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_009 Test case 2: TC-02.05")
	@Step("Step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0205(Method method) {
		String[] fields = new String[] {"Name", "Pharmacy License #", "Pharmacy Type", "Address 1", "City", "Province", "Postal Code", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Salutation", "First Name", "Last Name", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_009 Test case 2: TC-02.06")
	@Step("Step 6. The Pharmacy Type in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Pharmacy Type in the drop down list are properly displayed")
	public void Ts0206(Method method) {
		String[] fields = new String[] {"--None--", " Institution", " Retail"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Pharmacy Type in the drop down list are properly displayed");
		super.clickOnDropDownListBtn("Territory");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Pharmacy Type", fields[i]);
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
	
	@Test(priority = 7, description = "OQ_009 Test case 2: TC-02.07")
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
	
	@Test(priority = 8, description = "OQ_009 Test case 2: TC-02.08")
	@Step("Step 8. The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0208(Method method) {
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
	
	@Test(priority = 9, description = "OQ_009 Test case 2: TC-02.08")
	@Step("Step 9. The Salutation values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Salutation values in the drop down list are properly displayed")
	public void Ts0209(Method method) {
		String[] fields = new String[] {"--None--", "MR.", "MS.", "MRS.", "DR."};
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
	
	@Test(priority = 10, description = "OQ_009 Test case 2: TC-02.10")
	@Step("Step 10. The Preferred method of communicationn values in the drop down field are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Preferred method of communicationn values in the drop down field are properly displayed")
	public void Ts0210(Method method) {
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
	
	@Test(priority = 11, description = "OQ_009 Test case 2: TC-02.11")
	@Step("Step 11. The the  Additional Permission values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Additional Permission values in the drop down list are properly displayed")
	public void Ts0211(Method method) {
		String[] fields = new String[] {"--None--", "View Patient First Name and Last Name"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The the Additional Permission values in the drop down list are properly displayed");
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
	
	
	@Test(priority = 12, description = "OQ_009 Test case 2: TC-02.12")
	@Step("Step 12. Change the Name with  Uniprix Inc. Edit, then click save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Change the Name with  Uniprix Inc. Edit, then click save button, The information presented reflects the name entered")
	public void Ts0212(Method method) {
		startTest(method.getName(), "Change the Name with  Uniprix Inc. Edit, then click save button, The information presented reflects the name entered");
		editParticipantsPage.editParticipantField("Name", "Uniprix Inc. Edit");
		homePage.clickOnSaveBtn();
		String result = homePage.getFormText("Name");
		Assert.assertEquals(result, "Uniprix Inc. Edit");
	}
}

