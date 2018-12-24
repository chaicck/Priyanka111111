package testCases;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_89__Add_MAC extends CommonReusables implements OR_HomePage,
		OR_CustInfo, OR_ProjectManager, OR_NewMAC {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:In CDRConfig Page Verify On/Off Buttons And Add
	 * Link_Manage_SFTP_Credentials Account
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tc_1_89_addMac(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel  sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];

		// * logger method for report starting from here
		logger = extent.startTest("1.89 Test ID : 15008 - ZEUS-PM-22 Add MAC")
				.assignCategory("Projects");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Select Projects by PM Project Manager select All Open Projects for any project Add MAC,You are on the New MAC page");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(searchTextBox, 200);
		waitForElementPresent(prjLnk, 300);
		click(prjLnk, "Project Link");
		click(prjByPMLnk, "Project DropDown");
		waitForElementPresent(projManagerDd, 300);
		actionsClick(projManagerDd, "Project Manager DropDown");
		actionsClick(allOpenProjLnk, "All open projects");
		Thread.sleep(5000);
		actionsClick(srchBtn, "Search button");
		waitForElementPresent(firstProjLnk, 500);
		click(firstProjLnk, "First project link");
		waitForElementPresent(newMacLable, 300);
		softassert.assertTrue(isElementDisplayed(newMacLable, "New MAC"));

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
