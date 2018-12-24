package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_91_CancelReason_CBBReport extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Reports Menu The following menus are under the
	 * Reports tab: Accounting, Circuits, Customers,Devices, Engineering,
	 * Finance, Inventory, IPs, Monitoring, Numbers, Operations,Service\r\n" +
	 * delivery, Reconciliation, Sales, Tickets Under the Accounting Menu, click
	 * on the Cancelled Before Billing submenu
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_91_CancelReason_CBBReport(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from-Testdata.xlsx

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];

		// * logger method for report starting from here
		logger = extent.startTest("1.91 Test ID : 16005 - ZEUS-PM-36 Cancel Reason Dropdown iin CBB Report").assignCategory("Reports");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Reports Menu The following menus are under the Reports tab: Accounting, Circuits, Customers,Devices, Engineering, Finance, Inventory, IPs, Monitoring, Numbers, Operations,Service\r\n"
				+ "delivery, Reconciliation, Sales, Tickets Under the Accounting Menu, click on the Cancelled Before Billing submenu");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(reports, 300);
		aactionsClick(reports, "Reports");
		aJSClick(reports_accounting, "Reports-Accounting");
		aJSClick(reports_accounting_cancelledBeforeBilling,
				"reports-accounting-cancelledBeforeBilling");
		waitForElementPresent(
				reports_accounting_cancelledBeforeBilling_cancelReasonDD, 200);
		aactionsClick(reports_accounting_cancelledBeforeBilling_cancelReasonDD,
				"cancelledBeforeBilling-cancelReason-DropDown");
		logPass("Cancel Reason Code has list of options to select");

		// * Below method written to logout application
		logOut();
	}
}
