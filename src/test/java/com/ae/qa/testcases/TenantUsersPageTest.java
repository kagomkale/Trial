package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTest extends TestBase {
	TenantUsersPage tenantuserspage;
	String sheetName = "TenantUserData";

	public TenantUsersPageTest() {
		super();
	}


/*	@Test(priority = 8)
	public void ValidateCreatingTenantAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateCreatingTenantAdminTest", "TC_015: To verify create Tenant Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.creatingTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
		TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "It will create new Tenant Admin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

*/
	@Test(priority = 9)
	public void ValidateEditTenantUserTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditingTenantUserTest", "TC_016: To verify Edit Tenant User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.EditTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
	    TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"),TestDataInMap.get("NewEmailID"),TestDataInMap.get("NewPswd"),TestDataInMap.get("NewCnfPswd"));	
		extentTest.log(extentTest.getStatus(), "It will edit Tenant Admin details");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
