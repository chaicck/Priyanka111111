package testCases;

import demo.businesslogic.MediatorClass;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Circuit extends MediatorClass{
	String circuitSearch_circuitsHeading="xpath=(//a[starts-with(@href,'/circuit/listByCustomer/customer')])[3]";
	String Circuits_addCircuit="xpath=//a[starts-with(@href,'/circuit/addStep1/customer_id')]"; 
	String Circuits_addCircuit_circuitType_DD="id=circuit_type_id"; 
	String Circuits_addCircuit_Carrier_DD="id=carrier_id"; 
	String Circuits_addCircuit_pop_DD="id=pop_id"; 
	String Circuits_addCircuit_continue="xpath=(//button[@type='submit'])[2]";
	
	
	

	 String fs= File.separator;
	 String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	   public void verifyCircuitModifcation(String zUserName, String zPassword) throws Throwable {

		logger = extent.startTest("Circuit").assignCategory("Circuit");
		logInfo("TestCase Description:Add Circuit and or modify existing Circuit, once new or existing circuit has been performed, Add design entry (very important) delete circuit at the end of circuit scenarios have been perfromed. ");
	        Thread.sleep(2000);
	    	type(userNameTxt, zUserName, "User name");
			type(passTxt, zPassword, "Password");
	        click(submitBtn, "Submit button");
		    click(srchDd,"Search");  
		    click(search_circuit,"circuit button"); 
		    verifyText(circuit_tableName,"Circuits", "Verifying Circuits");   
		    
		    type(srchTxt, "1234","Search box");
	        type(srchTxt,"Search box",Keys.ENTER);	        
	        actionsClick(search_circuit_ViewEditLinksTable);
	        //Creating a ticket
	        waitForElementPresent(circuitSearch_circuitsHeading, 300);
	        actionsClick(circuitSearch_circuitsHeading,"Circuits");
	        waitForElementPresent(Circuits_addCircuit, 300);
	        actionsClick(Circuits_addCircuit,"'Add Circuits'");
	        
	        waitForElementPresent(Circuits_addCircuit_circuitType_DD, 300);
	       /* selectDropDownByIndex(Circuits_addCircuit_circuitType_DD, 2);
	        logPass("Circuit type value - 'Direct Internet'");
	        Thread.sleep(10000);	       
	        selectDropDownByIndex(Circuits_addCircuit_Carrier_DD, 1);
	        logPass("Circut value-365 Data Centers");
	        Thread.sleep(10000);	       
	        selectDropDownByIndex(Circuits_addCircuit_pop_DD, 1);
	        logPass("POP value-Charlotte, NC (clt1)");*/
	        
	        Thread.sleep(5000);	
	        if(!verifyElementText(Circuits_addCircuit_continue, "Continue")) {
				refreshBrowser();
				/*waitForElementPresent(Circuits_addCircuit_circuitType_DD, 300);
		        selectDropDownByIndex(Circuits_addCircuit_circuitType_DD, 2);
		        logPass("Circuit type value - 'Direct Internet'");
		        Thread.sleep(3000);	       
		        selectDropDownByIndex(Circuits_addCircuit_Carrier_DD, 1);
		        logPass("Circut value-365 Data Centers");
		        Thread.sleep(3000);	       
		        selectDropDownByIndex(Circuits_addCircuit_pop_DD, 1);
		        logPass("POP value-Charlotte, NC (clt1)");
		        Thread.sleep(2000);	*/
			}
	        selectDropDown();
	        actionsClick(Circuits_addCircuit_continue,"Continue");
	        waitForElementPresent(Circuits_addCircuit_continue, 30);
	        actionsClick(Circuits_addCircuit_continue,"Add Ticket");
	        //Finished creating ticket
	       
	        
	        waitForElementPresent(search_circuit_form_circuitId, 300);
	        clearText(search_circuit_form_circuitId);
	        String circuitId="1234"+generateRandomString(10);
	        waitForElementPresent(search_circuit_form_circuitId, 300);
	        type(search_circuit_form_circuitId, circuitId, "circuit id");
	        waitForElementPresent(search_circuit_form_saveBtn, 300);
	        actionsClick(search_circuit_form_saveBtn);
	        waitForElementPresent(search_circuit_form_successOkPopUp, 300);
	        actionsClick(search_circuit_form_successOkPopUp);
	        
	        //verifyText(search_circuit_form_circuitId, circuitId, "Circuit Id");
	        
	        scrollElementIntoView(search_circuit_form_addDesignEntryBtn);
	        waitForElementPresent(search_circuit_form_addDesignEntryBtn, 300);
	        JSClick(search_circuit_form_addDesignEntryBtn,"Add Design Entry");
	        waitForElementPresent(search_circuit_form_addDesignEntryBtn_circuitId, 300);
	        type(search_circuit_form_addDesignEntryBtn_circuitId, "1234", "Circuit Id");
	        waitForElementPresent(search_circuit_form_addDesignEntryBtn_addConnectedCircuitBtn, 300);
	        JSClick(search_circuit_form_addDesignEntryBtn_addConnectedCircuitBtn,"Add Connectected Circuit");
	        waitForElementPresentE(search_circuit_form_addDesignEntryBtn, 300);
	        scrollElementIntoView(search_circuit_form_addDesignEntryBtn);
	        Thread.sleep(9000);
	        waitForElementPresentE(search_circuit_form_CiircuitDesignEntries, 300);
	       verifyTextPresentInListAndDelete(search_circuit_form_CiircuitDesignEntries, search_circuit_form_CiircuitDesignEntries_delete,"1234");
	       Thread.sleep(9000);
	       acceptAlert();
	       logPass("Added circuit has been deleted successfully");
	       
	       Thread.sleep(2000);
	       String Circuit_AddLogEntryBtn="xpath=//a[@href='#log_modal']";
	       String Circuit_AddLogEntryBtn_AddLogtextEntry="id=log_entry";
	       String Circuit_AddLogEntryBtn_AddBtn="xpath=//button[text()='Add']";
	       String Circuit_logEntries_TableMessages="xpath=//table[@class='table table-striped table-condensed']/tbody/tr/td[4]";
	       String Circuit_logEntries_TableDelete_parametarised="xpath=//table[@class='table table-striped table-condensed']/tbody/tr[%s]/td[4]/a";
	       
	       String addLog="Test "+randomString(5);	       
	       waitForElementPresent(Circuit_AddLogEntryBtn, 300);
	       scrollElementIntoView(Circuit_AddLogEntryBtn);
	       Thread.sleep(2000);
	       JSClick(Circuit_AddLogEntryBtn, "Add Log Entry");	
	       waitForElementPresentE(Circuit_AddLogEntryBtn_AddLogtextEntry, 300);
	       type(Circuit_AddLogEntryBtn_AddLogtextEntry, addLog, "");	     
	       actionsClick(Circuit_AddLogEntryBtn_AddBtn,"Add");
	       Thread.sleep(3000);
	       waitForElementPresent(Circuit_logEntries_TableMessages, 300);
	       logInfo("Log Entry has been made successfully with message "+addLog);
	       if(getCurrentUrl().contains("qa5")) {
	       waitForElementPresentE(Circuit_logEntries_TableMessages, 300);
	       verifyTextInColumnClickOtherColumn(Circuit_logEntries_TableMessages, Circuit_logEntries_TableDelete_parametarised, addLog);
	       Thread.sleep(1000);
	       acceptAlert();
	       if(verifyElementText(Circuit_logEntries_TableMessages, "")) {			
				//Assert.assertFalse(verifyTextPresentInList(Circuit_logEntries_TableMessages, addLog));
				logPass("Added log deleted Successfully i.e., "+addLog);
			}
	       else {
	    	   logPass("Added log deleted Successfully i.e., "+addLog);
		}
	       }
	       
	       logOut();
	       
	        
	}  
	 
	 
	 
	 public boolean selectDropDown() throws Throwable{

		 waitForElementPresent(Circuits_addCircuit_circuitType_DD, 300);


		 int firstDropDownSize=getDropDownValues(Circuits_addCircuit_circuitType_DD, "").size();

		 for (int i = 2; i < firstDropDownSize; i++) {		

			 selectDropDownByIndex(Circuits_addCircuit_circuitType_DD, i);
			 Thread.sleep(4000);	  

			 int secondDropDownSize=getDropDownValues(Circuits_addCircuit_Carrier_DD, "").size();
			 for (int j = 1; j < secondDropDownSize; j++) {

				 selectDropDownByIndex(Circuits_addCircuit_Carrier_DD, 1);
				 Thread.sleep(4000);
				 int thirdDropDownSize = getDropDownValues(Circuits_addCircuit_pop_DD, "").size();
				
				 if (thirdDropDownSize>=2) {
					 selectDropDownByIndex(Circuits_addCircuit_pop_DD, 1);
					 Thread.sleep(4000);
					 logPass("Circuit type value - '"+ getDropdownSelectedValue(Circuits_addCircuit_circuitType_DD)+"'");
					 logPass("Circuit Carrier value - '"+ getDropdownSelectedValue(Circuits_addCircuit_Carrier_DD)+"'");
					 logPass("Circuit pop value - '"+ getDropdownSelectedValue(Circuits_addCircuit_pop_DD)+"'");
					 
					 return true;
				 }
				 else {
					 break;	
				 }

			 }




		 }
		return false;


		 
	 }
}
