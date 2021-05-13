package TestScript;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.Excel;

public class twodimdataprovider {
	@DataProvider

	public String[][] data() throws Exception{
		Excel excel=new Excel(); 
		String arr[][]=excel.ReadingMultipleData("./Resources/multiple.xlsx","Sheet1");
		return arr;
	}
	@Test(dataProvider="data")
	public void data1(String[] dataa) {
		for(String data1:dataa) {
			Reporter.log(data1,true);

		}


	}

}
