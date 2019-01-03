package demo.objectrepository;

public interface OR_DevicePageLoad {
	
    String devicePage_header="xpath=//h1[@class='panel-title']";
    String devicePage_deviceName="xpath=//*[@id='header_crumbs']/li[5]";
    String devicePage_solarWindStatus="id=solar_winds_status_button";
    
    // page urls 
    
    String url_telesphere = "https://zeus.telesphere.com/device/view/device_id:4883";

}
