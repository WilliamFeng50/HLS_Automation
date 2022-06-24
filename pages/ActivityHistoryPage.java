package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class ActivityHistoryPage extends BaseTest{
	
	public ActivityHistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Get the test subject from Activity History table")
	public String getSubject(String id) {
		String title = "";
		return title;
	}
	
	@Step("Get the test date from Activity History table")
	public String getTestDate(String id) {
		String xp = "//td/span/span/a[text()='" + id + "']//ancestor::tr/td[4]";
		return driver.findElement(By.xpath(xp)).getText();
	}
	
	
}
