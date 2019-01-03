
package Zeus_healthcheck;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class DevicePageLoadingVerification extends MediatorClass {

	String Customer_Dashboardverify = "xpath=//li[text()='TNL Test BroadsoftRAY V17']";
	String srchDd="id=dd-Search";
	String customerLnk="id=notification-customer";
    String srchTxt = "css=input#search";
    String userNameTxt = "css=input[name='user']";   
    String passTxt = "css=input[name='pass']";
    String submitBtn = "css=button[type='submit']";
    String usernameTextBox = "xpath=//input[@name='user']";
    String passwordTextBox = "xpath=//input[@name='pass']";
    String loginButton = "xpath=//button[@type='submit']";
    String devicePage_header="xpath=//h1[@class='panel-title']";
    String devicePage_deviceName="xpath=//*[@id='header_crumbs']/li[5]";
    String devicePage_solarWindStatus="id=solar_winds_status_button";

	@Test(alwaysRun = true, enabled = true)
	public void customer_Search() throws Throwable {
		logger = extent.startTest("Device Verification").assignCategory("Device");
	    type(userNameTxt, "ppundru", "User name");
	    type(passTxt, "Luckylasya1@", "Password"); 
		click(submitBtn, "Submit button");
		navigateTo("https://zeus.telesphere.com/device/view/device_id:4883");
		waitForElementPresent(devicePage_header, 20);
		verifyText(devicePage_header, "Device", "");
		System.out.println("Device displayed is "+getText(devicePage_deviceName).trim());
		logInfo("Device displayed is "+getText(devicePage_deviceName).trim());
		logInfo("Solar wind status when script excecuted is "+getText(devicePage_solarWindStatus));
		logOut();
	}
}