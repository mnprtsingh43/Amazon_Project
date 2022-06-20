package listener_class;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener_fail_test extends base.Baseclass_amazon implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
	try {
		base.Baseclass_amazon.ScreenshotMethod(result.getMethod().getMethodName());
		
	} catch (IOException e) {
		System.out.println("Listener class is not working ");
		e.printStackTrace();
	}	
	}

}
