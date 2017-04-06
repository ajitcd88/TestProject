package com.practice.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class FailRunner {
	
	public static void main(String []args){
		TestNG runner = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add("E:/Study/CapureFail/test-output/Failed suite [Default suite]/testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
	}

}
