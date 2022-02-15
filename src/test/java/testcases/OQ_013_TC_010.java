package testcases;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.FaxDocumentPage;
import pages.FaxManagementPage;
import pages.HomePage;
import pages.NewNRDBPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;

public class OQ_013_TC_010 extends BaseTest {
	ParticipantsPage participantsPage;

	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_013 Test case 1: TC-010.01")
	@Step("step 1. click on Participants tab, the Participants page is opened")
	@Severity(SeverityLevel.BLOCKER)
	@Description("click on Participants tab, the Participants page is opened")
	public void Ts0101(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is opened");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Participant Name"));

	}

	@Test(priority = 2, description = "OQ_013 Test case 1: TC-010.02")
	@Step("step 2. click on New button, add a new participants")
	@Severity(SeverityLevel.BLOCKER)
	@Description("click on New button,new participant is opened")
	public void Ts0102(Method method) {
		startTest(method.getName(), "click on New button,new participant is opened");
		participantsPage.clickOnNewBtn();
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_013 Test case 1: TC-010.03")
	@Step("step 3. select LCC, then click next button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("select record type as LCC, click on next, New Participant: LCC window is opened")
	public void Ts0103(Method method) {
		startTest(method.getName(), "select record type as LCC, click on next, New Participant: LCC window is opened");
		participantsPage.clickOnNextBtn();
		Assert.assertTrue(super.isTextShowing("New Participant: LCC"));
	}

	@Test(priority = 4, description = "OQ_013 Test case 1: TC-010.11")
	@Step("step 4. input participant information as request")
	@Severity(SeverityLevel.BLOCKER)
	@Description("input participant information as request, click save button, The information presented reflects the information entered ")
	public void Ts0104(Method method) {
		startTest(method.getName(), "nput participant information as request, click save button, The information presented reflects the information entered");
		participantsPage.newLCCParticipant("Karim", "Benin", "5141119090", "5141114000","Karim Benin");
		participantsPage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Legacy EC Username"));
	}
}
