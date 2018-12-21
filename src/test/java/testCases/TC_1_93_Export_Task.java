package testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_93_Export_Task extends MediatorClass{
	
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_93_Export_Task(String zUserName, String zPassword) throws Throwable {
    	
    	
	 logger=extent.startTest("1.93 Test ID : 16258 - ZEUS-PM-46 Add Export Option to Task Overview Page").assignCategory("Projects");
	logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Projects by PM My Tasks and Verify task overview page");
	 type(userNameTxt, zUserName, "User name");
	type(passTxt, zPassword, "Password");
     click(submitBtn,"Submit button");
     logInfo("Logged into Zeus successfully");   
     
     waitForElementPresent(projectMenu, 150);
     //Verifyng projects By PM
      JSClick(projectMenu,"project Link");
      JSClick(projects_tasksMyTasks);
      waitForElementPresent(projects_tasksMyTasks_accessManagement_DD, 200);
      //qa5
      if(getCurrentUrl().contains("qa5")) {
    	selectDropDownByVisibleText(projects_tasksMyTasks_accessManagement_DD, "Access Management");	
		}
      if(getCurrentUrl().contains("qa6")) {
    	selectDropDownByVisibleText(projects_tasksMyTasks_accessManagement_DD, "Voice Build");	
		}
     
      logInfo("Selected '"+ getDropdownSelectedValue(projects_tasksMyTasks_accessManagement_DD)+"' option under AccessManagement DropDown");
      waitForElementPresent(projects_tasksMyTasks_owner_DD, 200);
      actionsClick(projects_tasksMyTasks_owner_DD,"owner_DropDown");
      waitForElementPresent(projects_tasksMyTasks_owner_DD_searchEntry, 200);
      type(projects_tasksMyTasks_owner_DD_searchEntry, "-", "owner_DropDown_searchBox");
      Thread.sleep(1000);
      type(projects_tasksMyTasks_owner_DD_searchEntry,"search box",Keys.ENTER);
      waitForElementPresent(projects_tasksMyTasks_projectManager_DD, 200);
      actionsClick(projects_tasksMyTasks_projectManager_DD,"projectManager DropDown");
      waitForElementPresent(projects_tasksMyTasks_projectManager_DD_searchEntry, 200);
      type(projects_tasksMyTasks_projectManager_DD_searchEntry, "-", "projectManager_DD_searchBox");
      Thread.sleep(1000);
      type(projects_tasksMyTasks_projectManager_DD_searchEntry,"search box",Keys.ENTER);
      waitForElementPresent(projects_tasksMyTasks_taskName_DD, 200);
      actionsClick(projects_tasksMyTasks_taskName_DD,"taskName DropDown");
      waitForElementPresent(projects_tasksMyTasks_taskName_DD_searchEntry, 200);
      type(projects_tasksMyTasks_taskName_DD_searchEntry, "-", "taskName_DD_searchBox");
      Thread.sleep(1000);
      waitForElementPresent(projects_tasksMyTasks_taskName_DD_searchEntry, 200);

      type(projects_tasksMyTasks_taskName_DD_searchEntry,"search box",Keys.ENTER);
      waitForElementPresent(projects_tasksMyTasks_status_DD, 200);
      selectDropDownByVisibleText(projects_tasksMyTasks_status_DD, "- Select Value -");
      logInfo("'- Select Value -' option selected under status Dropown");
      
      waitForElementPresent(projects_tasksMyTasks_searchBtn, 200);
      JSClick(projects_tasksMyTasks_searchBtn,"search Button");
      
      waitForElementPresent(projects_tasksMyTasks_exportBtn, 200);
      actionsClick(projects_tasksMyTasks_exportBtn,"export Buton");
      /*verifyText(projects_tasksMyTasks_exportBtn_dropDownValue1, "CSV", "");
      verifyText(projects_tasksMyTasks_exportBtn_dropDownValue2, "MS Excel", "");
      verifyText(projects_tasksMyTasks_exportBtn_dropDownValue3, "XML", "");
      
      JSClick(projects_tasksMyTasks_exportBtn_dropDownValue1,"CSV downalod");
      Thread.sleep(5000);
      
      
      actionsClick(projects_tasksMyTasks_exportBtn,"export Buton");
      JSClick(projects_tasksMyTasks_exportBtn_dropDownValue2,"MS Excel Download");
      Thread.sleep(5000);
      
      actionsClick(projects_tasksMyTasks_exportBtn, "export Buton");
      JSClick(projects_tasksMyTasks_exportBtn_dropDownValue3,"XML Download");
      Thread.sleep(5000);*/
      
     
    }
    
    private void Verify(String menu,String submenu, String textElement, String text) throws Throwable {
		JSClick(adminLInk);
		JSClick(menu);
		JSClick(submenu);
        waitForElementPresent(textElement, 200);
        verifyText(textElement,  text, "Verifying HeadLine text");
	}
}
