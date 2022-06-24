package testcases.OQ_003;

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
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_003 Test cases")
public class OQ_003_TC02 extends BaseTest {
	PatientPage patientPage;
	ParticipantsPage participantsPage;
	
	String patient = "2006041101 MR";
	String physicianName = "ANTHONY LANG";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_003 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_003 Test case 2: TC-02.02")
	@Step("Step 2. Enter the physician's name, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the physician's name, click on search button, the Participant should be showing in the search result")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Enter the physician's name, click on search button, the Participant should be showing in the search result");
		homePage.clickOnSearch(physicianName);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}	
	
	@Test(priority = 3, description = "OQ_003 Test case 2: TC-02.03")
	@Step("Step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(physicianName);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_003 Test case 2: TC-02.04")
	@Step("Step 4. Click Edit button,  the participant page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click Edit button,  the participant page is displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Click Edit button,  the participant page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_003 Test case 2: TC-02.05")
	@Step("step 5. Confirm the mandatory fields are displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the mandatory fields are displayed")
	public void Ts0205(Method method) {
		String[] fields = new String[] {"Salutation","First Name", "Last Name", "Communication Language", "Participant Name"};
		
		boolean result = false;
		startTest(method.getName(), "Confirm the mandatory fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 6, description = "OQ_003 Test case 2: TC-02.06")
	@Step("step 6. The Salutation values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Salutation values in the drop down list are properly displayed")
	public void Ts0206(Method method) {
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
	
		
	@Test(priority = 7, description = "OQ_003 Test case 2: TC-02.07")
	@Step("step 7. The the Communication Language values in the drop down list are properly displayed")
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
	
	@Test(priority = 8, description = "OQ_003 Test case 2: TC-02.08")
	@Step("step 8. The the  Additional Permission values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The the  Additional Permission values in the drop down list are properly displayed")
	public void Ts0208(Method method) {
		String[] fields = new String[] {"--None--", "View Patient First Name and Last Name"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The the  Additional Permission values in the drop down list are properly displayed");
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
}
