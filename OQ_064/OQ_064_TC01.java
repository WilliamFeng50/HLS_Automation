package testcases.OQ_064;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
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
import pages.LookupPage;
import pages.ManagePortalUserPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_064 Test cases")
public class OQ_064_TC01 extends BaseTest {
	String institution = "ABERDEEN HOSPITAL";
	String owner = "Marie-France Sabourin";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		lookupPage = new LookupPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 1: TC-01.02")
	@Step("Step 2. In the top of search field, input the institution's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the institution's name, and click on search button, the search result list is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "In the search field, input the institution's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(institution);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the institution's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the institution's name, the Participant page is displayed")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the Participants section, click on the institution's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(institution);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_064 Test case 1: TC-01.04")
	@Step("Step 4. Click on the Manage Portal User button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the Manage Portal User button, the Manage Portal User page is displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Click on the Manage Portal User button, the Manage Portal User page is displayed");
		participantsPage.clickOnChangeOwnerButton();
		Assert.assertTrue(super.isTextShowing("Select New Owner"));		
	}
	
	@Test(priority = 5, description = "OQ_064 Test case 1: TC-01.05")
	@Step("Step 5. Click on the lookup button next to the Owner field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the lookup button next to the Owner field, confirm the lookup page appears")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Click on the lookup button next to the Owner field, confirm the lookup page appears");
		participantsPage.lookupOwner();
		Assert.assertTrue(super.isTextShowing("Lookup"));		
	}
	
	@Test(priority = 6, description = "OQ_064 Test case 1: TC-01.06")
	@Step("Step 6. In the search field, enter the owner and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the search field, enter the owner and click the Go! button")
	public void Ts0406(Method method) {
		startTest(method.getName(), "In the search field, enter the owner and click the Go! button");
		lookupPage.lookup(owner);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}
	
	@Test(priority = 7, description = "OQ_064 Test case 1: TC-01.07")
	@Step("Step 7. In the results list, click the owner to select it")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the results list, click the owner to select it, back to location edit page")
	public void Ts0407(Method method) {
		startTest(method.getName(), "In the results list, click the owner to select it, back to location edit page");
		lookupPage.selectResultName(owner);
		Assert.assertTrue(super.isTextShowing("Select New Owner"));
	}

	@Test(priority = 8, description = "OQ_064 Test case 1: TC-01.08")
	@Step("Step 8. Click on save button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on save button, the participant page is displayed for the selected participant")
	public void Ts0408(Method method) {
		startTest(method.getName(), "Click on save button, the participant page is displayed for the selected participant");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
}

