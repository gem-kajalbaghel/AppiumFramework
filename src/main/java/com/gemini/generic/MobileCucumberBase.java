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
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class MobileCucumberBase  extends AbstractTestNGCucumberTests  {
	

	@BeforeSuite
	public void beforeSuite() {
		MobileGlobalVar.mobileProperty = PropertyListeners
				.loadProjectProperties(ClassLoader.getSystemResourceAsStream("mobile.properties"));
		setCucumberProperties();
		
		
		
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

	@BeforeAll
	public static void before_all() throws FileNotFoundException, IOException {

//		MobileGenericUtils.initializeMobileGlobalVar();
//		ProjectApiUrl.initializeApiUrl();
//		ProjectSampleJson.loadSampleJson();
//		GemTestReporter.startSuite(QuanticGlobalVar.projectName, QuanticGlobalVar.environment);
		
	//	MobileDriverManager.androidInitialisation();
	}

	@Before
	public void before(Scenario scenario) throws FileNotFoundException, IOException {
		MobileDriverManager.androidInitialisation();
//		MobileDriverManager.androidInitialisation();	}
//		String testcaseName = scenario.getName();
//		String featureFileName = new File(scenario.getUri()).getName();
////		DriverManager.initializeBrowser(QuanticGlobalVar.browserInTest);
////		DriverAction.maximizeBrowser();
////		DriverAction.setImplicitTimeOut(Long.parseLong(ProjectProperties.getProperty("browserTimeOut")));
////		DriverAction.setPageLoadTimeOut(Long.parseLong(ProjectProperties.getProperty("browserTimeOut")));
////		DriverAction.launchUrl(ProjectProperties.getProperty("baseURL"));
//		GemTestReporter.startTestCase(testcaseName, featureFileName.substring(0, featureFileName.lastIndexOf('.')),
//				false);
	}


	@BeforeStep
	public void before_step(Scenario scenario){
	
		System.out.println(scenario.getId());
	}

	@AfterStep
	public void afterStep() {

	}

	@After
	public void after(Scenario scenario) {
		MobileDriverManager.closeDriver();
	//	GemTestReporter.endTestCase();
	}

//	@AfterAll
//	public static void after_all()  {
//		GemTestReporter.endSuite();
//	}


}
