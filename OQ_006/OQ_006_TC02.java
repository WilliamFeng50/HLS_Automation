package testcases.OQ_006;

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
import pages.EditParticipantsPage;
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_006 Test cases")
public class OQ_006_TC02 extends BaseTest {
	String participant = "Royal Victoria Hospital";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_006 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_006 Test case 2: TC-02.02")
	@Step("Step 2. Enter the Institution's name, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the Institution's name, click on search button, the Participant should be showing in the search result")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Enter the Institution's name, click on search button, the Participant should be showing in the search result");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}	
	
	@Test(priority = 3, description = "OQ_006 Test case 2: TC-02.03")
	@Step("Step 3.In the Participants section, click on the Institution's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the Institution's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the Institution's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_006 Test case 2: TC-02.04")
	@Step("Step 4. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_006 Test case 2: TC-02.05")
	@Step("Step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0205(Method method) {
		String[] fields = new String[] {"Name","Phone", "Fax", "Territory", "Address 1", "City", "Province", "Postal Code", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_006 Test case 2: TC-02.06")
	@Step("Step 6. The Territory values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Territory values in the drop down list are properly displayed")
	public void Ts0206(Method method) {
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
	
	@Test(priority = 7, description = "OQ_006 Test case 2: TC-02.07")
	@Step("Step 7. The the Communication Language values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the Communication Language values in the drop down list are properly displayed")
	public void Ts0207(Method method) {
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
	
	@Test(priority = 8, description = "OQ_006 Test case 2: TC-02.08")
	@Step("Step 8. Change the Name with  Montreal Children's Hospital Edit, then click save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Change the Name with  Montreal Children's Hospital Edit, then click save button, The information presented reflects the name entered")
	public void Ts0208(Method method) {
		startTest(method.getName(), "Change the Name with  Montreal Children's Hospital Edit, then click save button, The information presented reflects the name entered");
		editParticipantsPage.editParticipantField("Name", "Montreal Children's Hospital Edit");
		homePage.clickOnSaveBtn();
		String result = homePage.getFormText("Name");
		Assert.assertEquals(result, "MONTREAL CHILDREN'S HOSPITAL EDIT");
	}
}

