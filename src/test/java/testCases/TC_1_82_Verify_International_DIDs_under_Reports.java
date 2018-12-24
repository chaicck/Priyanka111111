package testCases;

import java.util.Set;

import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_82_Verify_International_DIDs_under_Reports extends
		MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description: Go to reports then hover on numbers and select on
	 * 'International DID Report page should load and verify the fields
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tc_1_82_Verify_International_DIDs_under_Reports(
			ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String listTexts1 = getTestData(this.getClass().getSimpleName()
				.substring(0, 5), 1);
		String containsTxt2 = getTestData(this.getClass().getSimpleName()
				.substring(0, 5), 2);
		String containsTxt3 = getTestData(this.getClass().getSimpleName()
				.substring(0, 5), 3);
		String containsTxt4 = getTestData(this.getClass().getSimpleName()
				.substring(0, 5), 4);
		String containsTxt5 = getTestData(this.getClass().getSimpleName()
				.substring(0, 5), 5);

		// * logger method for report starting from here
		logger = extent
				.startTest(
						"1.82 Test ID : 16858 - Verify there must be a new report called International DIDs under the Reports section")
				.assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Go to reports then hover on numbers and select on 'International DID Report page should load and verify the fields");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(reports, 300);
		
		actionsClick(reports, "Reports");
		mouseHoverMove(report_number, "Reports-Number",report_number_international_DID_Report,"'International-DID-Report'");
		waitForElementPresent(International_DIDs_TableHeaders, 300);

		isassert = verifyAllListValuesInOrder(International_DIDs_TableHeaders,
				AddElementsIntoList(listTexts1));
		softassert.assertEquals(isassert, true,
				"Verify International table header lists");

		logPass("Verified 'International_DIDs_TableHeaders' as Customer Name, International DID, State");
		System.out
				.println(getAllTheTextIntoSet(International_DIDs_Table_stateValues));
		Set<String> s = getAllTheTextIntoSet(International_DIDs_Table_stateValues);
		for (String string : s) {
			softassert.assertTrue(string.contains(containsTxt2)
					|| string.contains(containsTxt3)
					|| string.contains(containsTxt4)
					|| string.contains(containsTxt5));
		}

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
