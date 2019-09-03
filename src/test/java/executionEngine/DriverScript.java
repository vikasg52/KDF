package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {
	//This is a class object, declared as 'public static'
	//So that it can be used outside the scope of main[] method
	
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	//This is reflection class object, declared as 'public static'
	//So that it can be used outside the scope of main[] method
	public static Method method[];
	
	 public static int iTestStep;
	 public static int iTestLastStep;
	 public static String sTestCaseID;
	 public static String sRunMode;

	public static void main(String[] args) throws Exception {
		actionKeywords = new ActionKeywords();
		method=actionKeywords.getClass().getDeclaredMethods();
		System.out.println(method.length);

		//Declaring the path of the Excel file with the name of the Excel file
		String sPath = Constants.Path_TestData;	
		//Here we are passing the Excel path and SheetName to connect with the Excel file
		//This method was created in the last chapter of 'Set up Data Engine' 
		ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);
		ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestStepsObjects);
		ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestCases);		
		DriverScript startEngine = new DriverScript();
	    startEngine.execute_TestCase();
	}
	
//		for (int iRow = 1;iRow < 9;iRow++){
//			//This to get the value of column Action Keyword from the excel
//			sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
//			sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
//
//			//A new separate method is created with the name 'execute_Actions'
//			//You will find this method below of the this test
//			//So this statement is doing nothing but calling that piece of code to execute
//			execute_Actions();
//		}
	//}
	
	private void execute_TestCase() throws Exception {
		//This will return the total number of test cases mentioned in the Test cases sheet
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		//This loop will execute number of times equal to Total number of test cases
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
			//This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
			//This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			//This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")){
				//Only if the value of Run Mode is 'Yes', this part of code will execute
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				//This loop will execute number of times equal to Total number of test steps
				for (;iTestStep<=iTestLastStep;iTestStep++){
					sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
					sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
					execute_Actions();
				}
			}
		}
	}

	//This method contains the code to perform some action
	//As it is completely different set of logic, which revolves around the action only,
	//It makes sense to keep it separate from the main driver script
	//This is to execute test step (Action)
	private static void execute_Actions() throws Exception {
		//This is a loop which will run for the number of actions in the Action Keyword class 
		//method variable contain all the method and method.length returns the total number of methods
		for(int i = 0;i <method.length;i++){
			//This is now comparing the method name with the ActionKeyword value got from excel
			if(method[i].getName().equals(sActionKeyword)){
				//In case of match found, it will execute the matched method with action keyword and page object
				method[i].invoke(actionKeywords,sPageObject);
				//Once any method is executed, this break statement will take the flow outside of for loop
				break;
			}
		}
	}
}