package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class SecurityQuestionsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 250);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();

	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	WebElement SettingsTab;
	@FindBy(xpath = "//a[contains(text(),'Security Questions')]")
	WebElement securityQuesTab;
	@FindBy(xpath = "//input[@id='pswd']")
	WebElement pswd;
	@FindBy(xpath = "//div/p[contains(text(),'Security questions updated successfully')]")
	WebElement success_msg;
	@FindBy(xpath = "//div/p[contains(text(),'Security questions set successfully')]")
	WebElement success_Setmsg;
	@FindBy(name = "skip")
	WebElement skipBtn;
	@FindBy(xpath = "//div/h2[contains(text(),'Tenants')]")
	WebElement tenantPageTitle;
	@FindBy(xpath="//div/p[contains(text(),'Authentication failed')]")
	WebElement alertMessage;

	public SecurityQuestionsPage() {
		PageFactory.initElements(driver, this);
	}
	

	public void validateSkipQues(String Username,String Password) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		skipBtn.click();
		String actual_pageTitle = tenantPageTitle.getText();
		System.out.println("User navigated to " + actual_pageTitle + "Tab");
		Assert.assertEquals(actual_pageTitle, "Tenants", "User is not navigated to tenants tab");
		Reporter.log("User skipped the set security question and navigated to Tenant Tab",true);
		informationpage.validateSignOut();
	}


	public void validateSecurityQues(String Username,String Password) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			Select select = new Select(driver.findElement(By.xpath("//select[@id='que" + i + "']")));
			select.selectByVisibleText(prop.getProperty("IQue" + i));
			Thread.sleep(2000);
			WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
			select_Ans.sendKeys(prop.getProperty("IAns" + i));
			Thread.sleep(2000);
		}
		saveBtn.click();
		String actual_successMsg = success_Setmsg.getText();
		String expected_successMsg = Messages.securityQuestions;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg);
		Reporter.log("Security questions set successfully",true);
		informationpage.validateSignOut();

	}

	public void validateUpdatingSecurityQues(String Username,String Password) throws Exception {
		// Click Users Tab
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(SettingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SettingsTab);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", securityQuesTab);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			Select select = new Select(driver.findElement(By.xpath("//select[@id='que" + i + "']")));
			select.selectByVisibleText(prop.getProperty("IUQue" + i));
			Thread.sleep(2000);
			WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
			select_Ans.sendKeys(prop.getProperty("IUAns" + i));
			Thread.sleep(2000);
		}
		pswd.sendKeys(prop.getProperty("password"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		// Thread.sleep(20000);
		String actual_successMsg = success_msg.getText();
		String expected_successMsg = Messages.updatingSecurityQues;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg);
		Reporter.log("Security questions updated successfully",true);
		informationpage.validateSignOut();
	}

	public void validateSkipThenSetQues(String Username,String Password) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		// driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(2000);
		skipBtn.click();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(SettingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SettingsTab);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", securityQuesTab);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			Select select = new Select(driver.findElement(By.xpath("//select[@id='que" + i + "']")));
			select.selectByVisibleText(prop.getProperty("IQue" + i));
			Thread.sleep(2000);
			WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
			select_Ans.sendKeys(prop.getProperty("IAns" + i));
			Thread.sleep(2000);
		}
		// pswd.sendKeys(prop.getProperty("password"));
		saveBtn.click();
		// Thread.sleep(10000);
		String actual_successMsg = success_Setmsg.getText();
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, Messages.securityQuestions);
		Reporter.log("User first skip the security question and then set security questions successfully",true);
		informationpage.validateSignOut();
	}
	
	public void validateUpdatingSecQuesWithWrongPswd(String Username,String Password,String invalidPswd) throws Exception {
		// Click Settings Tab
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(SettingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SettingsTab);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", securityQuesTab);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			Select select = new Select(driver.findElement(By.xpath("//select[@id='que" + i + "']")));
			select.selectByVisibleText(prop.getProperty("IUQue" + i));
			Thread.sleep(2000);
			WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
			select_Ans.sendKeys(prop.getProperty("IUAns" + i));
			Thread.sleep(2000);
		}
		pswd.sendKeys(invalidPswd);
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		//Thread.sleep(2000);
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.failueInupdatingSecurityQues;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg);
		Reporter.log("Security questions can not be updated due to wrong password",true);
		informationpage.validateSignOut();
	}
}
