package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_59_Delete_Parent_children_tasks extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_59_Delete_Parent_children_tasks(String zUserName, String zPassword) throws Throwable {
		 String id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
    	
    	 String projectToAdd="Internal Circuit Add - ORDER SUBMISSION";
 	    String projectWithChild="Internal Circuit Add - ORDER SUBMISSION � ";

        logger = extent.startTest("1.59 Test ID : 19621 - Test to check deleting parent task must delete all children tasks").assignCategory("Customer_DashBoard");
       logInfo("Currently Running on -- "+getCurrentUrl());
	 logInfo("TestCase Description:Go to project,select any projects then Add and Delete Task and verify deleting parent task must delete all children tasks ");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");       
        
        waitForElementPresent(srchDd, 200);
        click(srchDd,"Search");  
        click(search_project,"search project"); 
        type(srchTxt, id,"Search box");
        type(srchTxt,"Search box",Keys.ENTER);        
        verifyText(projectTableName, "Projects", "Project Table Name");   
        waitForElementPresent(projects_table_magnifyingSymbol, 200);
        actionsClick(projects_table_magnifyingSymbol, "projects_table_magnifyingSymbol");
        Thread.sleep(6000);
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine, 200);
        verifyText(reports_projectBtPM_projectViewEditPage_headLine, "Project Details:", "");     
        scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
        //Deleting the project, if it exists on the table already ..
        deleteTask(projectToAdd);        
        Thread.sleep(8000);
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask, 200);
        JSClick(reports_projectBtPM_projectViewEditPage_addTask,"reports_projectBtPM_projectViewEditPage_addTask");
        Thread.sleep(5000);
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD, 200);
        actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD);
        type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, projectToAdd, "Add a New Task to Project");
        
        String selectedText=getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
        logInfo(selectedText +" option seleccted under taskSelection Drop down");
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, 300);
        
        type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, "", Keys.ENTER);
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn, 300);
        actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn," Clicked on AddNewTaskToPrject");
        waitForElementPresent(taskAddSuccessMsg, 300);
        verifyText(taskAddSuccessMsg, "The selected task, and its sub-tasks have been added successfully!", "");  
        waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
        actionsClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn,"Close the Add Task window");
        
        Thread.sleep(15000);
       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
       Assert.assertTrue(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, selectedText));
       logInfo(selectedText+" preset in taskNamesTable");
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
        verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, projectWithChild);
        logInfo(projectWithChild+" preset in taskNamesTable");
      //Deleting child task alone & verifying parent task
       deleteTask(projectWithChild);
       Thread.sleep(10000);
       logPass(projectWithChild +" task has been deleted successfully");
       logInfo("Verifying the parent task i.e., "+selectedText+" after deleting child task i.e., "+ projectWithChild);
       refreshBrowser();
       
       Thread.sleep(9000);
       Assert.assertTrue(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, selectedText));
       logPass("Parent task i.e., "+selectedText +" didn't deleted even after deleting child task "+projectWithChild);
      ////Deleting parent task alone & verifying parent task & child task
       logInfo("Deleting the parent task i.e., "+selectedText);
       Thread.sleep(9000);
       deleteTask(selectedText);       
       refreshBrowser();
       Thread.sleep(13000);
       Assert.assertFalse(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, selectedText));
       Assert.assertFalse(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, projectWithChild));
       logPass("After deleting parent task, Child tasks also deleted.");
       logPass("Deletion of tasks only applied within the individual project and the tasks should not get delete in other projects");
       
}
    
    public void deleteTask(String projectToAdd) throws InterruptedException, Throwable{
    	if(verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_Tasks, projectToAdd)){
    	       verifyTextInColumnClickOtherColumn(reports_projectBtPM_projectViewEditPage_Tasks, reports_projectBtPM_projectViewEditPage_taskCheckBox, projectToAdd);
    	       Thread.sleep(1000);
    	       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
    	       Thread.sleep(1000);
    	       JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
    	       // deleting selected task
    	       JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask);      
    	       acceptAlert();
    	       Thread.sleep(5000);
    	       verifyText(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg, "Successfully deleted", "");
    	       JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn);
    	        Thread.sleep(1000);
    	        JSClick(projectEdit_saveTaskBtn);
    	        waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn, 20);
    	        JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask_successMsg_xBtn);
    	        
    	        }
		
    }
    
}
