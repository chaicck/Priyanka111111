package testCases;

import static demo.objectrepository.OR_SearchPage.noOfRows;
import static demo.objectrepository.OR_SearchPage.srchTxt;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_5_CustomerDashboard_Data_CDR_Config extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/15/2018}
	 */

	/**
	 * TestCase Description:Go to CustomerDashBoard Select Data and CDR Config then Enable Toggles and Save then Download
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_5_CustomerDashboard_Data_CDR_Config(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String customertxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String textGets = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String textcentrex = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String textRedirction = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String textDeflection = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);

		// * Below lines written initialize extent report
		logger = extent.startTest("1.5 Test ID : 17793 - Customer Dashboard_Data_CDR Config").assignCategory("Data");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to CustomerDashBoard Select Data and CDR Config then Enable Toggels and Save then Download");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		// * Search for customerID in search box
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);

		JSClick(dashBoard_data, "Data");
		JSClick(dashBoard_data_cdr_config, "CDR config");
		Thread.sleep(8000);
		actionsClick(dashBoard_data_cdr_config_fieldsBtn, "Go to Fields");
		type(dashBoard_data_cdr_config_searchBox, textGets," search for text 'gets' in searchBox fields");
		waitForElementPresent(dashBoard_data_cdr_config_table, 300);

		// * Below methods written to verify customer table text(gets)in Description -This field is only present for GETS calls
		verifyText(dashBoard_data_cdr_config_table,textGets,"verified text in Description -This field is only present for GETS calls. If present, its value is Yes");
		logPass("verified text in Description -This field is only present for GETS calls. If present, its value is Yes");
		Thread.sleep(8000);

		clearText(dashBoard_data_cdr_config_searchBox);
		waitForElementPresent(dashBoard_data_cdr_config_searchBox, 300);
		type(dashBoard_data_cdr_config_searchBox, textcentrex," search for text 'Centrex' in searchBox fields");
		waitForElementPresent(dashBoard_data_cdr_config_table, 300);

		// * Below methods written to verify text in Module- Centrex in searchBox fields
		isassert = verifyText(dashBoard_data_cdr_config_table, textcentrex,"verified text in Module- Centrex in searchBox fields");
		logPass("verified text in Module- Centrex");
		softassert.assertEquals(true, isassert, "Verified customer id "+ customertxt + " in customer table");
		Thread.sleep(1000);
		clearText(dashBoard_data_cdr_config_searchBox);
		waitForElementPresent(dashBoard_data_cdr_config_searchBox, 300);
		type(dashBoard_data_cdr_config_searchBox, textRedirction,"search for text 'Redirection Reason for the' in searchBox field");
		waitForElementPresent(dashBoard_data_cdr_config_table, 300);

		// * Below methods written to verify text in Description-'Redirection Reason for the OriginalCalledNumber
		isassert = verifyText(dashBoard_data_cdr_config_table,textRedirction,"Verified text in Description-'Redirection Reason for the OriginalCalledNumber'");
		softassert.assertEquals(true, isassert, "Verified customer id "+ textRedirction + " in customer table");
		logPass("Verified text in Description-'Redirection Reason for the OriginalCalledNumber'");
		Thread.sleep(1000);
		waitForElementPresent(dashBoard_data_cdr_config_searchBox, 300);
		clearText(dashBoard_data_cdr_config_searchBox);
		type(dashBoard_data_cdr_config_searchBox, textDeflection,"search for text 'deflection' in searchBox field");
		waitForElementPresent(dashBoard_data_cdr_config_table, 300);

		// * Below methods written to verify text in Description-'deflection'
		isassert = verifyText(dashBoard_data_cdr_config_table, textDeflection,"Verified text in Description-'deflection'");
		logPass("Verified text in Description-'deflection'");
		softassert.assertEquals(true, isassert, "Verified customer id "+ textDeflection + " in customer table");
		waitForElementPresent(dashBoard_data_cdr_config_checkBoxEnable1, 300);

		actionsClick(dashBoard_data_cdr_config_checkBoxEnable1,"Enable toggles-one");
		actionsClick(dashBoard_data_cdr_config_checkBoxEnable2,"Enable toggles-second");
		// * Checking in summary page
		actionsClick(dashBoard_data_cdr_config_summaryBtn, "Summary");
		Thread.sleep(1000);
		actionsClick(dashBoard_data_cdr_config_summaryBtn_downLoadPreview,"DownLoad Preview");
		Thread.sleep(4000);
		
		// * Below line will verify alert, if yes, it will accept alert
		if (isAlertPresent())
			acceptAlert();

		softassert.assertAll();
		// * Below method written to logout application
		logOutt();

	}
}
