package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.aventstack.extentreports.Status;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;

	// WebDriver driver;
	// to initialize the prop files in TestBase class
	public LoginPageTest() {
		super();
	}

	@Test(priority = 25)
	public void validateForgotPswdTest(Method method) throws Exception {
	extentTest = extent.createTest("validateForgotPswdTest",
				"TC_111: This will validate forgot password link present on Login Page");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		loginpage = new LoginPage();
		boolean flag = loginpage.ValidateForgotPswdLink();
		if (flag == true) {
			Assert.assertTrue(true);
			Reporter.log("Forgotten password link is Present",true);
			extentTest.log(Status.PASS, "passed");
		} else {
			Assert.assertTrue(false);
			Reporter.log("Forgotten password link is not Present",true);
			extentTest.log(Status.FAIL, "failed");
		}
		extentTest.log(extentTest.getStatus(), "Forgot Password Link is presesnt on Login Page");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 26)
	public void ValidateResetPswdTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateResetPswd","TC_112: Verify sysadmin user able to reset password after answering correct to security ques");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		loginpage = new LoginPage();
		loginpage.ValidateResetPswd(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("ResetPswd"),TestDataInMap.get("ResetCnfPswd"));
		extentTest.log(extentTest.getStatus(), "Reset password after answering security ques");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 27, dependsOnMethods = { "ValidateResetPswdTest" })
	public void ValidateLoginWithResetPswdTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateLoginWithResetPswdTest",
				"TC_113: Verify sysadmin user able to login with new password and navigates on Tenants Page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		loginpage = new LoginPage();
		loginpage.ValidateLoginWithResetPswd(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("ResetPswd"));
		extentTest.log(extentTest.getStatus(), "Login with password and navigates to Tenants lab");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 28)
	public void ValidateForgotPswdWithoutSecQuesTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateForgotPswdWithoutSecQuesTest",
				"TC_114: To Verifiy forget password link click gives proper error with valid userid who didn't set security answers");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		loginpage = new LoginPage();
		loginpage.ValidateForgotPswdWithoutSecQues(TestDataInMap.get("SysadminUsername"));
		extentTest.log(extentTest.getStatus(), "User get error message while setting password if security question is not set");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 29)
	public void ValidateSettingPwdWOComplexityTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateSettingPwdWOComplexityTest","TC_115: Verify password complexity while reset password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
	loginpage = new LoginPage();
	loginpage.ValidateSettingPwdWOComplexity(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("minLength"),TestDataInMap.get("maxLength"),
	TestDataInMap.get("ResetPswd"),TestDataInMap.get("ResetCnfPswd"));
	extentTest.log(extentTest.getStatus(), "It checks password complexity while resetting password");
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	//While setting data for this pre-requisite is sysadmin should have set security questions before
	@Test(priority = 30)
	public void validateUnlockUserWithSecQueAndResetPswdTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUnlockUserWithSecQueAndResetPswdTest",
				"TC_128:Verify User get unlock by answering security answers and reset password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		loginpage = new LoginPage();
	    loginpage.validateUnlockUserWithSecQueAndResetPswd(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("SysadminInvalidPswd"),TestDataInMap.get("NoOfAttempt"),TestDataInMap.get("ResetPswd"),TestDataInMap.get("ResetCnfPswd"));
		extentTest.log(extentTest.getStatus(), "User set new password by unlocking user by answer");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	
}