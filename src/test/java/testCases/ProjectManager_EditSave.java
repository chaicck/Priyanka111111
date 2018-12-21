package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class ProjectManager_EditSave extends MediatorClass{
	
/*	
 * 1st adding the task to a manager
 * Verifying wheather added task updated or not.
 * Once updated, editing the fileds & verying edited fields are updated or not.
 * Then finally deleting the added task.
 * 
 * 
 * 
 * */
	
	 
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void editProjectTasks(String zUserName, String zPassword) throws Throwable {
      String Project_notes = "xpath=//textarea[@id='note']";
     logger=extent.startTest("Project Manager Edit and Save").assignCategory("Projects By PM","Regression test");
     logInfo("TestCase Description:Go to Project By PM,Search for any project edit and save");
     type(userNameTxt, zUserName, "User name");
     type(passTxt, zPassword, "Password");
     click(submitBtn,"Submit button");
     logInfo("Logged into Zeus successfully");
     //Verifyng projects By PM
     waitForElementPresent(projectMenu, 300);
     click(projectMenu,"project Link");
	 click(Reports_projectByPM,"menu");
	 waitForElementPresent(reports_projectBtPM_ProjectManager_DD, 300);
     actionsClick(reports_projectBtPM_ProjectManager_DD);
     actionsClick(reports_projectBtPM_ProjectManager_DD_AbbyHastings);       
     actionsClick(reports_projectBtPM_search);
     logPass("select AbbyHastings as project manager then clicked on search."); 
     actionsClick(reports_projectBtPM_1stProjectInTableMagnifier, "clicked on the magnifying glass next to an open project");
     waitForElementPresent(reports_projectBtPM_projectViewEditPage_headLine, 300);
     verifyText(reports_projectBtPM_projectViewEditPage_headLine, "Project Details:", "");
     selectDropDownByIndex(reports_projectBtPM_projectViewEditPage_Projectname_DD, 1);
     type(Project_notes, "Test", "Project_notes");
     actionsClick(queues_newProject_saveRecalculateBtn, "Save and Recalculate");
     actionsClick(queues_projectBuildSuccessMsg, "alert success message");
    
      logOut();
}


}
