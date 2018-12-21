package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;

public class MacUpdateAndDeleteTest extends CommonReusables implements OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC {


	 String fs= File.separator;
	 String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")

    public void macTest(String zUserName, String zPassword) throws Throwable {
        logger = extent.startTest("MAC Update And Delete");
        logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Add MAC Update And Delete In Admin Reconcilation");
        userlogin(zUserName, zPassword);
        waitForElementPresentE(adminLInk, 10);
        click(adminLInk, "adminLink");
        scrollElementIntoView(reconcilationLink);
        mouseOver(reconcilationLink);
        mouseOver(reconcilationMacLink);
        waitForElementPresentE(reconcilationMacLink, 10);
        JSClick(reconcilationMacLink);
        waitForElementPresentE(macEditLink, 10);
        click(macEditLink, "macEditLink");
        waitForElementPresentE(macEditnameTextBox, 10);
        typeKeys(getElement(macEditnameTextBox), generateRandomString(6), true, true);
        click(macDetailsSaveButton, "macDetailsSaveButton");
        waitForElementPresentE(macOkButton, 10);
        click(macOkButton, "macOkButton");
        waitForElementPresentE(macDeleteLink, 10);
        click(macDeleteLink, "macOkButton");
        waitForElementPresentE(deleteButton, 10);
        click(deleteButton, "macOkButton");
        



    }
}
