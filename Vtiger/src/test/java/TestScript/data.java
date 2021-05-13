package TestScript;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data {
	
	@DataProvider
	public String[] sample() {
		String arr[]= {"hi","hello","hey","bye"};
		return arr;
	}
    
	@Test(dataProvider="sample")
	public void sample1(String data1) {
		Reporter.log("heloooo",true);
	}
}
