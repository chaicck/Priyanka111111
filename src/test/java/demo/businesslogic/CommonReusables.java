package demo.businesslogic;

import static demo.objectrepository.OR_DNSRecords.nameToVerify;
import static demo.objectrepository.OR_DNSRecords.totalDnsRecords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.LogStatus;

import accelerators.ActionEngine;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_Logout;
import demo.objectrepository.OR_SearchPage;
import utils.ExcelUtils;
import demo.objectrepository.OR_Portal_users;

public class CommonReusables extends ActionEngine implements OR_LoginPage,
		OR_CustInfo, OR_Logout, OR_Portal_users {
	Alert alert;
	private String sTestCaseName;
	private int iTestCaseRow;
	Properties prop = new Properties();

	/**
	 * This method is used return test data based on Test case name
	 */
	public String getTestData(String testcaseName, int rowNo) throws Exception

	{
		String testData = null;
		XSSFSheet ExcelWSheet;
		try {
			FileInputStream ExcelFile = new FileInputStream(
					System.getProperty("user.dir") + "\\TestData.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);

			if (getCurrentUrl().contains("qa5")) {
				ExcelWSheet = ExcelWBook.getSheetAt(0);
			} else if (getCurrentUrl().contains("qa6")) {
				ExcelWSheet = ExcelWBook.getSheetAt(1);
			} else if (getCurrentUrl().contains("master-")) {
				ExcelWSheet = ExcelWBook.getSheetAt(2);
			} else {
				ExcelWSheet = ExcelWBook.getSheetAt(3);
			}
			int n = ExcelWSheet.getLastRowNum();

			for (int i = 1; i <= n; i++)
				if (ExcelWSheet.getRow(i).getCell(0).getStringCellValue() != null
						&& ExcelWSheet.getRow(i).getCell(0)
								.getStringCellValue().contains(testcaseName)) {
					DataFormatter dataFormatter = new DataFormatter();
					testData = dataFormatter.formatCellValue(ExcelWSheet
							.getRow(i).getCell(rowNo));
					return testData;
				}
		} catch (Exception e) {
			System.out.println("Unable to access xlsx file " + e.getMessage());
			throw e;
		}
		return testData;
	}

	/**
	 * TestNG data provider useful to return the login credentials from excel
	 * based on environment where scripts are executed
	 */
	@DataProvider
	public Object[][] Authentication(ITestContext context) throws Exception {
		/*
		 * sTestCaseName = this.toString(); // From above method we get long
		 * test case name including package and class name etc. // The below
		 * method will refine your test case name, exactly the name use have
		 * used sTestCaseName = ExcelUtils.getTestCaseName(this.toString()); //
		 * Fetching the Test Case row number from the Test Data Sheet
		 * 
		 * // Getting the Test Case name to get the TestCase row from the Test
		 * Data Excel sheet
		 * 
		 * iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
		 */
		// iTestCaseRow = ExcelUtils.getRowContains("zeus",0);
		String testParam = context.getCurrentXmlTest().getParameter("baseUrl");

		String sheet;

		if (testParam.contains("qa5")) {
			sheet = "qa5";
		} else if (testParam.contains("qa6")) {
			sheet = "qa6";
		} else if (testParam.contains("master-")) {
			sheet = "master";
		} else {
			sheet = "dev";
		}
		Object[][] testObjArray = ExcelUtils.getTableArray(
				System.getProperty("user.dir") + "\\LoginCredentials.xlsx",
				sheet, 1);

		return (testObjArray);

	}

	/**
	 * TestNG data provider useful to return the login credentials from property
	 * file based on environment where scripts are executed
	 */
	public String[] getCredentails(ITestContext context) throws IOException {
		String[] loginDetails = new String[2];
		String testParam = context.getCurrentXmlTest().getParameter("baseUrl");

		if (testParam.contains("qa5")) {

			loginDetails[0] = readProp("qa5UserName");
			loginDetails[1] = readProp("qa5Password");
		} else if (testParam.contains("qa6")) {
			loginDetails[0] = readProp("qa6UserName");
			loginDetails[1] = readProp("qa6Password");
			;
		} else if (testParam.contains("master-")) {
			loginDetails[0] = readProp("masterUserName");
			loginDetails[1] = readProp("masterPassword");
		} else {
			loginDetails[0] = readProp("devUserName");
			loginDetails[1] = readProp("devPassword");
		}
		return loginDetails;
	}

	/**
	 * This method written to read inputs fromn property file
	 */
	public String readProp(String data) throws IOException {
		FileReader reader = new FileReader(System.getProperty("user.dir")
				+ "\\LogingCredentails.properties");
		Properties properties = new Properties();
		properties.load(reader);

		return properties.getProperty(data);

	}

	/**
	 * This method is useful to wait for element by refreshing the browser for
	 * stipulated time period
	 */

	public void waitForTextPresentByBrowerRefresh(String string, int sec, int no)
			throws InterruptedException {
		for (int i = 0; i < no; i++) {
			Thread.sleep((sec * 1000));
			refreshBrowser();
			if (verifyElementText(billing_contracts_contractIdList, "")) {
				break;
			}
		}

	}

	/**
	 * This method is used return current url where scripts are executed
	 */
	public String getCurrentUrl() {
		return Driver.getCurrentUrl();
	}

	/**
	 * This method is used to select records where Billing status & Account
	 * status are in Active status and click on respective Dollar icon & then
	 * invoice and payments button
	 */
	public void selectBillingAndAccStatusActive(String webElementLocator)
			throws Throwable {
		String reCusTableTr = null;
		List<WebElement> list = getAllElements(webElementLocator);
		for (int i = 1; i <= list.size(); i++) {
			reCusTableTr = String.format(OR_SearchPage.cusTableTr, i);
			if (getVisibleText(reCusTableTr + OR_SearchPage.cusTableBillingStatus).equals("Active")
					&& getVisibleText(
							reCusTableTr + OR_SearchPage.cusTableAccStatus)
							.equals("Active")) {
				click(reCusTableTr + OR_SearchPage.cusTableDollorLnk,
						"Dollor Link");
				break;
			}
		}
		click(reCusTableTr + OR_SearchPage.invoicesAndPayMentsLnk,
				"Invoice And Payments button");
	}

	/**
	 * This method is used to select records where Billing status & Account
	 * status are in Active status and click on respective Dollar icon & then
	 * inventory button then modifying the text and saving the changes made
	 */
	public void selectBillingAndAccStatusActiveAndIventory(
			String webElementLocator) throws Throwable {
		String reCusTableTr = null;
		List<WebElement> list = getAllElements(webElementLocator);
		for (int i = 1; i <= list.size(); i++) {
			reCusTableTr = String.format(OR_SearchPage.cusTableTr, i);
			if (getVisibleText(
					reCusTableTr + OR_SearchPage.cusTableBillingStatus).equals(
					"Active")
					&& getVisibleText(
							reCusTableTr + OR_SearchPage.cusTableAccStatus)
							.equals("Active")) {
				aJSClick(reCusTableTr + OR_SearchPage.cusTableDollorLnk,
						"Dollor Link");
				aJSClick(reCusTableTr + OR_SearchPage.inventory,
						"Inventory link");
				if (!isElementDisplayed(OR_Inventory.emptyInventory,
						"Empty Inventory Data")) {
					aJSClick(OR_Inventory.pencilLink, "Pencil symbol Link");
					Assert.assertTrue(isElementDisplayed(
							OR_Inventory.assetDetailsLabel,
							"Assert details label"));
					type(OR_Inventory.changeNoteTxtBox, "Test",
							"Change Note Text Box");
					aJSClick(OR_Inventory.inventorySaveBtn, "Save button");
					Assert.assertTrue(isElementDisplayed(
							OR_Inventory.successPopUp, "Success PopUp"));
					break;
				} else {
					navigateBack();
				}
			}
		}

	}

	/**
	 * This method is used to select records where project status 'Ready for
	 * billing' and completion equals to 85%
	 */
	public void selectCusStatusRFFBAndCmpletion85Per() throws Throwable {
		List<WebElement> cusTable = getAllElements(OR_SearchPage.projTableTotalRecords);
		for (int i = 1; i <= cusTable.size(); i++) {
			String reProjTableTr = String.format(OR_SearchPage.projTableTr, i);
			if (getVisibleText(reProjTableTr + OR_SearchPage.projTableStatus)
					.equals("Ready for FULL Billing")
					&& getVisibleText(
							reProjTableTr + OR_SearchPage.projTableCompletion)
							.equals("85%")) {
				click(reProjTableTr + OR_SearchPage.projTableCusLnk,
						"Customer Link");
				break;
			}
		}
	}

	/**
	 * This method is used get tomorrow's date
	 */
	public String tomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		return format.format(cal.getTime());
	}

	/**
	 * This method is used to perform 'login as' functionality for the user
	 * provided
	 */
	public void selectUser(String userName) throws Throwable {
		List<WebElement> cusTable = getAllElements(portalUsersTotalRecords);
		for (int i = 1; i <= cusTable.size(); i++) {
			String reCusTableTr = String.format(portalUsersTr, i);
			if (getVisibleText(reCusTableTr + userNameTxtPu).equals(userName)) {
				click(reCusTableTr + loginAsBtn, "Login As");
				break;
			}
		}
	}

	/**
	 * This method is used to get the date after n days in required format
	 */
	protected String dateAftersomeDays(int i, String Dateformat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		SimpleDateFormat format = new SimpleDateFormat(Dateformat);
		return format.format(cal.getTime());
	}

	protected String format(String locator) throws Throwable {
		return "css=input[name='" + locator.toLowerCase().replaceAll(" ", "_")
				+ "']";
	}

	/**
	 * This method is used verify the text present in a locator
	 */
	public boolean verifyElementText(String locator, String text) {
		boolean flag = false;
		try {
			if (getElement(locator).getText().contains(text)) {
				flag = true;
				logger.log(LogStatus.PASS, "Verified Expected text on webpage i.e. '" + text + "'" +"is matching");
				System.out.println("Verified Expected text on webpage i.e. '" + text + "'" +"is matching");
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			flag = false;
		}

		return flag;
	}

	/**
	 * This method is used return List of elements associated with same locator
	 */
	@SuppressWarnings("null")
	public List<String> getAllTheText(String locator) throws Throwable {
		List<String> listWithText = new ArrayList<>();
		List<WebElement> l = getAllElements(locator);
		for (WebElement webElement : l) {
			listWithText.add(webElement.getText());
		}
		return listWithText;
	}

	/**
	 * This method is used to perform web page scroll up
	 */
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-2000)", "");
	}

	/**
	 * This method is used to convert List into Set to remove duplicates
	 */
	public Set<String> listToSet(List<String> list) {
		Set<String> hSet = new HashSet<String>(list);
		return hSet;
	}

	/**
	 * This method is used to get the elements associated with same locator into
	 * LIST & verify the list of texts in a LIST with given list
	 */
	public boolean verifyAllListValuesInOrder(String locator, List<String> l)
			throws Throwable {
		boolean flag = false;
		List<String> list = getAllTheText(locator);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).contains(l.get(i)))
			{
				flag = true;
				logger.log(LogStatus.PASS,"List of value in order -->"+ list.get(i));
				System.out.println("List of value in order -->"+ list.get(i));
			}
			else
			{
				flag = false;
				logger.log(LogStatus.FAIL,"List of value not in order -->"+ list.get(i));
				System.out.println("List of value not in order -->"+ list.get(i));
				logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
				break;
			}
		}
		return flag;
	}

	/**
	 * This method is used to get the elements associated with same locator into
	 * LIST & verify the list of texts in a LIST with given list
	 */
	public void verifyAllListValues(String locator, List<String> l)
			throws Throwable {

		List<String> list = getAllTheText(locator);
		for (int i = 0; i < list.size(); i++) {

			int j = l.size();
			for (int x = 0; x < j; x++) {
				list.get(i).contains(l.get(x));
			}
			Assert.assertTrue(list.get(i).contains("s")
					|| list.get(i).contains("s"));
		}

	}

	/**
	 * This method is used to get the elements associated with same locator into
	 * LIST & verify the list of texts in a LIST with given list
	 */
	public boolean verifyAllListValuesContainsText(String locator, String text)
			throws Throwable {
		// TODO Auto-generated method stub
		List<String> list = getAllTheText(locator);
		for (String string : list) {
			System.out.println(string);
			if (!string.contains(text))
				return false;
		}
		return true;
	}

	/**
	 * This method is used to add element into list
	 */
	public List<String> AddElementsIntoList(String string) {
		List<String> list = new ArrayList<>();
		String[] texts = string.split(";");

		for (String text : texts) {
			list.add(text);
		}
		// return Lists.reverse(list);

		return list;

	}

	/**
	 * This method is used to user login
	 */
	public void userlogin(String username, String password) throws Throwable {
		waitForElementPresent(usernameTextBox, 10);
		type(usernameTextBox, username, "username");
		typee(passwordTextBox, password, "password");
		click(loginButton, "LoginButton");
	}

	/**
	 * This method is used to enter given text into the provided locator
	 */
	private void typee(final String we, String testdata, String elementName)
			throws Throwable {

		boolean flag = false;
		try {
			// ((JavascriptExecutor)
			// Driver).executeScript("arguments[0].scrollIntoView(true);", we);
			getElement(we).sendKeys(testdata);
			flag = true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (flag) {
				logger.log(LogStatus.PASS,
						"Successfully entered '********' into field -->"
								+ elementName);
			} else {
				logger.log(LogStatus.FAIL,
						"Failed to enter '*********' into field -->"
								+ elementName);
			}
		}
	}

	/**
	 * This method is used to check all the check boxes
	 */
	public void checkAll(String locator) throws Throwable {
		// TODO Auto-generated method stub
		List<WebElement> l = getAllElements(locator);
		for (WebElement webElement : l) {
			if (!webElement.isSelected()) {
				webElement.click();
			}
		}

	}

	/**
	 * This method is used to get attribute value provided
	 */
	protected String getAttributeValue(String locator, String attribute) {

		return getElement(locator).getAttribute(attribute);
	}

	/**
	 * This method is used to verify the given text present in the elements text
	 * associated with same locator and click on the matching element
	 */
	protected void verifyTextPresentInLinkAndClick(String locator, String text)
			throws Throwable {
		List<WebElement> l = getAllElements(locator);
		for (WebElement webElement : l) {
			if (webElement.getText().equalsIgnoreCase(text)) {
				webElement.click();
				break;
			}
		}

	}

	/**
	 * This method is used to find parent customer present in the table after
	 * common search like 'test' or 'viena'
	 */
	public List findParentCustomerFromHomePage(String locator) throws Throwable {
		return getAllElements(locator);
	}

	/**
	 * This method is used to click on all the elements associated with same
	 * locator
	 */
	public void clickonElements(String webElementLocator, String locator,
			String locatorName) throws Throwable {

		List<WebElement> list = getAllElements(webElementLocator);

		for (int i = 0; i < list.size(); i++) {
			String element = String.format(locator, i + 1);
			waitForElementPresentE(element, 10);
			scrollElementIntoView(element);
			JSClick(element);
		}
	}

	/**
	 * This method is used to get the 5 days before date
	 */
	public String fiveDaysbeforeCurrentDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		SimpleDateFormat format = new SimpleDateFormat("ddmmyyy");
		return format.format(cal.getTime());
	}

	/**
	 * This method is used to scroll to the bottom using predefined Actions in
	 * java
	 */
	public void scrollToBottomActions() {
		Actions a = new Actions(Driver);
		a.click().sendKeys(Keys.END);
	}

	/**
	 * This method is used to verify account billing status as 'Active' and
	 * click on respective $ button ->invoice ->export->invoice
	 */
	public boolean VerifyAccountBillingStatus(String webElementLocator,
			String locatorName) throws Throwable {
		boolean flag = false;
		List<WebElement> list = getAllElements(webElementLocator);
		System.out.println("No of rows found : " + list.size());

		for (int i = 1; i <= 2; i++) {
			if (getTextByXpath(
					"((//table[@id='customer_table']/tbody/tr)[" + i
							+ "]/td)[7]").equalsIgnoreCase("Active")
					&& getTextByXpath(
							"((//table[@id='customer_table']/tbody/tr)[" + i
									+ "]/td)[6]").equalsIgnoreCase("Active")) {
				click("xpath=(//table[@id='customer_table']/tbody/tr)[" + i
						+ "]/td[1]/ul/li[2]/a", "$Button");
				click("xpath=(//table[@id='customer_table']/tbody/tr)[" + i
						+ "]/td[1]/ul/li[2]/ul/li[5]/a", "invoiceButton");
				click("xpath=//a[@class='btn btn-success btn-sm pull-right']",
						"exportButton");
				Thread.sleep(3000);
				click("xpath=(//i[@class='glyphicon  glyphicon-search '])[3]",
						"invoiceButton");
				actionsClick("xpath=//button[@class='close']",
						"invoiceCloseButton");
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * This method is used to verify account billing status as 'Active' and
	 * click on customer name
	 */
	public void getActiveCustomer(String webElementLocator) throws Throwable {
		List<WebElement> list = getAllElements(webElementLocator);
		System.out.println("No of rows found : " + list.size());
		for (int i = 1; i <= list.size(); i++) {
			if (getTextByXpath(
					"((//table[@id='customer_table']/tbody/tr)[" + i
							+ "]/td)[7]").equalsIgnoreCase("Active")
					&& getTextByXpath(
							"((//table[@id='customer_table']/tbody/tr)[" + i
									+ "]/td)[6]").equalsIgnoreCase("Active")) {
				String customerName = "xpath=//*[@id='customer_table']/tbody/tr["
						+ i + "]/td[4]/a";
				scrollElementIntoView(customerName);
				JSClick(customerName);
				break;
			}
		}
	}

	/**
	 * This method is used confirm operation
	 */
	public void handsoffConfirmOperations() throws Throwable {
		List<WebElement> list = getAllElements(handoffConfirmButtons);

		for (int i = 0; i < list.size(); i++) {
			String element = String.format(handoffConfirmButton, 1);
			waitForElementPresent(element, 10);
			scrollElementIntoView(element);
			JSClick(element);
			waitForElementPresent(successText, 10);
			JSClick(okButton);
		}
	}

	/**
	 * This method is used to perform mouseOver operation
	 */
	public void mouseOver(String webElement) {

		WebElement element = getElement(webElement);
		Actions action = new Actions(WebDriver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is wirtten to use for logout
	 */
	public void logOut() throws Throwable {
		try {
			waitForElementPresent(logoutDd, 20);
			click(logoutDd, "Logout");
			Thread.sleep(500);
			logPass("Successfully clicked on right top Menu");
			JSClick(logoutBtn);
			if(readProp("zLogout").trim().contains(getPageTile()))
			{
				logger.log(LogStatus.PASS, "Logout Success : Logout Successefully from Zeus Application");
				System.out.println("Logout Success : Logout Successefully from Zeus Application");
			}
			else{
				System.out.println(readProp("zTitle").trim()+""+getPageTile().trim()+"Logout Failed : Unable to verify logout page");
				logger.log(LogStatus.FAIL, "Logout Failed : Unable to verify logout page");
				Assert.assertTrue(readProp("zLogout").trim().contains(getPageTile()),"Unable to verify logout page");
			}	
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Logout Failed due to exception" +e);
			throw e;
		}
		
	}
	
	public void logOutbilling() throws Throwable {
		try {
			waitForElementPresent(logoutDd, 20);
			click(logoutDd, "Logout");
			logPass("Successfully clicked on right top Menu");
			JSClick(logoutBtn);
		}catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Logout Failed due to exception" +e);
			throw e;
		}
	}

	/**
	 * This method is used call after each method execution, if any test cases
	 * fails, it is used to capture screen shots and finally performs logout
	 * functionality ends the extent logger & flush the extent results and then
	 * quit the browser
	 */

	@AfterMethod(alwaysRun = true, enabled = true)
	public void afterMethod(ITestResult result) throws Throwable {

		try {
	        if(result.getStatus()==ITestResult.FAILURE){
	            logger.log(LogStatus.FAIL,"Failed test is: "+result.getName());
	            logger.log(LogStatus.FAIL, result.getThrowable());
//	            logger.log(LogStatus.FAIL, logger.addScreenCapture(capture(Driver, "screenShot")));
	        }
	        else if(result.getStatus()==ITestResult.SKIP){
	            logger.log(LogStatus.SKIP,"Skipped test is: "+result.getName());
	        } 
	    	}
	     
	        finally {	
	        extent.endTest(logger);
	        extentTestEndflag=true;
	        extent.flush();
	    	Driver.close();;
	        }
	}

	/**
	 * Used to perform logout functionality navigating to home page based on
	 * respective environment, then performing the logout only if login
	 * successful
	 */
	public void logOutt() throws Throwable {

		if (getCurrentUrl().contains("qa5")) {
			navigateTo("https://zeus.qa5.vonagenetworks.net/");
		} else if (getCurrentUrl().contains("qa6")) {
			navigateTo("https://zeus.qa6.vonagenetworks.net/");
		} else if (getCurrentUrl().contains("master-")) {
			navigateTo("https://zeus.qa6.vonagenetworks.net/");
		} else {
			navigateTo("https://zeus.qa6.vonagenetworks.net/");
		}
			waitForElementPresent(logoutDd, 20);
			actionsClick(logoutDd);
			Thread.sleep(1000);
			logPass("Successfully clicked on right top Menu");
			aJSClick(logoutBtn, "Logout Button");

		if(readProp("zLogout").trim().contains(getPageTile()))
		{
			logger.log(LogStatus.PASS, "Logout Success : Logout Successefully from Zeus Application");
			System.out.println("Logout Success : Logout Successefully from Zeus Application");
		}
		else{
			System.out.println(readProp("zTitle").trim()+""+getPageTile().trim());
			logger.log(LogStatus.FAIL, "Logout Failed");
			Assert.assertTrue(readProp("zLogout").trim().contains(getPageTile()));
		}	
	}
	
	public void login(String zUserName, String zPassword) throws Throwable
	{
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		JSClick(submitBtn, "Submit button");
		if(readProp("zTitle").trim().contains(getPageTile()))
		{
			logger.log(LogStatus.PASS, "Login Success : Login into Zeus Successefully");
			System.out.println("Login Success : Login into Zeus Successefully");
		}
		else{
			System.out.println(readProp("zTitle").trim()+""+getPageTile().trim());
			logger.log(LogStatus.FAIL, "Login Failed : Entered UserName/Password is wrong. Please check");
			Assert.assertTrue(readProp("zTitle").trim().contains(getPageTile()));
		}	
		
	}
	/**
	 * used get ToDay's date
	 */

	public String toDaysdate() {
		String pattern = "MMddyyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}

	/**
	 * Accepts java script alert
	 */
	public void acceptAlert() {
		alert = Driver.switchTo().alert();
		alert.accept();
		logger.log(LogStatus.PASS, "Alert present on page and clicked Ok");
		System.out.println("Alert present on page and clicked Ok");
	}

	/**
	 * Useful to Dismiss the java script alert
	 */
	public void dismissAlert() {
		try {
			alert = Driver.switchTo().alert();
			alert.dismiss();
			logger.log(LogStatus.PASS, "Alert present on page and clicked Ok");
			System.out.println("Alert present on page and clicked Ok");
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "No alert present on page");
			System.out.println("No alert present on page");
		}
		
	}

	/**
	 * Useful to get the text present on java script popup
	 */
	public String getAlertText() {
		alert = Driver.switchTo().alert();
		return alert.getText();
	}

	/**
	 * Useful to check first 2 check boxes
	 */
	public void selectTwoCheckBoxs() throws Throwable {
		for (int i = 1; i <= 2; i++) {
			click(String.format(OR_Inventory.chkBox, i), i + " Check box");
		}

	}

	/**
	 * Used to verify the java script alert present or not
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			Driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	/**
	 * This method is used to update the CSV file at particular row & column by
	 * given text
	 */
	public static void updateCSV(String fileToUpdate, String replace, int row,
			int col) throws IOException {

		File inputFile = new File(fileToUpdate);

		// Read existing file
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		// get CSV row column and replace with by using row and column
		csvBody.get(row)[col] = replace;
		reader.close();

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}

	/**
	 * This method is used to generate a random Alphabets string of given length
	 */
	public static String generateRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder objStringBuilder = new StringBuilder();
		Random random = new Random();
		for (int temp = 0; temp < length; temp++) {
			char c = chars[random.nextInt(chars.length)];
			objStringBuilder.append(c);
		}
		return objStringBuilder.toString();
	}

	/**
	 * This method is used to generate string from given path
	 */
	public static String generateStringFromResource(String path)
			throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	/**
	 * This method is used to read data from property file and return it in
	 * HashMap
	 */
	public static HashMap<String, String> readPropFileReturnMap(
			String propFilePath) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		FileReader reader = new FileReader(propFilePath);
		Properties properties = new Properties();
		properties.load(reader);

		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}

	/**
	 * Useful to generate tomorrows date
	 */
	public static String tomorrowsDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(calendar.getTime()) + "T10:00:00.0000000-05:00";
	}

	/**
	 * Useful to generate future date after n number of days
	 */
	public static String futureDate(int noOfDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays + 1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(calendar.getTime()) + "T10:00:00.0000000-05:00";
	}

	/**
	 * This method is used to generate a random Alphabets string of given length
	 */
	public static String randomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder objStringBuilder = new StringBuilder();
		Random random = new Random();
		for (int temp = 0; temp < length; temp++) {
			char c = chars[random.nextInt(chars.length)];
			objStringBuilder.append(c);
		}
		return objStringBuilder.toString();
	}

	public static String randomNumString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * This method is used to generate a random Number string of given length
	 */
	public static String randomNum(int length) {
		return String.valueOf(length < 1 ? 0 : new Random()
				.nextInt((9 * (int) Math.pow(10, length - 1)) - 1)
				+ (int) Math.pow(10, length - 1));
	}
	/**
	 * This method is read the file as string
	 */
	public static String readFileAsString(String path) throws IOException {
		return FileUtils.readFileToString(new File(path),
				Charset.forName("UTF-8"));
	}

	/**
	 * This method is used to verify DNS records are added or not
	 */
	public boolean verifyDNSRecordIsAdded(String name) throws Throwable {
		boolean flag = false;
		try {
			List<WebElement> totalRecords = getAllElements(totalDnsRecords);
			for (int i = 1; i <= totalRecords.size(); i++) {
				if (getVisibleText(String.format(nameToVerify, i)).trim()
						.equalsIgnoreCase(name)) {
					Assert.assertTrue(true);
					logger.log(LogStatus.PASS,
							"Successfully added DNS entry ::" + name);
					System.out
							.println("Successfully added DNS entry ::" + name);
					flag = true;
					break;
					
				} else {
					if (totalRecords.size() == i) {
						Assert.assertFalse(true);
						flag = true;
						logger.log(LogStatus.FAIL, "Failed to add DNS entry ::"
								+ name);
						System.out.println("Failed to add DNS entry ::" + name);
					}
				}

			}
		} catch (Exception e) {
			flag = false;
			logger.log(LogStatus.FAIL, e);
			System.out.println(e.getMessage());
			Assert.fail();
		}
		return flag;
	}
	/**
	 * This method is written export button is displayed
	 */
	public boolean verifyIsExportButtonDisplayed(
			String admin_nexmo_managePremier_export) {
		boolean flag = false;
		
		try {
			
		  boolean isExportDisplayed = isElementDisplayed(
					admin_nexmo_managePremier_export, "Export");
			Assert.assertTrue(isExportDisplayed);
			flag = true;

		} catch (AssertionError e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, e);
			System.out.println("Assertation Exeception " + e);
		} finally {

			if (flag) {
				logPass("Verified Export button is not displayed in UI after deleting");

			} else {
				logFail("Failed : Export button displayed");
				System.out.println("Failed : Export button displayed");
			}
		}
		return flag;
		
		
	}
	/**
	 * This method is used to Delete number and verify the text
	 */
	public boolean deleteNumber(String admin_nexmo_managePremier_search, String admin_nexmo_managePremier_table_numbers, String 
			admin_nexmo_managePremier_table_delete_parametarised, String admin_nexmo_managePremier_successMsg,  String phoneNumber1, String deletedMsg)
			throws Throwable {
		// TODO Auto-generated method stubs
		type(admin_nexmo_managePremier_search, phoneNumber1, "Search Field by redirected to Premier Central number page showing the number details ");
		Thread.sleep(1000);
		verifyTextInColumnClickOtherColumn(
				admin_nexmo_managePremier_table_numbers,
				admin_nexmo_managePremier_table_delete_parametarised,
				phoneNumber1);
		acceptAlert();
		Thread.sleep(1000);
		return verifyText(admin_nexmo_managePremier_successMsg, deletedMsg,"Delete Message");

	}
	/**
	 * This method is used to Delete number and verify the text
	 */
	public boolean verifyPremierCentralNumber(String adminLInk, String menu, String submenu, String textElement,
			String text) throws Throwable {
//		setBrowserTo80Size();
		JSClick(adminLInk);
		Thread.sleep(1000);
		actionsClick(menu);
		mouseHoverClick(menu, "Menu");
		Thread.sleep(1000);
		JSClick(submenu);
		waitForElementPresent(textElement, 200);
		return verifyText(textElement, text, "Verifying HeadLine text");
	}
	
	/**
	 * This method is written to Sub menu head line text
	 */
	public boolean verifySubMenuHeadLine(String adminLInk, String menu, String submenu, String textElement,
			String text) throws Throwable {
//		setBrowserTo80Size();
		JSClick(adminLInk);
		mouseHoverClick(menu, "Menu");
		Thread.sleep(1000);
		JSClick(submenu);
		waitForElementPresent(textElement, 200);
		return verifyText(textElement, text, "Verifying Submenu HeadLine text");
	}
	/**
	 * This method is written to Sub menu head line text
	 */
	public boolean verifyProjectHeadLine(String projectMenu, String projectHeadline, String text) throws Throwable
	{
		click(projectMenu,"project Link");
		click(projectHeadline,"Project menu");
		Thread.sleep(5000);
        waitForElementPresent(projectHeadline, 200);
		
        return verifyText(projectHeadline, text, "Verifying HeadLine text");
		
	}
	 /** 
	  * This method is written to Sub-menu headline text
	 */
	public boolean verifySubMenuHeadLine(String adminLInk, String menu, String menuText, String submenu, String subMenuText, String textElement,
			String expectedText) throws Throwable {
//		setBrowserTo80Size();
		JSClick(adminLInk);
		mouseHoverClick(menu, menuText);
		Thread.sleep(1000);
		aJSClick(submenu, subMenuText);
		waitForElementPresent(textElement, 200);
		return verifyText(textElement, expectedText, "Verifying Submenu HeadLine text");
	}

	public boolean verifyClicksInPage(String mainLink, String mainLinkText, String menu,String menuText,String submenu, String subMenuText) throws Throwable {
		
		aJSClick(mainLink, mainLinkText);
		return mouseHoverMove(menu,menuText, submenu,menuText);
		
	}

	
	@SuppressWarnings("unused")
	protected boolean verifyDropDownOptionsRespectiveRecordsDisplayed(String queues_billing_showRecords_DD,String queues_billing_tableRecords, List<String> list) throws Throwable {
		// TODO Auto-generated method stub
		boolean flag = false;
		selectDropDownByVisibleText(queues_billing_showRecords_DD, list.get(0));
		Thread.sleep(2000);
		int totalReords=getAllElements(queues_billing_tableRecords).size();	  
		for (int i = 0; i < (list.size()-1); i++) {

			if (totalReords >=Integer.parseInt(list.get((i+1)))) {
				selectDropDownByVisibleText(queues_billing_showRecords_DD, list.get((i+1)));
				Thread.sleep(3000);
				int totalReords4=getAllElements(queues_billing_tableRecords).size();
//				Assert.assertEquals(Integer.toString(totalReords4), list.get((i+1))); 
				if(Integer.toString(totalReords4).contains(list.get((i+1))))
				{
					flag = true;
				}
					
				
			}

		}
		return flag;

	}
	
	protected boolean verifyMenuNotification(String menu,String subMenu,String panelTitle, String text) throws Throwable
	{
		boolean flag = false;
		JSClick(menu);
		JSClick(subMenu);
		waitForElementPresent(panelTitle, 60);
		flag = verifyText(panelTitle, text, "Panel Title");
		return flag;
		
	}
	
	protected boolean verifyByReducingBrowseSize(String reports, String menu,String submenu, String textElement, String text) throws Throwable {
		setBrowserTo80Size();
		aclick(reports,"Reports Link");
		aactionsClick(menu,menu);		
		aJSClick(submenu,submenu);
        waitForElementPresent(textElement, 200);
        return verifyText(textElement,  text, "Verifying HeadLine text");
	}
	
	protected void typeAndVerify10DiscountPrice(String text, int n) throws Throwable{
    	
		String customerDashboard_addMAC_productAddNew_productTextBox;
		String customerDashboard_addMAC_productAddNew_unitPrice;
		String customerDashboard_addMAC_productAddNew_discountPrice;
		customerDashboard_addMAC_productAddNew_productTextBox="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[1]/span/input[2]";
		customerDashboard_addMAC_productAddNew_unitPrice="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[6]/input";
		customerDashboard_addMAC_productAddNew_discountPrice="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[7]/div/input[1]";
    	
		scrollElementIntoView(customerDashboard_addMAC_productAddNew_productTextBox);
    	Thread.sleep(5000);
    	clearText(customerDashboard_addMAC_productAddNew_productTextBox);
    	type(customerDashboard_addMAC_productAddNew_productTextBox, text, "");
		type(customerDashboard_addMAC_productAddNew_productTextBox, "", Keys.ARROW_DOWN , Keys.ENTER);
		Thread.sleep(9000);
		String unitPrice= getAttributeValue(customerDashboard_addMAC_productAddNew_unitPrice, "value");
		String discountPrice=getAttributeValue(customerDashboard_addMAC_productAddNew_discountPrice, "value");
		
		
		Double result = Double.parseDouble(unitPrice);			
		System.out.println(result);
		Double d= (result/100)*10;
		double discountPriceAmount=result-d;
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(discountPriceAmount));
		String discountPriceamt =df.format(discountPriceAmount);
		
		System.out.println("unit"+unitPrice);
		System.out.println("discount"+discountPrice);
		System.out.println("discount"+d);
		System.out.println("converted"+discountPriceamt);
		
        //System.out.println(df.format(Double.toString(discountPriceAmount)));
		Assert.assertTrue(discountPrice.contains(discountPriceamt));
		logPass("Verified "+discountPrice+ "is matching after converting price to " +discountPriceamt);
    }
	
	
	

}
