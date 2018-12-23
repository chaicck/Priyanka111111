package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Go to Queues and then select Engineering ICB queue and Verify that service delivery approved EICBs must display within the EICB Queue
	 */
public class TC_1_77_EICB_Queue extends MediatorClass {

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_77_eICB_Queue(ITestContext context) throws Throwable {
		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String serviceApprovedTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String serviceApprovedTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String rejectedTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String serviceInactiveTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		AssertSoftly softassert = new AssertSoftly();

		 // * logger method for report starting from here
		logger = extent
				.startTest(
						"1.77 Test ID : 18719 - Verify that service delivery approved EICBs must display within the EICB Queue")
				.assignCategory("Queue");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to Queues and then select Engineering ICB queue and Verify that service delivery approved EICBs must display within the EICB Queue");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(Queues, 300);
		JSClick(Queues, "Queues");
		actionsClick(Queues_enganeering_ICB, "Queues_enganeering_ICB");
		waitForElementPresent(Queues_enganeering_ICB_search, 300);
		type(Queues_enganeering_ICB_search, serviceApprovedTxt1,
				"Searched Service Delivery Approved");
		waitForElementPresent(
				Queues_enganeering_ICB_search_servicedeliver_aprproved, 300);

		isassert = verifyText(Queues_enganeering_ICB_search_servicedeliver_aprproved,serviceApprovedTxt2, "searched service-delivery-approved");
		softassert.assertEquals(isassert, true,"Verified serivice deliver approval text "+ serviceApprovedTxt2);

		waitForElementPresent(Queues_enganeering_ICB_search_inactive, 300);
		actionsClick(Queues_enganeering_ICB_search_inactive,"Queues_enganeering_ICB_search_inactive");
		waitForElementPresent(Queues_enganeering_ICB_search_inactive_rejected,300);

		isassert = verifyText(Queues_enganeering_ICB_search_inactive_rejected,rejectedTxt, "rejected");
		softassert.assertEquals(isassert, true,"Verified inactive rejected search text " + rejectedTxt);

		waitForElementPresent(Queues_enganeering_ICB_search, 300);
		type(Queues_enganeering_ICB_search, "Service Delivery Approved","Search Box");
		waitForElementPresent(Queues_enganeering_ICB_search_inactive_result,300);

		isassert = verifyText(Queues_enganeering_ICB_search_inactive_result,serviceInactiveTxt, "Showing 0 to 0 of 0 entries");
		softassert.assertEquals(isassert, true,"Verified inactive result text " + serviceInactiveTxt);

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}
}
