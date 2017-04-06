package com.practice.util;
import org.testng.IRetryAnalyzer;


public class ITestResult implements IRetryAnalyzer{
	int count=0;
	int retryAttempt = 4;

	@Override
	public boolean retry(org.testng.ITestResult result) {
		if(count<retryAttempt){
			count++;
			return true;
		}
		return false;
	}
	
}
