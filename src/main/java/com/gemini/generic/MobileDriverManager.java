package com.gemini.generic;

import com.gemini.reporting.GemTestReporter;
import com.gemini.reporting.STATUS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverManager extends MobileGenericUtils{

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	public static void setAppiumDriver(AppiumDriver AppiumDriver) {
		driver.set(AppiumDriver);
	}

	public static AppiumDriver getAppiumDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		try {
			GemTestReporter.addTestStep("Close Driver", "Driver Close Successful", STATUS.PASS);
			getAppiumDriver().quit();
		} catch (Exception e) {
			GemTestReporter.addTestStep("Close Driver", "Driver Close Failed", STATUS.FAIL);
			e.printStackTrace();
		}
	}


	public static void driverInitialisation() throws FileNotFoundException, IOException {


		try {
			if(getplatformName().equalsIgnoreCase("Android")){
				androidStart();
			} else if (getplatformName().equalsIgnoreCase("iOS")) {
				iOSStart();
			}
			getAppiumDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		} catch (Exception e) {

		}
	}


	// shubham
	public static void androidStart() {
		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app");
			File app = new File(appDir, getapp());

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, getplatformName());
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, getplatformVersion());
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, getdeviceName());
			cap.setCapability(MobileCapabilityType.UDID, getudid());
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

			setAppiumDriver(new AndroidDriver(new URL(getappiumUrl()), cap));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void iOSStart() {
		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app");
			File app = new File(appDir, getapp());

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, getplatformName());
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, getplatformVersion());
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, getdeviceName());
			cap.setCapability(MobileCapabilityType.UDID, getudid());
			cap.setCapability("bundleId", getBundelID());
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

			setAppiumDriver(new IOSDriver(new URL(getappiumUrl()), cap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
