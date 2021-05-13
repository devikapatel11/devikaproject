package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import GenericLibrary.Excel;

public class TestScriptExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		
		Excel excel=new Excel();
		System.out.println(excel.reader("./Resources/excel.xlsx","sheet1",0,1));
		System.out.println(excel.reader("./Resources/excel.xlsx","sheet1",0,3));
		System.out.println(excel.reader("./Resources/excel.xlsx","sheet1",0,0));
		System.out.println(excel.reader("./Resources/excel.xlsx","sheet1",0,2));
		

	}

}
