
package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class VerifyInfoFromBroadWorks extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${verifyInfoFromBroadWorks}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description:: Verify BraodWorks Details page
	 */

	@Test(alwaysRun = true, enabled = true)
	public void verifyInfoFromBroadWorks(ITestContext context) throws Throwable {

		// * Below variables written to get input data from
		// LogingCredentails.properties

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String customer_Name = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String url_teles = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String broadWorks = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String groupDetails = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);

		// * Below Code written to verify login
		logger = extent.startTest("Verify BraodWorks Details page").assignCategory("Voice");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description::Verify BraodWorks Details page");
		System.out.println("TestCase Description:: Verify BraodWorks Details page");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, customer_id, Keys.ENTER);
		isassert = verifyText(Customer_Dashboardverify,
				customer_Name, "Customer Name");
		softassert.assertEquals(isassert, true, "Verify customer name");

		// verifying with valid data
		//navigateTo(url_teles);
		// added blow url just to check in QA5, for production i will use above hardcode code line number 60
		navigateTo("https://zeus.qa5.vonagenetworks.net/broadworks/groupDetail/customer_id:39382");
		waitForElementPresent(voice_broadWorks_details_page, 20);
		isassert = verifyText(voice_broadWorks_details_page, "", "Broad work group page verified");
		softassert.assertEquals(isassert, true, "Verify Broadworks Details page successfully loaded for customer with id 39382");


		actionsClick(voice);
		actionsClick(voice_broadWorks);
		actionsClick(voice_broadWorks_details);
		waitForElementPresent(voice_broadWorks_details_page, 300);
		System.out.println(getText(voice_broadWorks_details_page));
		isassert = verifyText(voice_broadWorks_details_page, "", "Broad work Group Detail page verified");
		softassert.assertEquals(isassert, true, "Verify Broadworks - Details page has been loaded successfully");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
