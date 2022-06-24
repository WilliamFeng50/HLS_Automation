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
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_015 Test Cases")
public class OQ_015_TC05 extends BaseTest {
	ParticipantsPage participantsPage;
	String llc = "ADAM LING";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_015 Test case 5: TC-05.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0501(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_015 Test case 5: TC-05.02")
	@Step("Step 2: Enter the LCC's name, click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Enter the LCC's name, click on search button, the LCC'name should be showing in the search result")
	public void Ts0502(Method method) {
		startTest(method.getName(), "Enter the LCC's name, click on search button, the LCC'name should be showing in the search result");
		homePage.clickOnSearch(llc);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}

	@Test(priority = 3, description = "OQ_015 Test case 5: TC-05.03")
	@Step("Step 3: In the list view, find the desired LCC and click the LCC's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC")
	public void Ts0503(Method method) {
		startTest(method.getName(), "In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC");
		participantsPage.clickOnParticipantsLink(llc);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_015 Test case 5: TC-05.04")
	@Step("Step 4. Click on edit button, the participant edit page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on edit button, the participant edit page is displayed")
	public void Ts0504(Method method) {
		startTest(method.getName(), "Click on edit button, the participant edit page is displayed");
		participantsPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_015 Test case 5: TC-05.05")
	@Step("Step 5. Edit the First Name and Postal Code fields, then click on Save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Edit the First Name and Postal Code fields, then click on Save button, The information is saved successfully")
	public void Ts0505(Method method) {
		startTest(method.getName(), "Edit the First Name and Postal Code fields, then click on Save button, The information is saved successfully");
		homePage.editField("First Name", "tester");
		homePage.editField("Postal Code", "H3H2R7");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 6, description = "OQ_015 Test case 5: TC-05.06")
	@Step("Step 6. Confirm the edited values are showing in correct format")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the edited values are showing in correct format")
	public void Ts0506(Method method) {
		startTest(method.getName(), "Confirm the edited values are showing in correct format");
		String firstName = homePage.getFormText("First Name");
		String postcalCode = homePage.getFormText("Postal Code");
		Assert.assertTrue(firstName.equals("TESTER") && postcalCode.equals("H3H 2R7"));
	}
	
	
}
