package testCases;

import java.io.File;
import java.text.DecimalFormat;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_76_EMAC_price_algorithm extends MediatorClass{
	
	String customerDashboard_addMAC_productAddNew_productTextBox;
	String customerDashboard_addMAC_productAddNew_unitPrice;
	String customerDashboard_addMAC_productAddNew_discountPrice;
	
	  String fs= File.separator;
	  String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_76_EMAC_price_algorithm(String zUserName, String zPassword) throws Throwable {
    	
    	//906268
    	
		 String customer_id=getTestData(this.getClass().getSimpleName().substring(0, 5),1);
		logger = extent.startTest("1.76 Test ID : 16834 - Verify that EMAC price algorithm sets the price at the 10 percent discount level").assignCategory("Customer DashBoard");
		logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Add MAC for any customer with Contarct product and verify MRC and NRC price.");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
        waitForElementPresent(searchTextBox, 300);
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox,"search box",Keys.ENTER);
		Thread.sleep(3000);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		waitForElementPresent(customer_dashboard_name, 300);
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");  

		logInfo("Customer Dashboard has been displayed");
		
		String Mac_name="Test "+randomString(2);
		String Mac_ticket=randomNum(5);
		Thread.sleep(9000);
		scrollElementIntoView(customerDashboard_addMAC);
		JSClick(customerDashboard_addMAC,"customerDashboard_addMAC");
		waitForElementPresent(customerDashboard_addMAC_productAddNew, 200);
		type(customerDashboard_addMAC_productAddNew_macName, Mac_name, "AddMAC_productAddNew_macName");
		type(customerDashboard_addMAC_productAddNew_ticket, Mac_ticket, "AddMAC_productAddNew_ticket");
		Thread.sleep(15000);
		scrollElementIntoView(customerDashboard_addMAC_productAddNew);
		JSClick(customerDashboard_addMAC_productAddNew,"addMAC_productAddNew");
		
		int n=getAllElements(customerDashboard_addMAC_productAddNew_productTextBoxList).size();
		customerDashboard_addMAC_productAddNew_productTextBox="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[1]/span/input[2]";
		customerDashboard_addMAC_productAddNew_unitPrice="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[6]/input";
		customerDashboard_addMAC_productAddNew_discountPrice="xpath=//*[@id='ptable']/tbody/tr["+n+"]/td[7]/div/input[1]";
		
		typeAndVerify10DiscountPrice("Realogy Access Charge");
		logPass("Verified 10% discount price with 'Realogy Access Charge'");
		//typeAndVerify10DiscountPrice("Hunt Group");
		typeAndVerify10DiscountPrice("Call Recording Storage 1 year");	
		Thread.sleep(6000);
		logPass("Verified 10% discount price with 'Call Recording Storage 1 year'");
		
		
		
    }
    
    public void typeAndVerify10DiscountPrice(String text) throws Throwable{
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
    }
    
}

