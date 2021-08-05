package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class CategoriesPageTA extends TestBase {
	public LoginPageTA loginpage = new LoginPageTA();
	  public static WebDriverWait wait = new WebDriverWait(driver, 300);
	  public InformationPageTA Info = new InformationPageTA();
	
	  @FindBy(xpath="//*[@id='workflows-menuitem']/a/span")
	  WebElement workflowTab;
	  @FindBy(xpath="//*[@id='workflows-submenu']/ul/li[4]/a")
	  WebElement categories;
      @FindBy(xpath="//*[@id='main-component']/ng-component/div[1]/div/button")
      WebElement Add;
      @FindBy(xpath="//*[@id='categoryName']")
      WebElement categoryName;
      @FindBy(xpath="//*[@id='categoryDescription']")
      WebElement description;
      @FindBy(xpath="//*[@id='new-cat-btn']")
      WebElement Button;
      @FindBy(xpath="//*[@id='176']/div/span[3]")
	  WebElement deleteButton;
	  @FindBy(xpath="//*[@id='popup-button-ok']")
	  WebElement cnfrm;
      @FindBy(xpath="//div/p[@class='alert-message-text']")
	  WebElement successMsgBox;
      
    public CategoriesPageTA()
    {
  	  PageFactory.initElements(driver, this);
    }

    public void createCategory(String CategoryName,String CategoryDescription)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		  Reporter.log("User LogIn Succesfully",true);
		  wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  wait.until(ExpectedConditions.visibilityOf(categories));
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("arguments[0].click();", categories);
		  Reporter.log("Category  tab clicked",true);
		  Thread.sleep(4000);
		  Add.click();
		  Thread.sleep(2000);
		  categoryName.sendKeys(CategoryName);
		  Thread.sleep(1000);
		  description.sendKeys(CategoryDescription);
		  Thread.sleep(2000);
		  Button.click();
		  Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_testMsg=successMsgBox.getText();
		  String Expected_testMsg=Messages.Categories;
		  System.out.println("Actual Category created message is :"+Actual_testMsg);
		  System.out.println("Expected Category created message is :"+Expected_testMsg);
		  Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Categories created fail");
		  Thread.sleep(10000);
		  Reporter.log("Category created succesfully",true);
		  Info.validateSignOut();	  
    }
    
	  public void deleteCategory(String CatName)throws Exception
	  {
		  loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		  Reporter.log("User LogIn Succesfully",true);
		  wait.until(ExpectedConditions.visibilityOf(workflowTab));		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");		  
		  wait.until(ExpectedConditions.visibilityOf(categories));
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("arguments[0].click();", categories);
		  Reporter.log("Category  tab clicked",true);
		  WebElement deleteCat=driver.findElement(By.xpath("//div/label[text()='"+CatName+"']/../div/span[@title='Delete Category']"));
		  deleteCat.click();
		  Thread.sleep(3000);
		  cnfrm.click();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_testMsg=successMsgBox.getText();
		  String Expected_testMsg=Messages.deleteCategory;
		  System.out.println("Actual Category deleted message is :"+Actual_testMsg);
		  System.out.println("Expected Category deleted message is :"+Expected_testMsg);
		  Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Categories deletion fail");
		  Thread.sleep(10000);
		  Reporter.log("Category Deleted succesfully",true);
		  Info.validateSignOut();
	  }
	  
}
