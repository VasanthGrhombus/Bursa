package com.webapp.tests;


import com.webapp.helpers.TestCaseClass;
import com.automation.core.testng.BaseTest;
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

	
	
}
