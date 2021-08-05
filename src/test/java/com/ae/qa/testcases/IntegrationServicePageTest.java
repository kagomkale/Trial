package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.IntegrationServicesPage;
import com.ae.qa.pages.PluginAssignmentsPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;

public class IntegrationServicePageTest extends TestBase {
	IntegrationServicesPage integrationservicespage;

	public IntegrationServicePageTest() {
		super();
	}
	
	@Test(priority=45)
	public void validateAddIntegrationServicesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddIntegrationServicesTest", "TC_87: Verify adding integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		System.out.println(TestDataInMap.get("IntName")+TestDataInMap.get("ConfLowerLimit")+TestDataInMap.get("ResponseLowerLimit")+TestDataInMap.get("MachineName")+TestDataInMap.get("IntUserName")+TestDataInMap.get("ClusterIP")+TestDataInMap.get("ClusterPort"));
		integrationservicespage.validateAddIntegrationServices(TestDataInMap.get("IntName"), TestDataInMap.get("ConfLowerLimit"),TestDataInMap.get("ResponseLowerLimit"),TestDataInMap.get("MachineName"),TestDataInMap.get("IntUserName"),TestDataInMap.get("ClusterIP"),TestDataInMap.get("ClusterPort"));//("BR01","MSSQL-Server");TestDataInMap.get("TenantOrgCode")
		extentTest.log(extentTest.getStatus(), "It will add integration services successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}

