package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.LDAPPageTA;
import com.ae.qa.pagesTenantAdmin.TenantPolicyPageTA;
import com.ae.qa.util.ExcelHandler;

public class TenantPolicyPageTestTA extends TestBase {
	TenantPolicyPageTA tenantpolicypageta;

	public TenantPolicyPageTestTA() {
		super();
	}
/*
	@Test(priority = 20,alwaysRun=true)
	public void validateNoOfAttemptsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateNoOfAttemptsTest", "TC_562: To verify whether the user gets blocked, when max no of attempts is reached");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateNoOfAttempts(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
				TestDataInMap.get("InvalidPswd"),TestDataInMap.get("NoOfAttempts"));
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
/*	Remaining
	@Test(priority = 21,alwaysRun=true)
	public void validateUnlockTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUnlockTenantTest", "TC_564: Verify whether respective System admin is able to unlock the locked Tenant Admin user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateUnlockTenant(TestDataInMap.get("Pswd"),TestDataInMap.get("Pswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	/*Remaining for mapping
	@Test(priority = 22,alwaysRun=true)
	public void validateNoOfAttemptsRespectToTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateNoOfAttemptsRespectToTATest", "TC_: To verify whether respective Tenant admin is able to unlock the locked Tenant user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateNoOfAttemptsRespectToTA(5);
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
/*	@Test(priority = 23,alwaysRun=true,dependsOnMethods="validateNoOfAttemptsTest")
	public void validateUnlockTenantRespectToTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUnlockTenantRespectToTATest", "TC_565: Verify whether respective Tenant admin is able to unlock the locked Tenant Admin user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		System.out.println("Data:" +TestDataInMap.get("UserName")+TestDataInMap.get("NewPswd")+TestDataInMap.get("cnfPswd"));
		tenantpolicypageta.validateUnlockTenantRespectToTA(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	*/
/*
 	@Test(priority = 24,alwaysRun=true,dependsOnMethods="validateUnlockTenantRespectToTATest")
	public void validateTenantLoginTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantLoginTest", "TC_567: verify whether the above unlocked user  is able to get access to application, after change password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateTenantLogin(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
				TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	*/
/*	@Test(priority = 25,alwaysRun=true)
	public void validatePasswordHistoryTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePasswordHistoryTest", "Verify Password History");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validatePasswordHistory(3);
		extentTest.log(extentTest.getStatus(), "Password History is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 

	@Test(priority = 26,alwaysRun=true)
	public void validatePswdComplexityTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePswdComplexityTest", "Verify Password Complexity Criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validatePswdComplexity(6, 19, 1, 1, 1, 1, "Pune1254");
		extentTest.log(extentTest.getStatus(), "Password Complexity Criteria is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
*/
}
