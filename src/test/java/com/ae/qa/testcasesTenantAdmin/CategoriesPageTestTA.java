 package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.util.ExcelHandler;

public class CategoriesPageTestTA extends TestBase {
	
	CategoriesPageTA categoriespageta;
	
	public CategoriesPageTestTA()
	{
		super();
	}
	
   @Test()
   public void validateCreateCategory(Method method) throws Exception
   {
	   extentTest = extent.createTest("validateCreateCategory", "TC_209: To verify can create catagory with mandotary field only");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   categoriespageta = new CategoriesPageTA ();
	   categoriespageta.createCategory(TestDataInMap.get("categoryName"),TestDataInMap.get("catDesc"));
	   extentTest.log(extentTest.getStatus(), "Category Created successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
   }
   /*
   @Test(dependsOnMethods="validateCreateCategory")
	public void validateDeleteCategory(Method method) throws Exception
	{
	   extentTest = extent.createTest("validateCreateCategory", "TC_221: To verify delete catagory");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   categoriespageta = new CategoriesPageTA ();
	   categoriespageta.deleteCategory(TestDataInMap.get("categoryName"));
	   extentTest.log(extentTest.getStatus(), "Category deleted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
}

