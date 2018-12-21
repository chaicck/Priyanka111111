package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_53_VIPCustomer_Filter_VIP_Types  extends MediatorClass{


	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tC_1_53_VIPCustomer_Filter_VIP_Types(String zUserName, String zPassword) throws Throwable {

        logger = extent.startTest("TC_1_53_VIPCustomer_Filter_VIP_Types").assignCategory("Reports");
	    logInfo("Currently Running on -- "+getCurrentUrl());
        logInfo("TestCase Description:Go to Reports then hover on Customers and select VIP Customer List and Verify All, Platinum VIP, Standard, VIP Filters");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");    
           
        //refreshBrowser();
         Thread.sleep(60000);
        Verify(reports_customers,reports_customers_vipCustomerList ,reports_reconciliation_subMenu_headline, "VIP Customers");
        type(customers_customer_search, "Colliers International", "search with customer name");
        Thread.sleep(60000);
       String defaultValue= selectedOptionDroDown(customers_vipCustomerList_customers_dropDown);
       System.out.println(defaultValue);
       Assert.assertTrue(defaultValue.contains("Platinum VIP"));
       logPass("Verified if user is able to filter the list of customers on the VIP Customer page\r\n" + 
       		"        and by using the following type:Platinum VIP"); 
        
        int platinum_vipReords=getAllElements(customers_vipCustomerList_Platinum_vipType_list).size();
        int totalReords1=getAllElements(customers_vipCustomerList_customers_recordsInTable).size(); 
        Thread.sleep(60000);
        Assert.assertEquals(platinum_vipReords, totalReords1);
        
        selectDropDownByVisibleText(customers_vipCustomerList_customers_dropDown, "VIP");
        logPass(" Verified if user is able to filter the list of customers on the VIP Customer page "
        		+ "and by using the following type:Standard VIP"); 
        Thread.sleep(3000);
        
        int vipReords=getAllElements(customers_vipCustomerList_vipType_List).size();
        int totalReords2=getAllElements(customers_vipCustomerList_customers_recordsInTable).size(); 
        Thread.sleep(60000);
        Assert.assertEquals(vipReords, totalReords2);
    	waitForElementPresent(customers_vipCustomerList_customers_dropDown, 200);
        selectDropDownByVisibleText(customers_vipCustomerList_customers_dropDown, "All");
        logPass(" Verified if user is able to filter the list of customers on the VIP Customer page "
        		+ "and by using the following type:All"); 
        Thread.sleep(3000);
        waitForElementPresent(customers_vipCustomerList_recordsPerPage_dropDown, 200);
        selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "100");
        Thread.sleep(9000);
        int totalReords3=getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
        
        if (totalReords3>=50) {
        	selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "50");
        	 Thread.sleep(3000);
            int totalReords4=getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
            Assert.assertEquals(totalReords4, 50);            
        }
        if (totalReords3>=25) {
        	selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "25");
        	 Thread.sleep(3000);
            int totalReords5=getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
            Assert.assertEquals(totalReords5, 25);            
        }
        if (totalReords3>=10) {
        	selectDropDownByVisibleText(customers_vipCustomerList_recordsPerPage_dropDown, "10");
        	 Thread.sleep(3000);
            int totalReords6=getAllElements(customers_vipCustomerList_customers_recordsInTable).size();
    		logOut();	
            Assert.assertEquals(totalReords6, 10);            
        }
        
    }
    private void VerifyClick(String menu,String submenu) throws Throwable {
		click(reports,"Reports Link");
		click(menu,menu);
        click(submenu,submenu);
	}

	private void Verify(String menu,String submenu, String textElement, String text) throws Throwable {
		click(reports,"Reports Link");
		aJSClick(menu,menu);		
		aJSClick(submenu,submenu);
        waitForElementPresent(textElement, 200);
        verifyText(textElement,  text, "Verifying HeadLine text");
	}
	
	
}
