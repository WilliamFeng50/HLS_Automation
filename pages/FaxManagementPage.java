package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class FaxManagementPage extends BaseTest{
	
	private @FindBy(id="pagelength")
	WebElement totalPagesTxt;
	
	private @FindBy(xpath = "//button[contains(text(),'New Patient')]")
	WebElement newPatientBtn;

	private @FindBy(xpath = "//button[contains(text(),'Incoming NRDB')]")
	WebElement incomingNRDBBtn;
	
	private @FindBy(xpath = "//iframe")
	WebElement iframe;
	
	
	public FaxManagementPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewPatient() {
		newPatientBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickIncomingNRDB() {
		incomingNRDBBtn.click();
		super.waitForSleep(2000);
	}
	
	public boolean getPages() {
		try {
		//	driver.switchTo().frame(iframe);
		//	super.waitForSleep(6000);
			System.out.println(totalPagesTxt.getText());
			return true;
		}catch(NoSuchElementException e) {
			return false;
		//}finally {
		//	driver.switchTo().parentFrame();
		}
	}
	
}
