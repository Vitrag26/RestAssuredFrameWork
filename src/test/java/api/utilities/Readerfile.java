package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.xssf.usermodel.*;

public class Readerfile {

		// TODO Auto-generated method stub
		XSSFWorkbook excelworkbook=null;
		XSSFSheet Excelsheet;
		XSSFRow row;
		XSSFCell cell;
		FileInputStream inputstream=null;
		
		//create an onject to opena file
			
		File file=new File("D://userdata.xlsx");
		{
		try {
			inputstream=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Excel--workbook--sheet--row--cell
		//create object of xssfworkbook to handle xlsx
		try {
			excelworkbook=new XSSFWorkbook(inputstream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//to accesssheet workbooksheet
		Excelsheet=excelworkbook.getSheetAt(0);
		//get total row count
		int totalrows=Excelsheet.getLastRowNum()+1;
		//get total no. of cell in row
		int ttcell=Excelsheet.getRow(0).getLastCellNum();		
		
		for(int currentrow=0;currentrow<totalrows;currentrow++)
		{
			for(int currentcell=0;currentcell<ttcell;currentcell++)
			{
				System.out.print(Excelsheet.getRow(currentrow).getCell(currentcell).toString());
				System.out.print("\t");
			}
			System.out.println();
			
		}
		try {
			excelworkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
