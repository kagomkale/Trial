package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPage;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestTA extends TestBase {
	AgentListPage agentlistpage;

	public AgentListPageTestTA() {
		super();
	}

	@Test()
	public void validateDownloadAgentLog(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAgentLog", "TC_360: Verify download agent log");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpage = new AgentListPage();
		agentlistpage.downloadAgentLog();
		extentTest.log(extentTest.getStatus(), "Request Created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
