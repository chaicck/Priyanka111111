package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class TC_1_18_MacProject extends CommonReusables implements OR_HomePage,
		OR_CustInfo, OR_ProjectManager, OR_NewMAC, OR_SearchPage {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description: Go to customer dashboard page select Add MAC then
	 * verify and Push to Billing button
	 */

	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void addMac(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();
		String id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String searchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String customerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String customerTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String testText1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String testText2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String callRecording = getTestData(this.getClass().getSimpleName().substring(0, 8), 7);
		String requestInstallDate = getTestData(this.getClass().getSimpleName().substring(0, 8), 8);

		// * logger method for report starting from here
		logger = extent
				.startTest("1.18 Test ID : 19758 - Premier GET - 302_Add service on existing customer via MAC and Project");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Go to customer dashboard page select Add MAC then verify and  Push to Billing button");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Search for customerID in search box
		type(searchTextBox, id, "Search Box");
		type(searchTextBox, searchTxt, Keys.ENTER);
		Thread.sleep(6000);
		if (verifyElementText(customerTableHeadline, customerTxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, id);
		}
		
		isassert = verifyText(customer_dashboard_name, customerTxt2,"Customer Name");
		softassert.assertEquals(isassert, true, "Verify Customer Name");

		logInfo("User navigated to Customer Dashboard");
		waitForElementPresent(addMacLink, 300);
		scrollElementIntoView(addMacLink);
		click(addMacLink, "Add New MAC button");
		navigateToChild();
		waitForElementPresent(nameTxt, 300);
		type(nameTxt, "Test", "Name");
		waitForElementPresent(requestedInstallDateTxt, 300);
		type(requestedInstallDateTxt, tomorrowDate(), requestInstallDate);
		waitForElementPresent(tktIdTxt, 300);
		type(tktIdTxt, testText1, "Ticket");
		type(notesTxt, testText2, "Notes");
		waitForElementPresent(authorizedBySelect, 300);
		selectDropDownByIndex(authorizedBySelect, 1);
		selectDropDownByIndex(assignedToSelect, 1);
		waitForElementPresent(addNewProdBtn, 300);
		click(addNewProdBtn, "Add New Product");
		scrollElementIntoView(prodTxt);
		waitForElementPresent(prodTxt, 300);
		type(prodTxt, callRecording, "Product");
		Thread.sleep(2000);
		waitForElementPresent(prodDropDown, 300);
		click(prodDropDown, "Product List");
		waitForElementPresent(macSaveBtn, 300);
		click(macSaveBtn, "Save button");

		// * Below method written to do logout from application
		logOut();
		softassert.assertAll();
	}
}
