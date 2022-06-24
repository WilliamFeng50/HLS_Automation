package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class ManagePortalUserPage extends BaseTest{
	private @FindBy(xpath = "//p/strong")
	WebElement tempPassTxt;
	
	private @FindBy(xpath = "//h2[text()='Portal User']//following::tbody[1]/tr[1]/td[1]")
	WebElement tempUserTxt;
	
	private @FindBy(xpath = "//th/label")
	List<WebElement> portalUserInformationList;
	
	public ManagePortalUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Enter the user name {0} to create the portal user")
	public void createPortalUser(String username) {
		super.sendKeys(elementsPg.inputField("Username"), username);
		elementsPg.button("Create User").click();
		super.waitForSleep(2000);
	}
	
	@Step("Get the temporary password {0}")
	public String getPassword() {
		return tempPassTxt.getText();
	}
	
	@Step("Get the username {0}")
	public String getUserName() {
		return tempUserTxt.getText();
	}
	
	@Step("Click on the Deactivate User button")
	public void clickOnDeactivateUserButton() {
		elementsPg.button("Deactivate User").click();
		super.waitForSleep(1000);
	}
	
	@Step("Click on the Reset Password button")
	public void clickOnRestPasswordButton() {
		elementsPg.button("Reset Password").click();
		super.waitForSleep(1000);
	}
	
	@Step("Click on the Change Username button")
	public void clickOnChangeUsernameButton() {
		elementsPg.button("Change Username").click();
		super.waitForSleep(1000);
	}
	
	@Step("Click on the Reactivate User button")
	public void clickOnReactivateUserButton() {
		elementsPg.button("Reactivate User").click();
		super.waitForSleep(1000);
	}
	
	@Step("Get the Portal User information")
	public Map<String, String> getPortalUserInformation(String[] fields) {
		Map<String, String> details = new HashMap<String, String>();
		String value;
		for(String key : fields) {
			value = elementsPg.editText(key).getText();
			details.put(key, value);
		}
		return details;
	}
	
}
