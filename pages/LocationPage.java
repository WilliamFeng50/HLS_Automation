package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class LocationPage extends BaseTest{
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='edit']")
	WebElement editBtn;
	
	private @FindBy(xpath = "//label[text()='Participant']//following::span/input")
	WebElement participantTxt;
	
	private @FindBy(xpath = "//label[text()='Participant']//following::span/a")
	WebElement participantBtn;
		
	private @FindBy(xpath = "//label[text()='Location']//following::span[1]/input")
	WebElement locationTxt;
	
	private @FindBy(xpath = "//label[text()='Location']//following::span[1]/a")
	WebElement locationBtn;
	
	public LocationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click On the New button")
	public void clickOnNewButton() {
		elementsPg.button("New").click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On edit button")
	public void clickOnEditButton() {
		elementsPg.button("Edit").click();
		super.waitForSleep(2000);
	}
	
	@Step("Edit the location information: Location Name {0}, Paticipant {1}")
	public void information(String location, String participant, String search) {
		if (location.length()>0) super.sendKeys(elementsPg.inputField("Location Name"), location);
		if (participant.length()>0) super.sendKeys(elementsPg.inputField("Patricipant"), participant);
		if (search.length()>0) elementsPg.inputField("Remove from Searches").click();
	}
	
	@Step("Edit the location communication preferences: Communication Notes {0}")
	public void communationPreferences(String note) {
		super.sendKeys(elementsPg.inputField("Communication Notes"), note);
	}
	
	@Step("Edit the location information: Phone {0}, Fax {3}")
	public void phoneFaxInformation(String phone, String pager, String phone2, String fax) {
		if (phone.length()>0) super.sendKeys(elementsPg.inputField("Phone"), phone);
		if (pager.length()>0) super.sendKeys(elementsPg.inputField("Pager"), pager);
		if (phone2.length()>0) super.sendKeys(elementsPg.inputField("Secondary Phone"), phone2);
		if (fax.length()>0) super.sendKeys(elementsPg.inputField("Fax"), fax);
		
	}
	
	@Step("Edit the location information: Address {0}, City {3}, Province {4}, Postal Code {5}")
	public void addressInformation(String address1, String address2, String address3, String city, String province, String postalCode) {
		if (address1.length()>0) super.sendKeys(elementsPg.inputField("Address 1"), address1);
		if (address2.length()>0) super.sendKeys(elementsPg.inputField("Address 2"), address2);
		if (address3.length()>0) super.sendKeys(elementsPg.inputField("Address 3"), address3);
		if (city.length()>0) super.sendKeys(elementsPg.inputField("City"), city);
		
		if(province.length()>0) {
			elementsPg.dropDownBtn("Province").click();
			elementsPg.dropDownListItem(province).click();
		}
		if (postalCode.length()>0) super.sendKeys(elementsPg.inputField("Postal Code"), postalCode);
	}
	
	@Step("Get the default participant")
	public String getParticipant() {
		return participantTxt.getAttribute("value");
	}
	
	public void clicOnLocatioLookupButton() {
		locationBtn.click();
		super.waitForSleep(2000);
		super.switchToSubWindow();
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
