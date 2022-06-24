package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class LookupPage extends BaseTest{
	private @FindBy(id="lksrch")
	WebElement lookupTxt;
	
	private @FindBy(xpath = "//input[@name='go']")
	WebElement goBtn;

	public LookupPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Enter the name {0}, then click on Go button")
	public void lookup(String name) {
		driver.switchTo().frame("searchFrame");
		super.sendKeys(lookupTxt, name);
		goBtn.click();
		super.waitForSleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
	}
	
	@Step("Select the name {0} in the table list")
	public void selectResultName(String name) {
		final String prefix = "//tr/th/a[text()='";
		final String suffix = "']";
		WebElement element = driver.findElement(By.xpath(prefix + name + suffix));
		element.click();
		super.switchToParentWindow();
	}
}
