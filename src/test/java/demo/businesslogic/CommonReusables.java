package demo.businesslogic;
import static demo.objectrepository.OR_DNSRecords.nameToVerify;
import static demo.objectrepository.OR_DNSRecords.totalDnsRecords;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.LogStatus;

import accelerators.ActionEngine;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_Logout;
import demo.objectrepository.OR_SearchPage;
import demo.objectrepository.OR_Portal_users;


public class CommonReusables extends ActionEngine implements OR_LoginPage,OR_CustInfo,OR_Logout, OR_Portal_users {
	Alert alert;

	public void waitForTextPresentByBrowerRefresh(String string, int sec, int no) throws InterruptedException {
		for (int i = 0; i < no; i++) {
			Thread.sleep((sec*1000));
			refreshBrowser();
			if (verifyElementText(billing_contracts_contractIdList,"")) {
				break;
			}
		}
		
	}
	
	public String getCurrentUrl() {		
		// TODO Auto-generated method stub
		return Driver.getCurrentUrl();
	}
	
	public void selectBillingAndAccStatusActive(String webElementLocator) throws Throwable {
		String reCusTableTr=null;
		List<WebElement> list = getAllElements(webElementLocator);
		for (int i = 1; i <= list.size(); i++) {
			reCusTableTr=String.format(OR_SearchPage.cusTableTr,i);
			if(getVisibleText(reCusTableTr+ OR_SearchPage.cusTableBillingStatus).equals("Active")&&getVisibleText(reCusTableTr+ OR_SearchPage.cusTableAccStatus).equals("Active")){
				click(reCusTableTr+ OR_SearchPage.cusTableDollorLnk,"Dollor Link");
				break;
			}
		}
		click(reCusTableTr+ OR_SearchPage.invoicesAndPayMentsLnk,"Invoice And Payments button");
	}
	
	
	public void selectBillingAndAccStatusActiveAndIventory(String webElementLocator) throws Throwable {
		String reCusTableTr=null;
		List<WebElement> list = getAllElements(webElementLocator);
		for (int i = 1; i <= list.size(); i++) {
			reCusTableTr=String.format(OR_SearchPage.cusTableTr,i);
			if(getVisibleText(reCusTableTr+ OR_SearchPage.cusTableBillingStatus).equals("Active")&&getVisibleText(reCusTableTr+ OR_SearchPage.cusTableAccStatus).equals("Active")){
				click(reCusTableTr+ OR_SearchPage.cusTableDollorLnk,"Dollor Link");
				click(reCusTableTr+ OR_SearchPage.inventory,"Inventory link");
				if(!isElementDisplayed(OR_Inventory.emptyInventory,"Empty Inventory Data")){
					click(OR_Inventory.pencilLink,"Pencil symbol Link");
					Assert.assertTrue(isElementDisplayed(OR_Inventory.assetDetailsLabel,"Assert details label"));
					type(OR_Inventory.changeNoteTxtBox,"Test","Change Note Text Box");
					click(OR_Inventory.inventorySaveBtn,"Save button");
					Assert.assertTrue(isElementDisplayed(OR_Inventory.successPopUp,"Success PopUp"));
					break;
				}
				else {
					navigateBack();
				}
			}
		}

	}

	
	public void selectCusStatusRFFBAndCmpletion85Per() throws Throwable{
		List<WebElement> cusTable=getAllElements(OR_SearchPage.projTableTotalRecords);
		for (int i = 1; i <=cusTable.size() ; i++) {
			String reProjTableTr=String.format(OR_SearchPage.projTableTr,i);
			if(getVisibleText(reProjTableTr+ OR_SearchPage.projTableStatus).equals("Ready for FULL Billing")&&getVisibleText(reProjTableTr+ OR_SearchPage.projTableCompletion).equals("85%")){
				click(reProjTableTr+ OR_SearchPage.projTableCusLnk,"Customer Link");
				break;
			}
		}
	}
	
	public String tomorrowDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		return format.format(cal.getTime());
	}
	
	public void selectUser(String userName) throws Throwable{
		List<WebElement> cusTable=getAllElements(portalUsersTotalRecords);
		for (int i = 1; i <=cusTable.size() ; i++) {
			String reCusTableTr=String.format(portalUsersTr,i);
			if(getVisibleText(reCusTableTr+userNameTxtPu).equals(userName)){
				click(reCusTableTr+loginAsBtn,"Login As");
				break;
			}
		}
	}
	
	protected String dateAftersomeDays(int i, String Dateformat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
SimpleDateFormat format = new SimpleDateFormat(Dateformat);
		return format.format(cal.getTime());
	}
	
	protected String format(String locator) throws Throwable {
		return "css=input[name='" + locator.toLowerCase().replaceAll(" ", "_") + "']";
	}
	public boolean verifyElementText(String locator, String text){
		   try {
			if(getElement(locator).getText().contains(text))
				return true;		
		} catch (Exception e) {		  
			   return false;		   
		}
		   return false;
	   }
	
	@SuppressWarnings("null")
	public List<String> getAllTheText(String locator) throws Throwable {
		List<String> listWithText = new ArrayList<>();
		 List<WebElement>l=getAllElements(locator);
		 for (WebElement webElement : l) {
			 listWithText.add(webElement.getText());
		}
	   return listWithText;
	}
	
public void scrollUp() {
		
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		 js.executeScript("window.scrollBy(0,-2000)", "");
	}

	

	public Set<String> listToSet(List<String> list) {
		Set<String> hSet = new HashSet<String>(list);
		return hSet;
	}
	
	public void verifyAllListValuesInOrder(String locator, List<String> l) throws Throwable {
		
		List<String> list =getAllTheText(locator);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(list.get(i).contains(l.get(i)));
		}
			
		}
public void verifyAllListValues(String locator, List<String> l) throws Throwable {
		
		List<String> list =getAllTheText(locator);
		for (int i = 0; i < list.size(); i++) {
			
			int j=l.size();
			for (int x = 0; x < j; x++) {
				list.get(i).contains(l.get(x));	
			}
			Assert.assertTrue(list.get(i).contains("s")||list.get(i).contains("s"));
		}
			
		}

public boolean verifyAllListValuesContainsText(String locator, String text) throws Throwable {
	// TODO Auto-generated method stub
	List<String> list =getAllTheText(locator);
	for (String string : list) {
		System.out.println(string);
		if(!string.contains(text))
			return false;
	}
		return true;
}
		
	public List<String> AddElementsIntoList(String string) {	
		List<String> list =new ArrayList<>();
	      String[]texts = string.split(";");
	      
		      for (String text : texts) {
		        list.add(text);
		      }
			//return Lists.reverse(list);
		   
		       return list;
	     
	}

	public void userlogin(String username, String password) throws Throwable {
		waitForElementPresent(usernameTextBox, 10);
		type(usernameTextBox, username, "username");
		typee(passwordTextBox, password, "password");
		click(loginButton, "LoginButton");
	}
	
	 private void typee( final String we,String testdata,String elementName) throws Throwable {

	        boolean flag=false;
	        try {
	            //((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", we);
	        	getElement(we).sendKeys(testdata);
	            flag=true;
	        } catch (Exception e) {
	            throw e;
	        }
	        finally {
	            if (flag){
	                logger.log(LogStatus.PASS,"Successfully entered '********' into field -->"+elementName);
	            }else {
	                logger.log(LogStatus.PASS,"Failed to enter '*********' into field -->"+elementName);
	            }
	        }
	    }
	
	public void checkAll(String locator) throws Throwable {
		// TODO Auto-generated method stub
		List<WebElement> l=getAllElements(locator);
		for (WebElement webElement : l) {
			if(!webElement.isSelected()) {
				webElement.click();
			}
		}
		
	}
	
	 protected String getAttributeValue(String locator, String attribute) {
			
		 return  getElement(locator).getAttribute(attribute);
	 }

	
	protected void verifyTextPresentInLinkAndClick(String locator, String text) throws Throwable {
		List<WebElement> l=getAllElements(locator);
		for (WebElement webElement : l) {
			if(webElement.getText().equalsIgnoreCase(text)) {
				webElement.click();
				break;
			}
		}
		
	}

	public List findParentCustomerFromHomePage(String locator) throws Throwable{
		return getAllElements(locator);
	}

	public void clickonElements(String webElementLocator,String locator,String locatorName) throws Throwable {

		List<WebElement> list = getAllElements(webElementLocator);

		for (int i = 0; i < list.size(); i++) {
			String element=String.format(locator, i+1);
			waitForElementPresentE(element, 10);
			scrollElementIntoView(element);
			JSClick(element);
		}
	}
	public String fiveDaysbeforeCurrentDate(){
	Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -7);
	SimpleDateFormat format = new SimpleDateFormat("ddmmyyy");
				return format.format(cal.getTime());
}

public void scrollToBottomActions(){
		Actions a=new Actions(Driver);
		a.click().sendKeys(Keys.END);
}

	public void VerifyAccountBillingStatus(String webElementLocator,String locatorName) throws Throwable {

		List<WebElement> list = getAllElements(webElementLocator);
		System.out.println("No of rows found : "+list.size());

		for (int i = 1; i <= list.size(); i++) {
			if(getTextByXpath( "((//table[@id='customer_table']/tbody/tr)["+i+"]/td)[7]").equalsIgnoreCase("Active")&&getTextByXpath( "((//table[@id='customer_table']/tbody/tr)["+i+"]/td)[6]").equalsIgnoreCase("Active")){
				if(i>15) {
					//scrollElementIntoView("xpath=(//table[@id='customer_table']/tbody/tr)[\"+i+\"]/td[1]/ul/li[2]/a");
					//scrollToBottom();
					scrollToBottomActions();
				}
				click("xpath=(//table[@id='customer_table']/tbody/tr)["+i+"]/td[1]/ul/li[2]/a", "$Button");
				scrollElementIntoView("xpath=(//table[@id='customer_table']/tbody/tr)[\"+i+\"]/td[1]/ul/li[2]/a");
				click("xpath=(//table[@id='customer_table']/tbody/tr)["+i+"]/td[1]/ul/li[2]/ul/li[5]/a", "invoiceButton");

				click("xpath=//a[@class='btn btn-success btn-sm pull-right']","exportButton");

				click("xpath=//*[@id=\"invoice_table\"]/tbody/tr[2]/td[3]","invoiceButton");
				click("xpath=//*[@id=\"basic_modal\"]/div/div/div[1]/button","invoiceCloseButton");
				navigateBack();
			}
		}
	}

	public void getActiveCustomer(String webElementLocator) throws Throwable {
		List<WebElement> list = getAllElements(webElementLocator);
		System.out.println("No of rows found : "+list.size());
		for (int i = 1; i <= list.size(); i++) {
			if(getTextByXpath( "((//table[@id='customer_table']/tbody/tr)["+i+"]/td)[7]").equalsIgnoreCase("Active")&&getTextByXpath( "((//table[@id='customer_table']/tbody/tr)["+i+"]/td)[6]").equalsIgnoreCase("Active")){
				String customerName="xpath=//*[@id='customer_table']/tbody/tr["+i+"]/td[4]/a";
				scrollElementIntoView(customerName);
				JSClick(customerName);
				break;				
			}
		}
	}


	public void handsoffConfirmOperations() throws Throwable {
		List<WebElement> list = getAllElements(handoffConfirmButtons);

		for (int i = 0; i < list.size(); i++) {
			String element=String.format(handoffConfirmButton, 1);
			waitForElementPresent(element,10);
			scrollElementIntoView(element);
			JSClick(element);
			waitForElementPresent(successText,10);
			JSClick(okButton);
		}
	}
	public void mouseOver(String webElement){

		WebElement element=getElement(webElement);
		Actions action=new Actions(WebDriver);
		action.moveToElement(element).perform();
	}
	public void logOut() throws Throwable {
		waitForElementPresent(logoutDd,20);
		click(logoutDd,"Logout Dropdownd");
		JSClick(logoutBtn);
	}
	
	public String toDaysdate(){		
		String pattern = "MMddyyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	public void acceptAlert(){
		alert=Driver.switchTo().alert();
		alert.accept();
	}
	
	
	public void dismissAlert(){
		alert=Driver.switchTo().alert();
		alert.dismiss();
	}
	public String getAlertText(){
		alert=Driver.switchTo().alert();
		return alert.getText();
	}
	public void selectTwoCheckBoxs() throws Throwable{
		for (int i = 1; i <=2; i++) {
			click(String.format(OR_Inventory.chkBox,i),i+" Check box");
		}

	}

	
	
	public boolean isAlertPresent(){		
		try{		
		Driver.switchTo().alert();		
		return true;		
		}catch(NoAlertPresentException ex){		
		return false;		
		}		
		}
	/**
	 * This method is used to generate a random Alphabets string of given length
	 *
	 */
	
	public static void updateCSV(String fileToUpdate, String replace,int row, int col) throws IOException {

		File inputFile = new File(fileToUpdate);

		// Read existing file 
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		// get CSV row column  and replace with by using row and column
		csvBody.get(row)[col] = replace;
		reader.close();

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
		}
	
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
	
	 public static String generateStringFromResource(String path) throws IOException {
	        return new String(Files.readAllBytes(Paths.get(path)));
	    }

	    public static HashMap<String, String> readPropFileReturnMap(String propFilePath) throws IOException{
	        HashMap<String, String> map = new HashMap<String, String>();
	        FileReader reader = new FileReader(propFilePath);
	        Properties properties = new Properties();
	        properties.load(reader);

	        for(Map.Entry<Object, Object> entry : properties.entrySet()) {
	            map.put((String) entry.getKey(), (String) entry.getValue());
	        }
	        return map;

	    }
	    public  static String tomorrowsDate(){
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_YEAR, 1);
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        return formatter.format(calendar.getTime())+"T10:00:00.0000000-05:00";
	    }
	    public  static String futureDate(int noOfDays){
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_YEAR, noOfDays+1);
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        return formatter.format(calendar.getTime())+"T10:00:00.0000000-05:00";
	    }
	    public  static String randomString(int length){
	        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	        StringBuilder objStringBuilder = new StringBuilder();
	        Random random = new Random();
	        for (int temp = 0; temp < length; temp++) {
	            char c = chars[random.nextInt(chars.length)];
	            objStringBuilder.append(c);
	        }
	       return objStringBuilder.toString();
	    }
	    public  static String randomNumString(){
	        return UUID.randomUUID().toString().replace("-","");
	    }
	    public  static String randomNum(int length){
	        return String.valueOf(length < 1 ? 0 : new Random()
	                .nextInt((9 * (int) Math.pow(10, length - 1)) - 1)
	                + (int) Math.pow(10, length - 1));
	    }
	   public static String readFileAsString(String path) throws IOException {
	        return FileUtils.readFileToString(new File(path),Charset.forName("UTF-8"));
//	       String content = new Scanner(new File(path)).useDelimiter("\\Z").next();
//	       return content;
	   }
	   
	   public void verifyDNSRecordIsAdded(String name) throws Throwable{
			try{
				List<WebElement> totalRecords=getAllElements(totalDnsRecords);
				for (int i = 1; i <=totalRecords.size() ; i++) {
					if(getVisibleText(String.format(nameToVerify,i)).trim().equalsIgnoreCase(name)){
						Assert.assertTrue(true);
						logger.log(LogStatus.PASS,"Successfully added DNS entry ::"+name);

						break;
					}else {
						if(totalRecords.size()==i){
							Assert.assertFalse(true);
							logger.log(LogStatus.FAIL,"Failed to add DNS entry ::"+name);
						}
					}

				}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		}  
	   

}
