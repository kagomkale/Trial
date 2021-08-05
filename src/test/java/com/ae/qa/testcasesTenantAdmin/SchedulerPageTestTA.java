package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;

public class SchedulerPageTestTA extends TestBase {
	SchedulerPageTA schedulerpageta;

	public SchedulerPageTestTA() {
		super();
	}

	@Test
	public void validateDailyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDailySchedule", "TC_185: Verify user can create daily schedule for a day and only at once");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateDailySchedule(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"));
		extentTest.log(extentTest.getStatus(), "User created daily schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	
	}

}
