package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class AlertPage extends BaseTest{
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
		
	private @FindBy(xpath = "//input[@value='New Alert']")
	WebElement newAlertBtn;
	
	private @FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[3]")
	WebElement editBtn;
	
	private @FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[4]")
	WebElement eLetterBtn;
	
	public AlertPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click On the New button")
	public void clickOnNewButton() {
		elementsPg.button("New").click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On edit button")
	public void clickOnEditButton() {
		editBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On edit button")
	public void clickOnELetterButton() {
		eLetterBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Record Type of new record drop down list, and select {0}")
	public void selectAlertType(String type) {
		elementsPg.dropDownBtn("Record Type of new record").click();
		elementsPg.dropDownListItem(type).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on View drop down list, and select {0}")
	public void selectViewDropDownItem(String item) {
		elementsPg.dropDownBtn("View:").click();
		elementsPg.dropDownListItem(item).click();
		
	}
	
	@Step("Click on Alert Status drop down list, and select {0}")
	public void selectStatus(String status) {
		elementsPg.dropDownBtn("Alert Status").click();
		elementsPg.dropDownListItem(status).click();
	}
	
	@Step("Click On continue button")
	public void clickOnContinueButton() {
		elementsPg.button("Continue").click();
		super.waitForSleep(2000);
	}
	
	@Step("Edit the alert information: Patient {0}, Alert Status {1}, Reason for Override {2}")
	public void alertEdit(String patient, String status, String reason) {
		if (patient.length()>0) super.sendKeys(elementsPg.inputField("Patient"), patient);
		if(status.length()>0) {
			elementsPg.dropDownBtn("Alert Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		if(reason.length()>0) {
			elementsPg.dropDownBtn("Reason for Override").click();
			elementsPg.dropDownListItem(reason).click();
		}
	}
	
	@Step("Click on the Alert number {0} in the alerts list")
	public void clickViewAlertNumber(String number) {
		super.moveToElement(elementsPg.viewResultLink(number));
		elementsPg.viewResultLink(number).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Alert number {0} in the alerts list")
	public void clickSearchAlertNumber(String number) {
		super.moveToElement(elementsPg.searchListItemLink(number));
		elementsPg.viewResultLink(number).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on save button")
	public void clickOnSaveButton() {
		super.moveToElement(saveBtn);
		saveBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on cancel button")
	public void clickOnCancelButton() {
		super.moveToElement(cancelBtn);
		cancelBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on save&new button")
	public void clickOnSaveAndNewButton() {
		super.moveToElement(saveAndNewBtn);
		cancelBtn.click();
		super.waitForSleep(2000);
	}
	
}
