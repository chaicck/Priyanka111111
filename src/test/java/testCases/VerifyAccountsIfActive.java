package testCases;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.*;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;

import java.util.List;

import static demo.objectrepository.OR_SearchPage.noOfRows;
import static demo.objectrepository.OR_SearchPage.srchTxt;

public class VerifyAccountsIfActive extends CommonReusables
		implements OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC, OR_Inventory {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/18/2018}
	 */

	/**
	 * TestCase Description:Verify Billing Invoice page and should able to click
	 * on Export
	 */

	@Test(alwaysRun = true, enabled = true)
	public void verifyAccountsIfActive(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file
		// -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];

		// * logger method for report starting from here
		logger = extent.startTest("Verify Account links when Active");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify Billing Invoice page and should able to click on Export");
		// * Below Code written to verify login
		login(zUserName, zPassword);
//		click(srchDd, "Search");
		type(srchTxt, "vienna", "Search box");
		type(srchTxt, "Search box", Keys.ENTER);
		isassert = VerifyAccountBillingStatus(noOfRows, "NoOfRows");
		softassert.assertEquals(isassert, true);
		
		// Below method writtent to do logout from application
		logOut();
	}
}
