package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class EditParticipantsPage extends BaseTest{
	private @FindBy(id="acc2")
	WebElement participantNameTxt;
		
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[2]")
	WebElement saveNewBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[3]")
	WebElement cancelBtn;
		
	public EditParticipantsPage() {
		PageFactory.initElements(driver, this);
	}
			
	
	@Step("Input the new LCC participant information")
	public void newLCC(String salutation, String firstName, String lastName,  String language, String method, String phone, String fax, String participantName) {
		elementsPg.dropDownBtn("Salutation").click();
		elementsPg.dropDownListItem(salutation).click();
		
		super.sendKeys(elementsPg.inputField("First Name"), firstName);
		super.sendKeys(elementsPg.inputField("Last Name"), lastName);
		
		homePage.moveToSectionEdit("LCC Coordinates");
		elementsPg.dropDownBtn("Communication Language").click();
		elementsPg.dropDownListItem(language).click();
		elementsPg.dropDownBtn("Preferred method of communication").click();
		elementsPg.dropDownListItem(method).click();
		
		super.sendKeys(elementsPg.inputField("Phone"), phone);
		super.sendKeys(elementsPg.inputField("Fax"), fax);
		
		homePage.moveToSectionEdit("System Information");
		super.sendKeys(participantNameTxt, participantName);
	}
	
	@Step("input new Physician information")
	public void newPhysician(String salutation, String firstName, String lastName, String language, String participantName) {
		super.moveToElement(elementsPg.dropDownBtn("Salutation"));
		elementsPg.dropDownBtn("Salutation").click();
		elementsPg.dropDownListItem(salutation).click();
		
		super.sendKeys(elementsPg.inputField("First Name"), firstName);
		super.sendKeys(elementsPg.inputField("Last Name"), lastName);
		
		super.moveToElement(elementsPg.dropDownBtn("Communication Language"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Communication Language").click();
		elementsPg.dropDownListItem(language).click();
			
		super.moveToElement(participantNameTxt);
		super.waitForSleep(2000);
		super.sendKeys(participantNameTxt, participantName);
	}
	
	@Step("input new Institution information")
	public void newInstitution(String name, String phone, String fax, String territory, String language, String address, String city, String province, String postal) {
		super.sendKeys(elementsPg.inputField("Name"), name);
		super.sendKeys(elementsPg.inputField("Phone"), phone);
		super.sendKeys(elementsPg.inputField("Fax"), fax);
		
		elementsPg.dropDownBtn("Territory").click();
		elementsPg.dropDownListItem(territory).click();
		elementsPg.dropDownBtn("Communication Language").click();
		elementsPg.dropDownListItem(language).click();
		
		homePage.moveToSectionEdit("Institution Coordinates");
		super.sendKeys(elementsPg.inputField("Address 1"), address);
		super.sendKeys(elementsPg.inputField("City"), city);
		elementsPg.dropDownBtn("Province").click();
		elementsPg.dropDownListItem(province).click();
		super.sendKeys(elementsPg.inputField("Postal Code"), postal);
		
		super.sendKeys(participantNameTxt, name);
	}
	
	@Step("input new Pharmacy information")
	public void newPharmacy(String name, String license, String type, String address, String city, String province, String postal, String language, String method, String phone, String fax,  String salutation, String firstName, String lastName) {
		super.sendKeys(elementsPg.inputField("Name"), name);
		super.sendKeys(elementsPg.inputField("Pharmacy License #"), license);
		elementsPg.dropDownBtn("Pharmacy Type").click();
		elementsPg.dropDownListItem(type).click();
		
		homePage.moveToSectionEdit("Pharmacy Coordinates");
		super.sendKeys(elementsPg.inputField("Address 1"), address);
		super.sendKeys(elementsPg.inputField("City"), city);
		elementsPg.dropDownBtn("Province").click();
		elementsPg.dropDownListItem(province).click();
		super.sendKeys(elementsPg.inputField("Postal Code"), postal);
	
		elementsPg.dropDownBtn("Communication Language").click();
		elementsPg.dropDownListItem(language).click();
		elementsPg.dropDownBtn("Preferred method of communication").click();
		elementsPg.dropDownListItem(method).click();
		
		super.sendKeys(elementsPg.inputField("Phone"), phone);
		super.sendKeys(elementsPg.inputField("Fax"), fax);
		
		homePage.moveToSectionEdit("Pharmacy Contact Information");
		elementsPg.dropDownBtn("Salutation").click();
		elementsPg.dropDownListItem(salutation).click();
		super.sendKeys(elementsPg.inputField("First Name"), firstName);
		super.sendKeys(elementsPg.inputField("Last Name"), lastName);
		super.sendKeys(participantNameTxt, name);
	}
	
	@Step("input new Laboratory information")
	public void newLaboratory(String name, String address, String language, String method, String phone, String fax,  String salutation, String firstName, String lastName) {
		super.sendKeys(elementsPg.inputField("Name"), name);
				
		homePage.moveToSectionEdit("Laboratory Coordinates");
		super.sendKeys(elementsPg.inputField("Address 1"), address);
		elementsPg.dropDownBtn("Communication Language").click();
		elementsPg.dropDownListItem(language).click();
		elementsPg.dropDownBtn("Preferred method of communication").click();
		elementsPg.dropDownListItem(method).click();
		
		super.sendKeys(elementsPg.inputField("Phone"), phone);
		super.sendKeys(elementsPg.inputField("Fax"), fax);
		
		homePage.moveToSectionEdit("Laboratory Contact Information");
		elementsPg.dropDownBtn("Salutation").click();
		elementsPg.dropDownListItem(salutation).click();
		super.sendKeys(elementsPg.inputField("First Name"), firstName);
		super.sendKeys(elementsPg.inputField("Last Name"), lastName);
		super.sendKeys(participantNameTxt, name);
	}
	
	@Step("Edit the participant information")
	public void editParticipant(String cellPhone, String service) {
		super.moveToElement(elementsPg.inputField("Cell Phone for SMS"));
		 
		super.sendKeys(elementsPg.inputField("Cell Phone for SMS"), cellPhone);
		
		super.moveToElement(elementsPg.dropDownBtn("Service Provider"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Service Provider").click();
		elementsPg.dropDownListItem(service).click();
		
		elementsPg.checkBox("Preferred Communication SMS").click();
	}
	
	@Step("Check on the Preferred Email ")
	public void checkPreferredEmail() {
		super.moveToElement(elementsPg.checkBox("Preferred Communication Email"));
		elementsPg.checkBox("Preferred Communication Fax").click();
	}
	
	@Step("Input the Alert Email")
	public void inputAlertEmail(String email) {
		super.moveToElement(elementsPg.inputField("Email for Alerts"));
		super.sendKeys(elementsPg.inputField("Email for Alerts"), email);
		
	}
	
	@Step("Click on the Salutation dropdown list")
	public void clickOnSalutationBtn() {
		super.moveToElement(elementsPg.dropDownBtn("Salutation"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Salutation").click();
	}
	
	@Step("Click on the Communication Language dropdown list")
	public void clickOnLanguageBtn() {
		super.moveToElement(elementsPg.dropDownBtn("Communication Language"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Communication Language").click();
	}
	
	@Step("Click on the Service Provider dropdown list")
	public void clickOnService() {
		super.moveToElement(elementsPg.dropDownBtn("Service Provider"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Service Provider").click();
	}
	
	@Step("Click on the Privonce dropdown list")
	public void clickOnProvince() {
		super.moveToElement(elementsPg.dropDownBtn("Province"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Province").click();
	}
	
	@Step("Click on the Preferred Communication Method dropdown list")
	public void clickOnMethod() {
		super.moveToElement(elementsPg.dropDownBtn("Preferred method of communication"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Preferred method of communication").click();
	}
	
	@Step("Click on the Additional Permission dropdown list")
	public void clickOnPermission() {
		super.moveToElement(elementsPg.dropDownBtn("Additional Permission"));
		super.waitForSleep(2000);
		elementsPg.dropDownBtn("Additional Permission").click();
	}
				
	@Step("Get the Participant Record Type")
	public String getRecordType() {
		return elementsPg.editText("Participant Record Type").getText();
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
		super.moveToElement(saveNewBtn);
		saveNewBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Edit the field {0} with the values {1}")
	public void editParticipantField(String label, String name) {
		super.sendKeys(elementsPg.inputField(label), name);
	}
}
