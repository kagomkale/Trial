package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PurgePolicyPage;
import com.ae.qa.util.ExcelHandler;

public class PurgePolicyPageTest extends TestBase {
	LoginPage loginpage;
	PurgePolicyPage purgepolicyspage;

	public PurgePolicyPageTest() {
		super();
	}

	@Test(priority = 41)
	public void validatePurgePolicyDurationTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePurgePolicyDurationTest","TC_064: To verify that SA can specify different purging duration for each of  the entities on creation/update of purge policy");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		purgepolicyspage = new PurgePolicyPage();
		//purgepolicyspage.validatePurgePolicyDuration(3, 2, 2);
		purgepolicyspage.validatePurgePolicyDuration(TestDataInMap.get("WfRequests"), TestDataInMap.get("AuditLogs"),TestDataInMap.get("NotificationHistory"));
		extentTest.log(extentTest.getStatus(), "SA can specify different purging duration successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 42,dependsOnMethods="validatePurgePolicyDurationTest")
	public void validateUpdatePurgePolicyEntityTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdatePurgePolicyEntityTest","TC_065: To verify that SA is able to update an existing purging policy for each of the  purgable entities");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		purgepolicyspage = new PurgePolicyPage();
	//	purgepolicyspage.validateUpdationPurgePolicyDuration(TestDataInMap.get(WfRequests), TestDataInMap.get(AuditLogs),TestDataInMap.get(NotificationHistory));
		purgepolicyspage.validateUpdationPurgePolicyDuration(TestDataInMap.get("WfRequests"), TestDataInMap.get("AuditLogs"),TestDataInMap.get("NotificationHistory"));
		extentTest.log(extentTest.getStatus(), "SA can update different purging entity successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
