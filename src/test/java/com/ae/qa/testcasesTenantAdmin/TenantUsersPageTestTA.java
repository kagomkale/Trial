package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTestTA extends TestBase {
	TenantUsersPageTA tenantuserspageta;
	// String sheetName="TenantUserData";

	public TenantUsersPageTestTA() {
		super();
	}
	
	
	  @Test(priority=2)
	  public void ValidateCreatingWorkflowAdminTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingWorkflowAdminTest","TC_023: To verify create WF Admin");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.creatingWorkflowAdmin(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role"),TestDataInMap.get("NewPswd"));
	  extentTest.log(extentTest.getStatus(), "It will add new Tenant User data");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }
	/*  @Test(priority=2)
	  public void ValidateCreatingTenantUserTest(Method method) throws Exception { 
	  extentTest = extent.createTest("ValidateCreatingTenantUserTest","TC_025: To verify create Tenant User");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  tenantuserspageta=new TenantUsersPageTA();
	  tenantuserspageta.creatingTenantUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
	    TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
		TestDataInMap.get("role")); 
	  extentTest.log(extentTest.getStatus(), "It will add new Tenant User data");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }*/
	
	
}
