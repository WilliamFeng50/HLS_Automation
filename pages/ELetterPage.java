package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class ELetterPage extends BaseTest{
	
	private @FindBy(xpath = "//td/span/select")
	WebElement eLeterSelect;
	
	private @FindBy(xpath = "//div[text()='Recipient Type']//following::tbody[1]/tr")
	List<WebElement> recipientList;
	
	private @FindBy(xpath = "//div[text()='Recipient Type']//following::tbody[1]/tr[1]/td")
	List<WebElement> detailsList;
	
	public ELetterPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Select the eLeter: {0} ")
	public void selectELeter(String type) {
		super.selectByVisualText(eLeterSelect, type);
	}
	
	@Step("Get the information of the recipient type {0}")
	public List<String> getRecipientInformation(String type) {
		String xp = "//tr/td[text()='" + type +"']//following-sibling::td";
		List <WebElement> el = new ArrayList<WebElement>();
		
		el = driver.findElements(By.xpath(xp));
		
		List <String> details = new ArrayList<String>();
		for(int i = 0; i<3; i++) {
			String value = el.get(i).getText();
			details.add(i, value);
		}
		
		return details;
	}
	
	@Step("Get the information of the recipient")
	public Map<String, String> getRecipientInformation() {
		Map<String, String> details = new HashMap<String, String>();
		
		for (int i=0; i<recipientList.size();i++) {
			String xp = "//div[text()='Recipient Type']//following::tbody[1]/tr[" + i +"]/td";
			
		}
		
		return details;
	}
	
	
	@Step("Click on close button")
	public void clickOnSattusDropdownList() {
		elementsPg.button("Close").click();
		super.waitForSleep(2000);
	}

	@Step("Click On send button")
	public void clickOnSendBtn() {
		elementsPg.button("Send").click();
		super.waitForSleep(3000);
	}
	
		
}
