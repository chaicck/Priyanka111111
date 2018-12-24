package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_95_Tasks_Calendar_Page extends MediatorClass {
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
	public void tC_1_95_Tasks_Calendar_Page(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel  sheet-Testdata.xlsx and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String projecttxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String voiceBuildTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String voiceInstallTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String text1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String msg1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String msg2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);

		// * logger method for report starting from here
		logger = extent.startTest(
				"1.95 Test ID : 16103 - ZEUS-PM-92 Verify Tasks Calendar page")
				.assignCategory("Projects");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to projects then select Projects by PM,select the option All Open projects from the Project Manager drop down list\r\n"
				+ "and hit magnifying glass button,Verify Tasks Calendar page");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Verifying projects By PM
		waitForElementPresent(projectMenu, 300);
		click(projectMenu, "project Link");
		click(Reports_projectByPM, "menu");
		waitForElementPresent(Reports_projectByPM_headline, 400);

		waitForElementPresent(reports_projectBtPM_ProjectManager_DD, 300);
		actionsClick(reports_projectBtPM_ProjectManager_DD,"ProjectManager DropDown");
		waitForElementPresent(reports_projectBtPM_ProjectManager_DD_allOpenProjects, 300);
		actionsClick(reports_projectBtPM_ProjectManager_DD_allOpenProjects,"ProjectManager DropDown - AllOpenProjects");
		Thread.sleep(5000);
		waitForElementPresent(reports_projectBtPM_search, 300);
		actionsClick(reports_projectBtPM_search, "Search");
		waitForElementPresent(reports_projectBtPM_1stProjectInTableMagnifier,
				300);
		actionsClick(reports_projectBtPM_1stProjectInTableMagnifier,
				"1stProjectInTableMagnifier");
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine,
				300);
		isassert = verifyText(reports_projectBtPM_projectViewEditPage_headLine,projecttxt, "");
		softassert.assertEquals(isassert, true, "Verified customer id "+ projecttxt + " in customer table");

		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,
				300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);

		// verifying name
		isassert = verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,voiceBuildTxt);
		softassert.assertEquals(isassert, true, "Verified text "+ voiceBuildTxt + " in project view edit task names table");

		isassert = verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,voiceInstallTxt);
		softassert.assertEquals(isassert, true, "Verified text "+ voiceInstallTxt + " in project view edit task names table");

		Thread.sleep(3000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,300);
		JSClick(reports_projectBtPM_projectViewEditPage_addTask);
		Thread.sleep(5000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD,300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,300);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,voiceBuildTxt, "");
		System.out.println("1st Text"+ getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,300);
		clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,300);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,voiceInstallTxt, "");
		System.out.println("2nd Text"+ getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
		clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);

		// adding new task with name starts with a

		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,text1, "");
		String selectedText = getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
		System.out.println("3nd Text" + selectedText);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				"", Keys.ENTER);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn,300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn);
		waitForElementPresent(taskAddSuccessMsg, 300);
		isassert = verifyText(taskAddSuccessMsg, msg1, "");
		softassert.assertEquals(isassert, true, "Verified text " + msg1 + "");

		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn);

		Thread.sleep(10000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);

		isassert = verifyTextsPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,selectedText, "");
		softassert.assertEquals(isassert, true, "Verified text " + selectedText+ "in project view edit page");

		waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks, 300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		verifyTextInColumnClickOtherColumnJS(reports_projectBtPM_projectViewEditPage_taskNamesTable,reports_projectBtPM_projectViewEditPage_editTasks_checkBoxs,selectedText);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks, 300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask);
		Thread.sleep(15000);
		acceptAlert();
		Thread.sleep(10000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_successMsg, 300);

		isassert = verifyText(reports_projectBtPM_projectViewEditPage_successMsg, msg2, "");
		softassert.assertEquals(isassert, true, "Verified text " + msg2 + "");

		waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks_cancelEdit,300);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks_cancelEdit);
		Thread.sleep(5000);

		// need to write sort functionality verification

		// verifying step 8 od test case
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		actionsClick(reports_projectBtPM_projectViewEditPage_taskNamesTable);
		Thread.sleep(5000);

		String duration = randomNum(1);
		waitForElementPresent(projectEdit_duration, 300);
		clearText(projectEdit_duration);
		type(projectEdit_duration, duration, "");
		waitForElementPresent(projectEdit_saveTaskBtn, 300);
		scrollUp();
		Thread.sleep(1000);
		scrollElementIntoView(projectEdit_saveTaskBtn);
		Thread.sleep(1000);
		JSClick(projectEdit_saveTaskBtn);

		Thread.sleep(3000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		actionsClick(reports_projectBtPM_projectViewEditPage_taskNamesTable);
		Thread.sleep(5000);
		System.out.println("duration setUp" + duration);
		waitForElementPresent(projectEdit_duration, 300);
		String durationFromWebpage = getAttributeValue(projectEdit_duration,"value");
		System.out.println("from webPage" + durationFromWebpage);

		softassert.assertEquals(durationFromWebpage, duration);
		waitForElementPresent(projectEdit_closeBtn, 300);
		actionsClick(projectEdit_closeBtn);

		// 9th step

		Thread.sleep(5000);
		waitForElementPresent(projectmenu, 300);
		JSClick(projectmenu);
		click(Reports_tasks_Calander, "menu");
		waitForElementPresent(Reports_tasks_CalanderViews_DD, 300);
		isassert = verifyDropDownValue(Reports_tasks_CalanderViews_DD,voiceBuildTxt);
		softassert.assertEquals(isassert, true, "Verified text "+ voiceBuildTxt + "in calender view dropdown");

		isassert = verifyDropDownValue(Reports_tasks_CalanderViews_DD,voiceInstallTxt);
		softassert.assertEquals(isassert, true, "Verified text "+ voiceInstallTxt + "in calender view dropdown");

		selectDropDownByValue(Reports_tasks_CalanderViews_DD, voiceBuildTxt);
		waitForElementPresent(Reports_tasks_CalanderWeek, 300);
		actionsClick(Reports_tasks_CalanderWeek);
		Thread.sleep(5000);
		waitForElementPresent(Reports_tasks_CalanderDay, 200);
		actionsClick(Reports_tasks_CalanderDay);
		Thread.sleep(5000);
		waitForElementPresent(Reports_tasks_CalanderMonth, 200);
		actionsClick(Reports_tasks_CalanderMonth);
		Thread.sleep(5000);

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
