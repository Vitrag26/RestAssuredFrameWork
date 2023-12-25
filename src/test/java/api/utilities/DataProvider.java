package api.utilities;

import java.io.IOException;

public class DataProvider {

	@org.testng.annotations.DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		String fName = "D://userdata.xlsx";
		
		int ttlRowCnt = Excelutility.getRowCount(fName, "Sheet1");
		int ttlColCnt= Excelutility.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			for(int colNo=0; colNo<ttlColCnt; colNo++)
			{
				userData[rowNo-1][colNo] = Excelutility.getCellValue(fName, "Sheet1", rowNo, colNo);
			}
			
		}
		return userData;
	}
	
	
	@org.testng.annotations.DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider()
	{
		String fName = "D://userdata.xlsx";
		int ttlRowCnt = Excelutility.getRowCount(fName, "Sheet1");
	//	int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCnt-1];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			userNamesData[rowNo-1] = Excelutility.getCellValue(fName, "Sheet1", rowNo, 1);
			
		}
		return userNamesData;
	}
	
	
}