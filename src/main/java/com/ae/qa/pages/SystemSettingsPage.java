package com.ae.qa.pages;

import org.openqa.selenium.By;
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

public class SystemSettingsPage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage = new InformationPage();
	public static WebDriverWait wait = new WebDriverWait(driver, 120);
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement configureBtn;
	@FindBy(name = "dropdown-selector")
	WebElement configureDropdown;
	@FindBy(xpath = "//button[@aria-expanded='false']/b")
	WebElement httpProtocolBtn;
	@FindBy(xpath = "//span[(text()='http://')]")
	WebElement httpOption;
	@FindBy(xpath = "//span[(text()='https://')]")
	WebElement httpsOption;
	@FindBy(id = "serverUrl")
	WebElement serverUrl;
	@FindBy(id = "drServerUrl")
	WebElement drServerUrl;
	@FindBy(id = "cleanupOldReqHours")
	WebElement cleanUpRequest;
	@FindBy(name = "verify")
	WebElement verifyUrlBtn;
	@FindBy(xpath = "//button[@name='save' and @type='button']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[@name='cancel' and @type='button']")
	WebElement cancelBtn;
	@FindBy(xpath = "//div[@class='alert alert-success ae-alert ae-success-alert place-alert']")
	WebElement SuccessMsgBox;
	@FindBy(xpath = "//div[@class='alert ae-alert place-alert alert-danger ae-danger-alert']")
	WebElement failMsgBox;
	@FindBy(xpath = "//span[contains(text(),'DR Site')]")
	WebElement drSite;

	public SystemSettingsPage() {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void validateServerUrl() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		for (int i = 0; i <= 2; i++) {
			try {
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click();", configureBtn);
				Reporter.log("configure",true);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("configure");
		Reporter.log("Started configuring server url",true);
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			serverUrl.sendKeys(Keys.BACK_SPACE);
		}
		serverUrl.sendKeys(prop.getProperty("serverURL"));

		Thread.sleep(2000);
		if (verifyUrlBtn.isDisplayed()) {
			verifyUrlBtn.click();
			Reporter.log("Verify button is clicked",true);
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg = driver
					.findElement(By.xpath("//div/p[contains(text(),'System settings saved successfully')]")).getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			extentTest.log(extentTest.getStatus(), "System Settings saved");
		} else {
			Reporter.log("System settings not configured",true);
			extentTest.fail("System settings not configured");
		}
		informationpage.validateSignOut();
	}

	public void EditCleanUpRequest(String cleanUpRequestHour) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(configureBtn)));
		for (int i = 0; i <= 2; i++) {
			try {
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click();", configureBtn);
				System.out.println("configure");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// JavascriptExecutor js1=(JavascriptExecutor)driver;
		// js1.executeScript("arguments[0].click();", configureBtn);
		// System.out.println("configure");
		Reporter.log("Started configuring server url",true);
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			serverUrl.sendKeys(Keys.BACK_SPACE);
		}
		serverUrl.sendKeys(prop.getProperty("serverURL"));

		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			cleanUpRequest.sendKeys(Keys.BACK_SPACE);
		}
		cleanUpRequest.sendKeys(cleanUpRequestHour);

		if (verifyUrlBtn.isDisplayed()) {
			verifyUrlBtn.click();
			Reporter.log("Verify button is clicked",true);
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg = driver
					.findElement(By.xpath("//div/p[contains(text(),'System settings saved successfully')]")).getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			Reporter.log("System Settings saved",true);
		} else {
			System.out.println("System settings not configured");
			extentTest.fail("System settings not configured");
		}
		informationpage.validateSignOut();
	}

	public void ValidateDRServerUrl(String cleanUpRequestHour) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		wait.until(ExpectedConditions.elementToBeClickable(configureDropdown));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", configureDropdown);
		Reporter.log("configure dropdown selected",true);
		drSite.click();
		log.info("Started configuring DR server url");
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			drServerUrl.sendKeys(Keys.BACK_SPACE);
		}
		drServerUrl.sendKeys(prop.getProperty("DRServerURL"));

		Thread.sleep(2000);
		for (int i = 0; i < 10; i++) {
			cleanUpRequest.sendKeys(Keys.BACK_SPACE);
		}
		cleanUpRequest.sendKeys(cleanUpRequestHour);
		verifyUrlBtn.click();
		Reporter.log("Verify button is clicked",true);
		//	Thread.sleep(15000);
	//	WebElement actual_success_msg_verify= driver.findElement(By.xpath("//div/p"));
			
			//wait.until(ExpectedConditions.visibilityOf(actual_success_msg_verify));
			//String actaul_msg_text=actual_success_msg_verify.getText();
			//System.out.println(actaul_msg_text);
		//wait.until(ExpectedConditions.visibilityOf(actual_success_msg_verify));
			//Assert.assertEquals(actual_success_msg_verify, Messages.verifyDRServer,"Invalid Url");
			Thread.sleep(10000);
			//wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			if(saveBtn.isEnabled()) {
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg = driver
					.findElement(By.xpath("//div/p[contains(text(),'System settings saved successfully')]")).getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			extentTest.log(extentTest.getStatus(), "System Settings saved");
		} else {
			Reporter.log("System settings not configured validation of URL fail",true);
			Assert.assertTrue(false);
			extentTest.fail("System settings not configured");
		}
		informationpage.validateSignOut();
	}
}