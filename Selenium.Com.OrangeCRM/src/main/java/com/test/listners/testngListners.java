package com.test.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testngListners implements ITestListener {

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	result.getMethod();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
