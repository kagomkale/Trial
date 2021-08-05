package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPage;
import com.ae.qa.pagesTenantAdmin.ContainersPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class ContainersPageTestTA extends TestBase {
	ContainersPageTA containerspageta;

	public ContainersPageTestTA() {
		super();
	}
	
	@Test (priority=27)
	public void validateCreateContainerTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateContainerTest", "TC_173: Verify can create container workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		containerspageta = new ContainersPageTA();
		containerspageta.validateCreateContainer(TestDataInMap.get("ContainerName"),TestDataInMap.get("ContainerDescp"),
				TestDataInMap.get("CatOfChildWF"),TestDataInMap.get("StartWF"),TestDataInMap.get("EndWF"));
		extentTest.log(extentTest.getStatus(), "Container Created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}