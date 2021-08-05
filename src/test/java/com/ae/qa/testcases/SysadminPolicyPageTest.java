package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SysadminPolicyPage;
import com.ae.qa.util.ExcelHandler;

public class SysadminPolicyPageTest extends TestBase {
	SysadminPolicyPage sysadminpolicypage;

	public SysadminPolicyPageTest() {
		super();
	}

	/* @Test(priority= 32) 
	  public void validatePasswordHistoryTest(Method method) throws Exception
	  { 
	  extentTest = extent.createTest("validatePasswordHistoryTest","TC_133: Verify Password History");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
	  sysadminpolicypage=new SysadminPolicyPage();
	  sysadminpolicypage.validatePasswordHistory(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("PswdHistory"));
	  extentTest.log(extentTest.getStatus(),"Password History is validated successfully"); 
	 ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	  }
	
	*/
  //Same data fr below two
	@Test(priority = 33)
	public void validatePswdComplexityTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePswdComplexityTest", "TC_123: To verify how system behaves when user violates the password complexity");
		 Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage = new SysadminPolicyPage();
		//sysadminpolicypage.validatePswdComplexity("PswdComp","Pune@123","6","19","2","2","2","2","Pune1254");
		sysadminpolicypage.validatePswdComplexity(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("minLength"),TestDataInMap.get("maxLength"),TestDataInMap.get("upperCase"),TestDataInMap.get("lowerCase"),TestDataInMap.get("specialChar"),TestDataInMap.get("digitsIp"),TestDataInMap.get("invalidPswd"));//6, 19, 2, 2, 2, 2, "Pune1254");
		extentTest.log(extentTest.getStatus(), "Password Complexity Criteria is validated successfully");
		 ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/* @Test(priority=34)	 
	 public void validateNoOfAttemptsTest(Method method) throws Exception {
	  extentTest =extent.createTest("validateNoOfAttemptsTest","TC_125: To check the calculation of unsucessful attempt post first unsucessful attempt");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
	  sysadminpolicypage=new SysadminPolicyPage();
	  sysadminpolicypage.validateNoOfAttempts(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("SysadminInvalidPswd"),TestDataInMap.get("NoOfAttempt"));
	  extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully"); 
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	  }
	 */
}
