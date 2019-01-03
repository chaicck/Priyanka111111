package accelerators;


import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import utils.MyListener;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestEngine {
    public static final Logger LOG = Logger.getLogger(TestEngine.class);
    public WebDriver WebDriver = null;
    public EventFiringWebDriver Driver=null;
    public String browser = null;
    public String baseUrl = null;
    public static ExtentReports extent ;
    public ExtentTest logger;
    DesiredCapabilities capabilities;
    public String tcId;
    public String htmlFile="index.html";
    public String extentReportDirectoryPath = System.getProperty("user.dir")+"\\Reports\\Selenium_Repo.html";
    public String userEmail;
    public String pwd;
    public String orderReferenceNumber;
    DisplayOrder d;


    @BeforeSuite(alwaysRun=true)
    public void beforeSuite() throws Throwable{
        //loadConfig();
    	System.out.println("BeforeSuit-Helo123");
        extent = new ExtentReports(extentReportDirectoryPath, true);
    }

    public static String toDaysdatewithTime(){
		String pattern = "MM-dd-yyyy_HH_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
    public String toDaysdate(){
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}

    @BeforeMethod(alwaysRun=true)
    @Parameters({"browser","baseUrl"})
    public void beforeMethod(String browser,String baseUrl) throws IOException, InterruptedException
    {

		/*get configuration */
       this.browser = browser;
        this.baseUrl = baseUrl;
        this.setWebDriverForLocal(browser);
        this.Driver = new EventFiringWebDriver(this.WebDriver);
        MyListener myListener = new MyListener();
        this.Driver.register(myListener);
        Driver.manage().window().maximize();
        Driver.manage().deleteAllCookies();
        Driver.get(baseUrl);
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    System.out.println("beforeMethod-Helo123");

    }
	boolean extentTestEndflag=false;
	 @AfterMethod(alwaysRun=true, enabled=true)
	    public void afterMethod(ITestResult result) throws Throwable
	    {
	    	try {
	        if(result.getStatus()==ITestResult.FAILURE){
	            logger.log(LogStatus.FAIL,"Failed test is: "+result.getName());
	            logger.log(LogStatus.FAIL, result.getThrowable());
	            logger.log(LogStatus.FAIL, logger.addScreenCapture(capture(Driver, "screenShot")));
	        }
	        else if(result.getStatus()==ITestResult.SKIP){
	            logger.log(LogStatus.SKIP,"Skipped test is: "+result.getName());
	        } 
	    	}
	     
	        finally {	        
	        extent.endTest(logger);
	        extentTestEndflag=true;
	        extent.flush();
	    	WebDriver.quit();
	        }
	    }
	
    
    @AfterSuite
    public void afterSuite() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

       extent.close();
    }

    private void setWebDriverForLocal(String browser) throws IOException, InterruptedException
    {
        switch(browser)
        {
            case "firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                this.WebDriver = new FirefoxDriver(capabilities);
                break;
            case "chrome":
                //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver");
		//System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/AutomatedTests/SeleniumAutomationForDEV/Drivers/chromedriver");
		//System.setProperty("webdriver.chrome.verboseLogging", "true");
            	//ChromeDriverManager.getInstance().setup();
            	capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type","--headless");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                this.WebDriver = new ChromeDriver(capabilities);
                break;

        }

    }
    protected  String capture(String screenShotName) throws IOException
    {
        return capture(this.Driver,screenShotName);
    }

    private   String capture(WebDriver driver,String screenShotName) throws IOException
    {
        String ss=String.format(getCurrentTimeStamp(),screenShotName)+".png";
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"/Reports/ScreenShots/"+ss;
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
//        return "../ErrorScreenshots/"+screenShotName+".png";
        return dest;
    }

    private void loadConfig() {

        Properties prop = new Properties();
        InputStream input = null;
        try
        {
            input = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
            prop.load(input);
            for (final Map.Entry<Object, Object> entry : prop.entrySet()) {
                System.setProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("'%s'MMddHHmmssSSS").format(new Date());
    }

    private  void logFile(String tcId,String consoleOp) {
        try
        {
            String filename= System.getProperty("user.dir")+"/Reports/"+"logFile.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(tcId+" : ");//appends the string to the file
            fw.write(consoleOp+"\n");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }
    private String getCurrentTimeStampForLogFie() {
        return new SimpleDateFormat("MM-dd-yyy").format(new Date());
    }

}
