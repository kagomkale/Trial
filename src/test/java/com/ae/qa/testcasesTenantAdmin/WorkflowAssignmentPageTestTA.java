package com.ae.qa.testcasesTenantAdmin;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.WorkflowAssignmentPageTA;
import com.ae.qa.util.TestUtil;

public class WorkflowAssignmentPageTestTA extends TestBase{
	WorkflowAssignmentPageTA workflowassignmentpageta;

		public WorkflowAssignmentPageTestTA() {
			super();
		}
//No need to change data
	/*	@DataProvider(name = "WfAssignment")
		public Object[][] getWfAssignmentData() throws Exception {
			Object[][] data = TestUtil.getTestData(prop.getProperty("TenantAdmin_File"),"WfAssignmentSingle");
			return data;
		}

	
		@Test(dataProvider="WfAssignment")
		public void validateSingleWorkflowAssignment(String wfName) throws Exception {
			extentTest = extent.createTest("validateSingleWorkflowAssignment", "Verify user is able to assign single workflow to agent ");
			workflowassignmentpageta = new WorkflowAssignmentPageTA();
			workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
		}*/
		@DataProvider(name = "MultipleWfAssignment")
		public Object[][] getMultiWfAssignmentData() throws Exception {
			Object[][] data = TestUtil.getTestData(prop.getProperty("TenantAdmin_File"),"WorkflowAssignmentDetails");
			return data;
		}
		@Test(dataProvider="MultipleWfAssignment")
		public void validateWorkflowAssignment(String wfName1,String wfName2,String wfName3) throws Exception {
			extentTest = extent.createTest("validateWorkflowAssignment", "Verify user is able to assign single workflow to agent ");
			workflowassignmentpageta = new WorkflowAssignmentPageTA();
			workflowassignmentpageta.validateWorkflowAssignment(wfName1,wfName2,wfName3);
		}


}
