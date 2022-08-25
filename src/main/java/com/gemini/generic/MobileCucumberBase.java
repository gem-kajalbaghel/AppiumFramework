package com.gemini.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.BeforeSuite;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class MobileCucumberBase extends MobileAction {
	

	@BeforeSuite
	public void beforeSuite() {
		MobileGlobalVar.mobileProperty = PropertyListeners
				.loadProjectProperties(ClassLoader.getSystemResourceAsStream("mobile.properties"));
		setCucumberProperties();
		try {
			androidInitialisation();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setCucumberProperties() {

		try {
			String stepDefinitionPackages = MobileGlobalVar.mobileProperty.getProperty("glueCode");
			System.setProperty("cucumber.glue", "com.gemini.generic," + stepDefinitionPackages);
			System.setProperty("cucumber.features",
					new File(ClassLoader.getSystemResource("features").toURI()).getAbsolutePath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@BeforeAll
//	public static void before_all() {
//		MobileGenericUtils.initializeMobileGlobalVar();
////		ProjectApiUrl.initializeApiUrl();
////		ProjectSampleJson.loadSampleJson();
//		GemTestReporter.startSuite(QuanticGlobalVar.projectName, QuanticGlobalVar.environment);
//	}
//
//	@Before
//	public void before(Scenario scenario) {
//		String testcaseName = scenario.getName();
//		String featureFileName = new File(scenario.getUri()).getName();
////		DriverManager.initializeBrowser(QuanticGlobalVar.browserInTest);
////		DriverAction.maximizeBrowser();
////		DriverAction.setImplicitTimeOut(Long.parseLong(ProjectProperties.getProperty("browserTimeOut")));
////		DriverAction.setPageLoadTimeOut(Long.parseLong(ProjectProperties.getProperty("browserTimeOut")));
////		DriverAction.launchUrl(ProjectProperties.getProperty("baseURL"));
//		GemTestReporter.startTestCase(testcaseName, featureFileName.substring(0, featureFileName.lastIndexOf('.')),
//				false);
//	}


	@BeforeStep
	public void before_step(Scenario scenario){
		System.out.println(scenario.getId());
	}

	@AfterStep
	public void afterStep() {

	}

//	@After
//	public void after(Scenario scenario) {
//		DriverManager.closeDriver();
//		GemTestReporter.endTestCase();
//	}

//	@AfterAll
//	public static void after_all()  {
//		GemTestReporter.endSuite();
//	}


}
