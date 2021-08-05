package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.smtpPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class smtpPageTestTA extends TestBase {
	smtpPageTA smtppageta;

	public smtpPageTestTA() {
		super();
	}


	@Test(priority = 17)
	public void validateAddSmtpServerTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddSmtpServerTest", "TC_486: Verify user able to set smtp connection");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		smtppageta = new smtpPageTA();
		System.out.println(TestDataInMap.get("Host")+TestDataInMap.get("Port")+TestDataInMap.get("uname")+
				TestDataInMap.get("pswd")+TestDataInMap.get("encryptType")+TestDataInMap.get("PersonalName"));
		smtppageta.validateSetSmtpServer(TestDataInMap.get("Host"),TestDataInMap.get("Port"),TestDataInMap.get("SmtpUserName"),
				TestDataInMap.get("SmtpPswd"),TestDataInMap.get("encryptType"),TestDataInMap.get("PersonalName"));
		extentTest.log(extentTest.getStatus(), "SMTP connection done successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
