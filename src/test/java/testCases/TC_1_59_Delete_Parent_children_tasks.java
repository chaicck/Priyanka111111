package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_59_Delete_Parent_children_tasks extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:Go to project,select any projects then Add and
	 * Delete Task and verify deleting parent task must delete all children
	 * tasks
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tc_1_59_Delete_Parent_children_tasks(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String projects = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String projectDetails = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String projectToAdd = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String projectWithChild = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String deletedMsg = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String selectedText = null;
		AssertSoftly softassert = new AssertSoftly();

		// * logger method for report starting from here
		logger = extent.startTest("1.59 Test ID : 19621 - Test to check deleting parent task must delete all children tasks").assignCategory("Customer_DashBoard");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Go to project,select any projects then Add and Delete Task and verify deleting parent task must delete all children tasks ");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(srchDd, 200);
		click(srchDd, "Search");
		click(search_project, "search project");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);

		isassert = verifyText(projectTableName, projects, "Project Table Name");
		softassert.assertEquals(isassert, true, " Verify projects table name");

		waitForElementPresent(projects_table_magnifyingSymbol, 200);
		actionsClick(projects_table_magnifyingSymbol,"projects_table_magnifyingSymbol");
		Thread.sleep(6000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine,200);

		isassert = verifyText(reports_projectBtPM_projectViewEditPage_headLine,projectDetails, "");
		softassert.assertEquals(isassert, true," Verify projects details title");

		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);

		// Deleting the project, if it exists on the table already ..
		deleteTask(projectToAdd, deletedMsg);

		Thread.sleep(8000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask,200);
		JSClick(reports_projectBtPM_projectViewEditPage_addTask,"reports_projectBtPM_projectViewEditPage_addTask");
		Thread.sleep(5000);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD,200);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD);
		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,projectToAdd, "Add a New Task to Project");

		selectedText = getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
		logInfo(selectedText+ " option seleccted under taskSelection Drop down");
		System.out.println(selectedText+ " option seleccted under taskSelection Drop down");
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,300);

		type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox,"", Keys.ENTER);
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn,300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn," Clicked on AddNewTaskToPrject");
		waitForElementPresent(taskAddSuccessMsg, 300);

		isassert = verifyText(taskAddSuccessMsg,"The selected task, and its sub-tasks have been added successfully!","");
		softassert.assertEquals(isassert, true," Verify selected task, and its sub-tasks have been added successfully");

		waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
		actionsClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn,"Close the Add Task window");

		Thread.sleep(15000);
		scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
		softassert.assertTrue(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,selectedText));
//		logInfo(selectedText + " preset in taskNamesTable");
		waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
		verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,projectWithChild);
		logInfo(projectWithChild + " preset in taskNamesTable");

		// * Deleting child task alone & verifying parent task
		deleteTask(projectWithChild, deletedMsg);

		Thread.sleep(10000);
		logPass(projectWithChild + " task has been deleted successfully");
		logInfo("Verifying the parent task i.e., " + selectedText+ " after deleting child task i.e., " + projectWithChild);
		refreshBrowser();

		Thread.sleep(9000);
		softassert.assertTrue(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,selectedText));
		logPass("Parent task i.e., " + selectedText+ " didn't deleted even after deleting child task "
				+ projectWithChild);
		// * Deleting parent task alone & verifying parent task & child task
		logInfo("Deleting the parent task i.e., " + selectedText);
		Thread.sleep(9000);
		deleteTask(selectedText, deletedMsg);
		refreshBrowser();
		Thread.sleep(13000);
		softassert.assertFalse(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,selectedText));
		softassert.assertFalse(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable,projectWithChild));
		logPass("After deleting parent task, Child tasks also deleted.");
		logPass("Deletion of tasks only applied within the individual project and the tasks should not get delete in other projects");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}

	// * Below method written to delete task if available on table
	public void deleteTask(String projectToAdd, String deletedMsg)
			throws InterruptedException, Throwable {

		if (verifyTextPresentInList(
				reports_projectBtPM_projectViewEditPage_Tasks, projectToAdd)) {

			verifyTextInColumnClickOtherColumn(
					reports_projectBtPM_projectViewEditPage_Tasks,
					reports_projectBtPM_projectViewEditPage_taskCheckBox,
					projectToAdd);
			Thread.sleep(1000);
			scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
			Thread.sleep(1000);
			JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
			// deleting selected task
			JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask);
			acceptAlert();
			Thread.sleep(5000);
			verifyText(
					reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg,
					deletedMsg, "Successfully deleted msg");
			JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn);
			Thread.sleep(1000);
			JSClick(projectEdit_saveTaskBtn);
			waitForElementPresent(
					reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn,
					20);
			JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn);

		} else {
			logInfo("No task found on list to delete");
		}

	}

}
