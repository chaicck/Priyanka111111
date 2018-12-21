package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.MediatorClass;
import demo.objectrepository.OR_Admin;

public class TC_1_41_Configur_Project_Components  extends MediatorClass{

	String admin_serviceDelivery_manageWorkQueues_groups="xpath=//table[@class='table table-responsive']/tbody/tr/td/div/input";
	String admin_serviceDelivery_manageWorkQueues_saveBtn="xpath=(//button[@type='submit'])[2]";
	String admin_serviceDelivery_manageWorkQueues_successMessage="xpath=//div[@class='alert alert-success alert-dismissable']";

	String admin_serviceDelivery_editSystemTasks_addNewTask="xpath=//a[@href='/serviceDelivery/listSystemTasks/']";
	String admin_serviceDelivery_editSystemTasks_addNewTask_taskName="id=Task_Name";
	String admin_serviceDelivery_editSystemTasks_saveBtn="xpath=//button[@class='btn btn-primary pull-right btn-sm']";
	String admin_serviceDelivery_editSystemTasks_taskInfo="xpath=//*[@id='panelTaskInfo']/div[1]/div/a";
	String admin_serviceDelivery_editSystemTasks_taskInfo_taskStatus_DD="id=Status";
	String admin_serviceDelivery_editSystemTasks_taskInfo_owner_DD="id=Owner";
	String admin_serviceDelivery_editSystemTasks_taskInfo_Que_DD="id=Que";
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tC_1_41_Configur_Project_Components(String zUserName, String zPassword) throws Throwable {


		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		logger = extent.startTest("1.41 Test ID : 19950 - Premier Svc - 621_Configure Project components (Type, Template, Task, Work Queue)").assignCategory("Admin");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Admin>Service Delivery>Manage Work Queues>Edit WorkQueue and Save Successfully"
				+ "Admin>Service Delivery>Edit System Tasks>Pick Task>Change Status&Owner>Save Sucessfully"
				+ "Admin>Service Delievery>Manage Project Types>pick type edit>Edit successfully"
				+ "Admin>Service Delivery>Edit Project Templates>Pick project>Save successfully"
				+ "Customer Dashboard>Add project");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		JSClick(submitBtn, "Submit");
		// 1 & 2 step
		Thread.sleep(3000);
		Verify(admin_serviceDelivery,admin_serviceDelivery_manageWorkQueues ,admin_permissions_subMenu_headLine, "Manage Work Queues");
		logPass("Exisitng Work Quotes are listed");
		String groupName="aaaa "+randomString(5);   
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_groups, 30);
		String existingGroupName=getAttributeValue(admin_serviceDelivery_manageWorkQueues_groups, "value");
		//String newName=existingGroupName+" "+groupName;
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_groups, 20);
		typeWithClear(admin_serviceDelivery_manageWorkQueues_groups, groupName, "GroupName");
		
		JSClick(admin_serviceDelivery_manageWorkQueues_saveBtn, "Save");
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_successMessage, 30);
		verifyText(admin_serviceDelivery_manageWorkQueues_successMessage, "Changed Successfully", "");
		
		Assert.assertEquals(getAttributeValue(admin_serviceDelivery_manageWorkQueues_groups, "value"),groupName );
		//typeWithClear(admin_serviceDelivery_manageWorkQueues_groups, existingGroupName, "GroupName");
		//actionsClick(admin_serviceDelivery_manageWorkQueues_saveBtn, "Save");
		//verifyText(admin_serviceDelivery_manageWorkQueues_successMessage, "Changed Successfully", "");	

		//Step 3 & 4
		Verify(admin_serviceDelivery,admin_serviceDelivery_editSystemTasks ,admin_permissions_subMenu_headLine, "System Tasks");
		logInfo("Existing Project Task list is displayed");
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_addNewTask, 30);
		actionsClick(admin_serviceDelivery_editSystemTasks_addNewTask);

		String taskName="Automation Test "+randomString(3);
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_addNewTask_taskName, 30);
		typeWithClear(admin_serviceDelivery_editSystemTasks_addNewTask_taskName, taskName, "Task Name"); 
		
		actionsClick(admin_serviceDelivery_editSystemTasks_saveBtn,"Save");
		Thread.sleep(15000);
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_taskInfo, 20);
		actionsClick(admin_serviceDelivery_editSystemTasks_taskInfo,"Task info");
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_taskInfo_taskStatus_DD, 300);
		selectDropDownByIndex(admin_serviceDelivery_editSystemTasks_taskInfo_taskStatus_DD, 3);
		selectDropDownByIndex(admin_serviceDelivery_editSystemTasks_taskInfo_owner_DD, 3);
		selectDropDownByIndex(admin_serviceDelivery_editSystemTasks_taskInfo_Que_DD, 3);
		waitForElementPresent(admin_serviceDelivery_editSystemTasks_saveBtn, 300);
		actionsClick(admin_serviceDelivery_editSystemTasks_saveBtn,"Save");
		Thread.sleep(8000);
		logPass("Edit system tasks Saved successfully");

		//Step 5 & 6
		Thread.sleep(20000);
		Verify(admin_serviceDelivery,admin_serviceDelivery_ManageProjectTypes ,admin_permissions_subMenu_headLine, "Project Types");


		String admin_serviceDelivery_ManageProjectTypes_projectType="id=type_name";
		String admin_serviceDelivery_ManageProjectTypes_editBtn="xpath=//table[@class='table table-condensed']/tbody/tr/td[3]/div/button[1]";
		String admin_serviceDelivery_ManageProjectTypes_projectType_parametarised="xpath=(//input[@id='type_name'])[%s]";
		String admin_serviceDelivery_ManageProjectTypes_edit_parametarised="xpath=(//button[@value='edit'])[%s]";
		String admin_serviceDelivery_ManageProjectTypes_delete_parametarised="xpath=(//button[@value='delete'])[%s]";
		String admin_serviceDelivery_ManageProjectTypes_add="xpath=(//button[@value='add'])";

		String projectType= randomString(3);    
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_projectType, 30);
		String existingProjectType=getAttributeValue(admin_serviceDelivery_ManageProjectTypes_projectType, "value");
		String newProjectType=existingProjectType+projectType;
		Thread.sleep(6000);
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_projectType, 30);
		typeWithClear(admin_serviceDelivery_ManageProjectTypes_projectType, newProjectType, "'Project Type'");
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_editBtn, 300);
		JSClick(admin_serviceDelivery_ManageProjectTypes_editBtn, "'Edit Button'");
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_successMessage, 300);
		verifyText(admin_serviceDelivery_manageWorkQueues_successMessage, "edit successful", "");
		Assert.assertEquals(getAttributeValue(admin_serviceDelivery_ManageProjectTypes_projectType, "value"),newProjectType );
		Thread.sleep(9000);
		typeWithClear(admin_serviceDelivery_ManageProjectTypes_projectType, existingProjectType, "GroupName");
		waitForElementPresent(admin_serviceDelivery_ManageProjectTypes_editBtn, 30);
		JSClick(admin_serviceDelivery_ManageProjectTypes_editBtn, "'Edit Button'");
		waitForElementPresent(admin_serviceDelivery_manageWorkQueues_successMessage, 30);
		verifyText(admin_serviceDelivery_manageWorkQueues_successMessage, "edit successful", "");

		//Step 7 & 8 & 9 & 10 - 7 alone completed
		Thread.sleep(3000);
		Verify(admin_serviceDelivery,admin_serviceDelivery_editProjectTemplates ,admin_permissions_subMenu_headLine, "Project Templates");

		String admin_serviceDelivery_EditProjectTemplete_add="xpath=//a[@href='/serviceDelivery/projectTemplate']";
		String admin_serviceDelivery_EditProjectTemplete_add_name="id=Name";
		String admin_serviceDelivery_EditProjectTemplete_add_Description="id=Description";
		String admin_serviceDelivery_EditProjectTemplete_add_create="xpath=(//button[@type='submit'])[2]";
		String admin_serviceDelivery_EditProjectTemplete_search="xpath=//input[@type='search']";
		String admin_serviceDelivery_EditProjectTemplete_table_names="xpath=//*[@id='DataTables_Table_0']/tbody/tr/td[2]";
		String admin_serviceDelivery_EditProjectTemplete_table_magnifier_parametarised="xpath=//*[@id='DataTables_Table_0']/tbody/tr[%s]/td/a";
		String admin_serviceDelivery_EditProjectTemplete_add_delete="id=delete-template";
		waitForElementPresent(admin_serviceDelivery_EditProjectTemplete_add, 300);
		actionsClick(admin_serviceDelivery_EditProjectTemplete_add, "Add");
		String ProjectTempleteName="TestTemplete"+randomString(3);
		waitForElementPresent(admin_serviceDelivery_EditProjectTemplete_add_name, 300);
		type(admin_serviceDelivery_EditProjectTemplete_add_name, ProjectTempleteName, "Project Templete Name");
		waitForElementPresent(admin_serviceDelivery_EditProjectTemplete_add_Description, 300);
		type(admin_serviceDelivery_EditProjectTemplete_add_Description, randomString(5), "Project Templete Description");
		actionsClick(admin_serviceDelivery_EditProjectTemplete_add_create, "Create");
		logInfo("Project Templete has been created successfully");
		
	

		String dashboard_addProject="xpath=//a[starts-with(@href,'/project/create/customer_id')]";
		String dashboard_addProject_projectId="id=project_id";
		String dashboard_addProject_dueDate="id=due_date";
		String dashboard_addProject_projectManager_DD="id=project_manager";
		String dashboard_addProject_dueDate_dueDateReasonChange_DD="id=duedate_reason_code_id";
		String dashboard_addProject_dueDate_dueDateChangeNotes="id=duedate_change_note";
		String dashboard_addProject_dueDate_dueDateChangeNote_saveBtn="xpath=(//button[@type='submit'])[2]";   	
		String projectManager_search1="xpath=(//div[@class='chosen-search']/input)[2]";   	
		String dashboard_addProject_projectManager="id=project_manager_chosen"; 

		Thread.sleep(9000);
		String url=null;
		if(getCurrentUrl().contains("qa5")) {
		url="https://zeus.qa5.vonagenetworks.net/dashboard/view/customer_id:"+customer_id;		
		}
		else if (getCurrentUrl().contains("qa6")) {
			url="https://zeus.qa6.vonagenetworks.net/dashboard/view/customer_id:"+customer_id;			
		}
		else {
			url="https://master-hades.hydra.dev.vonagenetworks.net/dashboard/view/customer_id:"+customer_id;			
		}
		navigateTo(url);
		waitForElementPresent(customer_dashboard_name, 30);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name"); //Name To verify - eg.Customer: Novell & Jimenez-Corp (31589)
		Thread.sleep(7000);
		waitForElementPresent(dashboard_addProject, 30);
		scrollElementIntoView(dashboard_addProject);
		JSClick(dashboard_addProject,"Add Project");
		navigateToChild();
		waitForElementToBeClickable(queues_newProject_createAProjectOntoStep2Btn);
		waitForElementPresent(dashboard_addProject_projectManager, 30);
		actionsClick(dashboard_addProject_projectManager);
		waitForElementPresent(projectManager_search1, 30);
		type(projectManager_search1, "Abby Hastings", "Project Manager Search");
		type(projectManager_search1, "Alvin Walker", Keys.ENTER);
		waitForElementPresent(queues_newProject_createAProjectOntoStep2Btn, 30);
		JSClick(queues_newProject_createAProjectOntoStep2Btn,"'Create A Project & On to Step2'");
		Thread.sleep(4000);
		waitForElementPresent(queues_createAProjectOntoStep_DueDate, 30);
		scrollElementIntoView(queues_createAProjectOntoStep_DueDate);
		JSClick(queues_createAProjectOntoStep_DueDate, "'Due Date from calander'");
		waitForElementPresent(dashboard_addProject_projectId, 200);
		String projectId=getAttributeValue(dashboard_addProject_projectId, "value");
		waitForElementPresent(queues_createAProjectOntoStep_buildProjectTask, 20);
		actionsClick(queues_createAProjectOntoStep_buildProjectTask, "buildProjectTask");
		waitForElementPresent(queues_newProject_saveRecalculateBtn, 200);
		selectDropDownByVisibleText(queues_createAProjectOntoStep_projectStatus_DD, "Ready for FULL Billing");
		if(getCurrentUrl().contains("qa5")) {
			String toDaysDay=dateAftersomeDays(0, "dd");
			String toDaysmonth=dateAftersomeDays(0, "MM");
			String toDaysyear=dateAftersomeDays(0, "yyyy");
			enterDate(queues_createAProjectOntoStep_fullBillDate,toDaysmonth, toDaysDay, toDaysyear);	
		}
		if(getCurrentUrl().contains("qa6")) {
			type(queues_createAProjectOntoStep_fullBillDate, dateAftersomeDays(0, "MMddyyyy"), "full bill date");
		}

		Thread.sleep(2000);
		//String alvin_walker="xpath=//*[@id='project_manager']/option[10]";
		//JSClick(dashboard_addProject_projectManager_DD);
		Thread.sleep(1000);
		//actionsClick(alvin_walker);
		//Qa6
		selectDropDownByVisibleText(dashboard_addProject_projectManager_DD, "Abby Hastings");	
		//	selectDropDownByVisibleText(dashboard_addProject_projectManager_DD, "Alvin Walker");


		if(getCurrentUrl().contains("qa5")) {
			String dayAfterDays=dateAftersomeDays(5, "dd");
			String monthAfterDays=dateAftersomeDays(5, "MM");
			String yearAfterDays=dateAftersomeDays(5, "yyyy");
			enterDate(dashboard_addProject_dueDate, monthAfterDays,dayAfterDays, yearAfterDays);	
		}
		
		if(getCurrentUrl().contains("master")) {
			String dayAfterDays=dateAftersomeDays(5, "dd");
			String monthAfterDays=dateAftersomeDays(5, "MM");
			String yearAfterDays=dateAftersomeDays(5, "yyyy");
			enterDate(dashboard_addProject_dueDate, monthAfterDays,dayAfterDays, yearAfterDays);	
		}
		if(getCurrentUrl().contains("qa6")) {
			String dueDate=dateAftersomeDays(5, "MMddyyyy");
			type(dashboard_addProject_dueDate, dueDate, "Due Date");

		}

		String dueDateWithFormat=dateAftersomeDays(5, "yyy-MM-dd");
		/*actionsClick(queues_newProject_saveRecalculateBtn, "saveRecalculateBtn");
		waitForElementPresent(dashboard_addProject_dueDate_dueDateReasonChange_DD, 20);
		selectDropDownByIndex(dashboard_addProject_dueDate_dueDateReasonChange_DD, 2);
		String dueDateReasonChange_DD_value=getDropdownSelectedValue(dashboard_addProject_dueDate_dueDateReasonChange_DD);
		type(dashboard_addProject_dueDate_dueDateChangeNotes, "test", "DueDateChangeNotes");
		Thread.sleep(3000);
		JSClick(dashboard_addProject_dueDate_dueDateChangeNote_saveBtn,"DueDateChangeNote_saveBtn");		
		actionsClick(queues_newProject_saveRecalculateBtn, "saveRecalculateBtn");
		waitForElementPresent(queues_projectBuildSuccessMsg, 20);
		actionsClick(queues_projectBuildSuccessMsg,"projectBuildSuccessMsg_Ok_Button");	*/
		logPass("Project successfully created with Project Id "+projectId);
		logOut(); 
	}

	private int verifyTextInColumn_value_GetNumber(String locator, String text) throws Throwable {
		List<String> list=new ArrayList<>();

		List<WebElement> l=getAllElements(locator);
		for (WebElement web : l) {
			list.add(getAttributeValueOfWebElement(web, "value"));
		}


		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).equalsIgnoreCase(text))
				return (j+1);
		}
		return 1;
	}

	protected String getAttributeValueOfWebElement(WebElement webElement, String attribute) {

		return  webElement.getAttribute(attribute);
	}

	private void VerifyClick(String menu,String submenu) throws Throwable {
		click(adminLInk,"Admin LInk");
		click(menu,menu);
		click(submenu,submenu);
	}

	private void Verify(String menu,String submenu, String textElement, String text) throws Throwable {
		setBrowserTo80Size();
		Thread.sleep(2000);
		JSClick(adminLInk);
		JSClick(menu);
		JSClick(submenu);
		waitForElementPresent(textElement, 300);
		verifyText(textElement,  text, "Verifying HeadLine text");
	}

	private void Verifyy(String menu,String submenu, String textElement, String text) throws Throwable {
		click(adminLInk,"Admin LInk");
		click(menu,menu);
		JSClick(submenu);
		waitForElementPresent(textElement, 300);
		verifyText(textElement,  text, "Verifying HeadLine text");
	}


	public void verifyTextInColumnClickOtherColumnJS_value(String locator1, String locator2, String text) throws Throwable{
		List<WebElement> l=getAllElements(locator1);
		for (int i = 0; i < l.size(); i++) {		  
			if(l.get(i).getText().contains(text)) {
				String locator3=String.format(locator2, (i+1));
				scrollElementIntoView(locator3);
				JSClick(locator3);
				//getElement(locator3).click();
				break;
			}

		}			  
	}




}

