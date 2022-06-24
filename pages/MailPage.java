package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class MailPage extends BaseTest{
	private @FindBy(xpath = "//div/button[text()='GO']")
	WebElement goBtn;
	
	private @FindBy(xpath = "//div/input[@name=\"identifier\"]")
	WebElement emailTxt;
	
	private @FindBy(xpath = "//div/input[@name=\"password\"]")
	WebElement passwordTxt;
	
	private @FindBy(xpath = "//button/span[text()='Next']")
	WebElement nextBtn;
	
	
	public MailPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// go to mailinator.com check the received email
	public void mailinator() {
		driver.get("https://www.mailinator.com/");
		super.sendKeys(elementsPg.inputField("search"), "cloudpipe");	
		goBtn.click();
		super.waitForSleep(3000);
	}
	
	@Step("Check the Alert email details")
	public void gotoGmail() {
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		super.sendKeys(emailTxt, "cloudpipeTest@gmail.com");
		nextBtn.click();
		super.sendKeys(passwordTxt, "Cloud@123");
		nextBtn.click();
		super.waitForSleep(3000);
	}
	
}
