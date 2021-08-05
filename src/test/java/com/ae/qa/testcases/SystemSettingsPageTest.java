package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemSettingsPage;
import com.ae.qa.util.ExcelHandler;

public class SystemSettingsPageTest extends TestBase {
	SystemSettingsPage systemsettingspage;

	public SystemSettingsPageTest() {
		super();
	}

	
	@Test(priority = 9)
	public void validateServerUrlTest(Method method) throws Exception {
		extentTest = extent.createTest("validateServerUrlTest", "TC_101: Verify server Url");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.validateServerUrl();
		extentTest.log(extentTest.getStatus(), "Server URL saved successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	 @Test(priority = 10)
	 public void validateEditCleanUpRequest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditCleanUpRequest", "TC_103: Verify cleanup Requests older than Hours");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		//systemsettingspage.EditCleanUpRequest(6);
		systemsettingspage.EditCleanUpRequest(TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Sysadmin is able to add cleanup request for server URL setting");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 11)
	public void ValidateDRServerUrlTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDRServerUrlTest", "TC_102: Verify DR server Url");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		//systemsettingspage.ValidateDRServerUrl(2);
		systemsettingspage.ValidateDRServerUrl(TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "DR server URL validated successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	

	

}
