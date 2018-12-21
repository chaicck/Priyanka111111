package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class EditMACInventoryPage extends CommonReusables
		implements OR_SearchPage, OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/18/2018}
	 */

	/**
	 * TestCAse Description:Verify Billing Invenroty Page
	 */

	@Test(alwaysRun = true, enabled = true)

	public void editMACInventoryPage(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file
		// -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String searchName = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		String searchBox = getTestData(this.getClass().getSimpleName().substring(0, 5), 2);

		// * logger method for report starting from here
		logger = extent.startTest("Verify Edit MAC Inventory Page");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCAse Description:Verify Billing Invenroty Page");

		// * Below Code written to verify login
		login(zUserName, zPassword);


		type(srchTxt, searchName, "Search box");
		type(srchTxt, searchBox, Keys.ENTER);
		selectBillingAndAccStatusActiveAndIventory(noOfRows);
		logOut();

	}
}
