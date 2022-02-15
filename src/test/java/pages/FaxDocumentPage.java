package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class FaxDocumentPage extends BaseTest{
	private @FindBy(xpath = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/button")
	WebElement dropDownListBtn;
	
	private @FindBy(xpath = "//div[1]/div/ul/li/a/span[contains(text(),'NRDB Request')]")
	WebElement nrdbRequestList;
	
	private @FindBy(xpath = "//div/table/tbody/tr/td[4]")
	List <WebElement> documentList;
	
	private @FindBy(xpath = "//div/table/tbody/tr[1]/td[3]")
	WebElement viewBtn;
	
	
	public FaxDocumentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickDropDownBtn() {
		dropDownListBtn.click();
	}
	
	public void select09NRDBRequest() {
		nrdbRequestList.click();
	}
	
	public boolean verifyDocumentList(String category) {
		String element = null;
		boolean result = false;
		int k = 0;
		int l = documentList.size();
		for(int i=0; i<l;i++) {
			k++;
			element = "//div/table/tbody/tr[" + k + "]/td[4]";
			String c =  driver.findElement(By.xpath(element)).getText();
			if(c.contains(category))
			{
				result = true;
			}else {
				break;
			}
		}
		return result;
	}
	
	public void viewNewFax() {
		viewBtn.click();
		super.waitForSleep(5000);
		
	}
	
}
