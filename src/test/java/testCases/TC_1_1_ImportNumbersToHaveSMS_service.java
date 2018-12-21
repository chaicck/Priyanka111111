package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.MediatorClass;

public class TC_1_1_ImportNumbersToHaveSMS_service extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description: Go to Admin and mouse hover on Nexmo then select Manage
	 * Premier Central Numbers and Import number Range and list,now Verify imported
	 * number and delete and Hit the Export button
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_1_ImportNumbersToHaveSMS_service(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
        String phoneNumber1 = randomNum(10);
		String phoneNumber2 = randomNum(10);
		String premierCentralNum = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String deletedMsg = getTestData(this.getClass().getSimpleName().substring(0, 8), 2); 
        String phoneNumber3 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3); 
		String phoneNumber4 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4); 
		String phoneNumber5 = getTestData(this.getClass().getSimpleName().substring(0, 8), 5); 
		String phoneNumber6 = getTestData(this.getClass().getSimpleName().substring(0, 8), 6); 
        
        
		// * logger method for report starting from here
        logger = extent.startTest("Import Nexmo mange premier central number, veify imported numbers and delete").assignCategory("Admin");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Go to Admin and mouse hover on Nexmo then select Mangage Premier Central Numbers and Import number Range and list,now Verify imported number and delete and Hit the Export button");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		// * Below method return to verify Premier Central Numbers text page
		isassert = verifyPremierCentralNumber(adminLInk, nexmo_gdm, nexmo_gdm_managePremierCentralNo,
				engineering_subMenu_headLine, premierCentralNum);
		softassert.assertEquals(isassert, true);
		if (getCurrentUrl().contains("qa6"))
			actionsClick(admin_nexmo_managePremier_import, "Import Numbers");
		if (getCurrentUrl().contains("qa5"))
			actionsClick(admin_nexmo_managePremier_importQA5, "Import Number");
		waitForElementPresent(admin_nexmo_managePremier_import_numberList, 20);
		actionsClick(admin_nexmo_managePremier_import_numberList, "Premier Central Numbers Import- Number List");
		Thread.sleep(1000);
		type(admin_nexmo_managePremier_import_numberList_numberEntry, (phoneNumber1 + "," + phoneNumber2),"Enter Number");
		
		// * performs a click operation, and optionally waits for a new page to load.
		actionsClick(admin_nexmo_managePremier_import_numberList_saveBtn,"Save");
		waitForElementPresent(engineering_subMenu_headLine, 20);
		
		// * below lines for data search functionality & delete functionality
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,phoneNumber1, deletedMsg);
		softassert.assertEquals(isassert, true);
		
		// * below lines for deleting 2nd phone number
		refreshBrowser();
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,
		admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,phoneNumber2, deletedMsg);
		softassert.assertEquals(isassert, true);
		logPass("Successfully deleted the numbers imported through NUMBER LIST with ',' functionality");
		System.out.println("Successfully deleted the numbers imported through NUMBER LIST with ',' functionality");

		// * below lines for verifying Number Range import functionality..
		if (getCurrentUrl().contains("qa6"))
			actionsClick(admin_nexmo_managePremier_import, "Import Number");
		if (getCurrentUrl().contains("qa5"))
			actionsClick(admin_nexmo_managePremier_importQA5, "Import Number");

		waitForElementPresent(admin_nexmo_managePremier_import_numberList, 20);
		actionsClick(admin_nexmo_managePremier_import_numberRange, "Premier Central Numbers Import- Number Range");
		Thread.sleep(2000);

		type(admin_nexmo_managePremier_import_numberRange_startNo, phoneNumber3, "Start Number");
		type(admin_nexmo_managePremier_import_numberRange_endNo, phoneNumber6, "End Number");

		logInfo("importing numbers from " + phoneNumber3 + " to " + phoneNumber6);
		actionsClick(admin_nexmo_managePremier_import_numberList_saveBtn);
		waitForElementPresent(engineering_subMenu_headLine, 20);
		logPass("Numbers added successfully from " + phoneNumber3 + " to " + phoneNumber6);
		System.out.println("Numbers added successfully from " + phoneNumber3 + " to " + phoneNumber6);

		logInfo("Deleting the added numbers...");
		System.out.println("Deleting the added numbers...");

		// * below lines written to delete and verify delete message
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,
				admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,
				phoneNumber3, deletedMsg);
		softassert.assertEquals(isassert, true);
		refreshBrowser();
		// * below lines written to delete and verify delete message
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,
				admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,
				phoneNumber4, deletedMsg);
		softassert.assertEquals(isassert, true);
		refreshBrowser();
		// * below lines written to delete and verify delete message
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,
				admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,
				phoneNumber5, deletedMsg);
		softassert.assertEquals(isassert, true);
		refreshBrowser();
		// * below lines written to delete and verify delete message
		isassert = deleteNumber(admin_nexmo_managePremier_search, admin_nexmo_managePremier_table_numbers,
				admin_nexmo_managePremier_table_delete_parametarised, admin_nexmo_managePremier_successMsg,
				phoneNumber6, deletedMsg);
		softassert.assertEquals(isassert, true);
		refreshBrowser();
		softassert.assertEquals(isassert, true);
		// * below lines written to verify export button is available in page after deleting 
		isassert = verifyIsExportButtonDisplayed(admin_nexmo_managePremier_export);
		logPass("Successfully deleted the numbers imported through NUMBER RANGE functionality");
		System.out.println("Successfully deleted the numbers imported through NUMBER RANGE functionality");
		// * Below method written to logout application
		logOut();
		softassert.assertAll();
		
	}

}
