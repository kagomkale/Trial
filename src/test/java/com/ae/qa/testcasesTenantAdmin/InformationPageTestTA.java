package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.UserGroupsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class InformationPageTestTA extends TestBase {
	InformationPageTA informationpageta;

	public InformationPageTestTA() {
		super();
	}
//No data required
	
	/*  @Test (priority=4)
	  public void validateLastLoginTest(Method method) throws Exception  {
	  extentTest = extent.createTest( "validateLastLoginTest","TC_072: To Veify Last Login date and time");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  informationpageta=new InformationPageTA();
	  informationpageta.validateLastLogin(); 
	  extentTest.log(extentTest.getStatus(), "Last Login details verified.");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	  }
	  
	  @Test (priority=5,alwaysRun=true)
	  public void validateViewProfileTest(Method method) throws Exception {
	  extentTest = extent.createTest("validateViewProfileTest","TC_073: Verify  Profile details");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  informationpageta=new InformationPageTA();
	  informationpageta.validateViewProfile();
	  extentTest.log(extentTest.getStatus(), "Profile Details are verified"); 
	 ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	  }
	  
	/*  @Test (priority=6,alwaysRun=true)
	  public void validateAboutTest() throws Exception {
	  extentTest = extent.createTest("validateAboutTest","About AE details"); 
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  informationpageta=new InformationPageTA();
	  informationpageta.validateAbout();
	  extentTest.log(extentTest.getStatus(), "About AE Details"); 
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	  }*/

	/*	
	  @Test (priority=7,alwaysRun=true)
	  public void validateChangePasswordTest(Method method) throws Exception  { 
	  extentTest = extent.createTest("validateChangePasswordTest","TC_075: Change password of user");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  informationpageta=new InformationPageTA();
	  informationpageta.validateChangePassword(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
	  extentTest.log(extentTest.getStatus(), "User changed password successfully"); 
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	  }
	*/ 
	@Test(priority=8,alwaysRun=true)
	public void validateSetTenantLogo(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordTest", "TC_076:Set Tenant Logo");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.setTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant Logo set successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=9,alwaysRun=true,dependsOnMethods="validateSetTenantLogo")
	public void validateRemoveTenantLogo(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveTenantLogo", "TC_077: Remove Tenant Logo");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.removeTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant Logo removed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
