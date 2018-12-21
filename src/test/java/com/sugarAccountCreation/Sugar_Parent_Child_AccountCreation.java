package com.sugarAccountCreation;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_Admin;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_Projects;
import demo.objectrepository.OR_ReconsiliationPage;
import demo.objectrepository.OR_Reports;
import demo.objectrepository.OR_SearchPage;
import demo.objectrepository.OR_SugarSite;
import utils.WriteToExcel;

public class Sugar_Parent_Child_AccountCreation extends CommonReusables implements OR_SugarSite, OR_Projects,
		OR_Reports, OR_Admin, OR_SearchPage, OR_HomePage, OR_CustInfo, OR_NewMAC, OR_Inventory, OR_ReconsiliationPage {

	@Test
	public void sugarAccountCreationDisconnectVerification() throws Throwable {
		try {
            String userName = "ppundru";
			String password = "Ramareddy1@";
			String parent_companyId;
			String child_companyId;
            logger = extent.startTest("Suagr Child Account Creation");
			type(sugar_username, userName, "view In sugar Username");
			type(sugar_password, password, "view In sugar Password");
			click(sugar_loginBtn, "login Button");
			waitForElementPresent(sugar_comapniesMenu, 20);
			actionsClick(sugar_comapniesMenu);
			actionsClick(sugar_createCompany);
            String name = "Priyanka " + getRandomString(2) + " Parent";
			type(createACpmany_form_name, name, "");
			selectDropDownByIndex(createACpmany_form_market_DD, 2);
			selectDropDownByIndex(createACpmany_form_industry_DD, 2);
			type(createACpmany_form_billingAddress_street, "23 main street ", "");
			type(createACpmany_form_billingAddress_city, "holmdel", "");
			selectDropDownByVisibleText(createACpmany_form_billingAddress_state_DD, "New Jersey");
			Thread.sleep(4000);
			type(createACpmany_form_billingAddress_postalCode, "07733", "");
			type(createACpmany_form_billingAddress_postalCode, "search box", Keys.ENTER);
             scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
			Thread.sleep(4000);
			actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			Thread.sleep(2000);

			if (verifyElementText(createACpmany_duplicateCompany_headLine, "Possible Duplicate Company")) {
				actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			}

			parent_companyId = getText(createACpmany_companyId).trim();
			waitForElementPresent(createAcompany_opportunities, 20);
			scrollElementIntoView(createAcompany_opportunities);
			click(createAcompany_opportunities, "Opportunity created");
			type(createAcompany_opportunitiy_name, "Priyanka Test", "Opportunitiy_name type");
			selectDropDownByIndex(createAcompany_opportunitiy_Market, 2);
			type(createAcompany_opportunitiy_Recurring_Amount, "1000", "Recurring Amount Entered");
			String parent_expected_Proposal_date = dateAftersomeDays(30, "MM/dd/yyy");
			type(createAcompany_opportunitiy_Expected_Proposal, parent_expected_Proposal_date,
					"Expected proposal date");
			selectDropDownByIndex(createAcompany_opportunitiy_icbRequest_DD, 2);
            actionsClick(createAcompany_opportunitiy_creditCheck);
			actionsClick(createAcompany_opportunitiy_save_button);
            // Contacts creation
            Thread.sleep(5000);
			waitForElementToBeClickable(createAcompany_contacts_createBtn);
			scrollElementIntoView(createAcompany_contacts_createBtn);
			actionsClick(createAcompany_contacts_createBtn);
			type(createAcompany_contacts_form_firstName, "Priyanka", "");
			String parent_contact_lastName = "Reddy" + getRandomString(2);
			type(createAcompany_contacts_form_lastName, parent_contact_lastName, "");
			String email = "Priyanka" + getRandomString(2) + "@gmail.com";
			type(createAcompany_contacts_form_emailAddress, email, "");
			Thread.sleep(1000);
			actionsClick(createAcompany_contacts_form_saveBtn);
			Thread.sleep(4000);
            verifyTextInColumnClickOtherColumn(createAcompany_contacts_table_emailList,
			createAcompany_contacts_table_editLink, email);
			checkAll(createAcompany_contacts_edit_contactType_checkBoxs1);
			checkAll(createAcompany_contacts_edit_contactType_checkBoxs2);
			actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			Thread.sleep(5000);
            // Proposal Creation
            scrollElementIntoView(createACpmany_proposal_createBtn);
			actionsClick(createACpmany_proposal_createBtn);
			String proposal_subject = "Test Proposal" + getRandomString(2);
			type(createACpmany_proposal_form_subject, proposal_subject, "");
			selectDropDownByIndex(createACpmany_proposal_form_typeOfBusiness_DD, 1);
			selectDropDownByIndex(createACpmany_proposal_form_proposalStage_DD, 1);
			selectDropDownByIndex(createACpmany_proposal_form_proposal_type_DD, 1);
			String requestedInstallDate = dateAftersomeDays(5, "MM/dd/yyyy");
			type(createACpmany_proposal_form_requestedInstallDate, requestedInstallDate, "");
			scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
			actionsClick(createACpmany_form_shippingAddress_saveBtn2);
            Thread.sleep(2000);
			if (isAlertPresent()) {
				acceptAlert();
			}
			scrollElementIntoView(createACpmany_proposal_createBtn);
			verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable, proposal_subject);
         	waitForElementToBeClickable(createACpmany_proposal_editBtn);
		    actionsClick(createACpmany_proposal_editBtn);
            actionsClick(createACpmany_proposal_form_oppourtunityName);
			navigateToChild();
			maximise();
			Thread.sleep(1000);
			type(childOff_newTab_nameSearch, "test", "");
			type(childOff_newTab_nameSearch, "search box", Keys.ENTER);
         	Thread.sleep(1000);
         	actionsClick(createACpmany_proposal_oppourtunitySearch_1stOption);
			navigateBackToParentWindow();
            scrollElementIntoView(createACpmany_proposal_form_addRow);
			actionsClick(createACpmany_proposal_form_addRow);
			type(createACpmany_proposal_form_addRow_search, "advanced", "");
			Thread.sleep(3000);
			type(createACpmany_proposal_form_addRow_search, "search box", Keys.ENTER);
			actionsClick(createACpmany_form_shippingAddress_saveBtn2);
			if (isAlertPresent()) {
				acceptAlert();
			}
            // Admin
            Thread.sleep(1000);
            actionsClick(createAcompany_admin);
			actionsClick(createAcompany_usermanagement);
			actionsClick(createAcompany_userhome_account);
			actionsClick(createAcompany_usermanagement_edit);
			selectDropDownByValue(createAcompany_usermanagement_discountlevel, "gm");
			actionsClick(createAcompany_usermanagement_save);
            // proposal row discount check
            verifyTextPresentInLinkAndClick(form_headerLocators, name);
			actionsClick(createAcompany_Accounte_click);
			Thread.sleep(2000);
			/* verifyTextPresentInLinkAndClick(form_headerLocators, name); */
			actionsClick(createAcompany_Account_edit);
			scrollElementIntoView(createAcompany_Account_deposit_required);
			type(createAcompany_Account_deposit_required, "0", "");
			type(createAcompany_Account_deposit_received, "0", "");
			type(createAcompany_Account_deposit_dnb_score, "0", "");
			type(createAcompany_Account_deposit_deposit, "0", "");
			actionsClick(createACpmany_form_shippingAddress_saveBtn2);
			if (isAlertPresent()) {
				acceptAlert();
			}  
			scrollElementIntoView(createACpmany_proposal_createBtn);
			verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable, proposal_subject);
			// wrong
			/*
			 * scrollElementIntoView(createAcompany_Account_proposal_subject);
			 * actionsClick(createAcompany_Account_proposal_subject);
			 */
			// actionsClick(createAcompany_Account_pdf_print);
			actionsClick(createACpmany_proposal_saveAsPdf);
			Thread.sleep(10000);
			navigateBack();
			Thread.sleep(1000);
			actionsClick(createAcompany_Account_edit);
			waitForElementPresentE(createACpmany_proposal_form_proposalStage_DD, 10);
			selectDropDownByVisibleText(createACpmany_proposal_form_proposalStage_DD, "GM Approved");
			Thread.sleep(1000);
			acceptAlert();
			waitForElementPresentE(createACpmany_form_shippingAddress_saveBtn1, 10);
			actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			acceptAlert();
			// Excel Writing
			String location = System.getProperty("user.dir") + "\\TestData\\SugarAccountCreation_TestData.xlsx";
			WriteToExcel.intialiseExcel(location);
			WriteToExcel.writeExcel("Parent Account creation; Details");
			WriteToExcel.writeExcel("Parent company name;" + name);
			WriteToExcel.writeExcel("Parent Billing Address; 2605 Wildberry Ct,Edison,08817");
			WriteToExcel.writeExcel("opportunitiy_name;Priyanka Test");
			WriteToExcel.writeExcel("parent_expected_Proposal_date;" + parent_expected_Proposal_date);
			WriteToExcel.writeExcel("creating contact..; Details");
			WriteToExcel.writeExcel("parent_contact_firstName;Priyanka");
			WriteToExcel.writeExcel("parent_contact_lastName;" + parent_contact_lastName);
			WriteToExcel.writeExcel("parent_contact_email;" + email);
			WriteToExcel.writeExcel("proposal creation; Details");
			WriteToExcel.writeExcel("proposal_subject;" + proposal_subject);
			WriteToExcel.writeExcel("requestedInstallDate;" + requestedInstallDate);
			WriteToExcel.writeExcel("parent_companyId;" + parent_companyId);
			// Child Creation
			actionsClick(sugar_comapniesMenu);
			actionsClick(sugar_createCompany);
			String name_child = "Priyanka " + getRandomString(2) + " Child";
			type(createACpmany_form_name, name_child, "");
			selectDropDownByIndex(createACpmany_form_market_DD, 1);
			selectDropDownByIndex(createACpmany_form_industry_DD, 1);
			actionsClick(createACpmany_form_childOff_select);
			navigateToChild();
			maximise();
			Thread.sleep(1000);
			type(childOff_newTab_nameSearch, name, "");
			type(childOff_newTab_nameSearch, "search box", Keys.ENTER);
			Thread.sleep(1000);
			actionsClick(childOff_newTab_1stChild);
			navigateBackToParentWindow();
			type(createACpmany_form_billingAddress_street, "2605 Wildberry Ct", "");
			type(createACpmany_form_billingAddress_city, "Edison", "");
			// selectDropDownByIndex(createACpmany_form_billingAddress_state_DD, 3);
			type(createACpmany_form_billingAddress_postalCode, "08817", "");
			type(createACpmany_form_billingAddress_postalCode, "search box", Keys.ENTER);
			// scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
			Thread.sleep(4000);
			actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			if (isAlertPresent()) {
				acceptAlert();
			}
			Thread.sleep(2000);

			if (verifyElementText(createACpmany_duplicateCompany_headLine, "Possible Duplicate Company")) {
				actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			}
			waitForElementPresent(createAcompany_opportunities, 20);
			scrollElementIntoView(createAcompany_opportunities);
			click(createAcompany_opportunities, "Opportunity created");
			type(createAcompany_opportunitiy_name, "Priyanka Test", "Opportunitiy_name type");
			selectDropDownByIndex(createAcompany_opportunitiy_Market, 2);
			type(createAcompany_opportunitiy_Recurring_Amount, "1000", "Recurring Amount Entered");
			type(createAcompany_opportunitiy_Expected_Proposal, dateAftersomeDays(30, "MM/dd/yyy"),
					"Expected proposal date");
			selectDropDownByIndex(createAcompany_opportunitiy_icbRequest_DD, 2);
			actionsClick(createAcompany_opportunitiy_creditCheck);
			actionsClick(createAcompany_opportunitiy_save_button);
			child_companyId = getText(createACpmany_companyId).trim();
			// contacts creation - child
			Thread.sleep(5000);
			waitForElementToBeClickable(createAcompany_contacts_createBtn);
			scrollElementIntoView(createAcompany_contacts_createBtn);
			actionsClick(createAcompany_contacts_createBtn);
			type(createAcompany_contacts_form_firstName, "Priyanka", "");
			String child_lastName = "Reddy" + getRandomString(2);
			type(createAcompany_contacts_form_lastName, child_lastName, "");
			String email_child = "Priyanka" + getRandomString(2) + "@gmail.com";
			type(createAcompany_contacts_form_emailAddress, email_child, "");
			Thread.sleep(1000);
			actionsClick(createAcompany_contacts_form_saveBtn);
			Thread.sleep(4000);
			verifyTextInColumnClickOtherColumn(createAcompany_contacts_table_emailList,
					createAcompany_contacts_table_editLink, email_child);
			checkAll(createAcompany_contacts_edit_contactType_checkBoxs1);
			checkAll(createAcompany_contacts_edit_contactType_checkBoxs2);
			actionsClick(createACpmany_form_shippingAddress_saveBtn1);
			Thread.sleep(5000);
			// Need to write to verify 1's updated in the table, child Proposal creation
			scrollElementIntoView(createACpmany_proposal_createBtn);
			actionsClick(createACpmany_proposal_createBtn);
			String proposal_subject_child = "Test Proposal" + getRandomString(2);
			type(createACpmany_proposal_form_subject, proposal_subject_child, "");
			selectDropDownByIndex(createACpmany_proposal_form_typeOfBusiness_DD, 2);
			selectDropDownByIndex(createACpmany_proposal_form_proposalStage_DD, 1);
			selectDropDownByIndex(createACpmany_proposal_form_proposal_type_DD, 1);
			type(createACpmany_proposal_form_requestedInstallDate, dateAftersomeDays(5, "MM/dd/yyyy"), "");
			scrollElementIntoView(createACpmany_form_shippingAddress_saveBtn2);
			actionsClick(createACpmany_form_shippingAddress_saveBtn2);
			if (isAlertPresent()) {
				acceptAlert();
			}
			Thread.sleep(5000);
			scrollElementIntoView(createACpmany_proposal_createBtn);
			verifyTextPresentInLinkAndClick(createACpmany_proposal_subjectListTable, proposal_subject_child);
			waitForElementToBeClickable(createACpmany_proposal_editBtn);
			actionsClick(createACpmany_proposal_editBtn);
			actionsClick(createACpmany_proposal_form_oppourtunityName);
			navigateToChild();
			maximise();
			Thread.sleep(1000);
			type(childOff_newTab_nameSearch, "test", "");
			type(childOff_newTab_nameSearch, "search box", Keys.ENTER);
			Thread.sleep(1000);
			actionsClick(createACpmany_proposal_oppourtunitySearch_1stOption);
			navigateBackToParentWindow();
			scrollElementIntoView(createACpmany_proposal_form_addRow);
			actionsClick(createACpmany_proposal_form_addRow);
			type(createACpmany_proposal_form_addRow_search, "advanced", "");
			Thread.sleep(2000);
			type(createACpmany_proposal_form_addRow_search, "search box", Keys.ENTER);
			Thread.sleep(2000);
			actionsClick(createACpmany_form_shippingAddress_saveBtn2);
			if (isAlertPresent()) {
				acceptAlert();
			}
			// writing to excel
			WriteToExcel.writeExcel("Child Account creation; Details");
			WriteToExcel.writeExcel("Child company name;" + name_child);
			WriteToExcel.writeExcel("Child Billing Address; 2605 Wildberry Ct,Edison,08817");
			WriteToExcel.writeExcel("opportunitiy_name;Priyanka Test");
			WriteToExcel.writeExcel("child_expected_Proposal_date;" + parent_expected_Proposal_date);
			WriteToExcel.writeExcel("creating contact..; Details");
			WriteToExcel.writeExcel("parent_contact_firstName;Priyanka");
			WriteToExcel.writeExcel("child_contact_lastName;" + child_lastName);
			WriteToExcel.writeExcel("parent_contact_email;" + email_child);
			WriteToExcel.writeExcel("proposal creation; Details");
			WriteToExcel.writeExcel("child_proposal_subject;" + proposal_subject_child);
			WriteToExcel.writeExcel("child_requestedInstallDate;" + requestedInstallDate);
			WriteToExcel.writeExcel("child_companyId;" + child_companyId);

		} finally {

		//	WriteToExcel.closeExcelConnection();
		}
	}
}
