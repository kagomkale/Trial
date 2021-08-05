package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PluginsPage;
import com.ae.qa.util.ExcelHandler;

public class PluginsPageTest extends TestBase {
	LoginPage loginpage;
	PluginsPage pluginspage;

	public PluginsPageTest() {
		super();
	}

	@Test(priority = 32)
	public void validateUploadPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_032: Upload plugins zip");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadPlugins();
		extentTest.log(extentTest.getStatus(), "Plugins uploaded successfully and assigned to all tenants");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	

}
