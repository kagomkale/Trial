package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class SystemUsersPageTest extends TestBase {
	SystemUsersPage systemuserspage;

	public SystemUsersPageTest() {
		super();
	}

	/*@DataProvider(name = "SystemUserData")
	public Object[][] getSystemUsersData() throws Exception {
		Object[][] data = TestUtil.getTestData(prop.getProperty("sysadmin_File"),"SystemUsersDetails");
		return data;
	}
*/
	@Test(priority = 4)
	public void creatingSystemAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("creatingSystemAdminTest", "TC_008: Verify create System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdmin(TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
		TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"));
		extentTest.log(extentTest.getStatus(), "System User created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		
	}

	@Test(priority = 6,alwaysRun=true)
	public void validateEditSystemUsers(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditSystemUsersTest", "TC_009: Verify Edit System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.EditSystemUsers(TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
		TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"), TestDataInMap.get("NewEmailID"), TestDataInMap.get("NewPswd"), TestDataInMap.get("NewCnfPswd"));
		extentTest.log(extentTest.getStatus(), "System User edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 5,alwaysRun=true)
	public void validatePasswordMismatch(Method method) throws Exception {
		extentTest = extent.createTest("validatePasswordMismatch", "TC_014: Verify creating sysadmin with Password mismatch");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdminWithWrongPswd(TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"));
		extentTest.log(extentTest.getStatus(), "Password Mismatch gave error message");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	
	}



}
