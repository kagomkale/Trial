package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class SchedulerPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Scheduler']")
	WebElement schedulerTab;
	@FindBy(name = "add-new")
	WebElement addNewBtn;
	@FindBy(xpath="//div[@class='mul-position']/span")
	WebElement workflowDrpdwn;
	@FindBy(id="scheduleName")
	WebElement scheduleName; 
	@FindBy(id="scheduleDesc")
	WebElement description;
	@FindBy(id="WfExecStartDate")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneBtn;
	@FindBy(id="wfExecEndDate-datepicker")
	WebElement endDate;
	@FindBy(id="scheduleType")
	WebElement scheduleTypeDrpdown;
	@FindBy(id="timeZone")
	WebElement timeZone;
	@FindBy(id="wfExecStartTime-hours")
	WebElement scheduleHRS;
	@FindBy(id="wfExecStartTime-minutes")
	WebElement scheduleMins; 
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement actual_Msg;
	@FindBy(xpath="//span[text()='Requests']")
	WebElement requestTab;
	

	// tr/td[contains(text(),'xyz')]/../td/span[@title='Show workflow files']
	public SchedulerPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateDailySchedule(String wfName,String schedulename,String scheduleDescrip,String startMonth,String startYear,String startdate,
		String endMonth,String endYear,String enddate,String scheduleType,String timezone,String Hrs,String Mins) throws Exception {
		// Remaining is how to fetch time and then apply to scheduler
		//(String wfName,String wfdes,String category,String wfPath,String priority,String expTime,String maxTime, String cleanUpHrs,String manExeTime,String tUnit
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addNewBtn);
		Reporter.log("Add new Button clicked",true);
		Thread.sleep(5000);
		Reporter.log("Schedule form details started",true);
		workflowDrpdwn.click();
		WebElement search_wfName=driver.findElement(By.xpath("//label[contains(text(),'"+wfName+"')]/span"));
		search_wfName.click();
		Thread.sleep(3000);
		scheduleName.sendKeys(schedulename);
		Thread.sleep(2000);
		description.sendKeys(scheduleDescrip);
		Thread.sleep(3000);
		startDate.click();
		Thread.sleep(2000);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		//Thread.sleep(5000);
		//doneBtn.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
	//doneBtn.click();
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Thread.sleep(2000);
		Select timezone_drpdown=new Select(timeZone);
		timezone_drpdown.selectByVisibleText(timezone);
		Thread.sleep(2000);
		scheduleHRS.sendKeys(Hrs);
		Thread.sleep(2000);
		scheduleMins.sendKeys(Mins);
		Thread.sleep(2000);
		submitBtn.click();
		Reporter.log("Schedule submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.scheduleCreation;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not created");
		Reporter.log("Schedule created successfully",true);
	/*	wait.until(ExpectedConditions.visibilityOf(requestTab));
		JavascriptExecutor js_tenant5 = (JavascriptExecutor) driver;
		js_tenant5.executeScript("arguments[0].click();", requestTab);
		//requestTab.click();
		Reporter.log("Request tab clicked and validate if it is present in table",true);
		WebElement req=driver.findElement(By.xpath("//tbody[@class='tbody-stripped']/tr/td[2]"));
		String req_wf=req.getText();
		Assert.assertEquals(req_wf, wfName,"Workflow request not created,schedule fail ");
		Reporter.log("Workflow is scheduled and validated in the table");*/
		informationpageta.validateSignOut();
	}

}
