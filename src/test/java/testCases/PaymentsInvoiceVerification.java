package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_Inventory;
import demo.objectrepository.OR_InvoicesAndPayments;
import demo.objectrepository.OR_LoginPage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class PaymentsInvoiceVerification extends CommonReusables implements
		OR_InvoicesAndPayments, OR_HomePage, OR_CustInfo, OR_ProjectManager,
		OR_NewMAC, OR_Inventory {

	@Test(alwaysRun = true, enabled = true)
	public void paymentsInvoiceVerification(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		SoftAssert softassert = new SoftAssert();
		String srchTxt = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		
		// * logger method for report starting from here
		logger = extent.startTest("Payment and InvoiceVerification and Export").assignCategory("Billing");
		logInfo("Currently Running on -- " + getCurrentUrl());

		// * Below Code written to verify login
		login(zUserName, zPassword);
		
		type(OR_SearchPage.srchTxt, srchTxt, "Search box");
		type(OR_SearchPage.srchTxt, "Search box", Keys.ENTER);
		selectBillingAndAccStatusActive(OR_SearchPage.noOfRows);
		click(OR_InvoicesAndPayments.exportBtn, "Export button");
		isassert = JSClick(OR_InvoicesAndPayments.invoiceBtn, "Invoice button");
		softassert.assertEquals(isassert, true, "Verified Export button clicked successfully");
		softassert.assertAll();
		logger.log(LogStatus.PASS, "Verified Payment , InvoiceVerification and Export functionality in application");
		
		// * Below method written to logout application
		logOutt();

	}
}
