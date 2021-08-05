package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SmtpPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class SmtpPageTest extends TestBase {
	SmtpPage smtppage;

	public SmtpPageTest() {
		super();
	}

	@Test(priority = 31)
	public void validateAddSmtpServerTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddSmtpServerTest", "TC_104: Verify configuration of smtp");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		smtppage = new SmtpPage();
		//smtppage.validateAddSmtpServer(HName, PortNo, UName, Pswd, EncrypType, PName);
		System.out.println(TestDataInMap.get("Host")+TestDataInMap.get("Port")+TestDataInMap.get("uname")+TestDataInMap.get("pswd")+TestDataInMap.get("encryptType")+TestDataInMap.get("PersonalName"));
		smtppage.validateAddSmtpServer(TestDataInMap.get("Host"),TestDataInMap.get("Port"),TestDataInMap.get("uname"),TestDataInMap.get("pswd"),TestDataInMap.get("encryptType"),TestDataInMap.get("PersonalName"));
		extentTest.log(extentTest.getStatus(),"SMTP server configured successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
