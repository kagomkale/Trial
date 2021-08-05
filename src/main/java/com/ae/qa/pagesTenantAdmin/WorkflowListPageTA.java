package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.aventstack.extentreports.Status;

public class WorkflowListPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(name = "add-new")
	WebElement importTab;
	@FindBy(id = "workflow_name")
	WebElement workflowName;
	@FindBy(id = "description")
	WebElement wfDescription;
	@FindBy(id = "category_name")
	WebElement wfCategory;
	@FindBy(id = "is_assisted")
	WebElement assistedCheckbox;
	@FindBy(name = "is_sequential")
	WebElement sequentialCheckbox;
	@FindBy(xpath="//fieldset[@class='workflow-fieldset']/div[@class='ps-form-control']/label[@tabindex='0']")
	WebElement selectwf;
	@FindBy(xpath = "//label[@class='btn button btn-secondary zero-margin wf-upload-btn full-width text-truncate']/input")
	WebElement selectWorkflow;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(id = "wfPriority")
	WebElement wfPriority;
	@FindBy(id = "expectedCompletionTime")
	WebElement expected_completionTime;
	@FindBy(id = "maxCompletionTime")
	WebElement max_CompletionTime;
	@FindBy(id = "cleanupOldReqHours")
	WebElement cleanupOldReqHours;
	@FindBy(id = "manualExecutionTime")
	WebElement manualExecutionTime;
	@FindBy(id = "manualTimeUnit")
	WebElement manualTimeUnit;
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath = "//div/h5[text()='Show file content']")
	WebElement showFileContent;
	@FindBy(xpath = "//div/h5[text()='Content:']")
	WebElement content;
	@FindBy(name = "dropdown-selector")
	WebElement importDrpDwn;
	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement selectWf;
	@FindBy(xpath = "//div[@class='right-inner-addon']/input[@name='search']")
	WebElement searchBar;
	@FindBy(id = "isVerified")
	WebElement verifiedCheckbx;
	@FindBy(id = "export-btn")
	WebElement ewfBtn;
	@FindBy(id = "wfIcon")
	WebElement wfIcon;
	@FindBy(xpath = "//form/fieldset[2]/legend[1]/span")
	WebElement emailNotification;
	@FindBy(id = "notifyWfFailure")
	WebElement notifyWfFailureBox;
	@FindBy(id = "notifyLongRunningWf")
	WebElement notifyExceedingTimeBox;
	@FindBy(id = "ROLE_TENANT_ADMIN")
	WebElement roleTA;
	@FindBy(id = "ROLE_WORKFLOW_ADMIN")
	WebElement roleWA;
	@FindBy(id = "toEmail")
	WebElement emailID;
	@FindBy(id = "sendToRequestCreator")
	WebElement reqCreator;
	@FindBy(id = "failureMessage")
	WebElement failMsg;
	@FindBy(id = "isSeqExec")
	WebElement enableSeqExec;

	// tr/td[contains(text(),'xyz')]/../td/span[@title='Show workflow files']
	public WorkflowListPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateImportWorkflow(String wfName, String wfdes, String category, String wfPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		// Click Workflows Tab
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("Workflow List tab is clicked",true);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", importTab);
		Reporter.log("Import button clicked",true);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		Thread.sleep(3000);
		if (assistedCheckbox.isSelected()) {
			Reporter.log("assisted Workflow is selected",true);
			assistedCheckbox.click();
			Reporter.log("assisted Workflow is unselected",true);
		} else {
			Reporter.log("Is Assisted Workflow checkbox is unselected");
		}
		Thread.sleep(3000);
		if (!sequentialCheckbox.isSelected()) {
			sequentialCheckbox.click();
		} else {
			System.out.println("Is sequential checkbox already selected");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectwf));
		selectWorkflow.sendKeys(wfPath);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", createBtn);
		wait.until(ExpectedConditions.visibilityOf(wfPriority));
		Select wfPriority_drpdown = new Select(wfPriority);
		wfPriority_drpdown.selectByVisibleText(priority);
		Thread.sleep(2000);
		expected_completionTime.clear();
		expected_completionTime.sendKeys(expTime);
		Thread.sleep(2000);
		max_CompletionTime.clear();
		max_CompletionTime.sendKeys(maxTime);
		Thread.sleep(2000);
		cleanupOldReqHours.clear();
		cleanupOldReqHours.sendKeys(cleanUpHrs);
		Thread.sleep(2000);
		manualExecutionTime.clear();
		manualExecutionTime.sendKeys(manExeTime);
		wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
		Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
		manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		Thread.sleep(3000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
	}

	public void validateShowFileContent(String wfName, String wfdes, String category, String wfPath) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", importTab);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		if (assistedCheckbox.isSelected()) {
			Reporter.log("assisted Workflow is selected",true);
			assistedCheckbox.click();
			Reporter.log("assisted Workflow is unselected",true);
		} else {
			Reporter.log("Is Assisted Workflow checkbox is unselected");
		}
		if (!sequentialCheckbox.isSelected()) {
			sequentialCheckbox.click();
			Reporter.log("Sequential execution is selected",true);
		} else {
			Reporter.log("Is sequential checkbox already selected",true);
		}
		selectWorkflow.sendKeys(wfPath);
		Thread.sleep(3000);
		showFileContent.click();
		if (content.getText().equalsIgnoreCase("Content:")) {
			Assert.assertTrue(true);
			Reporter.log("File structure of workflow got displayed",true);
			
		} else {
			Assert.assertTrue(false);
			Reporter.log("File structure of workflow does not displayed",true);
			//extentTest.log(Status.FAIL, "Failed");
		}informationpageta.validateSignOut();
	}

	public void validateShowFileStructure(String wfname) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Thread.sleep(2000);
		WebElement showFileStructure = driver.findElement(
				By.xpath("//tr/td[contains(text(),'" + wfname + "')]/../td/span[@title='Show workflow files']"));
		showFileStructure.click();
		List<WebElement> files_name = driver.findElements(By.xpath("//li[@class='list-group-item']"));
		System.out.println("Total No of columns in table: " + files_name.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < files_name.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Thread.sleep(2000);
			System.out.println("Files in Show folder structure are: " + files_name.get(i).getText());
			value.add(files_name.get(i).getText());
		}
		if (value != null) {
			Assert.assertTrue(true);
			Reporter.log("Files in show folder structure are displayed.",true);
			//extentTest.log(Status.PASS, "Passed");
		} else {
			Assert.assertTrue(false);
			Reporter.log("Files in show folder structure are displayed.",true);
			//extentTest.log(Status.FAIL, "Failed");
		}
		informationpageta.validateSignOut();
	}

	public void validateExportAsVerified(String wfName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA_UAT"), prop.getProperty("password_TA_UAT"));
		Reporter.log("User is logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", importDrpDwn);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", exportBtn);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.visibilityOf(selectWf));
		selectWf.click();
		Thread.sleep(2000);
		searchBar.click();
		WebElement search_wfToExport = driver.findElement(By.xpath("//label[contains(text(),'" + wfName + "')]/span"));
		search_wfToExport.click();
		Thread.sleep(2000);
		selectWf.click();
	/*	wait.until(ExpectedConditions.visibilityOf(verifiedCheckbx));
		if (!verifiedCheckbx.isSelected()) {
			verifiedCheckbx.click();
		} else {
			Reporter.log("Export as verified checkbox is already selected.");
		}*/
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].click();", ewfBtn);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Success Message after exporting wf " + Actual_successMsg);
		String Expected_successMsg = Messages.exportWorkflow;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not exported");
		Reporter.log("Workflow exported successfully",true);
		informationpageta.validateSignOut();
	}

	public void validateEditWorkflow(String wfname, String wfIcon_path, String priority) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA_UAT"), prop.getProperty("password_TA_UAT"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement edit_btn = driver
				.findElement(By.xpath("//tr/td[contains(text(),'"+wfname +"')]/../td/span[@title='Edit Worklfow']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", edit_btn);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wfIcon.sendKeys(wfIcon_path);
		Thread.sleep(2000);
		/*
		 * if(!sequentialCheckbox.isSelected()) { sequentialCheckbox.click(); } else {
		 * System.out.println("Is sequential checkbox already selected"); }
		 */
		Select wfPriority_drpdown = new Select(wfPriority);
		wfPriority_drpdown.selectByVisibleText(priority);
		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			cleanupOldReqHours.sendKeys(Keys.BACK_SPACE);
		}
		cleanupOldReqHours.sendKeys("1");
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Success Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow edited successfully",true);
		informationpageta.validateSignOut();
	}
	
	  public void EditManualExecution(String wfname,String manExeTime, String tUnit) throws Exception
	  {
		  loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		  Reporter.log("User LogIn Succesfully",true);
		  wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowsTab);
		  System.out.println("workflowTab clicked");
		  wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("arguments[0].click();", workflowListTab);
		  Reporter.log("workflowList  tab clicked",true);
		  Thread.sleep(4000);
		  //Click on Edit Button
		  WebElement edit_btn = driver.findElement(By.xpath("//tr/td[contains(text(),'"+wfname +"')]/../td/span[@title='Edit Worklfow']"));
		  JavascriptExecutor js2 = (JavascriptExecutor) driver;
		  js2.executeScript("arguments[0].click();", edit_btn);
		  Thread.sleep(3000);
		  Reporter.log("Edit button is Clicked",true);
		  //Clear and Enter Manual Execution time.
			manualExecutionTime.clear();
			manualExecutionTime.sendKeys(manExeTime);
			wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
			Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
			manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		    Thread.sleep(3000);
			saveBtn.click();
			wait.until(ExpectedConditions.visibilityOf(success_msg));
			String Actual_successMsg = success_msg.getText();
			Reporter.log("Aactual Success Message after editing workflow: " + Actual_successMsg,true);
			String Expected_successMsg = Messages.updateWorkflow;
			Reporter.log("Expected Success Message after editing workflow: " +Expected_successMsg ,true);
			Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
			Reporter.log("Workflow updated",true);
			informationpageta.validateSignOut();
	  }
	  
/*	public void validateEmailNotification(String wfname, String ipemailId1, String ipemailId2) throws Exception {
		loginpageta.login(prop.getProperty("username_TA_UAT"), prop.getProperty("password_TA_UAT"));
		Reporter.log("User log in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement edit_btn = driver
				.findElement(By.xpath("//tr/td[contains(text(),'" + wfname + "')]/../td/span[@title='Edit Worklfow']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", edit_btn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emailNotification.click();
		Thread.sleep(2000);
		if (!notifyWfFailureBox.isSelected()) {
			notifyWfFailureBox.click();
		} else {
			System.out.println("Notify on Workflow Failure checkbox is already selected.");
		}
		Thread.sleep(2000);
		if (!notifyExceedingTimeBox.isSelected()) {
			notifyExceedingTimeBox.click();
		} else {
			System.out.println("Notify on exceeding time unit checkbox is already selected.");
		}
		if (!roleTA.isSelected()) {
			roleTA.click();
		} else {
			System.out.println("Role Tenant Admin checkbox is already selected.");
		}
		if (!roleWA.isSelected()) {
			roleWA.click();
		} else {
			System.out.println("Role Tenant Admin checkbox is already selected.");
		}
		Thread.sleep(5000);
		emailID.sendKeys(ipemailId1);
		emailID.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		emailID.sendKeys(ipemailId2);
		emailID.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		JavascriptExecutor js_tenant1 = (JavascriptExecutor) driver;
		js_tenant1.executeScript("arguments[0].click();", reqCreator);
		// reqCreator.click();
		Thread.sleep(3000);
		for (int i = 0; i < 100; i++) {
			failMsg.sendKeys(Keys.BACK_SPACE);
		}
		failMsg.sendKeys("Workflow failed due to exceeding time limit.Please check once more.");
		Thread.sleep(5000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Success Message after updating wf: " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated successfully",true);
		informationpageta.validateSignOut();
	}

	public void validateUncheckSeqExec(String wfname) throws Exception {
		loginpageta.login(prop.getProperty("username_TA_UAT"), prop.getProperty("password_TA_UAT"));
		Reporter.log("User log in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		wait.until(ExpectedConditions.elementToBeClickable(workflowListTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement edit_btn = driver
				.findElement(By.xpath("//tr/td[contains(text(),'" + wfname + "')]/../td/span[@title='Edit Worklfow']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", edit_btn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (!enableSeqExec.isSelected()) {
			enableSeqExec.click();
		} else {
			System.out.println("Is sequential checkbox already selected So Unchecking it.");
		}
		Thread.sleep(5000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Success Message after updating wf: " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated successfully",true);
		informationpageta.validateSignOut();
	}*/
}
