package GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public String reader(String abspath,String sheets,int rowno,int cellno) throws EncryptedDocumentException, IOException{
		File file=new File(abspath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet(sheets);
		Row row=sheet.getRow(rowno);
		String value=row.getCell(cellno).toString();
		return value;
	}

	public boolean reader1(String abspath,String sheets,int rowno,int cellno) throws EncryptedDocumentException, IOException{
		File file=new File(abspath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet(sheets);
		Row row=sheet.getRow(rowno);
		boolean value=row.getCell(cellno).getBooleanCellValue();
		return value;
	}

	public double reader2(String abspath,String sheets,int rowno,int cellno) throws EncryptedDocumentException, IOException{
		File file=new File(abspath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet(sheets);
		Row row=sheet.getRow(rowno);
		double value=row.getCell(cellno).getNumericCellValue();
		return value;
	}

	public Date reader3(String abspath,String sheets,int rowno,int cellno) throws EncryptedDocumentException, IOException{
		File file=new File(abspath);
		FileInputStream fin=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet(sheets);
		Row row=sheet.getRow(rowno);
		Date value=(Date) row.getCell(cellno).getDateCellValue();
		return value;
	}


	public String[][] ReadingMultipleData(String excel1Path,String sheetName) throws Exception {
		File absPath=new File(excel1Path);
		FileInputStream fin=new FileInputStream(absPath);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] arr=new String[rowCount][cellCount];
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				try {
					arr[i][j]=sheet.getRow(i).getCell(j).toString();
				} catch(Exception e) {

				}
			}

		}
		return arr;


	}
}

























