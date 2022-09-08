package com.gemini.generic;

//import com.gemini.listners.PropertyListeners;

import com.gemini.utils.TestCaseData;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MobileGenericUtils extends MobileGlobalVar {

    public static String getplatformName() {
        String platformName = MobileGlobalVar.appiumProperties.getProperty("platformName");
//	        String platformNameFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("platformName");
        String platform = platformName != null ? platformName : "Android";
        return platformName;
    }

    public static String getdeviceName() {
        // 	System.out.println(System.getProperties());
        String deviceName = MobileGlobalVar.appiumProperties.getProperty("deviceName");
//	        System.out.println(deviceName);
//	        String deviceNameFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("deviceName");
//	        String device = deviceName != null ? deviceName
//	                : deviceNameFromPropertiesFile != null ? deviceNameFromPropertiesFile : "Android Emulator";
        return deviceName;
    }

    public static String getplatformVersion() {
        String platformVersion = MobileGlobalVar.appiumProperties.getProperty("platformVersion");
//	        String platformVersionFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("platformVersion");
//	        String platform1 = platformVersion != null ? platformVersion
//	                : platformVersionFromPropertiesFile != null ? platformVersionFromPropertiesFile : "10.0";
        return platformVersion;
    }

    public static String getapp() {
        System.out.println(System.getProperties());
        String app = MobileGlobalVar.appiumProperties.getProperty("app");

//	        String appFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("app");
//	        String app1 = app != null ? app
//	                : appFromPropertiesFile != null ? appFromPropertiesFile : "user.dir";
        return app;

    }

    public static String getudid() {
        String app = MobileGlobalVar.appiumProperties.getProperty("udid");
//	        String udidFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("udid");
//	        String udid1 = udid != null ? udid
//	                : udidFromPropertiesFile != null ? udidFromPropertiesFile : "192.168.157.102:5555";
        return udid;

    }

    public static String getappiumUrl() {
        String appiumUrl = MobileGlobalVar.appiumProperties.getProperty("appiumUrl");
//	        String platformNameFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("platformName");
        String appium = appiumUrl != null ? appiumUrl : "http://0.0.0.0:4723/wd/hub/";
        return appiumUrl;
    }

    public static String getBundelID() {
        String bundleId = MobileGlobalVar.appiumProperties.getProperty("bundleID");
        return bundleId;
    }

    public static String getProjectName() {
        String sysProjectName = String.valueOf(Paths.get(System.getProperty("user.dir")).getFileName());
        String sysPropProjectName = MobileGlobalVar.appiumProperties.getProperty("projectName");
        String projectName = sysPropProjectName != null && sysPropProjectName.length() >= 1 ?
                sysPropProjectName : sysProjectName;
        return projectName;
    }

    public static String getProjectReportName() {
        String sysPropReportName = MobileGlobalVar.appiumProperties.getProperty("reportName");
        String reportName = sysPropReportName != null && sysPropReportName.length() >= 1 ? sysPropReportName
                : "Gem-Jar-Report";
        return reportName;
    }

    public static String getTestCaseFileName() {
        String sysTestCaseFileName = System.getProperty("testCaseFileName");
        String testCaseFileNameFromProjProp = MobileGlobalVar.projectProperty.getProperty("testCaseFileName");
        String testCaseFileName = sysTestCaseFileName != null ? sysTestCaseFileName
                : testCaseFileNameFromProjProp != null ? testCaseFileNameFromProjProp
                : MobileGlobalVar.projectName + "_testCase.json";
        return testCaseFileName;
    }

    public static String getProjectEnvironment() {
        String sysPropEnvironmentName = MobileGlobalVar.appiumProperties.getProperty("environment");
        String environmentName = sysPropEnvironmentName != null && sysPropEnvironmentName.length() >= 1 ?
                sysPropEnvironmentName : "beta";
        return environmentName;
    }

    public static void initializeMailingList() {
        String mailProperties = MobileGlobalVar.projectName + "_Mail.properties";
        MobileGlobalVar.mailingProperty = PropertyListeners.loadProjectProperties(
                ClassLoader.getSystemResourceAsStream(mailProperties));
        MobileGlobalVar.failMail = mailingProperty.getProperty("failMail");
        MobileGlobalVar.ccMail = mailingProperty.getProperty("ccMail");
        MobileGlobalVar.passMail = mailingProperty.getProperty("passMail");
        MobileGlobalVar.mail = mailingProperty.getProperty("mail");
    }


    public static void initializeMobileGlobalVariables() {
        System.out.println("Main Branch");
        MobileGlobalVar.mobileProperty = PropertyListeners
                .loadProjectProperties(ClassLoader.getSystemResourceAsStream("Mobile.properties"));
	        MobileGlobalVar.projectName = getProjectName();
        ProjectProperties.setProjectProperties(
                ClassLoader.getSystemResourceAsStream(MobileGlobalVar.projectName + ".properties"));
        MobileGlobalVar.projectProperty = PropertyListeners.loadProjectProperties(
                ClassLoader.getSystemResourceAsStream(MobileGlobalVar.projectName + ".properties"));
	        MobileGlobalVar.environment = getProjectEnvironment();
        MobileGlobalVar.reportName = getProjectReportName();
        MobileGlobalVar.testCaseFileName = getTestCaseFileName();
        MobileGlobalVar.testCaseDataJsonPath = System.getProperty("TestCaseDataJsonPath");
//	        MobileGlobalVar.testCasesToRun = getTestCasesToRunFromSystemProperties();
	        String cucumberFlag = MobileGlobalVar.appiumProperties.getProperty("cucumber");
	        if(cucumberFlag == null || !cucumberFlag.equalsIgnoreCase("y") ){
	            if (MobileGlobalVar.testCaseDataJsonPath != null) {
	                TestCaseData.setProjectTestCaseData(MobileGlobalVar.testCaseDataJsonPath);
	            } else {
	                TestCaseData
                        .setProjectTestCaseData(ClassLoader.getSystemResourceAsStream(MobileGlobalVar.testCaseFileName));
	            }
	        }
	        if (MobileGlobalVar.projectProperty.getProperty("sendMail") == null) {
                MobileGlobalVar.sendMail = "true";
	        } else {
                MobileGlobalVar.sendMail = MobileGlobalVar.projectProperty.getProperty("sendMail");
	        }
    //    MobileGlobalVar.reportLocation = getReportLocation();
	        initializeMailingList();
	    }

    }
