package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;
import net.bytebuddy.implementation.bytecode.Throw;

public class CDRConfig extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:In CDRConfig Page Verify On/Off Buttons And Add
	 * Link_Manage_SFTP_Credentials Account
	 */
	@Test(alwaysRun = true, enabled = true)
	public void CDRConfiguration(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		String Credentials_username = getTestData(this.getClass().getSimpleName().substring(0, 5), 2);
		String Credentials_hostname = getTestData(this.getClass().getSimpleName().substring(0, 5), 3);
		String Credentials_port = getTestData(this.getClass().getSimpleName().substring(0, 5), 4);
		String Credentials_folder = getTestData(this.getClass().getSimpleName().substring(0, 5), 5);
		String Credentials_password = getTestData(this.getClass().getSimpleName().substring(0, 5), 6);
		String rsakey = getTestData(this.getClass().getSimpleName().substring(0, 5), 7);
		String savedsucessfullymessage = getTestData(this.getClass().getSimpleName().substring(0, 5), 8);
		String customertxt1 = getTestData(this.getClass().getSimpleName().substring(0, 5), 9);
		String customertxt2 = getTestData(this.getClass().getSimpleName().substring(0, 5), 10);

		// * logger method for report starting from here
		logger = extent.startTest("CDRConfig").assignCategory("Home","Regression test");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:In CDRConfig Page Verify On/Off Buttons And Add Link_Manage_SFTP_Credentials Account");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		// * Search for customerID in search box
		waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		Thread.sleep(1000);

		// * Below if statement is written to verify the customer table header
		if (verifyElementText(customerTableHeadline, customertxt1)) {
			isassert = verifyTextInColumnClickOtherColumn(customerIdList,
					customerName, customer_id);
			softassert.assertEquals(true, isassert,
					"Verified customer id "+customertxt1+" in customer table");
			logPass("Verified customer id "+customertxt1+" in customer table");
		}
		Thread.sleep(1000);
		isassert = verifyText(customer_dashboard_name, customertxt2,"Customer Name");
		softassert.assertEquals(isassert, true, "Verified customer id "+customertxt2+" in customer table");
	
		JSClick(homeBtnDd, "Home");
		Thread.sleep(1000);
		JSClick(prortaluserLink, "Portal User");
		waitForElementPresent(prortaluserLink_call_file, 80);

		// * Making CDR file transfer service to off
		if (getAttributeValue(prortaluserLink_call_file, "class").contains(
				checked)) {
			logPass("Call Detail Record (CDR) File Transfer Service is by default 'ON' and making it 'OFF'");
			System.out
					.println("Call Detail Record (CDR) File Transfer Service is by default 'ON' and making it 'OFF'");
			actionsClick(prortaluserLink_call_file,
					"Call Detail Record (CDR) File Transfer Service- ON");
			Thread.sleep(1000);

		} else {
			logPass("Call Detail Record (CDR) File Transfer Service is by default 'OFF' and making it 'ON'");
			System.out
					.println("Call Detail Record (CDR) File Transfer Service is by default 'OFF' and making it 'ON'");
			actionsClick(prortaluserLink_call_file,
					"Call Detail Record (CDR) File Transfer Service- ON");
			Thread.sleep(1000);

		}

		// * Making CDR file transfer service to ON
		if (!getAttributeValue(prortaluserLink_call_file, "class").contains(
				checked)) {
			actionsClick(prortaluserLink_call_file,
					"Call Detail Record (CDR) File Transfer Service- ON");
			Thread.sleep(1000);

		}

		actionsClick(prortaluserLink_call_account,
				"Call Detail Record (CDR) Accounting (billable)- OFF");
		JSClick(prortaluserLink_Manage_SFTP_Credentials,
				"Clicked on Link_Manage_SFTP_Credentials");
		Thread.sleep(1000);
		// Fill required details into Manage SFTP credentials
		clearText(prortaluserLink_Manage_SFTP_Credentials_username);
		type(prortaluserLink_Manage_SFTP_Credentials_username,
				Credentials_username, "User name");
		clearText(prortaluserLink_Manage_SFTP_Credentials_hostname);
		type(prortaluserLink_Manage_SFTP_Credentials_hostname,
				Credentials_hostname, "Host name");
		clearText(prortaluserLink_Manage_SFTP_Credentials_port);
		type(prortaluserLink_Manage_SFTP_Credentials_port, Credentials_port,
				"Port");
		clearText(prortaluserLink_Manage_SFTP_Credentials_folder);
		type(prortaluserLink_Manage_SFTP_Credentials_folder,
				Credentials_folder, "Folder");
		JSClick(prortaluserLink_Manage_SFTP_Credentials_compress, "Compress on");
		JSClick(prortaluserLink_Manage_SFTP_Credentials_md5file, "MD5 Files");
		JSClick(prortaluserLink_Manage_SFTP_Credentials_passwordradiobutton,
				"Password Radiobutton");
		type(prortaluserLink_Manage_SFTP_Credentials_password,
				Credentials_password, "Pass Word");
		JSClick(prortaluserLink_Manage_SFTP_Credentials_RSAradiobutton,
				"RSA radio button");
		type(prortaluserLink_Manage_SFTP_Credentials_rsakey, rsakey, "RSA Key");
		scrollElementIntoView(prortaluserLink_Manage_SFTP_Credentials_save);
		JSClick(prortaluserLink_Manage_SFTP_Credentials_save,
				"Saved sucessfully");
		scrollElementIntoView(prortaluserLink_Manage_SFTP_Credentials_savedsucessfullymessage);
		// verifies expected text and its corresponding HTML tag are present on the page.
		isassert = verifyText(
				prortaluserLink_Manage_SFTP_Credentials_savedsucessfullymessage,
				savedsucessfullymessage, "Saved sucessfully massage verified");
		softassert.assertEquals(isassert, true,
				"Verified expected text on page");
		// waitForElementPresent(prortaluserLink_Manage_SFTP_Credentials_windowclose_X, 80);
		JSClick(prortaluserLink_Manage_SFTP_Credentials_windowclose_X,
				"Window close");
		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	

	}

}
