package TestScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Bye {
	@Test(dataProviderClass=hai.class,dataProvider="disp")
	public void disp2(String data) {
		Reporter.log(data,true);
	}
	

}
