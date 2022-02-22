package testLibs;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;

public class Utility extends BaseTest {

	public boolean login(final String userName, final String password) {

		String pageTitle;
		String message;

		elementsPg.inputField("UserNameOrEmailAddress").sendKeys(userName);
		elementsPg.inputField("Password").sendKeys(password);
		elementsPg.button("Login").click();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		try {
			pageTitle = driver.getTitle();

			if (pageTitle.equals("EfOnline Portal") && elementsPg.headerTitle("header").getText().equals(userName)) {

				Reporter.log("User: " + userName + " logged in successfully", true);
				return true;
			}

		} catch (Exception e) {

			if (userName.isEmpty() || password.isEmpty() || userName == null || password == null) {
				message = elementsPg.errorMessage("error").getText();
				Reporter.log("Unable to login due to: " + message, true);
				org.testng.Assert.fail("Unable to login due to Error: " + message);
				return false;
			} else {
				message = elementsPg.popUpMessage("alert").getText().trim();
				Reporter.log("Unable to login due to: " + message, true);
				org.testng.Assert.fail("Unable to login due to Error: " + message);
				return false;
			}

		}
		return false;

	}

}
