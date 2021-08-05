package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.UserGroupsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class UserGroupsPageTestTA extends TestBase {
	UserGroupsPageTA usergroupspageta;
	// String sheetName="TenantUserData";

	public UserGroupsPageTestTA() {
		super();
	}


	@Test(priority=3)
	public void validateCreateUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("creatingTenantUserTest", "TC_066: To verify create Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.createUserGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("userGrpDesc"));
		extentTest.log(extentTest.getStatus(), "It will create new User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	
	@Test (priority=4)
	public void validateEditUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUserGroup", "TC_067:To verify edit user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		System.out.println(TestDataInMap.get("userGroup")+TestDataInMap.get("updateDesc"));
		usergroupspageta.editUserGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("updateDesc"));
		extentTest.log(extentTest.getStatus(), "It will edit User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test (priority=5)
	public void validateAddUserToGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateAddUserToGroup", "TC_068:To verify adding user to user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.addUserToGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"),TestDataInMap.get("TUser2"));
		extentTest.log(extentTest.getStatus(), "It will add users to User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test (priority=6)
	public void validateRemoveUserFromGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveUserFromGroup", "TC_069:To verify removing user from user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.removeUserFromGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"),TestDataInMap.get("TUser2"));
		extentTest.log(extentTest.getStatus(), "It will remove users from User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test (priority=7)
	public void validateDeleteUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUserGroupTest", "TC_070: To verify Delete Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.deleteUserGroup(TestDataInMap.get("userGroup"));
		extentTest.log(extentTest.getStatus(), "It will delete User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
