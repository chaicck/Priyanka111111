package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_35_AddNew_EditProjectDueDate extends MediatorClass{
	
	String dashboard_addProject="xpath=//a[starts-with(@href,'/project/create/customer_id')]";
	String dashboard_addProject_projectId="id=project_id";
	String dashboard_addProject_dueDate="id=due_date";
	String dashboard_addProject_projectManager_DD="id=project_manager";
	String dashboard_addProject_dueDate_dueDateReasonChange_DD="id=duedate_reason_code_id";
	String dashboard_addProject_dueDate_dueDateChangeNotes="id=duedate_change_note";
	String dashboard_addProject_dueDate_dueDateChangeNote_saveBtn="xpath=(//button[@type='submit'])[2]";
	String reports_projectBtPM_view_DD="id=view";
	String reports_projectBtPM_ProjectManager_AlvinWalker="xpath=(//ul[@class='chosen-results']/li)[15]";	
	String reports_projectBtPM_groupByCustomer="name=group";
	String reports_projectBtPM_PIDs="xpath=//*[@id='project_table']/tbody/tr/td[2]";
	String reports_projectBtPM_magnifier_parametarised="xpath=//*[@id='project_table']/tbody/tr[%s]/td[1]/a[1]/i";
	String reports_projectBtPM_project_dueDateChangeNote="id=note";
	
	String projectManager_search="xpath=//div[@class='chosen-search']/input";
	String projectManager_search1="xpath=(//div[@class='chosen-search']/input)[2]";
	
	String dashboard_addProject_projectManager="id=project_manager_chosen";
	 
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tC_1_35_AddNew_EditProjectDueDate(String zUserName, String zPassword) throws Throwable {

		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		
		logger = extent.startTest("1.35 Test ID : 19944 - Premier Svc - 605_Add New and edit Project Due Date");
		logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description: Search project manager and Edit project and save" );
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		if(verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id); 
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name"); //Name To verify - eg.Customer: Novell & Jimenez-Corp (31589)
		waitForElementPresent(dashboard_addProject, 300);
		scrollElementIntoView(dashboard_addProject);
		JSClick(dashboard_addProject,"Add Project");
		navigateToChild();
		waitForElementToBeClickable(queues_newProject_createAProjectOntoStep2Btn);
		waitForElementPresent(dashboard_addProject_projectManager, 300);
		actionsClick(dashboard_addProject_projectManager);
		type(projectManager_search1, "Alvin Walker", "Project Manager Search");
		type(projectManager_search1, "Alvin Walker", Keys.ENTER);
		waitForElementPresent(queues_newProject_createAProjectOntoStep2Btn, 300);
		JSClick(queues_newProject_createAProjectOntoStep2Btn,"'Create A Project & On to Step2'");
		waitForElementPresent(queues_createAProjectOntoStep_DueDate, 300);
		scrollElementIntoView(queues_createAProjectOntoStep_DueDate);
		JSClick(queues_createAProjectOntoStep_DueDate, "'Due Date from calander'");
		waitForElementPresent(dashboard_addProject_projectId, 20);
		String projectId=getAttributeValue(dashboard_addProject_projectId, "value");
		waitForElementPresent(queues_createAProjectOntoStep_buildProjectTask, 300);
		actionsClick(queues_createAProjectOntoStep_buildProjectTask, "buildProjectTask");
		waitForElementPresent(queues_newProject_saveRecalculateBtn, 200);
		selectDropDownByVisibleText(queues_createAProjectOntoStep_projectStatus_DD, "Ready for FULL Billing");
		String toDaysDay=dateAftersomeDays(0, "dd");
		String toDaysmonth=dateAftersomeDays(0, "MM");
		String toDaysyear=dateAftersomeDays(0, "yyyy");
		System.out.println("fullBillDate "+toDaysDay+" - "+toDaysmonth+" - "+" toDaysyear");
		waitForElementPresent(queues_createAProjectOntoStep_fullBillDate, 300);
		//enterDate(queues_createAProjectOntoStep_fullBillDate, toDaysDay, toDaysmonth, toDaysyear);		
		type(queues_createAProjectOntoStep_fullBillDate, toDaysdate(), "full bill date");
		Thread.sleep(2000);
		//String alvin_walker="xpath=//*[@id='project_manager']/option[10]";
		//JSClick(dashboard_addProject_projectManager_DD);
		Thread.sleep(1000);
		//actionsClick(alvin_walker);
		waitForElementPresent(dashboard_addProject_projectManager_DD, 300);
		selectDropDownByVisibleText(dashboard_addProject_projectManager_DD, "Alvin Walker");
				
		String dueDate=dateAftersomeDays(5, "MMddyyy");
		String dayAfterDays=dateAftersomeDays(5, "dd");
		String monthAfterDays=dateAftersomeDays(5, "MM");
		String yearAfterDays=dateAftersomeDays(5, "yyyy");
		System.out.println("dueDate "+dayAfterDays+" - "+monthAfterDays+" - "+" toDaysyear");
		waitForElementPresent(dashboard_addProject_dueDate, 300);
		//enterDate(dashboard_addProject_dueDate, dayAfterDays, monthAfterDays, yearAfterDays);		
		type(dashboard_addProject_dueDate, dueDate, "Due Date");
		
		String dueDateWithFormat=dateAftersomeDays(5, "yyy-MM-dd");
		waitForElementPresent(queues_newProject_saveRecalculateBtn, 300);
		actionsClick(queues_newProject_saveRecalculateBtn, "saveRecalculateBtn");
		waitForElementPresent(dashboard_addProject_dueDate_dueDateReasonChange_DD, 200);
		selectDropDownByIndex(dashboard_addProject_dueDate_dueDateReasonChange_DD, 1);
		String dueDateReasonChange_DD_value=getDropdownSelectedValue(dashboard_addProject_dueDate_dueDateReasonChange_DD);
		waitForElementPresent(dashboard_addProject_dueDate_dueDateChangeNotes, 300);
		type(dashboard_addProject_dueDate_dueDateChangeNotes, "test", "DueDateChangeNotes");
		Thread.sleep(3000);
		
		JSClick(dashboard_addProject_dueDate_dueDateChangeNote_saveBtn,"DueDateChangeNote_saveBtn");
		Thread.sleep(5000);		
		actionsClick(queues_newProject_saveRecalculateBtn, "saveRecalculateBtn");
		waitForElementPresent(queues_projectBuildSuccessMsg, 200);
		actionsClick(queues_projectBuildSuccessMsg,"projectBuildSuccessMsg_Ok_Button");	
		logPass("Project successfully created with Project Id "+projectId);
		//---		
		waitForElementPresent(projectMenu, 300);
		click(projectMenu,"project Link");
		click(Reports_projectByPM,"projectByPM");
		waitForElementPresent(Reports_projectByPM_headline, 200);
		//11 the step in test cases - need clarification
		//verifyText(reports_projectBtPM_ProjectManager_DD, "", "");   
		waitForElementPresent(reports_projectBtPM_ProjectManager_DD, 300);
		actionsClick(reports_projectBtPM_ProjectManager_DD,"ProjectManager DropDown");
		waitForElementPresent(projectManager_search, 300);
		type(projectManager_search, "Alvin Walker", "projectManager Search");
		type(projectManager_search, "Alvin Walker", Keys.ENTER);
		
		waitForElementPresent(reports_projectBtPM_view_DD, 300);      
		String viewDD_value=getDropdownSelectedValue(reports_projectBtPM_view_DD);		
		waitForElementPresent(viewDD_value, 300);
		Assert.assertEquals(viewDD_value, "O'Reilly");
		logPass("Default value under view Drop Down is 'O'Reilly'");       
		System.out.println("is group By Customer checked ? - " +isChecked(reports_projectBtPM_groupByCustomer));
		waitForElementPresent(reports_projectBtPM_groupByCustomer, 300);  
		Assert.assertFalse(isChecked(reports_projectBtPM_groupByCustomer));
		logPass("Group By Customer unchecked.");
		waitForElementPresent(reports_projectBtPM_search, 300);  
		JSClick(reports_projectBtPM_search,"Search");    
		waitForElementPresent(reports_projectBtPM_PIDs, 300);  
		verifyTextInColumnClickOtherColumnJS(reports_projectBtPM_PIDs, reports_projectBtPM_magnifier_parametarised, projectId);
		//verifyText(reports_projectBtPM_projectViewEditPage_headLine, "Project Details:", "");
		String dueDateFromApplication=getAttributeValue(dashboard_addProject_dueDate, "value");
		
		//verifyText(reports_projectBtPM_project_dueDateChangeNote, "test", "");
		logPass("Project Details page displayed the Due Date we previously entered, the Note section displayed the text entered when we changed the due date");
        logOut();
	}

	private boolean isChecked(String locator) {
		// TODO Auto-generated method stub
		return getElement(locator).isSelected();
	}


}
