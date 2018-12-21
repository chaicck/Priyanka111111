package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import demo.businesslogic.MediatorClass;

public class TC_1_92_Task_Calendar extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/15/2018}
	 */

	/** TestCase Description:Projects Tasks Calendar-Ensure that the week view and the list view also show the appropriate tasks */
	
	@Test(alwaysRun = true, enabled = true)
	public void tc_1_92_Task_Calendar(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		SoftAssert softassert = new SoftAssert();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String voiceBuild = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String voiceInstall = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);

		// * Below lines written o initialize extent report
		logger = extent.startTest("Task Calendar").assignCategory("Projects");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Projects Tasks Calendar-Ensure that the week view and the list view also show the appropriate tasks");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(projectmenu, 300);
		JSClick(projectmenu, "Projects");
		click(Reports_tasks_Calander, "Tasks Calendar");
		waitForElementPresent(Reports_tasks_CalanderViews_DD, 200);
		waitForElementPresent(Reports_tasks_date, 300);
		
		// * Below methods written to verify calendar views

		isassert = verifyText(Reports_tasks_date,
				dateAftersomeDays(0, "MMMM d, yyy"), "");
		softassert.assertEquals(isassert, true);
		isassert = verifyDropDownValue(Reports_tasks_CalanderViews_DD,
				voiceBuild);
		softassert.assertEquals(isassert, true);
		isassert = verifyDropDownValue(Reports_tasks_CalanderViews_DD,
				voiceInstall);
		softassert.assertEquals(isassert, true);

		selectDropDownByValue(Reports_tasks_CalanderViews_DD, voiceBuild);
		waitForElementPresent(Reports_tasks_CalanderWeek, 300);
		actionsClick(Reports_tasks_CalanderWeek, "Reports_tasks_CalanderWeek");
		Thread.sleep(5000);
		waitForElementPresent(Reports_tasks_CalanderDay, 300);
		actionsClick(Reports_tasks_CalanderDay, "Reports_tasks_CalanderDay");
		Thread.sleep(5000);
		waitForElementPresent(Reports_tasks_CalanderMonth, 300);
		actionsClick(Reports_tasks_CalanderMonth, "Reports_tasks_CalanderMonth");
		Thread.sleep(5000);
		// * Below method written to logout application
		logOutt();
		softassert.assertAll();



	}
}
