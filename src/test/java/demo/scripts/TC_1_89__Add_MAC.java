package demo.scripts;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import org.testng.Assert;
import org.testng.annotations.Test;
import demo.objectrepository.OR_ProjectManager;

public class TC_1_89__Add_MAC extends CommonReusables implements OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

    @Test
    public void demo() throws Throwable {
        try

        {
            logger = extent.startTest("Verify Add MAC");
            userlogin("zqa-admin", "Q@eZL9Pw2D");
            waitForElementPresent(searchTextBox, 10);
            click(prjLnk, "Project Link");
            click(prjByPMLnk, "Project DropDown");
            waitForElementPresent(projManagerDd, 10);
            click(projManagerDd, "Project Manager DropDown");
            click(allOpenProjLnk, "All open projects");
            click(srchBtn, "Search button");
            waitForElementPresent(firstProjLnk, 40);
            click(firstProjLnk, "First project link");
            waitForElementPresent(newMacLable, 40);
            Assert.assertTrue(isElementDisplayed(newMacLable,"New MAC"));

        } catch (Exception e) {

        }
    }
}
