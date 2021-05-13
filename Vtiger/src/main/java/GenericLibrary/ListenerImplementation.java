package GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import TestScript.BaseTest;

public class ListenerImplementation extends BaseTest implements ITestListener {
	 
		
	    public void onFinish(ITestContext arg0) {					
	       Reporter.log("onFinish",true);				
	        		
	    }		

	  		
	    public void onStart(ITestContext arg0) {					
	    	 Reporter.log("onStart",true);				
	        		
	    }		

	   	
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	    	 Reporter.log("onTestFailedButWithinSuccessPercentage",true);			
	        		
	    }		

	   		
	    public void onTestFailure(ITestResult result) {					
	    	 Reporter.log("Test script is Failed",true);	
	    	 TakeScreenShot sc=new TakeScreenShot();
	    	 sc.getscreenshotofpage(driver,result);
	        		
	    }		

	  		
	    public void onTestSkipped(ITestResult arg0) {					
	    	Reporter.log("onTestSkipped",true);	
	        		
	    }		

	 		
	    public void onTestStart(ITestResult arg0) {					
	    	 Reporter.log("onTestStart",true);			
	        		
	    }		

	   	
	    public void onTestSuccess(ITestResult arg0) {					
	    	 Reporter.log("onFinish",true);				
	        		
	    }
	
	

}
/*onStart        
 *onTestStart
 *@Test
 *{
 *}
 *onTestFailure
 *onTestSuccess
 *onFinish*/
