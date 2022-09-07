package geminisample.appiumTrial;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class testbase {
	
	static AndroidDriver driver;

	public static void main(String[] args) {
		
		openCalculator();
		

	}
	
	public static void openCalculator() {
		
	    File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app");
        File app = new File(appDir, "calculatorsample.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("udid", "192.168.157.102:5555");
		cap.setCapability("app", app.getAbsolutePath());
		
		 try {
         	driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), cap);                    
 			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

         } catch (MalformedURLException e) {         }

		
		
	}

}
