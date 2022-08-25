package com.gemini.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
public class MobileAction extends MobileGenericUtils
{
	static AndroidDriver driver;

//	public static void main(String[] args) {
//		
//		deviceInitialisation();
//		androidInitialisation();
//		
//
//	}
	
	public static void deviceInitialisation() {
		
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
	
	public static void androidInitialisation() throws FileNotFoundException, IOException {
		
		mobileProperty();
	    File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app");
        File app = new File(appDir, getapp());
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName",getdeviceName());
		cap.setCapability("platformName",getPlatformName());
		cap.setCapability("platformVersion", getplatformVersion());
		cap.setCapability("udid", getudid());
		cap.setCapability("app", app.getAbsolutePath());
		
		 try {
         	driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), cap);                    
 			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

         } catch (MalformedURLException e) {         }

		
		
	}
	
	public static void mobileProperty(){
		
		String rootDirectory=System.getProperty("user.dir");
		String resourceDirectory=rootDirectory+"/src/test/resources/";

		//Configure property File
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(resourceDirectory + "AppiumSample.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MobileGlobalVar.appiumProperties = properties;
		}
	
//	public static void refresh() {
////    int deviceWidth = getDriver().manage().window().getSize().getWidth();
////    int deviceHeight = getDriver().manage().window().getSize().getHeight();
////
////    int midX = (deviceWidth / 2);
////    int midY = (deviceHeight / 2);
//    int bottomEdge = (int) (deviceHeight * 0.85f);
//
//    new TouchAction(getDriver())
//            .longPress(midX,midY)
//            .moveTo(midX, bottomEdge)
//           .release().perform();
//    JavascriptExecutor js = JavascriptExecutor;
//    Map<String, Object> params = new HashMap<>();
//    params.put("direction", "down");
//    params.put("velocity", 3000);
//    js.executeScript("mobile: swipe", params);
//}
	
	public void swipeScreen(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'");


	    final int ANIMATION_TIME = 200; // ms

	    final int PRESS_TIME = 200; // ms

	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    Dimension dims = driver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(driver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}

	public enum Direction {
	    UP,
	    DOWN,
	    LEFT,
	    RIGHT;
	}
	
	
	
	
}




