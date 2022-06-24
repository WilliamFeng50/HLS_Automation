package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class BloodTestEntryPage extends BaseTest {

	private @FindBy(xpath = "//lightning-button/button[@title='Add Row']") WebElement addRowBtn;

	private @FindBy(id = "searchInputId") WebElement patientTxt;

	private @FindBy(id = "searchButtonId") WebElement searchBtn;

	private @FindBy(xpath = "//tr[1]/td/select/option") List<WebElement> typeListItems;

	private @FindBy(xpath = "//tr[1]/td/select") WebElement typeList;
	

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[2]/input") WebElement csanTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[11]/input") WebElement testDateTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[12]/input") WebElement wbcTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[13]/input") WebElement ancTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[14]/input") WebElement ancPercentTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[15]/input") WebElement grcTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[16]/input") WebElement grcPercentTxt;

	private @FindBy(xpath = "//th/div[text()='CSAN Number']//following::td[17]/textarea") WebElement testCommentTxt;

	private @FindBy(xpath = "//td/input[@class='btn' and @value=' + ']") WebElement addRowIcon;

	private @FindBy(xpath = "//td/input[@class='btn' and @value='Remove']") WebElement removeBtn;

	public BloodTestEntryPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Click on add icon ")
	public void clickOnAddIcon() {
			addRowIcon.click();
			super.waitForSleep(2000);
	}

	public boolean addIconIsDisplayed() {
		return addRowIcon.isDisplayed();
	
	}
	
	public boolean csanRowIsDisplayed() {
		return csanTxt.isDisplayed();
	}
	
	
	
	@Step("Click On Add Row button")
	public void clickOnAddRowBtn() {
		super.moveToElement(searchBtn);
		elementsPg.button("Add Row").click();
		super.waitForSleep(1000);
	}

	@Step("Input the Patient number {0},  search the patient in the list")
	public void search(String patient) {
		super.sendKeys(patientTxt, patient);
		patientTxt.sendKeys(Keys.RETURN);
		super.waitForSleep(3000);
	}

	@Step("Click On the patient in the table list")
	public void clickOnItem(String patient) {
		// super.moveToElement(elementsPg.searchListItem(patient));
		// elementsPg.searchListItem(patient).click();
		super.waitForSleep(3000);
	}

	@Step("Input the test data {0} {1} {2} {3} {4} {5} {6}")
	public void newTestResult(String csan, String type, String testDate, String wbc, String anc, String ancP, String grc, String grcP, String comments) {
		boolean breakIt = true;
        while (true) {
	        breakIt = true;
	        try {
	        	if (csan.length() > 0) csanTxt.sendKeys(csan);
	
	    		if (type.length() > 0) selectType(type);
	    		
	    		testDateTxt.sendKeys(testDate);
	    		super.waitForSleep(2000);
	
	    		super.sendKeys(wbcTxt, wbc);
	    		super.waitForSleep(2000);
	    		
	    		if(anc.length()>0) super.sendKeys(ancTxt, anc);
	    			super.waitForSleep(2000);
	    		if(ancP.length()>0) super.sendKeys(ancPercentTxt, anc);
	    			super.waitForSleep(2000);
	    		if(grc.length()>0) super.sendKeys(grcTxt, grc);
	    			super.waitForSleep(2000);
	    		if(grcP.length()>0) super.sendKeys(grcPercentTxt, grc);
	    			super.waitForSleep(2000);
	    		
	    		super.sendKeys(testCommentTxt,comments);
	    		super.waitForSleep(2000);
	        } catch (StaleElementReferenceException e) {
	            breakIt = false;
	        }
	        if (breakIt) {
	            break;
	        }
        }
	}
	
	@Step("Click on Type button, select type {0} form the type list")
	public void selectType(String type) {
		typeList.click();
		super.waitForSleep(1000);
		String xp = "//tr[1]/td/select/option[text()='" + type + "']";
		driver.findElement(By.xpath(xp)).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Save button")
	public void clickOnSaveBtn() {
		elementsPg.button("Save").click();
		super.waitForSleep(2000);
	}

	@Step("Get the ANC % value")
	public String getANCPercentValue() {
		return ancPercentTxt.getText();
	}

	@Step("Get the GRC % value")
	public String getGRCPercentValue() {
		return grcPercentTxt.getText();
	}

	@Step("Confirm that the row disappears from the blood test entry table")
	public boolean checkTheRow() {
		boolean result = false;
		try {
			typeList.click();
		} catch (NoSuchElementException e) {
			result = true;
		}
		return result;
	}

	@Step("Verify the background color of wbc {0}, anc {1}, grc {2}")
	public boolean verifyBackgroundColor(String wbc, String anc, String grc) {
		boolean result = false;
		if (wbc.length() > 0)
			wbc = wbcTxt.getCssValue("background-color");

		if (Color.fromString(wbc).asHex().equals("#87ceeb"))
			result = true;
		
		if (anc.length() > 0)
			anc = ancTxt.getCssValue("background-color");

		if (Color.fromString(anc).asHex().equals("#87ceeb"))
			result = true;

		if (grc.length() > 0)
			grc = grcTxt.getCssValue("background-color");

		if (Color.fromString(grc).asHex().equals("#87ceeb"))
			result = true;
		return result;
	}
}
