package com.ae.qa.testcasesTenantAdmin;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;
import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.DataSourcesPageTA;
import com.ae.qa.util.ExcelHandler;
public class DataSourcesPageTestTA extends TestBase{
	DataSourcesPageTA datasourcespageta;
	
	public DataSourcesPageTestTA()
	{
		super();
	}

	@Test()
	public void ValidateConfigDataSource(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateConfigDataSource", "TC_421:Verify user is able to create datasource");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		datasourcespageta= new DataSourcesPageTA();
		datasourcespageta.configDataSource(TestDataInMap.get("DBType"),TestDataInMap.get("DatasourceName"),TestDataInMap.get("ConnectionString"),TestDataInMap.get("DBUsername"),TestDataInMap.get("DBPswd"));
		extentTest.log(extentTest.getStatus(), "User set DataSource configuration successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
