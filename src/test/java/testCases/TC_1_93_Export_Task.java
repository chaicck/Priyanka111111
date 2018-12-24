package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_93_Export_Task extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Projects by PM My Tasks and Verify task overview
	 * page
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_93_Export_Task(ITestContext context) throws Throwable {

		// * Below variables written to get input data from-Testdata.xlsx

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String url5 = "qa5";
		String url6 = "qa6";

		// * logger method for report starting from here
		logger = extent
				.startTest(
						"1.93 Test ID : 16258 - ZEUS-PM-46 Add Export Option to Task Overview Page")
				.assignCategory("Projects");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Projects by PM My Tasks and Verify task overview page");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(projectMenu, 150);
		// * Verifying projects By PM
		JSClick(projectMenu, "project Link");
		JSClick(projects_tasksMyTasks);
		waitForElementPresent(projects_tasksMyTasks_accessManagement_DD, 200);
		// * qa5
		if (getCurrentUrl().contains(url5)) {
			selectDropDownByVisibleText(
					projects_tasksMyTasks_accessManagement_DD,
					"Access Management");
		}
		if (getCurrentUrl().contains(url6)) {
			selectDropDownByVisibleText(
					projects_tasksMyTasks_accessManagement_DD, "Voice Build");
		}

		logInfo("Selected '"
				+ getDropdownSelectedValue(projects_tasksMyTasks_accessManagement_DD)
				+ "' option under AccessManagement DropDown");
		waitForElementPresent(projects_tasksMyTasks_owner_DD, 200);
		actionsClick(projects_tasksMyTasks_owner_DD, "owner_DropDown");
		waitForElementPresent(projects_tasksMyTasks_owner_DD_searchEntry, 200);
		type(projects_tasksMyTasks_owner_DD_searchEntry, "-",
				"owner_DropDown_searchBox");
		Thread.sleep(1000);
		type(projects_tasksMyTasks_owner_DD_searchEntry, "search box",
				Keys.ENTER);
		waitForElementPresent(projects_tasksMyTasks_projectManager_DD, 200);
		actionsClick(projects_tasksMyTasks_projectManager_DD,
				"projectManager DropDown");
		waitForElementPresent(
				projects_tasksMyTasks_projectManager_DD_searchEntry, 200);
		type(projects_tasksMyTasks_projectManager_DD_searchEntry, "-",
				"projectManager_DD_searchBox");
		Thread.sleep(1000);
		type(projects_tasksMyTasks_projectManager_DD_searchEntry, "search box",
				Keys.ENTER);
		waitForElementPresent(projects_tasksMyTasks_taskName_DD, 200);
		actionsClick(projects_tasksMyTasks_taskName_DD, "taskName DropDown");
		waitForElementPresent(projects_tasksMyTasks_taskName_DD_searchEntry,
				200);
		type(projects_tasksMyTasks_taskName_DD_searchEntry, "-",
				"taskName_DD_searchBox");
		Thread.sleep(1000);
		waitForElementPresent(projects_tasksMyTasks_taskName_DD_searchEntry,
				200);

		type(projects_tasksMyTasks_taskName_DD_searchEntry, "search box",
				Keys.ENTER);
		waitForElementPresent(projects_tasksMyTasks_status_DD, 200);
		selectDropDownByVisibleText(projects_tasksMyTasks_status_DD,
				"- Select Value -");
		logInfo("'- Select Value -' option selected under status Dropown");

		waitForElementPresent(projects_tasksMyTasks_searchBtn, 200);
		JSClick(projects_tasksMyTasks_searchBtn, "search Button");

		waitForElementPresent(projects_tasksMyTasks_exportBtn, 200);
		actionsClick(projects_tasksMyTasks_exportBtn, "export Buton");
		
		// * Below method written to logout application
		logOut();

	}

}
