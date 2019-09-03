package config;
 
public class Constants {
 
 //This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value 
 public static final String URL = "https://www.qtpselenium.com";
 public static final String Path_TestData = "D:\\Data\\DataEngine.xlsx";
 public static final String File_TestData = "DataEngine.xlsx";
 public static final String Path_OR ="./src/main/resources/ObjectRepository/OR.properties";
 
 //List of Data Sheet Column Numbers
 public static final int Col_TestCaseID = 0; 
 public static final int Col_TestScenarioID =1 ;
 //This is the new column for 'Page Object'
 public static final int Col_PageObject =3 ;
 //This column is shifted from 3 to 4
 public static final int Col_ActionKeyword =4;
 //New entry in Constant variable
public static final int Col_RunMode =2 ;
 
 //List of Data Engine Excel sheets
 public static final String Sheet_TestSteps = "TestSteps";
 // List of test Objects
 public static final String Sheet_TestStepsObjects = "TestStepsObjects";
 // List of test cases
 public static final String Sheet_TestCases = "TestCases";
 
// List of Test Data
 public static final String UserName = "vikasgarg.mgl@gmail.com";
 public static final String Password = "Master1";
 
}