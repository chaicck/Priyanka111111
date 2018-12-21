package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_FAXMail;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class FAXAddDeleteModify extends CommonReusables implements OR_FAXMail,
		OR_SearchPage, OR_HomePage, OR_CustInfo, OR_ProjectManager, OR_NewMAC {
	/**
	 * @author ${FAXAddDeleteModify}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */

	/** TestCase Description:Add, modify, delete faxmail feature */

	@Test(alwaysRun = true, enabled = true)
	public void addDns(ITestContext context) throws Throwable {
		
		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		String[] loginDetails;
		loginDetails = getCredentails(context);
		SoftAssert softassert = new SoftAssert();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String id = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		String mailID = getTestData(this.getClass().getSimpleName().substring(0, 5), 2);
		String mailDomain = getTestData(this.getClass().getSimpleName().substring(0, 5), 3);
		String email = mailID + generateRandomString(5) + mailDomain; // added
		String faxtext = getTestData(this.getClass().getSimpleName().substring(0, 5), 4);
		
		logger = extent.startTest("FaxMail");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Add, modify, delete faxmail feature");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		// * Search for customer id
		type(srchTxt, id, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);
		click(voiceLnk, "Voice Link");
		click(faxMailLnk, "FaxMail Link");
		click(faxDeleteLnk, "Delete Icon");
		
		// * Verify alert when delete icon
		softassert.assertTrue(isAlertPresent(), "Alert is displayed on page");
		dismissAlert();
		
		// * Performs a click operation, and optionally waits for a new page to load.
		click(viewOrEditLnk, "View Or Edit Icon");
		Assert.assertTrue(Driver.getCurrentUrl().toLowerCase()
				.contains(faxtext));
		// * Naivete back to the page
		Driver.navigate().back();
		click(addFaxUserBtn, "Add Fax User Button");
		selectDropDownByIndex(numberDd, 2);
		type(recipientsMailTxt, email, "Recipients Mail");
		type(sendersMailTxt, email, "Senders Mail");
		// * Naivete back to the page
		Driver.navigate().back();
		click(uploadCoverSheetBtn, "Upload Cover SheetB button");
		click(uploadCoverSheetBtn_close, "Upload Cover SheetB button close");
		// * Below method written to logout application
		logOutt();
		softassert.assertAll();



	}
}
