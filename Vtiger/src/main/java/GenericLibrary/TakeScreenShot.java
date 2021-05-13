package GenericLibrary;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import TestScript.BaseTest;

public class TakeScreenShot {
	public void getscreenshotofpage(WebDriver driver,ITestResult result){
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File tempFile=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Errorshots/"+result.getMethod().getMethodName()+".png");
		tempFile.renameTo(dest);
	}
}


