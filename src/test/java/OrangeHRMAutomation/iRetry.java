package OrangeHRMAutomation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class iRetry implements IRetryAnalyzer{
	int count=0;
	int maxLimit=1;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<maxLimit) {
			count++;
			return true;
		}
		return false;
	}
	
	
}
