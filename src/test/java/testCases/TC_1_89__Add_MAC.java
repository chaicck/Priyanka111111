package testCases;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import org.testng.Assert;
import org.testng.annotations.Test;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_89__Add_MAC extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
           public void demo(String zUserName, String zPassword) throws Throwable {
           logger = extent.startTest("1.89 Test ID : 15008 - ZEUS-PM-22 Add MAC").assignCategory("Projects");
          logInfo("Currently Running on -- "+getCurrentUrl());
           logInfo("TestCase Description:Select Projects by PM Project Manager select All Open Projects for any project Add MAC,You are on the New MAC page");
           userlogin(zUserName, zPassword); 
            waitForElementPresent(searchTextBox, 200);
            waitForElementPresent(prjLnk, 300);
            click(prjLnk, "Project Link");
            click(prjByPMLnk, "Project DropDown");
            waitForElementPresent(projManagerDd, 300);
            actionsClick(projManagerDd, "Project Manager DropDown");
            actionsClick(allOpenProjLnk, "All open projects");
            actionsClick(srchBtn, "Search button");
            waitForElementPresent(firstProjLnk, 500);
            click(firstProjLnk, "First project link");
            waitForElementPresent(newMacLable, 300);
            Assert.assertTrue(isElementDisplayed(newMacLable,"New MAC"));
        
    }
}
