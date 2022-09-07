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

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileAction extends MobileGenericUtils {

    public static void mobileProperty() {

        String rootDirectory = System.getProperty("user.dir");
        String resourceDirectory = rootDirectory + "/src/test/resources/";

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


    public static WebElement getElement(By locator) {
        try {
            WebElement element = (WebElement) MobileDriverManager.getAppiumDriver().findElement(locator);
            return element;
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String getElementText(By locator) {
        try {
            WebElement element = getElement(locator);
            String elementText = element.getText();
            return elementText;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static void click(By locator) {
        try {
            WebElement element = getElement(locator);
            element.click();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Click", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void typeText(By locator, String textToEnter) {
        try {
            WebElement element = getElement(locator);
            element.sendKeys(textToEnter);
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Click", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void tap(By locator) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            WebElement element = getElement(locator);
            action.singleTap(element);
            action.perform();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }


    public static void doubleTap(By locator) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            WebElement element = getElement(locator);
            action.doubleTap(element);
            action.perform();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void move(int X, int Y) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            //action.down(10, 10);
            action.move(X, Y);
            action.perform();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void moveUp(int X, int Y) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            //action.down(10, 10);
            action.up(X, Y);
            action.perform();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void moveDown(int X, int Y) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            //action.down(10, 10);
            action.down(X, Y);
            action.perform();
        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }

    public static void longPress(By locator) {
        try {
            TouchActions action = new TouchActions(MobileDriverManager.getAppiumDriver());
            WebElement element = getElement(locator);
            action.longPress(element);
            action.perform();


        } catch (Exception var2) {
            //GemTestReporter.addTestStep("Some error occur while Tap", "Error Occur", STATUS.FAIL, takeSnapShot());
            var2.printStackTrace();
        }
    }


    public static void waitSec(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImplicitTimeOut(long seconds) {
        try {
            MobileDriverManager.getAppiumDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setScriptTimeOut(long seconds) {

        try {
            MobileDriverManager.getAppiumDriver().manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS); // seconds is being converted into Timeunit.SECONDS
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setPageLoadTimeOut(long seconds) {
        try {
            MobileDriverManager.getAppiumDriver().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
////	////////////////////////////////////////NAVIGATION//////////////////////////////////////////////////////


    public static void navigateBack(Boolean report) {
        try {
            MobileDriverManager.getAppiumDriver().navigate().back();
//	            if (report) {
//	                GemTestReporter.addTestStep("Navigate Back", "Navigate Back Successful", STATUS.PASS, DriverAction.takeSnapShot());
//	            }
        } catch (Exception e) {
//	            GemTestReporter.addTestStep("Navigate Back", "Navigate Back Failed", STATUS.FAIL, DriverAction.takeSnapShot());
            e.printStackTrace();
        }
    }

    public static void refresh(Boolean report) {
        try {
            MobileDriverManager.getAppiumDriver().navigate().refresh();
//	            if (report) {
//	                GemTestReporter.addTestStep("Refresh Page", "Page Refresh Successful", STATUS.PASS, DriverAction.takeSnapShot());
//	            }
        } catch (Exception e) {
//	            GemTestReporter.addTestStep("Refresh Page", "Page Refresh Failed", STATUS.FAIL, DriverAction.takeSnapShot());
            e.printStackTrace();
        }
    }

    public static void navigateForward(Boolean report) {
        try {
            MobileDriverManager.getAppiumDriver().navigate().forward();
//	            if (report) {
//	                GemTestReporter.addTestStep("Navigate Forward", "Forward Navigation Successful", STATUS.PASS, DriverAction.takeSnapShot());
            //
        } catch (Exception e) {
//	            GemTestReporter.addTestStep("Navigate Forward", "Forward Navigation Failed", STATUS.FAIL, DriverAction.takeSnapShot());
            e.printStackTrace();
        }
    }

    public static void navigateToUrl(String url, Boolean report) {
        try {
            MobileDriverManager.getAppiumDriver().navigate().to(url);
//	                 if (report){
//	                     GemTestReporter.addTestStep("Navigate Forward", "Forward Navigation Successful", STATUS.PASS, DriverAction.takeSnapShot());
            //
//	                 }
        } catch (Exception e) {
//	                GemTestReporter.addTestStep("Navigate Forward", "Forward Navigation Successful", STATUS.PASS, DriverAction.takeSnapShot());
            e.printStackTrace();
        }

    }

    public static void LaunchURL(String url, Boolean report) {
        try {
            MobileDriverManager.getAppiumDriver().get(url);
//	            if (report){
//	                  GemTestReporter.addTestStep("URL launch ", "URL launch Successful", STATUS.PASS, DriverAction.takeSnapShot());
            //
////	                 }
        } catch (Exception e) {
//	            GemTestReporter.addTestStep("URL launch ", "URL launch Successful", STATUS.PASS, DriverAction.takeSnapShot());
            e.printStackTrace();
        }
    }
    ////////////////////////Mouse///////////////////////////////////////////////////////

    public static void doubleClick(WebElement element) {
        try {
            Actions act = new Actions(MobileDriverManager.getAppiumDriver());
            act.doubleClick(element).perform();
//	            GemTestReporter.addTestStep("Double Click on ", "Double Click Successful on " + elementLabel, STATUS.PASS,
//	                    DriverAction.takeSnapShot());
        } catch (Exception e) {
            e.printStackTrace();
//	            GemTestReporter.addTestStep("Double Click on ", "Double Click Failed on " + elementLabel, STATUS.FAIL,
//	                    DriverAction.takeSnapShot());
        }
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

//	public void swipeScreen(Direction dir) {
//	    System.out.println("swipeScreen(): dir: '" + dir + "'");
//
//
//	    final int ANIMATION_TIME = 200; // ms
//
//	    final int PRESS_TIME = 200; // ms
//
//	    int edgeBorder = 10; // better avoid edges
//	    PointOption pointOptionStart, pointOptionEnd;
//
//	    // init screen variables
//	//    Dimension dims = driver.manage().window().getSize();
//
//	    // init start point = center of screen
//	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
//
//	    switch (dir) {
//	        case DOWN: // center of footer
//	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
//	            break;
//	        case UP: // center of header
//	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
//	            break;
//	        case LEFT: // center of left side
//	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
//	            break;
//	        case RIGHT: // center of right side
//	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
//	            break;
//	        default:
//	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
//	    }
//
//	    // execute swipe using TouchAction
//	    try {
//	//        new TouchAction(driver)
//	//                .press(pointOptionStart)
//	                // a bit more reliable when we add small wait
//	 //               .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
//	//                .moveTo(pointOptionEnd)
//	 //               .release().perform();
//	    } catch (Exception e) {
//	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
//	        return;
//	    }
//
//	    // always allow swipe action to complete
//	    try {
//	        Thread.sleep(ANIMATION_TIME);
//	    } catch (InterruptedException e) {
//	        // ignore
//	    }
//	}
//
//	public enum Direction {
//	    UP,
//	    DOWN,
//	    LEFT,
//	    RIGHT;
//	}
//	
//	
//	

}




