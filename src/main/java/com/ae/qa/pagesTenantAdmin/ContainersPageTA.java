package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class ContainersPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();

	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Containers']")
	WebElement containersTab;
	@FindBy(name = "add-new")
	WebElement addNewBtn;
	@FindBy(id = "wfName")
	WebElement containerName;
	@FindBy(id = "wfDesc")
	WebElement description;
	@FindBy(id = "wfCat")
	WebElement catOfChildWF_drpdown;
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement selectWFs;
	@FindBy(id = "startWf")
	WebElement startWf;
	@FindBy(id = "endWf")
	WebElement endWf;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;

	public ContainersPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateCreateContainer(String containerWFName, String wfdes, String categoryChildWF, String WF1_name,
			String WF2_name) throws Exception {
		loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(containersTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", containersTab);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addNewBtn);
		containerName.sendKeys(containerWFName);
		Thread.sleep(3000);
		description.sendKeys(wfdes);
		Thread.sleep(5000);
		Select wfCategory_drpdown = new Select(catOfChildWF_drpdown);
		wfCategory_drpdown.selectByVisibleText(categoryChildWF);
		Thread.sleep(6000);
		selectWFs.click();
		Thread.sleep(3000);
		WebElement selectwf1 = driver.findElement(By.xpath("//label[contains(text(),'" + WF1_name + "')]/span"));
		selectwf1.click();
		Thread.sleep(3000);
		// selectWFs.click();
		WebElement selectwf2 = driver.findElement(By.xpath("//label[contains(text(),'" + WF2_name + "')]/span"));
		selectwf2.click();
		Thread.sleep(2000);
		selectWFs.click();
		Thread.sleep(2000);
		Select startWf_dropdown = new Select(startWf);
		startWf_dropdown.selectByVisibleText(WF1_name);
		Thread.sleep(2000);
		Select endWf_dropdown = new Select(endWf);
		endWf_dropdown.selectByVisibleText(WF2_name);
		Thread.sleep(5000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Success Message after changing password: " + Actual_successMsg);
		String Expected_successMsg = Messages.createContainer;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Container not created");
	}
	public void validateEditContainer(String containerWFName, String wfdes, String categoryChildWF, String WF1_name,
			String WF2_name) throws Exception {
		////span[@title='WebGuiSimpleWF']/span
		loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("User clicked on Workflows Tab",true);
		wait.until(ExpectedConditions.elementToBeClickable(containersTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", containersTab);
		Reporter.log("User clicked on Containers Tab",true);
		Thread.sleep(2000);
		WebElement edit_btn=driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+containerWFName+"')]/../td/span[@class='fa fa-edit']"));
	/*	JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addNewBtn);
		containerName.sendKeys(containerWFName);
		Thread.sleep(3000);
		description.sendKeys(wfdes);
		Thread.sleep(5000);
		Select wfCategory_drpdown = new Select(catOfChildWF_drpdown);
		wfCategory_drpdown.selectByVisibleText(categoryChildWF);
		Thread.sleep(6000);
		selectWFs.click();
		Thread.sleep(3000);
		WebElement selectwf1 = driver.findElement(By.xpath("//label[contains(text(),'" + WF1_name + "')]/span"));
		selectwf1.click();
		Thread.sleep(3000);
		// selectWFs.click();
		WebElement selectwf2 = driver.findElement(By.xpath("//label[contains(text(),'" + WF2_name + "')]/span"));
		selectwf2.click();
		Thread.sleep(2000);
		selectWFs.click();
		Thread.sleep(2000);
		Select startWf_dropdown = new Select(startWf);
		startWf_dropdown.selectByVisibleText(WF1_name);
		Thread.sleep(2000);
		Select endWf_dropdown = new Select(endWf);
		endWf_dropdown.selectByVisibleText(WF2_name);
		Thread.sleep(5000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Success Message after changing password: " + Actual_successMsg);
		String Expected_successMsg = Messages.createContainer;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Container not created");*/
	}

}
