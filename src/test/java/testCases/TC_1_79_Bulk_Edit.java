package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_79_Bulk_Edit extends CommonReusables implements OR_HomePage,
		OR_CustInfo, OR_ProjectManager, OR_NewMAC, OR_Inventory {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description: Any customer Go to Billing Inventory verify user ia
	 * able to click on EditBilke
	 */

	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void bulkEdit(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customerId = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String id1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String id2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);

		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent.startTest("1_79_Verify that there must be a Bulk Edit button on the Inventory page").assignCategory("Billing");
		logInfo("TestCase Description: Any customer Go to Billing Inventory verify user ia able to click on EditBilk");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(searchTextBox, 300);
		click(srchDd, "Search DropDown");
		click(customerLnk, "Customer Link");
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customerId, "searchBox");
		type(searchTextBox, "searchBox", Keys.ENTER);
		Thread.sleep(3000);
		if (isElementDisplayed(String.format(disCustomer, customerId),"Searched Customer")) {
			Thread.sleep(9000);
			click(dashBoardBillingLink, "Billing DropDown");
			click(inventoryLnk, "Inventory Link");
			isassert = isElementDisplayedOrNot(bulkEditBtn, "Bulk Edit");
			softassert.assertEquals(isassert, true,"Verify bulk edit is displayed");

			isassert = isElementDisplayedOrNot(chkBoxForAllEntries, "Bulk Edit");
			softassert.assertEquals(isassert, true,"Verify bulk edit is displayed in all entries");

			waitForElementPresent(bulkEditBtn, 300);
			click(bulkEditBtn, "Bulk Edit");
			Thread.sleep(9000);
			softassert.assertTrue(getAlertText().contains("No items selected"),"Verify no iteams selected text");
			Thread.sleep(9000);
			acceptAlert();
			waitForElementPresent(bulkEditBtn, 300);
			click(bulkEditBtn, "Bulk Edit");
			type(locationId, id1, "Location ID");
			type(ownerId, id2, "Owner ID");
			click(saveBtn, "Save Button");

		}

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
