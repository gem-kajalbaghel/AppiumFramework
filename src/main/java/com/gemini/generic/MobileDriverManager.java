package com.gemini.generic;

import io.appium.java_client.AppiumDriver;

public class MobileDriverManager {
	
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	
	public static void setAppiumDriver(AppiumDriver AppiumDriver) {
		driver.set(AppiumDriver);
	}

	public static AppiumDriver getAppiumDriver() {
		return driver.get();
	}

//	public static void closeDriver() {
//		try {
//			GemTestReporter.addTestStep("Close Driver", "Driver Close Successful", STATUS.PASS);
//			driver.get().close();
//		} catch (Exception e) {
//			GemTestReporter.addTestStep("Close Driver", "Driver Close Failed", STATUS.FAIL);
//			e.printStackTrace();
//		}
//	}

}
