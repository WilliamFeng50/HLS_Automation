package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class HomePage extends BaseTest{
	
	private @FindBy(id = "i0116")
	WebElement emailTxt;
	
	private @FindBy(id = "idSIButton9")
	WebElement nextBtn;
	
	private @FindBy(id = "i0118")
	WebElement passwordTxt;
	
	private @FindBy(id = "idSIButton9")
	WebElement signBtn;
	
	private @FindBy(id="idTxtBx_SAOTCC_OTC")
	WebElement codeTxt;
	
	private @FindBy(id = "idSubmit_SAOTCC_Continue")
	WebElement verifyBtn;
	
	private @FindBy(xpath = "//*[@id=\"idDiv_SAOTCS_Proofs\"]/div/div")
	WebElement cellCodeBtn;
	
	private @FindBy(xpath = "//div/one-app-nav-bar-item-root[1]")
	WebElement homeBtn;
	
	private @FindBy(xpath = "//div/one-app-nav-bar-item-root[2]")
	WebElement patientsBtn;
	
	private @FindBy(xpath = "//div/one-app-nav-bar-item-root[3]")
	WebElement participantsBtn;
	
	private @FindBy(xpath = "//div/one-app-nav-bar-item-root[8]")
	WebElement faxDocBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeTab() {
		homeBtn.click();
		super.waitForSleep(3000);
	}
	
	
	public void clickPatientTab() {
		patientsBtn.click();
		super.waitForSleep(3000);
	}
	
	public void clickParticipantsTab() {
		participantsBtn.click();
		super.waitForSleep(3000);
	}
	
	public void clickFaxDocumentTab() {
		faxDocBtn.click();
		super.waitForSleep(3000);
	}
	
	public void login(String userName, String password) {
		super.waitForSleep(2000);
		emailTxt.sendKeys(userName);
		super.waitForSleep(2000);
		nextBtn.click();
		
		super.waitForSleep(2000);
		passwordTxt.sendKeys(password);
		signBtn.click();
		super.waitForSleep(2000);
		
		cellCodeBtn.click();
		super.waitForSleep(15000);
		
		verifyBtn.click();
		signBtn.click();
		super.waitForSleep(5000);
		
	}
	
	
}
