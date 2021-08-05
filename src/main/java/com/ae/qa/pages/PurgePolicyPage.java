package com.ae.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class PurgePolicyPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 180);
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	public WebElements webelements = new WebElements();

	@FindBy(xpath = "//span[(text()='Purging')]")
	WebElement purgingTab;
	@FindBy(name = "add-new")
	WebElement addBtn;
	@FindBy(xpath="//span[@class='fa fa-edit']")
	WebElement editBtn;
	@FindBy(id = "durationRequests")
	WebElement WFRequests;
	@FindBy(id = "durationAudits")
	WebElement AuditLogs;
	@FindBy(id = "durationNotificationHistory")
	WebElement NotificationHistory;
//	@FindBy(id = "durationSessionHistory")
	//WebElement UserSessionHistory;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath="//input[@id='adv-input']")
	WebElement emailBox;

	public PurgePolicyPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validatePurgePolicyDuration(String wfRequests,String auditLogs,String notHistory)
			throws InterruptedException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);
		int WFRequest=Integer.valueOf(wfRequests);
		WFRequests.sendKeys("" +WFRequest);
		Thread.sleep(2000);
		int AudititLog=Integer.valueOf(auditLogs);
		AuditLogs.sendKeys("" +AudititLog);
		Thread.sleep(2000);
		int NotHistory=Integer.valueOf(notHistory);
		NotificationHistory.sendKeys("" +NotHistory);
		Thread.sleep(2000);
		if (WFRequest>= NotHistory) {
	//		UserSessionHistory.sendKeys("" + userSessionHist);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", saveBtn);
			String Actual_SuccessMsg = success_Message.getText();
			System.out.println("Actual success message after setting purging policy:" + Actual_SuccessMsg);
			String Expected_SuccessMsg = Messages.purgePolicyDuration;
			System.out.println("Expected success message after setting purging policy:" + Expected_SuccessMsg);
			Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Purge policy not saved successfully");
			Reporter.log("Purge policy saved successfully",true);
		} else {
			Assert.assertTrue(WFRequest >= NotHistory,
					"Value for Notification history must be less than or equal to Workflow Request.");
			Reporter.log("Purge policy not saved-failure",true);
		}
	}
	public void validateUpdationPurgePolicyDuration(String wfRequests, String auditLogs, String notHistory) throws InterruptedException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(editBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			WFRequests.sendKeys(Keys.BACK_SPACE);
		}
		WFRequests.sendKeys("" + wfRequests);
		int wkfRequest=Integer.valueOf(wfRequests);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			AuditLogs.sendKeys(Keys.BACK_SPACE);
		}
		AuditLogs.sendKeys("" + auditLogs);
		int AitLogs=Integer.valueOf(auditLogs);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			NotificationHistory.sendKeys(Keys.BACK_SPACE);
		}
		NotificationHistory.sendKeys("" + notHistory);
		int history=Integer.valueOf(notHistory);
		Thread.sleep(2000);
		emailBox.click();
		if (wkfRequest >= history) {
	//		UserSessionHistory.sendKeys("" + userSessionHist);
			Thread.sleep(5000);
			js.executeScript("arguments[0].click();", saveBtn);
			String Actual_SuccessMsg = success_Message.getText();
			System.out.println("Actual success message after setting purging policy:" + Actual_SuccessMsg);
			String Expected_SuccessMsg = Messages.purgePolicyDuration;
			System.out.println("Expected success message after setting purging policy:" + Expected_SuccessMsg);
			Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Purge policy not saved successfully");
			Reporter.log("Purge policy saved successfully",true);
		} else {
			Assert.assertTrue(wkfRequest >= history,
					"Value for Notification history must be less than or equal to Workflow Request.");
			Reporter.log("Purge policy not saved-failure",true);
		}
	}
}
