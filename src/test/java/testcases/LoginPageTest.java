package testcases;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import utils.listeners.TestListener;
import pages.LoginPage;
import testLibs.BaseTest;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	@Step("step 1. setup browser and lunch URL")	
	@BeforeMethod
	public void beforeMethod() {
		super.setUpBrowser();
		super.launchApplication();
		loginPage = new LoginPage();
		
	}

	@Test(priority = 1, description="valid Login Scenario with correct username and password.")
	@Step("step 2. Test login funcation")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with correct username and correct password.")
    @Story("Valid username and password login test")
	public void loginSucceedTest(Method method) {
		startTest(method.getName(), "Login Page: Valid Login Scenario with correct username and password.");
		
		loginPage.inputUserNamePassword(userName, passWord);
		loginPage.clickLogin();
		Reporter.log("Checking Login succeed with correct userName and password",true);
		Assert.assertTrue(super.isTextShowing("Announcements"));
	}

	@Test(priority = 2, description="Invalid Login Scenario with wrong username and password.")
	@Step("step 3. Test login funcation with wrong username and password")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and password.")
    @Story("Invalid username and password login test")
	public void loginValidationTest(Method method) {
		startTest(method.getName(), "Login Page: Invalid Login Scenario with wrong username and password.");
		loginPage.inputUserNamePassword("00360", "Test!1");
		loginPage.clickLogin();
		Reporter.log("Checking Login sucessed with correct userName and password",true);
		Assert.assertTrue(super.isTextShowing("Invalid username or password!"));
	}
	
	@AfterMethod
	public void afterMethod() {
		super.tearDown();
	}
	
}

