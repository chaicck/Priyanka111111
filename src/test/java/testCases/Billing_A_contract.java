
package testCases;

import demo.businesslogic.MediatorClass;
import utils.AssertSoftly;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.MediatorClass;

public class Billing_A_contract extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/** TestCase Description:Verify Billing Contract DropDown */

	@Test(alwaysRun = true, enabled = true)
	public void billing_contract(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
        String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1); 
        String customers = getTestData(this.getClass().getSimpleName().substring(0, 8), 3); 
		AssertSoftly softassert = new AssertSoftly();
		
		// * logger method for report starting from here
        logger = extent.startTest("Billing Contracts DropDown Verify").assignCategory("Billing");
		logInfo("Currently Running on -- " + getCurrentUrl());
		System.out.println("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify Billing Contract DropDown");

		// * Below Code written to verify login
		login(zUserName, zPassword);

       //  * Search for customerID in search box
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		
        // verifies expected text and its corresponding HTML tag are present on this page.
        isassert = verifyText(customer_dashboard_name, customers, "Customer Name");
		softassert.assertEquals(isassert, true);
		
		logInfo("User navigated to Customer Dashboard");
		System.out.println("Usernavigated to Customer Dashboard");
		JSClick(Billing, "Billing");
		Thread.sleep(2000);
		mouseHoverClick(Billing_contract, "Billing_contract");
		Thread.sleep(2000);
		isassert = clickIfclickable(Billing_contract_list, "Billing_contract_list");
		softassert.assertEquals(isassert, true, "Verify billing contract list submenu in billing contract");
		Thread.sleep(2000);
		
        actionsClick(Billing, "Billing");
		Thread.sleep(2000);
		mouseHoverClick(Billing_contract, "Billing_contract");
		Thread.sleep(2000);
		isassert = clickIfclickable(Billing_contract_summary, "Billing_contract_summary");
		softassert.assertEquals(isassert, true, "Verify billing contract summary submenu in billing contract");
		Thread.sleep(2000);
		
        JSClick(Billing, "Billing");
		Thread.sleep(2000);
		mouseHoverClick(Billing_contract, "Billing_contract");
		Thread.sleep(2000);
		isassert = clickIfclickable(Billing_contract_timeline, "Billing_contract_timeline");
		softassert.assertEquals(isassert, true, "Verify billing contract timeline submenu in billing contract");
		Thread.sleep(2000);
		// * Below method written to logout application
		logOut();
        softassert.assertAll();

	}
}