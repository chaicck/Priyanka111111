package testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;

public class TestDemo extends CommonReusables implements OR_HomePage, OR_CustInfo {

    @Test
    public void demo() throws Throwable {
    	
    	try {
        logger = extent.startTest("Verify HomePage Icons");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
        waitForElementPresent(searchTextBox, 10);
        type(searchTextBox, "test", "searchBox");
        click(searchLinkButton, "Search");
        waitForElementPresent(projectLink, 10);
        click(projectLink, "projectLink");
        waitForElementPresent(customerTitleText, 10);
        click(queuesLink, "queuesLink");
        waitForElementPresent(newprojectLink, 10);
        click(newprojectLink, "newprojectLink");
        waitForElementPresent(addprojectplusButton, 10);
        click(addprojectplusButton, "addprojectplusButton");
        waitForElementPresent(marketDropDown, 10);
        click(marketDropDown, "marketDropDown");
        type(marketTextBox, "chi", "Search box");
        type(marketTextBox, "Search box", Keys.ENTER);
        waitForElementPresent(projectManagerDropDown, 10);
        click(projectManagerDropDown, "Abby Hastings");
        type(projectManagerTextBox, "ab", "Search box");
        type(projectManagerTextBox, "Search box", Keys.ENTER);
        type(globalNotesTextBox, "Test", "globalNotesTextBox");
        click(createProjectButton, "createProjectButton");
        waitForElementPresent(selectDateLink, 10);
        JSClick(selectDateLink);
        waitForElementPresent(buildProjectButton, 10);
        click(buildProjectButton, "buildProjectButton");
        waitForElementPresent(fillBillingDate, 10);
        selectDropDownByValue(billingStatusDropDown, "Ready for FULL Billing");
        click(fillBillingDate, "fillBillingDate");
        type(fillBillingDate, "06282018", "fillBillingDatebox");
        waitForElementPresent(saveButton, 10);
        click(saveButton,"saveButton");
        waitForElementPresent(successText,10);
        JSClick(okButton);
        waitForElementPresent(handOffLink, 10);
        JSClick(handOffLink);
       Thread.sleep(5000);
        clickonElements(checkBoxesList,handoffCheckBox, "checkBox");
        scrollElementIntoView(productTypeDropDown);
        selectDropDownByValue(productTypeDropDown, "Hybrid");
        waitForElementPresent(handoffRadioButtonsList,10);
        clickonElements(handoffRadioButtonsList,handoffRadioButtons,"radio Buttons");
        type(handoffDateTextBox, "06282018", "handoffDateTextBox");
        waitForElementPresent(handoffSaveandSignButton,10);
        click(handoffSaveandSignButton,"handoffSaveandSignButton");
        waitForElementPresent(successText,10);
        click(okButton,"okButton");
        waitForElementPresent(handoffConfirmButtons,10);
        handsoffConfirmOperations();
        Thread.sleep(15000);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }
}
