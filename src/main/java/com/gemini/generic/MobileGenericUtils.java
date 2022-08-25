package com.gemini.generic;

//import com.gemini.listners.PropertyListeners;

public class MobileGenericUtils extends MobileGlobalVar{
	
	 public static String getPlatformName() {
	        String platformName = MobileGlobalVar.appiumProperties.getProperty("platformName");
//	        String platformNameFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("platformName");
        String platform = platformName != null ? platformName : "Android";
	        return platformName;
	    }
	    
	    public static String getdeviceName() {
	   // 	System.out.println(System.getProperties());
	        String deviceName =  MobileGlobalVar.appiumProperties.getProperty("deviceName");
	        System.out.println(deviceName);
//	        String deviceNameFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("deviceName");
//	        String device = deviceName != null ? deviceName
//	                : deviceNameFromPropertiesFile != null ? deviceNameFromPropertiesFile : "Android Emulator";
	        return deviceName;
	    }
	    
	    public static String getplatformVersion() {
	        String platformVersion =  MobileGlobalVar.appiumProperties.getProperty("platformVersion");
//	        String platformVersionFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("platformVersion");
//	        String platform1 = platformVersion != null ? platformVersion
//	                : platformVersionFromPropertiesFile != null ? platformVersionFromPropertiesFile : "10.0";
	        return platformVersion;
	    }
	    
	    public static String getapp() {
	    	System.out.println(System.getProperties());
	        String app =  MobileGlobalVar.appiumProperties.getProperty("app");
	        
//	        String appFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("app");
//	        String app1 = app != null ? app
//	                : appFromPropertiesFile != null ? appFromPropertiesFile : "user.dir";
	        return app;
	    
	    }
	    
	    public static String getudid() {
	        String app =  MobileGlobalVar.appiumProperties.getProperty("udid");
//	        String udidFromPropertiesFile = MobileGlobalVar.projectProperty.getProperty("udid");
//	        String udid1 = udid != null ? udid
//	                : udidFromPropertiesFile != null ? udidFromPropertiesFile : "192.168.157.102:5555";
	        return udid;
	        
	    }
	    
	    public static String getProjectName() {
	        try {
	            String sysPropProjectName = System.getProperty("projectName");
	            String mavenProjectName = MobileGlobalVar.projectProperty.getProperty("artifactId");
	            String projectName = sysPropProjectName != null ? sysPropProjectName
	                    : mavenProjectName != null ? mavenProjectName : null;
	            return projectName;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    public static String getProjectReportName() {
	        String sysPropReportName = System.getProperty("reportName");
	        String reportNameFromPropFiles = MobileGlobalVar.projectProperty.getProperty("reportName");
	        String reportName = sysPropReportName != null ? sysPropReportName
	                : reportNameFromPropFiles != null ? reportNameFromPropFiles
	                : MobileGlobalVar.projectName + " Test report";
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
	    
	    public static void initializeQuanticGlobalVariables() {
	        System.out.println("Main Branch");
	        MobileGlobalVar.mobileProperty = PropertyListeners
	                .loadProjectProperties(ClassLoader.getSystemResourceAsStream("Mobile.properties"));
//	        MobileGlobalVar.projectName = getProjectName();
	        ProjectProperties.setProjectProperties(
	                ClassLoader.getSystemResourceAsStream(MobileGlobalVar.projectName + ".properties"));
	        MobileGlobalVar.projectProperty = PropertyListeners.loadProjectProperties(
	                ClassLoader.getSystemResourceAsStream(MobileGlobalVar.projectName + ".properties"));
//	        QuanticGlobalVar.environment = getProjectEnvironment();
	        MobileGlobalVar.reportName = getProjectReportName();
	        MobileGlobalVar.testCaseFileName = getTestCaseFileName();
	        MobileGlobalVar.testCaseDataJsonPath = System.getProperty("TestCaseDataJsonPath");
//	        MobileGlobalVar.testCasesToRun = getTestCasesToRunFromSystemProperties();
//	        MobileGlobalVar.browserInTest = getBrowserToTest();
//	        String cucumberFlag = QuanticGlobalVar.quanticProperty.getProperty("cucumber");
//	        if(cucumberFlag == null || !cucumberFlag.equalsIgnoreCase("y") ){
//	            if (QuanticGlobalVar.testCaseDataJsonPath != null) {
//	                TestCaseData.setProjectTestCaseData(QuanticGlobalVar.testCaseDataJsonPath);
//	            } else {
//	                TestCaseData
//	                        .setProjectTestCaseData(ClassLoader.getSystemResourceAsStream(QuanticGlobalVar.testCaseFileName));
//	            }
//	        }
//	        if (QuanticGlobalVar.projectProperty.getProperty("sendMail") == null) {
//	            QuanticGlobalVar.sendMail = "true";
//	        } else {
//	            QuanticGlobalVar.sendMail = QuanticGlobalVar.projectProperty.getProperty("sendMail");
//	        }
//	        QuanticGlobalVar.reportLocation = getReportLocation();
//	        initializeMailingList();
//	    }

}
}