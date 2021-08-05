package com.ae.qa.testcasesTenantAdmin;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.HomePageTA;

public class HomePageTestTA extends TestBase {

	HomePageTA homepageta;

	public HomePageTestTA() {
		super();
	}

	@Test(priority = 1, alwaysRun = true)
	public void validateUploadLicenseTest() throws Exception {
		extentTest = extent.createTest("validateUploadLicenseTest",
				"It will validate the license uploaad for Tenant Admin");
		homepageta = new HomePageTA();
		// homepageta.validateUploadLicenseNewUser("Pune@123");
		homepageta.validateUploadLicense("Tenant_Admin404", "Pune@123");
		// extentTest.log(extentTest.getStatus(), "License is uploaded successfully");
		// homepageta.validateActivateLicense("Tenant_Admin404","Pune@123");
	}

}
