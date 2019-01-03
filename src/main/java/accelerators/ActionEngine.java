
package accelerators;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class ActionEngine extends TestEngine {
	
	
	    String winHandleBefore;
	
	public void currentWindowClose() {
		Driver.close();
		
	}
	public String getCurrentWindowId() {
		return Driver.getWindowHandle();// TODO Auto-generated method stub
		
	}
	public void navigateToWindow(String string) {
		
		Driver.switchTo().window(string);
	}
	
	public void setBrowserTo80Size(){
		((JavascriptExecutor) Driver).executeScript("document.body.style.zoom='80%';");
	
	}
	public void setBrowserToSize(int x){
		((JavascriptExecutor) Driver).executeScript("document.body.style.zoom='"+x+"%';");
	
	}
	public void refreshBrowser(){
		Driver.navigate().refresh();
	
	}
	
	 public void clearText(String locator) {
		getElement(locator).clear();
	 }
	
	
    private static Integer pauseS = 30;

    /**
     * Binding to get Xpath, CSS, Link, Partial link element
     *
     * @param locator locator of element in xpath=locator; css=locator etc
     * @return found WebElement
     */
    protected WebElement getElement(final String locator) {
        return getElement(locator, true);
    }


    /**
     * Get "By" object to locate element
     *
     * @param locator locator of element in xpath=locator; css=locator etc
     * @return by object
     */
    protected By byLocator(final String locator) {
        String prefix = locator.substring(0, locator.indexOf('='));
        String suffix = locator.substring(locator.indexOf('=') + 1);

        switch (prefix) {
            case "xpath":
                return By.xpath(suffix);
            case "css":
                return By.cssSelector(suffix);
            case "link":
                return By.linkText(suffix);
            case "partLink":
                return By.partialLinkText(suffix);
            case "id":
                return By.id(suffix);
            case "name":
                return By.name(suffix);
            case "tag":
                return By.tagName(suffix);
            case "className":
                return By.className(suffix);
            default:
                return null;
        }
    }

    /**
     * @param locator          locator of element in xpath=locator; css=locator etc
     * @param screenShotOnFail make screenshot on failed attempt
     * @return found WebElement
     */
    private WebElement getElement(final String locator, boolean screenShotOnFail) {
        try {
            return Driver.findElement(byLocator(locator));
        } catch (Exception e) {
            throw e;
        }
    }

    public void navigateBack() {
        Driver.navigate().back();
    }
    
    public void navigateTo(String url) {
        Driver.navigate().to(url);
    }

    protected void mouseHoverMove(String we, String we1){

        Actions a=new Actions(Driver);
        a.moveToElement(getElement(we)).build().perform();
        a.moveToElement(getElement(we1)).click().build().perform();
    }



    /**
     *
     * @param locator
     * @param secs
     * @return
     * @throws Throwable
     */
    protected boolean waitForElementPresent(String locator, int secs) throws Throwable {
        boolean status = false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, secs);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator(locator)));
            status=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return status;
        }

        return status;
    }

    public void  maximise() {
   	 Driver.manage().window().maximize();
    }
    protected boolean waitForElementPresentIfNotThrowException(String locator, int secs) throws Throwable {
        boolean status = false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, secs);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator(locator)));
            status=true;
        }
        catch (Exception e) {
           throw e;
        }

        return status;
    }

    protected boolean waitForElementToBeClickable(String locator, int secs) throws Throwable {

        boolean flag=false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, secs);
            wait.until(ExpectedConditions.elementToBeClickable(byLocator(locator)));
            return flag=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return flag;
        }

    }

    protected boolean waitForElementToBeClickable(String locator) throws Throwable {
        boolean flag=false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, pauseS);
            wait.until(ExpectedConditions.elementToBeClickable(byLocator(locator)));
            return flag=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }
    
    protected  void switchToChildWindow(){
        // Get Parent window handle
        winHandleBefore = Driver.getWindowHandle();
        for (String winHandle : Driver.getWindowHandles()) {
            // Switch to child window
            Driver.switchTo().window(winHandle);
        }

    }
    protected  void switchToParentWindow(){
        //To close child Window
        Driver.close();
        Driver.switchTo().window(winHandleBefore);

    }

    protected boolean waitForElementToBeClickable(WebElement element,int secs) throws Throwable {
        boolean flag=false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, secs);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return flag=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }

    protected boolean waitForElementToBeClickable(WebElement element) throws Throwable {
        boolean flag=false;
        try {
            WebDriverWait wait = new WebDriverWait(Driver, pauseS);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return flag=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }



    /**
     * Wait until element is invisible/not present on the page
     *
     * @param locator locator to element
     * @param timeOut time to wait
     */
    protected void waitForElementNotPresent(final String locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver, timeOut);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(byLocator(locator))));
        } catch (Exception e) {
            if (e.getCause() != null &&
                    !e.getCause().getClass().toString().contains("NoSuchElementException")) {
                //takeScreenshot();
                throw e;
            }
        }
    }


    /**
     * Soft wait for visibility of element with default timeout
     *
     * @param locator locator of element to wait for
     * @return true if element is present and visible / false otherwise
     */
    protected boolean waitForElementPresent(final String locator) throws Throwable {
        return waitForElementPresent(locator, pauseS);
    }

    protected boolean waitForElementPresentE(final String locator, String string) throws Throwable {
        return waitForElementPresentIfNotThrowException(locator, pauseS);
    }

    protected boolean waitForElementPresentE(final String locator,int time) throws Throwable {
        return waitForElementPresentIfNotThrowException(locator, time);
    }

    /**
     * Wait until element is invisible/not present on the page with default timeout
     *
     * @param locator locator to element
     */
    protected void waitForElementNotPresent(final String locator) {
        waitForElementNotPresent(locator, pauseS);
    }


    /**
     * Wait for invisibility of specific object on page
     *
     * @param locator of object that we wait for invisibility
     */
    protected void waitForInvisibility(final String locator) {

        WebDriverWait wait = new WebDriverWait(Driver, pauseS);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator(locator)));
        } catch (Exception e) {
            //log.info("Try to wait little more (wait for invisibility)");
        }
    }

    /**
     * Verifies whether element is present and displayed
     *
     * @param locator locator for element to verify
     * @return true if present; false otherwise
     */
    /*protected boolean isElementPresent(final String locator) {
        try {
            return isElementPresent(getElement(locator, false));
        } catch (Exception e) {
            return false;
        }
    }*/


    /**
     * Binding to click the webElement
     *
     * @param we webElement to click
     */
    protected boolean click(final WebElement we,String elementName) {
        boolean flag=false;
        try {
            we.click();
            flag=true;
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        finally {
            if (flag){
                logger.log(LogStatus.PASS,"Successfully clicked on -->"+elementName);
            }else {
                logger.log(LogStatus.PASS,"Failed to click on -->"+elementName);
            }
        }

    }

    public boolean ButtonSelected(String locator) {
    	System.out.println(getElement(locator).getAttribute("class"));
    	if(getElement(locator).getAttribute("class")=="true")
    		return true;
    	else return false;
    }

    /**
     * Binding to click Xpath, CSS, Link, Partial link element
     *
     * @param locator locator of the element in format xpath=locator; css=locator  etc
     */
    
   public void actionsClick(String locator) {
	   
	   Actions ob = new Actions(Driver);
	   ob.moveToElement(getElement(locator));
	   ob.click(getElement(locator));
	   ob.build().perform();
	   
   } 
   
   protected boolean actionsClick(String locator,String elementName) throws Throwable {
       boolean flag=false;
       try {
    	   Actions ob = new Actions(Driver);
    	   waitForElementPresent(locator, 20);
    	   ob.moveToElement(getElement(locator));
    	   ob.click(getElement(locator));
    	   ob.build().perform();
    	   flag=true;
    	   return flag;
    	   
       } catch (Exception e) {
           e.printStackTrace();
           return flag;
       }
       finally {
           if (flag){
               logger.log(LogStatus.PASS,"Successfully clicked on -->"+elementName);
           }else {
               logger.log(LogStatus.WARNING,"Failed to click on -->"+elementName);
           }
       }
   }
    
    protected boolean click(final String locator,String elementName) throws Throwable {

        try{
        	waitForElementToBeClickable(locator, 3);
        	 return click(getElement(locator), elementName);
        }catch (StaleElementReferenceException e){
            return click(getElement(locator),elementName);
        }
    }

    
    protected void verifyText(final String locator,String text, String elementName) {
    	 
            Assert.assertTrue(getElement(locator).getText().contains(text));
            logPass("Verified Expected text on webpage i.e., '"+text+"'");
    }   
    
    protected String getText(final String locator) {
   	 
         return getElement(locator).getText();
}
    
   public void clickOnAllButtons(String locator) throws Throwable{
    	List<WebElement> l=getAllElements(locator);
    	for (WebElement object : l) {
			object.click();
		}
    }
   
   public boolean verifyTextPresentInList(String locator, String text) throws Throwable {
	   List<WebElement> l=getAllElements(locator);
   	for (WebElement object : l) {
			if (object.getText().contains(text))
				return true;
		}
	return false; 	
	 
   }
   
   public boolean verifyTextsPresentInList(String locator, String text, String text1) throws Throwable {
	   try {
	   List<WebElement> l=getAllElements(locator);
   		for (WebElement object : l) {
			if (!object.getText().equalsIgnoreCase(text)||!object.getText().equalsIgnoreCase(text1))
				return false;
		}
	   }
   catch(ElementNotFoundException e) {
	   logger.log(LogStatus.PASS,"No Records found with"+text + " and "+text1 );
   }
	return true;
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
   
  public void verifyTextPresentInListAndDelete(String locator1, String locator2, String text) throws Throwable{
	  List<WebElement> l=getAllElements(locator1);
	  for (int i = 0; i < l.size(); i++) {
		  System.out.println(l.get(i).getText());
		  if(l.get(i).getText().contains(text)) {
			  System.out.println(locator1+"["+(i+1)+"]"+locator2);
			  getElement(locator1+"["+(i+1)+"]"+locator2).click();
			  break;
		  }
		  System.out.println("*** "+l.get(i).getText());
	}			  
	}
  
  
  public void verifyTextInColumnClickOtherColumn(String locator1, String locator2, String text) throws Throwable{
	  List<WebElement> l=getAllElements(locator1);
	  for (int i = 0; i < l.size(); i++) {		  
		  if(l.get(i).getText().contains(text)) {
			  String locator3=String.format(locator2, (i+1));
			  //scrollElementIntoView(locator3);
			  getElement(locator3).click();
			  break;
		  }
		  
	}			  
	}
  
  protected String retriveRowNumberToEditOtherColumnData(String locator, String text) throws Throwable {
	  List<WebElement> l=getAllElements(locator);
	  for (int i = 0; i < l.size(); i++) {		  
		  if(l.get(i).getText().contains(text)) {
			  return Integer.toString((i+1));
			  
		  }
		  
	}
	return null;			  
	}
  
  public String verifyTextInColumnGetOtherColumnText(String locator1, String locator2, String text) throws Throwable{
	  List<WebElement> l=getAllElements(locator1);
	  for (int i = 0; i < l.size(); i++) {		  
		  if(l.get(i).getText().contains(text)) {
			  String locator3=String.format(locator2, (i+1));
			  //scrollElementIntoView(locator3);
			  return getElement(locator3).getText();
			 
		  }
		  
	}
	return null;			  
	}
  
  public void verifyTextInColumnClickOtherColumnJS(String locator1, String locator2, String text) throws Throwable{
	  List<WebElement> l=getAllElements(locator1);
	  for (int i = 0; i < l.size(); i++) {		  
		  if(l.get(i).getText().contains(text)) {
			  String locator3=String.format(locator2, (i+1));
			  scrollElementIntoView(locator3);
			  JSClick(locator3);
			  //getElement(locator3).click();
			  break;
		  }
		  
	}			  
	}
   
   public String parentHandle;
   public void navigateToChild() {	   
	   parentHandle = Driver.getWindowHandle();	   
	   for (String winHandle : Driver.getWindowHandles()) {
	       if(parentHandle!=winHandle)
		   Driver.switchTo().window(winHandle);
	       }
	   }   
 public void navigateBackToParentWindow() {	   
	         Driver.switchTo().window(parentHandle);	      
   }
   
   public boolean verifyDropDownValue(String locator, String text){
	   
	   Select select = new Select(getElement(locator));

	    List<WebElement> options = select.getOptions();
	    for (WebElement we : options) {	        
	            if (we.getText().contains(text))
	                return true;
	           	    } 
	    return false;
   }
   
public List<WebElement> getDropDownValues(String locator, String text){
	   
	   Select select = new Select(getElement(locator));

	    List<WebElement> options = select.getOptions();
	   
	    return options;
   }

public List<String> getDropDownValuesText(String locator, String text){
	 List<String> list= new ArrayList<>();
Select dropdown = new Select(getElement(locator));
//Get all options
List<WebElement> dd = dropdown.getOptions();
//Get the length
System.out.println(dd.size());
//Loop to print one by one
for (int j = 0; j < dd.size(); j++) {
 
		list.add(dd.get(j).getText());

}
return list;
}
    

    protected boolean isElementDisplayed(String locatorName,String elementName) {
        boolean flag=false;

        try {
           WebElement we= getElement(locatorName);
            we.isDisplayed();
            flag=true;

            return flag;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        finally {
            if (flag){
                logger.log(LogStatus.PASS,"Element is displayed :: -->"+elementName);
            }else {
                logger.log(LogStatus.PASS,"Element is not displayed :: -->"+elementName);
            }
        }

    }
    /**

     * Verifies whether element is displayed

     *

     * @param we webelement to verify

     * @return true if present; false otherwise

     */

    protected void isElementDisplayedE(String locatorName,String elementName) {
        boolean flag=false;

        try {
            WebElement we= getElement(locatorName);
            we.isDisplayed();
            flag=true;

        } catch (Exception e) {
            throw new NoSuchElementException();
        }
        finally {
            if (flag){
                logger.log(LogStatus.PASS,"Element is displayed :: -->"+elementName);
            }else {
                logger.log(LogStatus.PASS,"Element is not displayed :: -->"+elementName);
            }
        }

    }

    protected void logInfo(String msg) {
    	 logger.log(LogStatus.PASS, msg);
    }
    
    protected void logFail(String msg) {
   	 logger.log(LogStatus.FAIL, msg);
   }

    protected void logPass(String msg) {
      	 logger.log(LogStatus.PASS, msg);
      }
    protected void type( final WebElement we,String testdata,String elementName) throws Throwable {

        boolean flag=false;
        try {
            //((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", we);
            we.sendKeys(testdata);
            flag=true;
        } catch (Exception e) {
            throw e;
        }
        finally {
            if (flag){
            	if(elementName.equalsIgnoreCase("Password"))
                logger.log(LogStatus.PASS,"Successfully entered data '***************' into field -->"+elementName);
            	else {
            		logger.log(LogStatus.PASS,"Successfully entered data ::"+testdata+" into field -->"+elementName);
				}
            }else {
                logger.log(LogStatus.PASS,"Failed to enter data ::"+testdata+" into field -->"+elementName);
            }
        }
    }
    protected void typePassword(String locatorName,String testdata,String elementName) throws Throwable {
   	 typee(getElement(locatorName),testdata,elementName);
		
	}
   private void typee( final WebElement we,String testdata,String elementName) throws Throwable {

       boolean flag=false;
       try {
           //((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", we);
           we.sendKeys(testdata);
           flag=true;
       } catch (Exception e) {
           throw e;
       }
       finally {
           if (flag){
               logger.log(LogStatus.PASS,"Successfully entered '****' into field -->"+elementName);
           }else {
               logger.log(LogStatus.PASS,"Failed to enter '****' into field -->"+elementName);
           }
       }
   }
    protected void type( String locatorName,String elementName,CharSequence... var1) throws Throwable {

        boolean flag=false;
        try {
            //((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", we);
            WebElement we= getElement(locatorName);
            we.sendKeys(var1);
            flag=true;
        } catch (Exception e) {
            throw e;
        }
        finally {
            if (flag){
                logger.log(LogStatus.PASS,"Successfully entered key into field -->"+elementName);
            }else {
                logger.log(LogStatus.PASS,"Failed to enter key into field -->"+elementName);
            }
        }
    }

    protected String getTextByXpath(String element){
        return Driver.findElement(By.xpath(element)).getText();

    }
    
    protected void enterDate(String locator, String dd,String mm, String yyy){
    	//click(locator, "date");
    	Actions a =new Actions(Driver);
    	a.moveToElement(getElement(locator)).click();
    	//getElement(locator).sendKeys(dd+mm);
    	//Driver.findElement(By getElement(locator))
    	a.sendKeys(dd);
    	a.sendKeys(mm);
    	a.sendKeys(Keys.TAB);
    	a.sendKeys(yyy).build().perform();
    	
    }

    protected void type( String locatorName,String testdata,String elementName) throws Throwable {
    	
        type(getElement(locatorName),testdata,elementName);
    }
    protected void type( String locatorName,String testdata, boolean clear, boolean keyClear) throws Throwable {

        typeKeys(getElement(locatorName),testdata,clear,keyClear);
    }
    
    protected void typeWithClear( String locatorName,String testdata,String elementName) throws Throwable {
    	clearText(locatorName);
        type(getElement(locatorName),testdata,elementName);
    }
    

    /**
     *
     * @param locatorName: webelement having multiple elements
     * @return list of webelements
     * @throws Throwable
     */
    protected List<WebElement> getAllElements(String locatorName) throws Throwable {

       // WebDriverWait wait = new WebDriverWait(Driver, 100);
        List<WebElement> elements = new ArrayList<WebElement>();
        try {
           // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator(locatorName)));
            elements = Driver.findElements(byLocator(locatorName));
            return elements;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
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
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected Set<String> getAllTheTextIntoSet(String locatorName) throws Throwable {
		// TODO Auto-generated method stub
		 List<String>l=getAllTheText(locatorName);		 
		 System.out.println(l);
		 Set elements = new HashSet(l);
	   return elements;
    }

    /**
     * Binding to check Checkbox
     *
     * @param we webElement of checkbox to check
     */
    protected void check(final WebElement we) {
        if (!we.isSelected()) {
            we.click();
        }
    }

    /**
     * Binding to check checkbox
     *
     * @param locator locator of checkbox to check
     */
    protected void check(final String locator) {
        check(getElement(locator));
    }

    /**
     * Binding to clear text field and enter text
     *
     * @param we       webElement to type to
     * @param value    value to type into the field
     * @param clear    true to clear the field first; false to enter text without clearing field
     * @param keyClear true to clean using keyboard shortcut; false without clean;
     * @return webElement with edited text
     */
    protected WebElement typeKeys(final WebElement we, final String value, final boolean clear, final boolean keyClear) {
        if (clear) we.clear();
        if (keyClear) {
            we.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            we.sendKeys(Keys.chord(Keys.DELETE));
        }
        we.sendKeys(value);
        return we;
    }

    protected  String getVisibleText(final String locator) throws Throwable {
        String text = "";
        try {
            text = getElement(locator).getText();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * Binding to select item in dropdown which needs to be clicked for edit mode.
     * Fills actual value and presses "TAB" to submit, otherwise value could be not saved
     *
     * @param clickE        webElement of the field to click
     * @param selectLocator locator of the dropdown
     * @param value         value to select
     */
    /*protected void clickToSelect(final WebElement clickE, final String selectLocator, final String value) {
        click(clickE);
        selectDropDown(getElement(selectLocator), value);
        getElement(selectLocator).sendKeys(Keys.TAB);
    }*/

    /**
     * Binding to select item in dropdown by value
     *
     * @param we     WebElement of the dropdown
     * @param option value to select in the dropdown
     */
    protected void selectDropDown(final String we, final String option) {

        try {
            Select element=new Select(getElement(we));
            element.selectByVisibleText(option);
        } catch (Exception e) {
            //takeScreenshot();
            throw e;
        }
    }
    
    
public String selectedOptionDroDown(String locator) {
		
		Select select = new Select(getElement(locator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;
		
	}

public String getDropdownSelectedValue(String locator) {
	
	Select select = new Select(getElement(locator));
	WebElement option = select.getFirstSelectedOption();
	String defaultItem = option.getText();
	return defaultItem;
	
}

    protected void selectDropDownByVisibleText(final String we, final String option) {

        try {
            Select element=new Select(getElement(we));
            element.selectByVisibleText(option);
        } catch (Exception e) {
            //takeScreenshot();
            throw e;
        }
    }
    protected void selectDropDownByValue(final String we, final String option) {

        try {
            Select element=new Select(getElement(we));
            element.selectByValue(option);
        } catch (Exception e) {
            //takeScreenshot();
            throw e;
        }
    }

    protected void selectDropDownByIndex(final String we, final int option) {

        try {
            Select element=new Select(getElement(we));
            element.selectByIndex(option);
        } catch (Exception e) {
            //takeScreenshot();
            throw e;
        }
    }
    protected Select getSelect(final WebElement we) {

        return new Select(we);

    }

    protected void scrollElementIntoView(String locator){
        try {
            ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected void scrollToBottom(){
        try {
            //((JavascriptExecutor) Driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            //((JavascriptExecutor) Driver).executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight))");

            //Actions actions = new Actions(Driver);
            //actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            ((JavascriptExecutor) Driver).executeScript("window.scrollBy(0,1500)");
            Thread.sleep(3000);
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }


    protected void scrollElementIntoView(WebElement elementToScroll){
        try {
            ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected  void JSClick(String locator){

        try {
            WebElement element = getElement(locator);
            ((JavascriptExecutor)Driver).executeScript("arguments[0].click();", element);
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    
    protected boolean JSClick(String locator,String elementName) throws Throwable {
        boolean flag=false;
        try {
        	waitForElementPresent(locator, 1);
            WebElement element = getElement(locator);
            ((JavascriptExecutor)Driver).executeScript("arguments[0].click();", element);
            flag=true;
            return flag;
        }

        catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        
        finally {
            if (flag){
                logger.log(LogStatus.PASS,"Successfully clicked on -->"+elementName);
            }else {
                logger.log(LogStatus.WARNING,"Failed to click on -->"+elementName);
            }
        }
    }
    
    protected  void switchToFrame(String locator){

        try {
           Driver.switchTo().frame(getElement(locator));
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
    protected  void switchToDefaultFrame(){

        try {
           Driver.switchTo().defaultContent();
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
     }
    
    public static String getRandomInt(int length) {
        final String characters = "123450";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
     }
    
    public static String getRandomStringforMAC(int length) {
        final String characters = "ABCDEF1234567890";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
     }

}
