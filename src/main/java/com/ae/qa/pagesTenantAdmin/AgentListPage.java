package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

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

public class AgentListPage extends TestBase{
	
	  public LoginPageTA loginpage = new LoginPageTA();
	  public static WebDriverWait wait = new WebDriverWait(driver, 300);
	  public InformationPageTA Info = new InformationPageTA();
	  @FindBy(xpath="//*[@id='logs-menuitem']/a")
	  WebElement LogTab;
	  @FindBy(xpath="//*[@id='logs-submenu']/ul/li[1]/a")
	  WebElement AgentTab;
	  @FindBy(xpath="//*[@id='main-component']/ng-component/div[1]/div/button")
	  WebElement NewRequest;
	  @FindBy(xpath="//*[@id='agentType']")
	  WebElement AgentType;
	  @FindBy(xpath="//*[@id='agentList']/div/span")
	  WebElement SelectAgent;
	  @FindBy(xpath="//*[@id='options-list']/li/label")
	  WebElement AgentName;
	  @FindBy(xpath="//*[@id='ui-datepicker-div']")
	  WebElement Duration;
	  @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a")
	  WebElement fromDate;
	  @FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/button[1]")
	  WebElement Duration1;
	  @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a")
	  WebElement toDate;
	  @FindBy(xpath="//*[@id='submitBtn']/span")
	  WebElement Submit;
	  @FindBy(xpath="//*[@id='177']/div/span[3]")
	  WebElement successMsgBox;
	  
	  public AgentListPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  public void downloadAgentLog() throws Exception
	  {
		  loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		  Reporter.log("User LogIn Succesfully",true);
		  wait.until(ExpectedConditions.visibilityOf(LogTab));
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", LogTab);
		  Reporter.log("LogTab clicked",true);
		  wait.until(ExpectedConditions.visibilityOf(AgentTab));
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("arguments[0].click();", AgentTab);
		  Reporter.log("Agent  tab clicked",true);	
		  NewRequest.click();
		  Thread.sleep(3000);
		  Select sel = new Select(AgentType);
		  sel.selectByIndex(1);
		  Thread.sleep(3000);
		  SelectAgent.click();
		  Thread.sleep(2000);
		  AgentName.click();
		  Thread.sleep(2000);
		  Duration.click();
		  Thread.sleep(2000); 
		  fromDate.click();
		  Thread.sleep(2000);
		  Duration1.click();
		  Thread.sleep(2000); 
		  toDate.click();
		  Thread.sleep(2000);
		  Submit.click();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_testMsg=successMsgBox.getText();
		  String Expected_testMsg=Messages.AgentRequest;
		  System.out.println("Actual Request message is :"+Actual_testMsg);
		  System.out.println("Expected Request message is :"+Expected_testMsg);
		  Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Download agent logs failed");
		  Thread.sleep(10000);
		  Reporter.log("Request Creation succesfully",true);
		  Info.validateSignOut();
		  
		  
	  }

}
