package testCases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_80_Verify2NewGroupsUnderGroups_TicketPage extends
		MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * "TestCase Description:Go to ticekts Queue in main menu Test that two new groups under 'Groups' on the 'Tickets'  "
	 * list: 'Group – Broadsoft TS' and 'Group – Broadsoft SS' and Verified if
	 * user is able to sort the results by clicking on column titles
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tC_1_80_Verify2NewGroupsUnderGroups_TicketPage(
			ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file -
		// LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent
				.startTest(
						"1.80 Test ID : 16691 - Verify that there must be two new groups under Groups on the tickets page")
				.assignCategory("Ticket");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to ticekts Queue in main menu Test that two new groups under 'Groups' on the 'Tickets'  "
				+ "list: 'Group – Broadsoft TS' and 'Group – Broadsoft SS'  and Verified if user is able to sort the results by clicking on column titles");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(ticketsMenu, 300);
		JSClick(ticketsMenu, "Tickets-Menu");
		waitForElementPresent(tickets_groupsMenu, 200);
		scrollElementIntoView(tickets_group_BroadSoft_SS);
		JSClick(tickets_group_BroadSoft_SS, "Tickets-GroupBroadSoft_SS");
		// verifying headers
		waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
		scrollElementIntoView(tickets_group_BroadSoftTableColumnHeaders);

		scrollUp();
		Thread.sleep(9000);
		List<String> list = getAllTheText(tickets_group_BroadSoftTableTicketIds);
		System.out.println("list-" + list);
		Collections.sort(list);
		System.out.println("List after sorting by complaier ascending order "
				+ list);
		Collections.reverse(list);
		scrollUp();
		waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
		actionsClick(tickets_group_BroadSoftTableColumnHeaders,
				"BroadSoftTable-ColumnTitle");
		Thread.sleep(10000);
		List<String> list_sorted = getAllTheText(tickets_group_BroadSoftTableTicketIds);
		System.out.println("list-sorted-java" + list);
		System.out.println("list-sorted-application" + list_sorted);
		logInfo("Verifying sort functionality by clicking on BroadSoftTable-ColumnTitle");
		System.out.println(list.equals(list_sorted));
		Thread.sleep(15000);
		softassert
				.assertTrue(list.equals(list_sorted), "Verify is list sorted");

		isassert = verifyAllListValuesInOrder(
				tickets_group_BroadSoftTableColumnHeaders,
				AddElementsIntoList("ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update"));
		softassert.assertEquals(isassert, true,
				"Verified ticket group broad soft tables lists 1");

		scrollElementIntoView(tickets_group_BroadSoft_TS);
		JSClick(tickets_group_BroadSoft_TS, "tickets_group_BroadSoft_TS");
		waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
		scrollUp();
		scrollElementIntoView(tickets_group_BroadSoftTableColumnHeaders);

		isassert = verifyAllListValuesInOrder(
				tickets_group_BroadSoftTableColumnHeaders,
				AddElementsIntoList("ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update"));
		softassert.assertEquals(isassert, true,
				"Verified ticket group broad soft tables lists 2");

		logInfo("Verified the table Headers - ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}
}
