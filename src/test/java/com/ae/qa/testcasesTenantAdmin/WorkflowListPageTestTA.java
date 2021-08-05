package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class WorkflowListPageTestTA extends TestBase {
	WorkflowListPageTA workflowlistpageta;

	public WorkflowListPageTestTA() {
		super();
	}

/*	@Test(priority=10)
	public void validateImportWorkflowTest(Method method) throws Exception {
	    extentTest = extent.createTest("validateImportWorkflowTest", "TC_082: Verify Import PS workflow w/o parameter");
	    Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	    workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflow(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				TestDataInMap.get("wfPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow without parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
	*/
/*	  @Test(priority=11,alwaysRun=true) 
	  public void validateShowFileContentTest(Method method) throws Exception {
	  extentTest=extent.createTest("validateShowFileContentTest","TC_095: Verify show file structure on Create New Workflow when workflow import");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  workflowlistpageta=new WorkflowListPageTA();
	  workflowlistpageta.validateShowFileContent(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				TestDataInMap.get("wfPath"));
	  extentTest.log(extentTest.getStatus(), "File content shown successfully");  
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}*/
	/*  @Test(priority=12,alwaysRun=true) 
	  public void validateShowFileStructureTest(Method method)throws Exception {
	  extentTest=extent.createTest("validateShowFileStructureTest","TC_096: Verify show file structure on Workflow List Page"); 
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  workflowlistpageta=new WorkflowListPageTA();
	  workflowlistpageta.validateShowFileStructure(TestDataInMap.get("wfName"));
	  extentTest.log(extentTest.getStatus(), "File structure seen successfully");  
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	  }
	  */
	/* @Test(priority=13,alwaysRun=true) 
	  public void validateExportAsVerifiedTest(Method method)throws Exception {
	  extentTest=extent.createTest("validateExportAsVerifiedTest","TC_132: Verify export as verified workflow from UAT environment"); 
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  workflowlistpageta=new WorkflowListPageTA();
	  workflowlistpageta.validateExportAsVerified(TestDataInMap.get("wfName")); 
	  extentTest.log(extentTest.getStatus(), "Workflow exported from UAT environment successfully");  
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	  } 
 */
/*	@Test(priority = 14, alwaysRun = true)
	public void validateEditWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWorkflowTest",
				"TC_167: To verify edits the workflow-upload icon and change priority");
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),
				method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.validateEditWorkflow(TestDataInMap.get("wfName"),TestDataInMap.get("wfIconPath"),TestDataInMap.get("priority"));
		extentTest.log(extentTest.getStatus(), "Workflow icon uploaded and changed priority successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	*/
	
	
	@Test()
	public void validateEditManualExecution(Method method) throws Exception
	{
		extentTest = extent.createTest("validateEditManualExecution", "TC_173:To verify can set manual execution time");
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),
				method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.EditManualExecution(TestDataInMap.get("wfName"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Manual Execution Edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	/* Need to rethink on this
	 *  @Test (priority=16,alwaysRun=true) public void
	  validateEmailNotificationTest(Method method)throws Exception {
	  extentTest=extent.createTest(
	  "validateEmailNotificationTest","To verify all type of user get notification if workflow exceed time and then fail"
	  ); workflowlistpageta=new WorkflowListPageTA();
	  workflowlistpageta.validateEmailNotification("WF_Gui1",
	  "shivani.janokar@automationedge.com","kalyani.gomkale@automationedge.com"); 
	  extentTest.log(extentTest.getStatus(), "Workflow exported from UAT environment successfully");  
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	  
	  }*/
	// give data with is Sequnetial chechbox selected- didnt find it in sheet so ignore thos tc
	/*
	  @Test(priority=15,alwaysRun=true) 
	  public void validateUncheckSeqExecTest(Method method) throws Exception { 
	  extentTest = extent.createTest("validateUncheckSeqExecTest","To verify User can uncheck Is Sequentail Execution while editing workflow");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  workflowlistpageta = new WorkflowListPageTA();
	  workflowlistpageta.validateUncheckSeqExec("WF_Gui1"); 
	  extentTest.log(extentTest.getStatus(), "Workflow exported from UAT environment successfully");  
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	  
	  }
	  
	*/
	
	  
  }
	 


