package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class ParticipantsPage extends BaseTest{
	
	private @FindBy(xpath = "//input[@title='New']")
	WebElement newBtn;
	
	private @FindBy(id = "p3")
	WebElement recordTypeListBtn;

	private @FindBy(id="acc2")
	WebElement participantNameTxt;
		
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[2]")
	WebElement saveNewBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[3]")
	WebElement cancelBtn;
		
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@title='Edit']")
	WebElement editBtn;
	
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@title='Manage Portal User']")
	WebElement managePortalUserBtn;
	
	private @FindBy(xpath = "//*[@id='Account_body']/table/tbody/tr[2]/th/a")
	WebElement participant1Link;
	
	private @FindBy(xpath = "//*[@id='Account_body']/table/tbody/tr[2]/th/a")
	WebElement firstPatientLink;
	
	private @FindBy(xpath = "//tr[2]/td/a[text()='Del']")
	WebElement firstDelBtn;
	
	private @FindBy(xpath = "//td[text()='Participant Owner']//following::a[text()='[Change]']")
	WebElement changeOwnerBtn;
	
	private @FindBy(id="newOwn")
	WebElement ownerTxt;
	
	private @FindBy(id="newOwn_lkwgt")
	WebElement ownerLookupBtn;
	
	private @FindBy(id="transOpenOpps")
	WebElement transOpenOppsChk;
	
	private @FindBy(id="transClosedOpps")
	WebElement transCloseOppsChk;
	
	private @FindBy(id="transOwnedCases")
	WebElement transOwendCaseChk;
	
	private @FindBy(id="transClosedCase")
	WebElement transCloseCaseChk;
	
	private @FindBy(id="sendMail")
	WebElement sendEmailChk;
	
	private @FindBy(xpath = "//td[text()='Participant Owner']//following::a[1]")
	WebElement changeRecordTypeBtn;
	
	private @FindBy(xpath = "//td/h3")
	List<WebElement> relatedListsTitle;
	
	private @FindBy(xpath = "//div/h3")
	List<WebElement> fildsList;
	

	public ParticipantsPage() {
		PageFactory.initElements(driver, this);
	}
			
	@Step("Click on New Button")
	public void clickOnNewBtn() {
		newBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Select record type for new record")
	public void selectRecordType(String type) {
		recordTypeListBtn.click();
		elementsPg.dropDownListItem(type).click();
	}
	
	@Step("Click on Continue Button")
	public void clickOnContinueBtn() {
		elementsPg.button("Continue").click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Edit Button")
	public void clickOnEditBtn() {
		editBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Manage Portal User Button")
	public void clickOnManagePortalUserButton() {
		managePortalUserBtn.click();
		super.waitForSleep(2000);
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
	
	@Step("Click on the participants name {0} in the search results list")
	public void clickOnParticipantsLink(String name) {
		participant1Link.click();
		super.waitForSleep(2000);
	}
	
	@Step("Get the related titles list")
	public List<String> getRelatedTitleList() {
		List<String> listTitle = new ArrayList<String>();
		for(int i=0;i<relatedListsTitle.size();i++) {
			listTitle.add(relatedListsTitle.get(i).getText());
		}
		return listTitle;
	}
	
	@Step("Get the fields list ")
	public List<String> getFieldsList() {
		List<String> listTitle = new ArrayList<String>();
		for(int i=0;i<fildsList.size();i++) {
			listTitle.add(fildsList.get(i).getText());
		}
		return listTitle;
	}
	
	@Step("Get the Participant Record Type")
	public String getRecordType() {
		return elementsPg.editText("Participant Record Type").getText();
	}
	
	@Step("Get the the first patient number in the patients section")
	public String getFirstPatient() {
		return firstPatientLink.getText();
	}
	
	@Step("Click on the Del button")
	public void clickOnDelButton() {
		firstDelBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on New Additional Location Access button")
	public void clickOnNewAdditionalLocationAccessButton() {
		elementsPg.button("New Additional Location Access").click();
		super.waitForSleep(2000);
	}

	@Step("Click on change owner button")
	public void clickOnChangeOwnerButton() {
		changeOwnerBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on change record type button")
	public void clickOnChangeRecordTypeButton() {
		changeRecordTypeBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Select the new owner type {0}")
	public void selectOwnerType(String type) {
		elementsPg.dropDownBtn("Owner").click();
		elementsPg.dropDownListItem(type).click();
	}
	
	@Step("Input the new owner {0}")
	public void inputOwner(String owner) {
		super.sendKeys(ownerTxt, owner);
	}
	
	@Step("Click on lookup button adding a new owner")
	public void lookupOwner() {
		ownerLookupBtn.click();
		System.out.println(parentWindowHandler);
		super.waitForSleep(2000);
		super.switchToSubWindow();
		super.waitForSleep(2000);
	}
	
	public void selectOwnerOptions(String transOpen, String transClose, String caseOwend, String closeCase, String sendEmail) {
		if(transOpen.equalsIgnoreCase("Yes")) transOpenOppsChk.click();
		if(transClose.equalsIgnoreCase("Yes")) transCloseOppsChk.click();
		if(caseOwend.equalsIgnoreCase("Yes")) transOwendCaseChk.click();
		if(closeCase.equalsIgnoreCase("Yes")) transCloseCaseChk.click();
		if(sendEmail.equalsIgnoreCase("Yes")) sendEmailChk.click();
	}
	
	
}
