package TestScript;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.Excel;

public class Excel1 {
	
	@DataProvider
	public String[][] testData() throws Exception {
		Excel excel=new Excel();
		String sarr[][]=excel.ReadingMultipleData("./Resources/multiple.xlsx","Sheet1");
		return sarr;
		
		
	}
    @Test(dataProvider="testData")
    public void sample(String[] data) {
    	for(String datas:data) {
    		Reporter.log(datas,true);
    	}
    }
}
