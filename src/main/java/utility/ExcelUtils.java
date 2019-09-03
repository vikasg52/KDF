package utility;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Constants;

import java.io.FileInputStream;

public class ExcelUtils
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell; 

	//This method is to set the File path and to open the Excel file
	//Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception 
	{
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}

	//This method is to read the test data from the Excel cell
	//In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception
	{
		 ExcelWSheet = ExcelWBook.getSheet(SheetName);
		try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                String CellData = Cell.getStringCellValue();
                return CellData;
                }catch (Exception e){
                  return"Could not get data";
                }
     }
	

    //This method is to get the row count used of the excel sheet
    public static int getRowCount(String SheetName){
    ExcelWSheet = ExcelWBook.getSheet(SheetName);
    int number=ExcelWSheet.getLastRowNum()+1;
    return number;
    }

//This method is to get the Row number of the test case
//This methods takes three arguments(Test Case name , Column Number & Sheet name)
    public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{ 
    	int i;
    ExcelWSheet = ExcelWBook.getSheet(SheetName);
    int rowCount = ExcelUtils.getRowCount(SheetName);
    for (i=0 ; i<rowCount; i++){
    if  (ExcelUtils.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
    break;
    }
    }
    return i;
    }

//This method is to get the count of the test steps of test case
//This method takes three arguments (Sheet name, Test Case Id & Test case row number)
    public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
    	
    	for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++)
    	{
    		if(!sTestCaseID.equals(ExcelUtils.getCellData(i,Constants.Col_TestCaseID, SheetName))){
    			int number = i;
    			return number;
    		}
    	}
    	ExcelWSheet = ExcelWBook.getSheet(SheetName);
    	
    	int number=ExcelWSheet.getLastRowNum()+1;
    	
    	return number;
    }

}
