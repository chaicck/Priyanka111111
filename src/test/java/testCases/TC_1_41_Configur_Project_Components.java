package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_41_Configur_Project_Components extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/07/2018}
	 */

	/**
	 * TestCase Description:Admin>Service Delivery>Manage Work Queues>Edit
	 * WorkQueue and Save Successfully" +
	 * "Admin>Service Delivery>Edit System Tasks>Pick Task>Change Status&Owner>Save Sucessfully"
	 * +
	 * "Admin>Service Delievery>Manage Project Types>pick type edit>Edit successfully"
	 * +
	 * "Admin>Service Delivery>Edit Project Templates>Pick project>Save successfully"
	 * + "Customer Dashboard>Add project
	 */

	String fs = File.separator;
	String rtfFilePath = System.getProperty("user.dir") + fs + "TestData" + fs
			+ "test.rtf";

	@Test(alwaysRun = true, enabled = true)
	public void tC_1_41_Configur_Project_Components(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String successMsg = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String autoName = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String editSuccess = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String template = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String url5 = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String url6 = getTestData(this.getClass().getSimpleName().substring(0, 8), 7);
		String masterUrl = getTestData(this.getClass().getSimpleName().substring(0, 8), 8);
		String customerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 8), 9);
		String firsName = getTestData(this.getClass().getSimpleName().substring(0, 8), 10);
		String lastName = getTestData(this.getClass().getSimpleName().substring(0, 8), 11);
		AssertSoftly softassert = new AssertSoftly();

		// * Logger methods starts from here
		logger = extent
				.startTest(
						"1.41 Test ID : 19950 - Premier Svc - 621_Configure Project components (Type, Template, Task, Work Queue)")
				.assignCategory("Admin");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Admin>Service Delivery>Manage Work Queues>Edit WorkQueue and Save Successfully"
				+ "Admin>Service Delivery>Edit System Tasks>Pick Task>Change Status&Owner>Save Sucessfully"
				+ "Admin>Service Delievery>Manage Project Types>pick type edit>Edit successfully"
				+ "Admin>Service Delivery>Edit Project Templates>Pick project>Save successfully"
				+ "Customer Dashboard>Add project");
		// * Below Code written to verify login
		login(zUserName, zPassword);
		// 1 & 2 step
		Thread.sleep(3000);
		verifySubMenuHeadLine(adminLInk, admin_serviceDelivery,
				admin_serviceDelivery_manageWorkQueues,
				admin_permissions_subMenu_headLine, "Manage Work Queues");
		logPass("Exisitng Work Quotes are listed");
		String groupName = "aaaa " + randomString(5);
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_groups, 30);
		String existingGroupName = getAttributeValue(
				admin_serviceDelivery_manageWorkQueues_groups, "value");
		// String newName=existingGroupName+" "+groupName;
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_groups, 20);
		typeWithClear(admin_serviceDelivery_manageWorkQueues_groups, groupName,
				"GroupName");

		JSClick(admin_serviceDelivery_manageWorkQueues_saveBtn, "Save");
		waitForElementPresent(
				admin_serviceDelivery_manageWorkQueues_successMessage, 30);
		isassert = verifyText(
				admin_serviceDelivery_manageWorkQueues_successMessage,
				successMsg, "");
		softassert.assertEquals(isassert, true);

		softassert.assertEquals(getAttributeValue(admin_serviceDelivery_manageWorkQueues_groups,"value"), groupName);
		// Step 3 & 4
		verifySubMenuHeadLine(adminLInk, admin_serviceDelivery,
				admin_serviceDelivery_editSystemTasks,
				admin_permissions_subMenu_headLine, "System Tasks");
		logInfo("Existing Project Task list is displayed");
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_addNewTask,
				30);
		actionsClick(admin_serviceDelivery_editSystemTasks_addNewTask);

		String taskName = autoName + randomString(3);
		waitForElementPresent(
				admin_serviceDelivery_editSystemTasks_addNewTask_taskName, 30);
		typeWithClear(
				admin_serviceDelivery_editSystemTasks_addNewTask_taskName,
				taskName, "Task Name");

		actionsClick(admin_serviceDelivery_editSystemTasks_saveBtn, "Save");
		Thread.sleep(15000);
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_taskInfo,
				20);
		actionsClick(admin_serviceDelivery_editSystemTasks_taskInfo,
				"Task info");
		waitForElementPresent(
				admin_serviceDelivery_editSystemTasks_taskInfo_taskStatus_DD,
				300);
		selectDropDownByIndex(
				admin_serviceDelivery_editSystemTasks_taskInfo_taskStatus_DD, 3);
		selectDropDownByIndex(
				admin_serviceDelivery_editSystemTasks_taskInfo_owner_DD, 3);
		selectDropDownByIndex(
				admin_serviceDelivery_editSystemTasks_taskInfo_Que_DD, 3);
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_saveBtn,
				300);
		actionsClick(admin_serviceDelivery_editSystemTasks_saveBtn, "Save");
		Thread.sleep(8000);
		logPass("Edit system tasks Saved successfully");

		// Step 5 & 6
		Thread.sleep(20000);
		verifySubMenuHeadLine(adminLInk, admin_serviceDelivery,
				admin_serviceDelivery_ManageProjectTypes,
				admin_permissions_subMenu_headLine, "Project Types");

		String projectType = randomString(3);
		waitForElementPresent(
				admin_serviceDelivery_ManageProjectTypes_projectType, 30);
		String existingProjectType = getAttributeValue(
				admin_serviceDelivery_ManageProjectTypes_projectType, "value");
		String newProjectType = existingProjectType + projectType;
		Thread.sleep(6000);
		waitForElementPresent(
				admin_serviceDelivery_ManageProjectTypes_projectType, 30);
		typeWithClear(admin_serviceDelivery_ManageProjectTypes_projectType,
				newProjectType, "'Project Type'");
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_editBtn,
				300);
		JSClick(admin_serviceDelivery_ManageProjectTypes_editBtn,
				"'Edit Button'");
		waitForElementPresent(
				admin_serviceDelivery_manageWorkQueues_successMessage, 300);
		isassert = verifyText(
				admin_serviceDelivery_manageWorkQueues_successMessage,
				editSuccess, "Edit successfully");
		softassert.assertEquals(isassert, true);

		softassert.assertEquals(
				getAttributeValue(
						admin_serviceDelivery_ManageProjectTypes_projectType,
						"value"), newProjectType);
		Thread.sleep(9000);

		typeWithClear(admin_serviceDelivery_ManageProjectTypes_projectType,
				existingProjectType, "GroupName");
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_editBtn,
				30);
		JSClick(admin_serviceDelivery_ManageProjectTypes_editBtn,
				"'Edit Button'");
		waitForElementPresent(
				admin_serviceDelivery_manageWorkQueues_successMessage, 30);

		isassert = verifyText(
				admin_serviceDelivery_manageWorkQueues_successMessage,
				editSuccess, "Edit successfully");
		softassert.assertEquals(isassert, true);

		// Step 7 & 8 & 9 & 10 - 7 alone completed
		Thread.sleep(3000);
		verifySubMenuHeadLine(adminLInk, admin_serviceDelivery,
				admin_serviceDelivery_editProjectTemplates,
				admin_permissions_subMenu_headLine, "Project Templates");

		waitForElementPresent(admin_serviceDelivery_EditProjectTemplete_add,
				300);
		actionsClick(admin_serviceDelivery_EditProjectTemplete_add, "Add");
		String ProjectTempleteName = template + randomString(3);
		waitForElementPresent(
				admin_serviceDelivery_EditProjectTemplete_add_name, 300);
		type(admin_serviceDelivery_EditProjectTemplete_add_name,
				ProjectTempleteName, "Project Templete Name");
		waitForElementPresent(
				admin_serviceDelivery_EditProjectTemplete_add_Description, 300);
		type(admin_serviceDelivery_EditProjectTemplete_add_Description,
				randomString(5), "Project Templete Description");
		actionsClick(admin_serviceDelivery_EditProjectTemplete_add_create,
				"Create");
		logInfo("Project Templete has been created successfully");

		Thread.sleep(9000);
		String url = null;
		if (getCurrentUrl().contains("qa5")) {
			url = url5 + customer_id;
		} else if (getCurrentUrl().contains("qa6")) {
			url = url6 + customer_id;
		} else {
			url = masterUrl + customer_id;
		}
		navigateTo(url);
		waitForElementPresent(customer_dashboard_name, 30);
		isassert = verifyText(customer_dashboard_name, customerTxt1,
				"Customer Name"); 
		softassert.assertEquals(isassert, true);

		Thread.sleep(7000);
		waitForElementPresent(dashboard_addProject, 30);
		scrollElementIntoView(dashboard_addProject);
		JSClick(dashboard_addProject, "Add Project");
		navigateToChild();
		waitForElementToBeClickable(queues_newProject_createAProjectOntoStep2Btn);
		waitForElementPresent(dashboard_addProject_projectManager, 30);
		actionsClick(dashboard_addProject_projectManager);
		waitForElementPresent(projectManager_search1, 30);
		type(projectManager_search1, firsName, "Project Manager Search");
		type(projectManager_search1, lastName, Keys.ENTER);
		waitForElementPresent(queues_newProject_createAProjectOntoStep2Btn, 30);
		JSClick(queues_newProject_createAProjectOntoStep2Btn,
				"'Create A Project & On to Step2'");
		Thread.sleep(4000);
		waitForElementPresent(queues_createAProjectOntoStep_DueDate, 30);
		scrollElementIntoView(queues_createAProjectOntoStep_DueDate);
		JSClick(queues_createAProjectOntoStep_DueDate,
				"'Due Date from calander'");
		waitForElementPresent(dashboard_addProject_projectId, 200);
		String projectId = getAttributeValue(dashboard_addProject_projectId,
				"value");
		waitForElementPresent(queues_createAProjectOntoStep_buildProjectTask,
				20);
		actionsClick(queues_createAProjectOntoStep_buildProjectTask,
				"buildProjectTask");
		waitForElementPresent(queues_newProject_saveRecalculateBtn, 200);
		selectDropDownByVisibleText(
				queues_createAProjectOntoStep_projectStatus_DD,
				"Ready for FULL Billing");
		if (getCurrentUrl().contains("qa5")) {
			String toDaysDay = dateAftersomeDays(0, "dd");
			String toDaysmonth = dateAftersomeDays(0, "MM");
			String toDaysyear = dateAftersomeDays(0, "yyyy");
			enterDate(queues_createAProjectOntoStep_fullBillDate, toDaysmonth,
					toDaysDay, toDaysyear);
		}
		if (getCurrentUrl().contains("qa6")) {
			type(queues_createAProjectOntoStep_fullBillDate,
					dateAftersomeDays(0, "MMddyyyy"), "full bill date");
		}

		Thread.sleep(2000);
		Thread.sleep(1000);
		// Qa6
		selectDropDownByVisibleText(dashboard_addProject_projectManager_DD,
				"Abby Hastings");
		if (getCurrentUrl().contains("qa5")) {
			String dayAfterDays = dateAftersomeDays(5, "dd");
			String monthAfterDays = dateAftersomeDays(5, "MM");
			String yearAfterDays = dateAftersomeDays(5, "yyyy");
			enterDate(dashboard_addProject_dueDate, monthAfterDays,
					dayAfterDays, yearAfterDays);
		}

		if (getCurrentUrl().contains("master")) {
			String dayAfterDays = dateAftersomeDays(5, "dd");
			String monthAfterDays = dateAftersomeDays(5, "MM");
			String yearAfterDays = dateAftersomeDays(5, "yyyy");
			enterDate(dashboard_addProject_dueDate, monthAfterDays,
					dayAfterDays, yearAfterDays);
		}
		if (getCurrentUrl().contains("qa6")) {
			String dueDate = dateAftersomeDays(5, "MMddyyyy");
			type(dashboard_addProject_dueDate, dueDate, "Due Date");

		}

		String dueDateWithFormat = dateAftersomeDays(5, "yyy-MM-dd");
		logPass("Project successfully created with Project Id " + projectId);
		
		// * below method writtent to perform logout operation 
		logOut();
		softassert.assertAll();
	}

}
