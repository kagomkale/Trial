package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ProcessStudioPageTA;
import com.ae.qa.util.ExcelHandler;

public class ProcessStudioPageTestTA extends TestBase{
	ProcessStudioPageTA processstudiopageta;

	public ProcessStudioPageTestTA() {
		super();
	}

	@Test(priority=10)
	public void validateDownloadandAssignPSTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateDownloadandAssignPSTest", "TC_xxx: Verify if user can download PS & assign ps license to TA");
	 //  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   processstudiopageta = new ProcessStudioPageTA(); 
	   processstudiopageta.validateDownloadandAssignPS();
	   extentTest.log(extentTest.getStatus(), "PS downloaded and assigned to TA successfully");  
//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}

}
