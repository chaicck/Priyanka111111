package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class Faxmail extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description:: Faxmail
	 */

	@Test(alwaysRun = true, enabled = true)
	public void customer_Search(ITestContext context) throws Throwable {

		// * Below variables written to get input data from
		// LogingCredentails.properties

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		String customer_Name = getTestData(this.getClass().getSimpleName().substring(0, 5), 2);
		String faxMail = getTestData(this.getClass().getSimpleName().substring(0, 5), 3);
		
		// * Below Code written to verify login
		logger = extent.startTest("Faxmail").assignCategory("Faxmail");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:: Fax Mail");
		System.out.println("TestCase Description:: Faxmail");

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, customer_id, Keys.ENTER);
		
		isassert =verifyText(Customer_Dashboardverify, customer_Name,"Customer Name");
		softassert.assertEquals(isassert, true);
		
		click(voiceLnk, "Voice Link");
		click(faxmail_btn, "fax  mail");
		isassert = verifyText(Verifytext_faxmail_user, faxMail,"verified faxmial header");
		softassert.assertEquals(isassert, true, "Verify Fax mail headers");

		isassert = verifyText(Verify_faxmail_table, "", "");
		softassert.assertEquals(isassert, true, "Verify fax Mail table");
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
