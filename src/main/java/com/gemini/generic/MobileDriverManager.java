package com.gemini.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import com.qa.meld.utility.DriverManager;
//import com.qa.meld.utility.MeldProperty;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;

public class MobileDriverManager extends MobileGenericUtils{
	
//	static AppiumDriver driver;
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	
//	private static AndroidDriver driver = new ThreadLocal<AppiumDriver>();

	
	public static void setAppiumDriver(AppiumDriver AppiumDriver) {
		driver.set(AppiumDriver);
	}

	public static AppiumDriver getAppiumDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		try {
	//		GemTestReporter.addTestStep("Close Driver", "Driver Close Successful", STATUS.PASS);
			getAppiumDriver().close();
		} catch (Exception e) {
	//		GemTestReporter.addTestStep("Close Driver", "Driver Close Failed", STATUS.FAIL);
			e.printStackTrace();
		}
	}
	

	public static void androidInitialisation() throws FileNotFoundException, IOException {
		
		MobileAction.mobileProperty();
	    File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app");
        File app = new File(appDir, getapp());
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName",getdeviceName());
		cap.setCapability("platformName",getplatformName());
		cap.setCapability("platformVersion", getplatformVersion());
		cap.setCapability("udid", getudid());
		cap.setCapability("app", app.getAbsolutePath());
		
		 try {
        	setAppiumDriver( new AppiumDriver(new URL(getappiumUrl()), cap));                    
			getAppiumDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {       
        	
        }

		

		
		
	}
	

}
