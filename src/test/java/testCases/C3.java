package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class C3 extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${TC_1_1_ImportNumbersToHaveSMS_service}
	 * @Date ${}
	 * @Modified ${12/06/2018}
	 */

	/**
	 * TestCase Description::C3
	 */
	@Test(alwaysRun = true, enabled = true)
	public void c3(ITestContext context) throws Throwable {

		// * Below variables written to get input data from LogingCredentails.properties
		
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 1), 1);
		String customer_Name = getTestData(this.getClass().getSimpleName().substring(0, 1), 2);
		String gloablParam = getTestData(this.getClass().getSimpleName().substring(0, 1), 3);
		String c3UserInfo = getTestData(this.getClass().getSimpleName().substring(0, 1), 4);
		String id = getTestData(this.getClass().getSimpleName().substring(0, 1), 5);
		String importtxt = getTestData(this.getClass().getSimpleName().substring(0, 1), 6);
		String buildCompany = getTestData(this.getClass().getSimpleName().substring(0, 1), 7);
		String build_UCC_Services = getTestData(this.getClass().getSimpleName().substring(0, 1), 8);
		String speak2Dial_Service = getTestData(this.getClass().getSimpleName().substring(0, 1), 9);
		String build_in_TeamOne = getTestData(this.getClass().getSimpleName().substring(0, 1), 10);

		// * Below Code written to verify login
		logger = extent.startTest("C3").assignCategory("C3");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description::C3");
		System.out.println("TestCase Description::C3");


		// * Below Code written to verify login
		login(zUserName, zPassword);

		click(srchDd, "Search");
		click(customerLnk, "Customer");
		type(srchTxt, customer_id, "Search box");
		type(srchTxt, customer_id, Keys.ENTER);
		isassert = verifyText(Customer_Dashboardverify, customer_Name,"Customer Name");
		softassert.assertEquals(isassert, true, "Verify customer name");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Global_Parametrers, "Global Parameters");
		
		waitForElementPresent(a, 20);
		isassert = verifyText(header, gloablParam, "Global Parameters");
		softassert.assertEquals(isassert, true, "Verify global parameters");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", C3_configure_users, "ConfiureUsers");
		waitForElementPresent(header, 20);
		isassert = verifyText(header, c3UserInfo, "C3 user Info");
		softassert.assertEquals(isassert, true ,"Verify C3 user info");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Build_enterprisegroup, "Enterprisegroup");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Build_Iads, "Enterprisegroup");
		waitForElementPresent(Verify_Build_Iads, 20);
		isassert = verifyText(Verify_Build_Iads, id, "Build_Id");
		softassert.assertEquals(isassert, true, "Verify buid id");
		

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", E911, "E911");
		waitForElementPresent(E911_verify, 20);
		isassert = verifyText(E911_verify, importtxt, "E911 page load verified");
		softassert.assertEquals(isassert, true, "Verify E911 page load verified");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Build_usersDevice, "User Device");
		isassert = verifyText(Verify_Build_usersDevice,buildCompany,"Build_usersDevice page load verified");
		softassert.assertEquals(isassert, true, "Verify Build_usersDevice page load verified");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Build_ucc, "UCC");
		isassert = verifyText(Verify_Build_ucc, build_UCC_Services,"Build_Ucc page load verified");
		softassert.assertEquals(isassert, true, "Verify build_Ucc page load verified");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Build_SCA, "Build SCA");
		isassert = verifyText(Verify_Build_SCA, "", "Build_SCA load Verified");
		softassert.assertEquals(isassert, true, "Verify build_SCA load Verified");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Colabirative_bridge, "Colabriravtive bridge");
		isassert = verifyText(colabarativebridge_verify, "","Colabarative bridge page load verified");
		softassert.assertEquals(isassert, true, "Verify Colabarative bridge page load verified");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Speak2dail, "Speak to dail");
		isassert = verifyText(header, speak2Dial_Service, "");
		softassert.assertEquals(isassert, true, "Verify Speak to dail");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", team_one, "team one");
		isassert = verifyText(verify_teamone, build_in_TeamOne,"verify_teamone");
		softassert.assertEquals(isassert, true, "Verify team one");

		actionsClick(Home, "Home");
		mouseHoverMove(c3_configuration, "C3_configuration", Customer_tag, "customer tag");
		isassert = verifyText(Verify_customertag, "", "Verify_customertag");
		softassert.assertEquals(isassert, true, "Verify customer tag");
		// * Below method written to logout application
		logOut();
		softassert.assertAll();
	}

}
