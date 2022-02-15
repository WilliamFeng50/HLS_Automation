package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class ParticipantsPage extends BaseTest{
	
	private @FindBy(xpath = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a")
	WebElement newBtn;
	
	private @FindBy(xpath = "//div/div/div[2]/div/button[2]")
	WebElement nextBtn;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-154\"]")
	WebElement salutationBtn;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-154-2-154\"]")
	WebElement msBtn;
	
	private @FindBy(xpath = "//*[@id=\"input-161\"]")
	WebElement firstNameTxt;
	
	private @FindBy(xpath = "//*[@id=\"input-167\"]")
	WebElement lastNameTxt;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-276\"]")
	WebElement languageBtn;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-276-1-276\"]")
	WebElement englishBtn;
	
	private @FindBy(xpath = "//*[@id=\"input-296\"]")
	WebElement phoneTxt;
	
	private @FindBy(xpath = "//*[@id=\"input-315\"]")
	WebElement faxTxt;
	
	private @FindBy(xpath = "//*[@id=\"input-354\"]")
	WebElement participantNameTxt;
	
	private @FindBy(xpath = "//button[@name = 'SaveEdit']")
	WebElement saveBtn;
	
	public ParticipantsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewBtn() {
		newBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnNextBtn() {
		nextBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
		super.waitForSleep(3000);
	}
	
	public void newLCCParticipant(String firstName, String lastName, String phone, String fax, String participantName) {
		salutationBtn.click();
		msBtn.click();
		
		super.sendKeys(firstNameTxt, firstName);
		super.sendKeys(lastNameTxt, lastName);
		super.moveToElement(languageBtn);
		super.waitForSleep(2000);
		languageBtn.click();
		englishBtn.click();
		
		super.sendKeys(phoneTxt, phone);
		super.sendKeys(faxTxt, fax);
		super.moveToElement(participantNameTxt);
		super.waitForSleep(2000);
		super.sendKeys(participantNameTxt, participantName);
	}
	
	
	
}
