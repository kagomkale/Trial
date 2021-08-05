package com.ae.qa.testcases;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SysadminPolicyPage;

public class HomePageTest extends TestBase {
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	  @Test 
	  public void validateSearchFunctionalityTest() throws Exception
	  { 
	  extentTest = extent.createTest("validateSearchFunctionalityTest","Search functionality in sidebar menu");
	  homepage=new HomePage();
	  homepage.validateSearchFunctionality();
	  extentTest.log(extentTest.getStatus(),"Search functionality in sidebar menu is validated successfully"); 
	  }

}
