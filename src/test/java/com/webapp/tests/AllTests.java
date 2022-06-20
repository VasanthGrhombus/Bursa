package com.webapp.tests;


import com.webapp.helpers.TestCaseClass;
import com.automation.core.testng.BaseTest;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AllTests  extends BaseTest {


	@Test(groups = { "P1" }, description = "sorting On Change Column")
	public void equityPriceSorting() throws InterruptedException, IOException {
		TestCaseClass.sortOnChangeColumn(driver);
	}

	@Parameters({ "testCaseID", "dataSheet" })
	@Test(groups = { "P1" }, description = "Registration")
	public void RegistrationModule(String testCaseID, String dataSheet) throws InterruptedException, IOException {

		TestCaseClass.registrationValidation(driver,testCaseID,dataSheet);
	}


	@Test
	public void RegistrationModule_Inject_UserObject() throws InterruptedException, IOException 
	{
		TestConfiguration config = new TestConfiguration();
		Injector injector = Guice.createInjector(config);
		TestImpl test = injector.getInstance(TestImpl.class);
		TestCaseClass.registrationValidation(driver,test.name,test.email,test.pwd);
	}



}
