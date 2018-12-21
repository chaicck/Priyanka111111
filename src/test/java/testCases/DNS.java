package testCases;

import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_AddDNS;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_DNSRecords;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class DNS extends CommonReusables implements OR_AddDNS, OR_DNSRecords,
		OR_SearchPage, OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description::Add, Delete and modify DNS on an account
	 */

	@Test(alwaysRun = true, enabled = true)
	public void data_Dns_Add_Edit_Delete(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String id = getTestData(this.getClass().getSimpleName().substring(0, 3), 1);
		String dnsAssert = getTestData(this.getClass().getSimpleName().substring(0, 3), 2);
		String hosttxt1 = getTestData(this.getClass().getSimpleName().substring(0, 3), 3);
		String hosttxt2 = getTestData(this.getClass().getSimpleName().substring(0, 3), 4);
		String hosttxt3 = getTestData(this.getClass().getSimpleName().substring(0, 3), 5);
		String hosttxt4 = getTestData(this.getClass().getSimpleName().substring(0, 3), 6);
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		// * logger method for report starting from here
        logger = extent.startTest("Add DNS");
		logInfo("Currently Running on -- " + getCurrentUrl());
		System.out.println("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description::Add, Delete and modify DNS on an account");
		System.out.println("TestCase Description::Add, Delete and modify DNS on an account");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		// * Search for customerID in search box
		type(srchTxt, id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);
		waitForElementPresent(dataLnk, 300);
		
		// Customer-Data-DNS performs a click operation, and optionally waits for a new page to load.
		click(dataLnk, "Data ");
		click(dnsLnk, "DNS ");
		waitForElementPresent(firstDeleteLnk, 300);
		// Below click method will delete the icon
		click(firstDeleteLnk, "Delete DNS");
		Thread.sleep(8000);
		softassert.assertTrue(isAlertPresent());
		dismissAlert();
		waitForElementPresent(viewOrEdit, 300);
		click(viewOrEdit, "View Or Edit DNS");
		Thread.sleep(8000);
		softassert.assertTrue(Driver.getCurrentUrl().toLowerCase().contains(dnsAssert));
		Driver.navigate().back();
		waitForElementPresent(addDnsEntryLnk, 300);
		click(addDnsEntryLnk, "Add DNS Entry");
		String name = hosttxt1 + generateRandomString(5);
		waitForElementPresent(dnsNameTxt, 300);
		type(dnsNameTxt, name, "Name");
		type(hostTxt, hosttxt2 + "." + randomNum(3) + "." + hosttxt3 + "."
				+ randomNum(3), hosttxt4);
		waitForElementPresent(addBtn, 300);
		click(addBtn, "Add button");
		Thread.sleep(9000);
		
		// Below line will verify records added in table
		isassert = verifyDNSRecordIsAdded(name);
		softassert.assertEquals(isassert, true);
		// * Below method written to logout application
		logOutt();
		softassert.assertAll();


	}
}
