package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_95_Tasks_Calendar_Page extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tC_1_95_Tasks_Calendar_Page(String zUserName, String zPassword) throws Throwable {

        logger = extent.startTest("1.95 Test ID : 16103 - ZEUS-PM-92 Verify Tasks Calendar page").assignCategory("Projects");
      logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Go to projects then select Projects by PM,select the option All Open projects from the Project Manager drop down list\r\n" + 
        		"and hit magnifying glass button,Verify Tasks Calendar page");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");

        waitForElementPresent(projectMenu, 300);
       //Verifyng projects By PM
        click(projectMenu,"project Link");
		click(Reports_projectByPM,"menu");
        waitForElementPresent(Reports_projectByPM_headline, 400);
        
        waitForElementPresent(reports_projectBtPM_ProjectManager_DD, 300);
       actionsClick(reports_projectBtPM_ProjectManager_DD,"ProjectManager DropDown");
       waitForElementPresent(reports_projectBtPM_ProjectManager_DD_allOpenProjects, 300);
       actionsClick(reports_projectBtPM_ProjectManager_DD_allOpenProjects,"ProjectManager DropDown - AllOpenProjects");  
       waitForElementPresent(reports_projectBtPM_search, 300);
       actionsClick(reports_projectBtPM_search,"Search");
       waitForElementPresent(reports_projectBtPM_1stProjectInTableMagnifier, 300);
       actionsClick(reports_projectBtPM_1stProjectInTableMagnifier,"1stProjectInTableMagnifier");
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine, 300);
       verifyText(reports_projectBtPM_projectViewEditPage_headLine, "Project Details:", "");
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask, 300);
       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
       
       //verifying name
       boolean taskWith_Voice_Build = verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, "Voice Build");
       boolean taskWith_Voice_Install=verifyTextPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, "Voice Install");
       
       System.out.println(taskWith_Voice_Build +"  - -  "+taskWith_Voice_Install);
       Thread.sleep(3000);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask, 300);
       JSClick(reports_projectBtPM_projectViewEditPage_addTask);
       Thread.sleep(5000);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD, 300);
       actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, 300);
       type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, "Voice Build", "");
       System.out.println("1st Text"+getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, 300);
       clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, 300);
       type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, "Voice Install", "");
       System.out.println("2nd Text"+getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result));
       clearText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox);
       
       // adding new task with name starts with a
       
       type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, "a", "");
       String selectedText=getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
       System.out.println("3nd Text"+selectedText);
       type(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox, "", Keys.ENTER);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn, 300);
       actionsClick(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_addNewTaskToPrjctBtn);
       waitForElementPresent(taskAddSuccessMsg, 300);
       verifyText(taskAddSuccessMsg, "added successfully", "");  
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask_closeBtn, 300);
       actionsClick(reports_projectBtPM_projectViewEditPage_addTask_closeBtn);
       
       Thread.sleep(10000);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_addTask, 300);
       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_addTask);
       verifyTextsPresentInList(reports_projectBtPM_projectViewEditPage_taskNamesTable, selectedText, "");
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks, 300);
       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
       JSClick(reports_projectBtPM_projectViewEditPage_editTasks);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
       verifyTextInColumnClickOtherColumnJS(reports_projectBtPM_projectViewEditPage_taskNamesTable, reports_projectBtPM_projectViewEditPage_editTasks_checkBoxs, selectedText);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks, 300);
       scrollElementIntoView(reports_projectBtPM_projectViewEditPage_editTasks);
       JSClick(reports_projectBtPM_projectViewEditPage_editTasks_deleteSelectedTask);
       Thread.sleep(15000);
       acceptAlert();
       Thread.sleep(10000);
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_successMsg, 300);
       verifyText(reports_projectBtPM_projectViewEditPage_successMsg, "Successfully deleted", "");
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_editTasks_cancelEdit, 300);
       JSClick(reports_projectBtPM_projectViewEditPage_editTasks_cancelEdit);
       Thread.sleep(5000);
       
       //need to write sort functionality verification
       
       //verifying step 8 od test case
       waitForElementPresent(reports_projectBtPM_projectViewEditPage_taskNamesTable, 300);
       actionsClick(reports_projectBtPM_projectViewEditPage_taskNamesTable);
       Thread.sleep(5000);
       
       String duration=randomNum(1);
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
       System.out.println("duration setUp"+duration);
       waitForElementPresent(projectEdit_duration, 300);
       String durationFromWebpage=getAttributeValue(projectEdit_duration, "value");
       System.out.println("from webPage"+durationFromWebpage);
      
       assertEquals(durationFromWebpage, duration);
       waitForElementPresent(projectEdit_closeBtn, 300);
       actionsClick(projectEdit_closeBtn);
       
       // 9th step
      
       Thread.sleep(5000);
       waitForElementPresent(projectmenu, 300);
       JSClick(projectmenu);
        //click(projectMenu,"project Link");
       click(Reports_tasks_Calander,"menu");
       waitForElementPresent(Reports_tasks_CalanderViews_DD, 300);
       verifyDropDownValue(Reports_tasks_CalanderViews_DD, "Voice Build");
       verifyDropDownValue(Reports_tasks_CalanderViews_DD, "Voice Install");
       selectDropDownByValue(Reports_tasks_CalanderViews_DD, "Voice Build");
       waitForElementPresent(Reports_tasks_CalanderWeek, 300);
       actionsClick(Reports_tasks_CalanderWeek);
       Thread.sleep(5000);
       waitForElementPresent(Reports_tasks_CalanderDay, 200);
       actionsClick(Reports_tasks_CalanderDay);
       Thread.sleep(5000);
       waitForElementPresent(Reports_tasks_CalanderMonth, 200);
       actionsClick(Reports_tasks_CalanderMonth);
       Thread.sleep(5000);
       
		
       
       
}
} 
