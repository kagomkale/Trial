package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.ReadExcel;
import com.ae.qa.util.TestDataHandler;
import com.ae.qa.util.TestUtil;

import com.aventstack.extentreports.gherkin.model.Scenario;


public class TenantsPageTest extends TestBase {
	LoginPage loginpage;
	TenantsPage tenantspage;
	TestDataHandler testdata=new TestDataHandler();
	
	//constructor is used to initialize object of class and super to call superclass objects and access the superclass methods and variables
	public TenantsPageTest() {
		super();
	}
	//Here we are eliminating hard-coded value and adopting data driven approach
	@Test(priority = 1)
	public void validateAddNewTenant(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenant", "TC_001: To Verfiy Add new Tenant");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenants(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant added successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 2)
	public void validateaddNewTenantsWithDuplicateOrgCode(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenantsWithDuplicateOrgCode","TC_006: To verify if user give duplicate org code");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenantsWithDuplicateOrgCode(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant not created with duplicate org code");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 3)
	public void verifyLicenseInfoTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyLicenseInfoTest", "TC_007: Verify License Information");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.verifyLicenseInfo();
		extentTest.log(extentTest.getStatus(), "It validates the license status of Sysadmin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	// Give same data to both test so that in first one it will create user and in
	// second flow it gives error as duplicate orgcode
	/*
	 * @Test(priority=1) public void validateAddNewTenant() throws Exception {
	 * extentTest = extent.createTest("validateAddNewTenant","It will add user");
	 * tenantspage=new TenantsPage();
	 * tenantspage.addNewTenants("Demo_Tenant12 "+tenantspage.createUniqueName(),
	 * "Desc_Tenant12","DT12"); extentTest.log(extentTest.getStatus(),
	 * "User added successfully"); }
	 * 
	 * @Test (priority=2) public void validateaddNewTenantsWithDuplicateOrgCode()
	 * throws Exception { extentTest = extent.createTest(
	 * "validateAddNewTenantsWithDuplicateOrgCode","It will verify if we can add user with duplicate code"
	 * ); tenantspage=new TenantsPage();
	 * tenantspage.addNewTenantsWithDuplicateOrgCode("Demo_Tenant12","Desc_Tenant12"
	 * ,"DT12"); extentTest.log(extentTest.getStatus(),
	 * "It will verify if we can add user with duplicate code"); }
	 * 
	 * @Test(priority=3) public void verifyLicenseInfoTest() throws Exception {
	 * extentTest = extent.createTest(
	 * "verifyLicenseInfoTest","It validates the license status of Sysadmin");
	 * tenantspage=new TenantsPage(); tenantspage.verifyLicenseInfo();
	 * extentTest.log(extentTest.getStatus(),
	 * "It validates the license status of Sysadmin"); }
	 */
}
