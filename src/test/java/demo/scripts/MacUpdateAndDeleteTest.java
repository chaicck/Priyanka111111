package demo.scripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;

public class MacUpdateAndDeleteTest extends CommonReusables implements OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC {



    @Test

    public void macTest() throws Throwable {
        logger = extent.startTest("Mac HomePage Icons");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
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
        waitForElementPresentE(addMacLink, 10);
        click(addMacLink, "macOkButton");
        waitForElementPresentE(macEditnameTextBox, 10);
        typeKeys(getElement(macEditnameTextBox), generateRandomString(6), true, true);
        click(addMacNameDropDown, "addMacNameTextBox");
        type(addMacNameTextBox, "Bogen", "addMacNameTextbox");
        type(addMacNameTextBox, "addMacNameTextBox", Keys.ENTER);
        click(macDetailsSaveButton, "macDetailsSaveButton");
        waitForElementPresentE(macOkButton, 10);
        click(macOkButton, "macOkButton");
        System.out.println("End Test");



    }
}