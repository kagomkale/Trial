package com.ae.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class AuditLogsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage = new InformationPage();
	public SystemSettingsPage systemsettingspage = new SystemSettingsPage();
	@FindBy(xpath = "//span[contains(text(),'Logs')]")
	@CacheLookup
	WebElement logsTab;
	@FindBy(name = "download-logs")
	WebElement downloadLogsBtn;
	@FindBy(id = "downloadBtn")
	WebElement downloadBtn;
	@FindBy(xpath = "//div/p[contains(text(),'Audit Logs download started')]")
	WebElement successMsg;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;

	public AuditLogsPage() {
		PageFactory.initElements(driver, this);
	}

	public void downloadingAuditLogs() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Reporter.log("Clicked on logs tab",true);
		downloadLogsBtn.click();
		Thread.sleep(2000);
		downloadBtn.click();
		Reporter.log("Clicked the download button", true);
		String actual_successMsg = successMsg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.downloadAuditLogs;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Download does not started.");
		Thread.sleep(15000);
		informationpage.validateSignOut();
	}

	public void checkColumnsInAuditLogs() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
	//	List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
	//	System.out.println("Total No of columns in table: " + TotalColumn.size());
		Assert.assertEquals(sizeOfColumnsInt, 13, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.",true);
		informationpage.validateSignOut();
	}

	public void deselectAllInAuditLogs() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All and resulted into deselected all columns.");
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			System.out.println("Select All Checkbox is not already selected, Hence selected twice to deselect it.");

		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);//4
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);//4
	    List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			System.out.println("Field of Columns: " + TotalColumn.get(i).getText());
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Entity") || value.contains("Object Id")) {
			System.out.println("Column Value found");
			Assert.assertEquals(sizeOfColumnsInt, 2, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Entity and ObjectId.",true);
		} else {
			System.out.println("Column value not found");
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}

	public void verifySpecificColumn() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All and resulted into deselected all columns.");
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			System.out.println("Select All Checkbox is not already selected, Hence selected twice to deselect it.");

		}
		// select 2 more columns
		driver.findElement(By.xpath("//li/div/a/span[text()='Source']")).click();
		driver.findElement(By.xpath("//li/div/a/span[text()='Description']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			System.out.println("Field of Columns: " + TotalColumn.get(i).getText());
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Entity") && value.contains("Object Id") && value.contains("Description")
				&& value.contains("Source")) {
			System.out.println("Column Value found");
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table with Entity and ObjectId.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}

	public void checkLogs() throws Exception {
		systemsettingspage.EditCleanUpRequest("4");
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Thread.sleep(2000);
		ArrayList<String> actual_content = new ArrayList<String>();
		ArrayList<String> expected_content=new ArrayList<String>();
		expected_content.add("LOGOUT");
		expected_content.add("UPDATE");
		expected_content.add("AUTHENTICATE");
		for (int i = 3; i <= 5; i++) {
		List<WebElement> operation_list = driver.findElements(By.xpath("//table/tr["+i+"]/td[4]"));
		
		for(WebElement element:operation_list) {
			String element_value=element.getText();
			System.out.println(element_value);
			actual_content.add(element_value);
		}
		System.out.println("Actual content :"+actual_content);
	}
		if(actual_content.equals(expected_content)) {
			Reporter.log("Operations in audit logs validated in table",true);
			Assert.assertTrue(true, "Operations validated");
		} else {
			Assert.assertTrue(false, "Operation in audit logs not validated in table");
		}

}
}
