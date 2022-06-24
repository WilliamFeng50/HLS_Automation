package testcases.OQ_011;

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
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_011 Test cases")
public class OQ_011_TC02 extends BaseTest {
	ParticipantsPage participantsPage;
	String participant = " Alpha Laboratories";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_011 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Participants tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_011 Test case 2: TC-02.02")
	@Step("Step 2. Enter the Laboratory's name, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the Laboratory's name, click on search button, the Participant should be showing in the search result")
	public void Ts0202(Method method) {
		startTest(method.getName(), "Enter the Laboratory's name, click on search button, the Participant should be showing in the search result");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}	
	
	@Test(priority = 3, description = "OQ_011 Test case 2: TC-02.03")
	@Step("Step 3.In the Participants section, click on the Laboratory's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the Laboratory's name, the Participant page is displayed")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the Participants section, click on the Laboratory's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_011 Test case 2: TC-02.04")
	@Step("Step 4.Confirm that the following related lists are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following related lists are properly displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Confirm that the following related lists are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] titles = {"Patients (Laboratory)", "Scheduled Reports", "Locations", "Activity History", "Participant History"};
		titleList = participantsPage.getRelatedTitleList();
		result = titleList.equals(Arrays.asList(titles));
		Assert.assertTrue(result);
	}
	
	@Test(priority = 5, description = "OQ_011 Test case 2: TC-02.05")
	@Step("Step 5.Confirm that the following fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following fields are properly displayed")
	public void Ts0205(Method method) {
		startTest(method.getName(), "Confirm that the following fields are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] fields = {"Additional Information", "Lablink", "Laboratory Coordinates", "Laboratory Contact Information", "Legacy Fields", "System Information"};
		titleList = participantsPage.getFieldsList();
		result = titleList.equals(Arrays.asList(fields));
		Assert.assertTrue(result);
	}
}
