package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.LicenseDetailsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;

public class LicenseDetailsPageTestTA extends TestBase {
	LicenseDetailsPageTA licensedetailspageta;
	TestDataHandler testdata=new TestDataHandler();

	public LicenseDetailsPageTestTA() {
		super();
	}

	@Test(priority=1)
	public void validateSelectAllColumnsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSelectAllColumnsTest", "TC_020:Verify License Details tab-Select All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		licensedetailspageta = new LicenseDetailsPageTA();
		licensedetailspageta.validateSelectAllColumns();
		extentTest.log(extentTest.getStatus(), "Tenant added successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		
	}
	
	/*@Test(priority = 1, alwaysRun = true)
	public void validateUploadLicenseTest() throws Exception {
		extentTest = extent.createTest("validateUploadLicenseTest","It will validate the license uploaad for Tenant Admin");
		licensedetailspageta = new LicenseDetailsPageTA();
		// homepageta.validateUploadLicenseNewUser("Pune@123");
		licensedetailspageta.validateUploadLicenseNewUser();
		// extentTest.log(extentTest.getStatus(), "License is uploaded successfully");
		// homepageta.validateActivateLicense("Tenant_Admin404","Pune@123");
	}*/
}
