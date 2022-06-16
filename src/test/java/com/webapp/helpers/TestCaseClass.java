package com.webapp.helpers;

import com.automation.core.config.ProjectConfig;
import com.automation.core.utils.data.ExcelDataReader;
import com.webapp.pages.*;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

//import junit.framework.Assert;

import org.testng.Assert;

public class TestCaseClass {

	public static void sortOnChangeColumn(WebDriver driver) {
		driver.navigate().to(ProjectConfig.getPropertyValue("BursaURL"));
		Assert.assertTrue(EquityPricePage.sortEquityprices());

	}

	public static void registrationValidation(WebDriver driver, String testCaseID, String dataSheet) {
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testCaseID, dataSheet);
		driver.navigate().to(ProjectConfig.getPropertyValue("BursaMarketURL"));
		if (testCaseID.contains("TC002")) {
			Assert.assertTrue(RegistrationPage.loginValidation(data));
		}
		if (testCaseID.contains("TC003")) {
			Assert.assertTrue(RegistrationPage.loginValidation(ProjectConfig.getPropertyValue("DispName"),
					ProjectConfig.getPropertyValue("Email"), ProjectConfig.getPropertyValue("Password")));

		}

	}

}
