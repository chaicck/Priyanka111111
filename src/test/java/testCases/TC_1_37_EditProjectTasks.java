package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_37_EditProjectTasks extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:Go to Project Manager ,select any project and save
	 */

	@Test(alwaysRun = true, enabled = true)
	public void editProjectTasks(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String projectDetails = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String voiceBuild = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String text1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String text2 = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent.startTest("1.37_Premier Svc - 607_Edit Project tasks").assignCategory("Projects");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to Project Manager ,select any project and save");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Verifying projects By PM
		waitForElementPresent(projectMenu, 300);
		click(projectMenu, "project Link");
		click(Reports_projectByPM, "Project By PM");
		waitForElementPresent(reports_projectBtPM_ProjectManager_DD, 300);
		actionsClick(reports_projectBtPM_ProjectManager_DD);
		actionsClick(reports_projectBtPM_ProjectManager_DD_AbbyHastings);
		actionsClick(reports_projectBtPM_search);
		logPass("select AbbyHastings as project manager then clicked on search.");
		actionsClick(reports_projectBtPM_1stProjectInTableMagnifier,
				"clicked on the magnifying glass next to an open project");
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine,
				300);
		isassert = verifyText(reports_projectBtPM_projectViewEditPage_headLine,
				projectDetails, "project details");
		softassert.assertEquals(isassert, true, "Verify project details");
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
		logPass("AddTask");

		// * verifying name
		boolean taskWith_Voice_Build = verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,"Able to select Voice Build");
		boolean taskWith_Voice_Install = verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,"Able to select Voice Install");

		System.out.println(taskWith_Voice_Build + "  - -  "+ taskWith_Voice_Install);
		Thread.sleep(3000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,300);
		JSClick(reports_projectBtPM_projectViewEditPage_addTask);
		Thread.sleep(5000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD,300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				300);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				voiceBuild, "Add New Task to Project filed");
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result,
				300);
		System.out
				.println("1st Text"
						+ getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				300);
		clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,voiceBuild, " Add New Task to Project filed");
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result,
				300);
		System.out
				.println("2nd Text"
						+ getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
		clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);

		// adding new task with name starts with a
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				300);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				text1, "Add New Task to Project filed");
		Thread.sleep(2000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result,
				300);
		String selectedText = getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
		System.out.println("3nd Text" + selectedText);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				300);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,
				"", Keys.ENTER);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn,
				300);
		actionsClick(
				reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn,
				"Add new Task to Project");
		/* verifyText(taskAddSuccessMsg, "added successfully", ""); */
		logInfo("Project added successfully");
		Thread.sleep(3000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
		JSClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn);

		Thread.sleep(10000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,
				300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
		verifyTextsPresentInList(
				reports_projectBtPM_projectViewEditPage_taskNamesTable,
				selectedText, "");
		logInfo("Newly added project present in the project table");
		Thread.sleep(7000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_editTasks, 300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
		Thread.sleep(7000);
		verifyTextInColumnClickOtherColumnJS(
				reports_projectBtPM_projectViewEditPage_taskNamesTable,
				reports_projectBtPM_projectViewEditPage_editTasks_checkBoxs,
				selectedText);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);

		// TC37...
		Thread.sleep(1000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		String s = "1";
		String ss = retriveRowNumberToEditOtherColumnData(
				reports_projectBtPM_projectViewEditPage_taskNamesTable,
				selectedText);
		if (ss != null) {
			s = ss;
			System.out.println(ss);
		}
		// modifying the data..
		Thread.sleep(15000);
		selectDropDownByIndex(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_Queue_DD, s),
				2);
		selectDropDownByIndex(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_owner_DD, s),
				3);
		clearText(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_percent, s));
		type(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_percent, s),
				randomNum(1), "");
		selectDropDownByIndex(
				String.format(
						reports_projectBtPM_projectViewEditPage_editTasks_status_DD,
						s), 2);
		clearText(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_note, s));
		type(String.format(
				reports_projectBtPM_projectViewEditPage_editTasks_note, s),
				text2 + randomString(5), "");
		Thread.sleep(15000);
		scrollUp();
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_editTasks_saveBtn, 300);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks_saveBtn);
		Thread.sleep(3000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
		JSClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn);

		// trying to delete created task...
		Thread.sleep(9000);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_editTasks, 300);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
		JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
		waitForElementPresent(
				reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		verifyTextInColumnClickOtherColumnJS(
				reports_projectBtPM_projectViewEditPage_taskNamesTable,
				reports_projectBtPM_projectViewEditPage_editTasks_checkBoxs,
				selectedText);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}

}
