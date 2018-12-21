package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class ProjectsDropDown extends MediatorClass{
	
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description:  verify Project By PM and calendar by VP Page should be displayed
	 */

    @Test(alwaysRun=true,enabled=true)
    public void projectsDropDown(ITestContext context) throws Throwable {
    	 
    	// * Below variables written to get input data from excel sheet-Testdata.xlsx
    	boolean isassert;
    	AssertSoftly softassert = new AssertSoftly();
  		String[] loginDetails;
  		loginDetails = getCredentails(context);
  		String zUserName = loginDetails[0];
  		String zPassword = loginDetails[1];
  		String projectByPM_headline=getTestData(this.getClass().getSimpleName().substring(0, 8),1);
		String projectByVP_headline=getTestData(this.getClass().getSimpleName().substring(0, 8),2);
		
        logger = extent.startTest("Verify Projects DropDowns").assignCategory("Projects");
        logInfo("Currently Running on -- "+getCurrentUrl());
      	logInfo("TestCase Description:  verify Project By PM and calendar by VP Page should be displayed");
        
      	// * Below Code written to verify login
     	login(zUserName, zPassword);
      	
        waitForElementPresent(projectMenu, 300);  
        actionsClick(projectMenu,"Project Menu");
        logPass("Project Menu-Project By PM");
        // * Below method written to verify project PM headline
        isassert = verifyProjectHeadLine(Reports_projectByPM, Reports_projectByPM_headline, projectByPM_headline);        
        softassert.assertEquals(isassert, true);
        
        // * Below method written to verify project VP headline
        actionsClick(projectMenu,"Project Menu");
        logPass("Project Menu-Project By VP");
        isassert = verifyProjectHeadLine(Reports_projectByVP, Reports_projectByVP_headline, projectByVP_headline);        
        softassert.assertEquals(isassert, true);
        softassert.assertAll();
        
        actionsClick(Reports_projectByVP_dropDown, "Project By VP DropDwon");
        Thread.sleep(1000);
        logPass("Able to select_projectByVP_dropDownOption_search successfully");
        
    	// * Below method written to logout application
		logOut();
        
       
    }

}
