package accelerators;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ActionEngine extends TestEngine {

	/**
	 * Local variable declaration
	 */
	String winHandleBefore;
	private static Integer pauseS = 30;

	/**
	 * This method is used close the browser
	 */
	public void currentWindowClose() {

	}

	/**
	 * This method is used to get current window ID
	 */
	public String getCurrentWindowId() {
		return Driver.getWindowHandle();// TODO Auto-generated method stub

	}
	
	/**
	 * Method is get title from page
	 */
	public String getPageTile()
	{
		return Driver.getTitle();
	}
	/**
	 * This method is used to navigate to specific window id
	 */
	public void navigateToWindow(String string) {

		Driver.switchTo().window(string);
	}

	/**
	 * This method is used to reduce window size to 80%
	 */
	public void setBrowserTo80Size() {
		((JavascriptExecutor) Driver)
				.executeScript("document.body.style.zoom='80%';");

	}

	/**
	 * This method is used set browser to specific size
	 */
	public void setBrowserToSize(int x) {
		((JavascriptExecutor) Driver)
				.executeScript("document.body.style.zoom='" + x + "%';");

	}

	/**
	 * This method is used refresh browser
	 */
	public void refreshBrowser() {
		Driver.navigate().refresh();

	}

	/**
	 * This method is used set clear text in input text box
	 */
	public void clearText(String locator) {
		getElement(locator).clear();
	}

	/**
	 * Binding to get Xpath, CSS, Link, Partial link element
	 *
	 * @param locator
	 *            locator of element in xpath=locator; css=locator etc
	 * @return found WebElement
	 */
	protected WebElement getElement(final String locator) {
		
		return getElement(locator, true);
	}

	/**
	 * Get "By" object to locate element
	 *
	 * @param locator
	 *            locator of element in xpath=locator; css=locator etc
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
	 * @param locator
	 *            locator of element in xpath=locator; css=locator etc
	 * @param screenShotOnFail
	 *            make screenshot on failed attempt
	 * @return found WebElement
	 */
	private WebElement getElement(final String locator, boolean screenShotOnFail) {

		return Driver.findElement(byLocator(locator));

	}

	/** This method used to navigate back (like clicking on browser back button) */

	public void navigateBack() {
		Driver.navigate().back();
	}

	/** This method used to navigate to specific URL mentioned */
	public void navigateTo(String url) {
		Driver.navigate().to(url);
	}

	/** This method used to perform Mouse hover Actions 
	 * @throws Throwable */
	protected boolean mouseHoverMove(String we, String text1, String we1,
			String text2) throws Throwable {
		boolean flag = false;
		try {
			Actions a = new Actions(Driver);
			a.moveToElement(getElement(we)).build().perform();
			logger.log(LogStatus.PASS, "Successfully clicked on '" + text1+ "'");
			System.out.println("Successfully clicked on '" + text1 + "'");
			aJSClick(we1, text2);
			logger.log(LogStatus.PASS, "Successfully clicked on '" + text2+ "'");
			System.out.println("Successfully clicked on '" + text2 + "'");
			flag = true;
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
			
		}
		
		return flag;

	}

	/**
	 * This method is used to click on locator using mouse hover actions
	 * 
	 * @return boolean value
	 */
	protected boolean aactionsClick(String locator, String elementName)
			throws Throwable {
		boolean flag = false;
		try {
			waitForElementPresent(locator, 1);

			Actions ob = new Actions(Driver);
			waitForElementPresent(locator, 20);
			ob.moveToElement(getElement(locator));
			ob.click(getElement(locator));
			ob.build().perform();
			Thread.sleep(2000);
			flag = true;
			logger.log(LogStatus.PASS, "Successfully clicked on '"+ elementName + "'");
			System.out.println("Successfully clicked on '" + elementName+ "'");
			return flag;
		}

		catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click on '" + elementName+ "' Button -> Reason - Element not Present/Clickale" +e);
			System.out.println("Failed to click on '" + elementName+ "' Button -> Reason - Element not Present/Clickale" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();

		} 
		return flag;
	}

	/** This method written to Mouse hover to element in page */
	protected boolean mouseHoverClick(String locator1, String elementName1)
			throws Throwable {
		boolean flag = false;
		try {

			Actions actions = new Actions(Driver);
			waitForElementPresent(locator1, 60);
			actions.moveToElement(getElement(locator1)).perform();
			Thread.sleep(1000);
			flag = true;
			logger.log(LogStatus.PASS, "Successfully clicked  menu '"+ elementName1 + "'");
			System.out.println("Successfully clicked  menu '"+ elementName1 + "'");

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Failed to click on   menu '"+ elementName1 + "'" +e);
			System.out.println("Failed to click on   menu '"+ elementName1 + "'" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		
		}
		return flag;

	}

	/**
	 * This method is used to click on element using java script
	 */
	protected boolean aJSClick(String locator, String elementName)
			throws Throwable {
		boolean flag = false;
		try {
			// waitForElementPresent(locator, 1);
			WebElement element = getElement(locator);
			((JavascriptExecutor) Driver).executeScript(
					"arguments[0].click();", element);
			logger.log(LogStatus.PASS, "Successfully clicked on '"+ elementName + "'");
			System.out.println("Successfully clicked on '" + elementName+ "'");
			flag = true;
			return flag;
		}

		catch (Exception e) {
			flag = false;
			logger.log(LogStatus.FAIL, "Failed to click on '" + elementName+ "due to exception " +e);
			System.out.println("Failed to click on '" + elementName+ "due to exception " +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();

		}
		return flag;
	}

	/**
	 * This method is used to click on element using java script
	 */
	protected boolean aclick(final String locator, String elementName)
			throws Throwable {

		boolean flag = false;
		try {
				waitForElementToBeClickable(locator, 60);
				WebElement element = getElement(locator);
				((JavascriptExecutor) Driver).executeScript(
						"arguments[0].click();", element);
				logger.log(LogStatus.PASS, "Successfully clicked on '"+ elementName + "'");
				System.out.println("Successfully clicked on '" + elementName+ "'");
				flag = true;
				return flag;

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click on '" + elementName+ "' Button -> Reason - Element not Present/Clickale" +e);
			System.out.println("Failed to click on '" + elementName+ "' Button -> Reason - Element not Present/Clickale" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();
		
		}
		return flag;
	}

	/**
	 *
	 * @param locator
	 * @param secs
	 * @return
	 * @throws Throwable
	 */
	protected boolean waitForElementPresent(String locator, int secs)
			throws Throwable {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, secs);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(byLocator(locator)));
			flag = true;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Element is not loading on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
		}

		return flag;
	}

	/**
	 * This method is used to maximise window
	 */
	public void maximise() {
		Driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for element present
	 */
	protected boolean waitForElementPresentIfNotThrowException(String locator,
			int secs) throws Throwable {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, secs);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(byLocator(locator)));
			status = true;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e);
			System.out.println(e);

		}

		return status;
	}

	/**
	 * This method is used to wait for element until it is clickable
	 */
	protected boolean waitForElementToBeClickable(String locator, int secs)
			throws Throwable {

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, secs);
			wait.until(ExpectedConditions
					.elementToBeClickable(byLocator(locator)));
			 flag = true;
		} catch (Exception e) {
			System.out.println(e);	
			logger.log(LogStatus.ERROR, e);
			throw e;
	
		}
		return flag;
		
	}

	/**
	 * This method is used to wait for element untill it is clickable
	 */

	protected boolean waitForElementToBeClickable(String locator)
			throws Throwable {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, pauseS);
			wait.until(ExpectedConditions
					.elementToBeClickable(byLocator(locator)));
			return flag = true;
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
			;
		}
		return flag;
	}

	/**
	 * This method is used to switch to the immediate child ( next tab to the
	 * current focused tab)
	 */

	protected void switchToChildWindow() {
		// Get Parent window handle
		winHandleBefore = Driver.getWindowHandle();
		for (String winHandle : Driver.getWindowHandles()) {
			// Switch to child window
			Driver.switchTo().window(winHandle);
		}

	}

	/**
	 * This method is switch back to the parent window
	 */
	protected void switchToParentWindow() {
		// To close child Window
		Driver.close();
		Driver.switchTo().window(winHandleBefore);

	}

	/**
	 * This method is used to wait for element until it is click able
	 */

	protected boolean waitForElementToBeClickable(WebElement element, int secs)
			throws Throwable {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, secs);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return flag = true;
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
		}
		return flag;
	}

	/**
	 * This method is used to wait for element until it is click able
	 */
	protected boolean waitForElementToBeClickable(WebElement element)
			throws Throwable {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, pauseS);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return flag = true;
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
		}
		return flag;
	}

	/**
	 * Wait until element is invisible/not present on the page
	 *
	 * @param locator
	 *            locator to element
	 * @param timeOut
	 *            time to wait
	 */
	protected void waitForElementNotPresent(final String locator, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver, timeOut);
			wait.until(ExpectedConditions.not(ExpectedConditions
					.visibilityOfElementLocated(byLocator(locator))));
		} catch (Exception e) {
			if (e.getCause() != null
					&& !e.getCause().getClass().toString()
							.contains("NoSuchElementException")) {
				// takeScreenshot();
				logger.log(LogStatus.FAIL, e);
				System.out.println(e);
			}

		}
	}

	/**
	 * Soft wait for visibility of element with default timeout
	 *
	 * @param locator
	 *            locator of element to wait for
	 * @return true if element is present and visible / false otherwise
	 */
	protected boolean waitForElementPresent(final String locator)
			throws Throwable {
		return waitForElementPresent(locator, pauseS);
	}

	protected boolean waitForElementPresentE(final String locator, String string)
			throws Throwable {
		return waitForElementPresentIfNotThrowException(locator, pauseS);
	}

	protected boolean waitForElementPresentE(final String locator, int time)
			throws Throwable {
		return waitForElementPresentIfNotThrowException(locator, time);
	}

	/**
	 * Wait until element is invisible/not present on the page with default
	 * timeout
	 *
	 * @param locator
	 *            locator to element
	 */
	protected void waitForElementNotPresent(final String locator) {
		waitForElementNotPresent(locator, pauseS);
	}

	/**
	 * Wait for invisibility of specific object on page
	 *
	 * @param locator
	 *            of object that we wait for invisibility
	 */
	protected void waitForInvisibility(final String locator) {

		WebDriverWait wait = new WebDriverWait(Driver, pauseS);
		try {
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(byLocator(locator)));
		} catch (Exception e) {
			// log.PASS("Try to wait little more (wait for invisibility)");
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
		}
	}

	/**
	 * Verifies whether element is present and displayed
	 *
	 * @param locator
	 *            locator for element to verify
	 * @return true if present; false otherwise
	 */
	/*
	 * protected boolean isElementPresent(final String locator) { try { return
	 * isElementPresent(getElement(locator, false)); } catch (Exception e) {
	 * return false; } }
	 */

	/**
	 * Binding to click the webElement
	 *
	 * @param we
	 *            webElement to click
	 * @throws IOException 
	 */
	protected boolean clickElement(final WebElement we, String elementName) throws IOException {
		boolean flag = false;
		try {
			we.click();
			flag = true;
			logger.log(LogStatus.PASS, "Successfully clicked on -->"+ elementName);
			System.out.println("Successfully clicked on -->" + elementName);
			return flag;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click on -->"+ elementName + "due to exception :" +e);
			System.out.println("Failed to click on -->" + elementName +"due to exception :" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * This method is used to select button
	 */
	public boolean buttonSelected(String locator) {
		System.out.println(getElement(locator).getAttribute("class"));
		if (getElement(locator).getAttribute("class") == "true")
			return true;
		else
			return false;
	}

	/**
	 * Binding to click Xpath, CSS, Link, Partial link element
	 *
	 * @param locator
	 *            locator of the element in format xpath=locator; css=locator
	 *            etc
	 */

	public void actionsClick(String locator) {

		Actions ob = new Actions(Driver);
		ob.moveToElement(getElement(locator));
		ob.click(getElement(locator));
		ob.build().perform();
	}

	/**
	 * This method is used to click on provided element using normal selenium
	 * click
	 */
	protected void nClick(String locator, String elementName) throws Throwable {

		getElement(locator).click();

	}

	/**
	 * This method is used to click on locator using actions click
	 */
	protected boolean aClick(String locator, String elementName)
			throws Throwable {

		boolean flag = false;
		try {
			waitForElementPresent(locator, 1);

			Actions ob = new Actions(Driver);
			waitForElementPresent(locator, 20);
			ob.moveToElement(getElement(locator));
			// ob.click(getElement(locator));
			ob.build().perform();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Successfully clicked on '"+ elementName + "'");
			System.out.println("Successfully clicked on '" + elementName+ "'");
			flag = true;
			return flag;
		}

		catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click on '" + elementName+ "'"+" due to exception :" +e);
			System.out.println("Failed to click on '" + elementName + "'"+" due to exception :" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * This method is used to click on locator using actions actionsclick
	 */
	protected boolean actionsClick(String locator, String elementName)
			throws Throwable {
			boolean flag = false;
			try {
				waitForElementToBeClickable(locator, 40);
				Actions ob = new Actions(Driver);
				waitForElementPresent(locator, 30);
				ob.moveToElement(getElement(locator));
				ob.click(getElement(locator));
				ob.build().perform();
				logger.log(LogStatus.PASS, "Successfully clicked on -->"+ elementName);
				System.out.println("Successfully clicked on -->"+ elementName);
				flag = true;
				return flag;

			} catch (Exception e) {
				logger.log(LogStatus.FAIL, "Failed to click on -->"+ elementName);
				logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
				System.out.println("Failed to click on -->" + elementName + "due to exception" +e);
				e.printStackTrace();

			}
		
		return false;
	}

	protected void verifyIsLoggedin(final String locator, String elementName)
			throws Throwable {
		Assert.assertEquals(isElementDisplayed(locator, elementName), false,
				"Login failed : UserID/Password Invalid");
		logger.log(LogStatus.PASS, "Login Success");

	}

	/**
	 * This method is used to click on locator using java script
	 */
	protected boolean click(final String locator, String elementName)
			throws Throwable {

			boolean flag = false;
			try {
				waitForElementPresent(locator, 1);
				WebElement element = getElement(locator);
				((JavascriptExecutor) Driver).executeScript(
						"arguments[0].click();", element);
				logger.log(LogStatus.PASS, "Successfully clicked on -->"+ elementName);
				System.out.println("Logged into Zeus Successfully");
				flag = true;
				return flag;
			}

			catch (Exception e) {
				logger.log(LogStatus.FAIL, "Unable to click button/link due to " + e);
				logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
				System.out.println("Element is not available on page due to exception" +e);
				e.printStackTrace();
			}

		return false;
	}

	/**
	 * This method is used verify the text present in the locator
	 * 
	 * @throws Exception
	 */
	protected boolean verifyText(final String locator, String text,
			String elementName) throws Exception {

		boolean flag = false;

		try {
			String expectedTxt = getElement(locator).getText();
			if(expectedTxt.contains(text))
			{
				flag = true;
				logger.log(LogStatus.PASS, "Verified Expected text on webpage i.e. '" + text + "'");
				System.out.println("Verified Expected text on webpage i.e. '" + text + "'");
			}else
			{
				logger.log(LogStatus.FAIL, "Expected text '" + text + "' is not matching ");
				System.out.println("Expected text '" + text
						+ "' is not matching");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Unable to locate elemnt " +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Unable to locate elemnt " + e);
		
		}
		return flag;

	}

	/**
	 * This method is used to get text 
	 */

	protected String getText(final String locator) {

		return getElement(locator).getText();
	}

	/**
	 * This method is used to click on all the elements
	 */
	public void clickOnAllButtons(String locator) throws Throwable {
		try {
			List<WebElement> l = getAllElements(locator);
			for (WebElement object : l) {
				object.click();
				logger.log(LogStatus.PASS, "Successfully clicked on -->"+ object);
				System.out.println("Successfully clicked on -->"+ object);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.ERROR, e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to verify the text present in the list of elements
	 */
	public boolean verifyTextPresentInList(String locator, String text)
			throws Throwable {
		boolean flag = false;
		try {
			List<WebElement> l = getAllElements(locator);
			for (WebElement object : l) {
				if (object.getText().contains(text))
				{
					flag = true;
					logger.log(LogStatus.PASS, "Verifed text '" + text);
					System.out.println("Verifed text '" + text);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Element is not available on page due to exception" +e);		
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();

		}
		return flag;
	}

	/**
	 * This method is used to verify the text present in the list of elements
	 */
	public boolean verifyTextsPresentInList(String locator, String text,
			String text1) throws Throwable {
		try {
			List<WebElement> l = getAllElements(locator);
			for (WebElement object : l) {
				if (!object.getText().equalsIgnoreCase(text)|| !object.getText().equalsIgnoreCase(text1))
				{
					
					logger.log(LogStatus.PASS, "Records found with" + text + " and "+ text1);
					System.out.println("Records found with" + text + " and " + text1);
					return false;
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "No Records found with" + text + " and "
					+ text1 + "  " + e);
			System.out.println("No Records found with" + text + " and " + text1
					+ "  " + e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
		}
		return true;
	}

	/**
	 * This method is used to verify the text in element
	 */
	public boolean verifyElementText(String locator, String text) {
		try {
			if (getElement(locator).getText().contains(text))

				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * This method is used to verify the text present in the list and click if
	 * match founds
	 */
	public void verifyTextPresentInListAndDelete(String locator1,
			String locator2, String text) throws Throwable {
		List<WebElement> l = getAllElements(locator1);
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getText());
			if (l.get(i).getText().contains(text)) {
				System.out.println(locator1 + "[" + (i + 1) + "]" + locator2);
				getElement(locator1 + "[" + (i + 1) + "]" + locator2).click();
				break;
			}
			System.out.println("*** " + l.get(i).getText());
		}
	}

	/**
	 * This method is used to verify the text present in one column of the table
	 * and click on other column data(of same row) if match founds
	 */
	public boolean verifyTextInColumnClickOtherColumn(String locator1,
			String locator2, String text) throws Throwable {
		boolean flag = false;
		try {
			List<WebElement> l = getAllElements(locator1);
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getText().contains(text)) {
					String locator3 = String.format(locator2, (i + 1));
					// scrollElementIntoView(locator3);
					getElement(locator3).click();
					flag = true;
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Element is not available on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		} finally {
			if (flag) {
				logger.log(
						LogStatus.PASS,
						"Verified the text present in one column of the table and click on other column data(of same row) if match founds");
				System.out.println();

			} else {
				logger.log(
						LogStatus.FAIL,
						"Failed to verify text present in one column of the table and click on other column data(of same row)");
				System.out
						.println("Failed to verify text present in one column of the table and click on other column data(of same row)");
			}
		}
		return flag;
	}

	/**
	 * This method is used to verify the text present in one column of the table
	 * and return the row number
	 */
	protected String retriveRowNumberToEditOtherColumnData(String locator,
			String text) throws Throwable {
		try {
			List<WebElement> l = getAllElements(locator);
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getText().contains(text)) {
					return Integer.toString((i + 1));

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
		}

		return null;
	}

	/**
	 * This method is used to verify the text present in one column of the table
	 * and get the other column data(of same row) if match founds
	 */
	public String verifyTextInColumnGetOtherColumnText(String locator1,
			String locator2, String text) throws Throwable {
		boolean flag = false;
		try {
			List<WebElement> l = getAllElements(locator1);
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getText().contains(text)) {
					String locator3 = String.format(locator2, (i + 1));
					// scrollElementIntoView(locator3);
					flag = true;
					return getElement(locator3).getText();
					

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Element is not available on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		} finally {
			if (flag) {
				logger.log(
						LogStatus.PASS,
						"Verified the text present in one column of the table and click on other column data(of same row) if match founds");
				System.out.println();

			} else {
				logger.log(
						LogStatus.FAIL,
						"Failed to verify text present in one column of the table and click on other column data(of same row)");
				System.out
						.println("Failed to verify text present in one column of the table and click on other column data(of same row)");
			}
		}

		return null;
	}

	/**
	 * This method is used to verify the text present in one column of the table
	 * and click on other column data(of same row) if match founds using java
	 * script
	 */
	public void verifyTextInColumnClickOtherColumnJS(String locator1,
			String locator2, String text) throws Throwable {
		try {

			List<WebElement> l = getAllElements(locator1);
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getText().contains(text)) {
					String locator3 = String.format(locator2, (i + 1));
					scrollElementIntoView(locator3);
					JSClick(locator3);
					// getElement(locator3).click();
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.ERROR, e);
			System.out.println(e);
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to navigate to the child window
	 */
	public String parentHandle;

	public void navigateToChild() {
		parentHandle = Driver.getWindowHandle();
		for (String winHandle : Driver.getWindowHandles()) {
			if (parentHandle != winHandle)
				Driver.switchTo().window(winHandle);
		}
	}

	/**
	 * This method is used to navigate back to the parent window
	 */
	public void navigateBackToParentWindow() {
		Driver.switchTo().window(parentHandle);
	}

	/**
	 * This method is used verify the weather given text present in drop down
	 * values
	 * @throws IOException 
	 */
	public boolean verifyDropDownValue(String locator, String text) throws Throwable {
		boolean flag = false;
		try {
			Select select = new Select(getElement(locator));

			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				if (we.getText().contains(text)){
					flag = true;
					logger.log(LogStatus.PASS, "Element --> " + text+ " is displayed");
					System.out.println("Element --> " + text+ " is displayed");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Element --> " + text+ " is not displayed due to excption :" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element --> " + text+ " is not displayed due to excption :" +e);
		}
		return flag;

	}

	/**
	 * This method is used to get drop down elements present under the dropdown
	 */
	public List<WebElement> getDropDownValues(String locator, String text) {

		Select select = new Select(getElement(locator));

		List<WebElement> options = select.getOptions();

		return options;
	}

	/**
	 * This method is used to get drop down values text present under the
	 * dropdown
	 */
	public List<String> getDropDownValuesText(String locator, String text) {
		List<String> list = new ArrayList<>();
		Select dropdown = new Select(getElement(locator));
		// Get all options
		List<WebElement> dd = dropdown.getOptions();
		// Get the length
		System.out.println(dd.size());
		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {

			list.add(dd.get(j).getText());

		}
		return list;
	}

	/**
	 * 
	 * Verifies whether element is displayed
	 * 
	 *
	 * 
	 * @param we
	 *            webelement to verify
	 * @return
	 * 
	 * @return true if present; false otherwise
	 * @throws IOException 
	 */

	protected boolean isElementDisplayedOrNot(String locatorName,
			String elementName) throws IOException {
		boolean flag = false;

		try {

			WebElement we = getElement(locatorName);
			if (we.isDisplayed()){
				flag = true;
			logger.log(LogStatus.PASS, "Element --> " + elementName+ " is displayed");
			System.out.println("Element --> " + elementName + " is displayed");
			return flag;
			}

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Element --> " + elementName+ " is not displayed due to exception No such element found" +e);
			System.out.println("Element --> " + elementName
					+ " is not displayed" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			
		}
		return flag;

	}

	/**
	 * 
	 * Verifies element displayed is not displayed
	 * 
	 *
	 * 
	 * @param we
	 *            webelement to verify
	 * @return
	 * 
	 * @return true if present; false otherwise
	 */

	protected boolean isElementDisplayed(String locatorName, String elementName) {
		boolean flag = false;

		try {
			WebElement we = getElement(locatorName);
			if (we.isDisplayed())
				flag = true;
			return flag;

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return flag;
		}

	}
	
	protected boolean isElementPresentOnPage(String locatorName)
	{
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locatorName)));
			flag = true;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return flag;
		}
		return flag;
		
	}

	/**
	 * This method is used to loginfo
	 */
	protected void logInfo(String msg) {
		logger.log(LogStatus.PASS, msg);

	}

	/**
	 * This method is used to show logfail
	 */
	protected void logFail(String msg) {
		logger.log(LogStatus.FAIL, msg);
	}

	/**
	 * This method is used to show logpass
	 */
	protected void logPass(String msg) {
		logger.log(LogStatus.PASS, msg);
	}

	/**
	 * This method is used to type given text into the text box
	 */
	protected boolean type(final WebElement we, String testdata, String elementName)
			throws Throwable {

		boolean flag = false;
		try {
			we.sendKeys(testdata);
			flag = true;
		} catch (Exception e) {
			System.out.println("Failed to type element :" + elementName
					+ " due to exception " + e.getMessage());
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			throw e;

		} finally {
			if (flag) {
				if (elementName.contains("Password")) {
					logger.log(LogStatus.PASS,
							"Successfully entered data '***************' into field -->"
									+ elementName);
					System.out
							.println("Successfully entered data '***************' into field -->"
									+ elementName);
				} else {
					logger.log(LogStatus.PASS, "Successfully entered data ::"
							+ testdata + " into field -->" + elementName);
					System.out.println("Successfully entered data ::"
							+ testdata + " into field -->" + elementName);
				}
			} else {
				logger.log(LogStatus.FAIL, "Failed to enter data ::" + testdata
						+ " into field -->" + elementName);
				System.out.println("Failed to enter data ::" + testdata
						+ " into field -->" + elementName);
			}
		}
		return flag;
	}

	/**
	 * This method is used to type password
	 */
	protected void typePassword(String locatorName, String testdata,
			String elementName) throws Throwable {
		typee(getElement(locatorName), testdata, elementName);

	}

	/**
	 * This method is used to type given text into the text box
	 */
	private void typee(final WebElement we, String testdata, String elementName)
			throws Throwable {

		boolean flag = false;
		try {
			// ((JavascriptExecutor)
			// Driver).executeScript("arguments[0].scrollIntoView(true);", we);
			we.sendKeys(testdata);
			flag = true;
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();

		} finally {
			if (flag) {
				logger.log(LogStatus.PASS,
						"Successfully entered '****' into field -->"
								+ elementName);
				System.out.println("Successfully entered '****' into field -->"
						+ elementName);
			} else {
				logger.log(LogStatus.FAIL,
						"Failed to enter '****' into field -->" + elementName);
				System.out.println("Failed to enter '****' into field -->"
						+ elementName);
			}
		}
	}

	/**
	 * This method is used to enter character seq into the locator provided like
	 * ENTER, SHIFT, CTRL.. etc
	 */
	protected void type(String locatorName, String elementName,
			CharSequence... var1) throws Throwable {

		boolean flag = false;
		try {
			// ((JavascriptExecutor)
			// Driver).executeScript("arguments[0].scrollIntoView(true);", we);
			WebElement we = getElement(locatorName);
			we.sendKeys(var1);
			flag = true;
		} catch (Exception e) {
			flag = false;
			logger.log(LogStatus.ERROR, "Element is not available on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		} finally {
			if (flag) {
				logger.log(LogStatus.PASS,
						"Successfully 'ENETR' key into field '" + elementName
								+ "'");
				System.out.println("Successfully 'ENETR' key into field '"
						+ elementName + "'");
			} else {
				logger.log(LogStatus.FAIL, "Failed to 'ENTER' into field '"
						+ elementName + "'");
				System.out.println("Failed to 'ENTER' into field '"
						+ elementName + "'");
			}

		}
	}

	/**
	 * This method is used to get text of provided xpath
	 */
	protected String getTextByXpath(String element) {
		return Driver.findElement(By.xpath(element)).getText();

	}

	/**
	 * This method is used to enter date in dd , mm, yyy format
	 */
	protected void enterDate(String locator, String dd, String mm, String yyy) {
		// click(locator, "date");
		Actions a = new Actions(Driver);
		a.moveToElement(getElement(locator)).click();
		// getElement(locator).sendKeys(dd+mm);
		// Driver.findElement(By getElement(locator))
		a.sendKeys(dd);
		a.sendKeys(mm);
		a.sendKeys(Keys.TAB);
		a.sendKeys(yyy).build().perform();

	}

	/**
	 * This method is used to type given text into the text box
	 */
	protected void type(String locatorName, String testdata, String elementName)
			throws Throwable {

			type(getElement(locatorName), testdata, elementName);
	
	}

	/**
	 * This method is used to type given text into the text box and clear text
	 */
	protected void type(String locatorName, String testdata, boolean clear,
			boolean keyClear) throws Throwable {

		typeKeys(getElement(locatorName), testdata, clear, keyClear);
	}

	/**
	 * This method is used to type given text into the text box by clearing the
	 * existing text
	 */
	protected void typeWithClear(String locatorName, String testdata,
			String elementName) throws Throwable {
		clearText(locatorName);
		type(getElement(locatorName), testdata, elementName);
	}

	/**
	 *
	 * @param locatorName
	 *            : webelement having multiple elements
	 * @return list of webelements
	 * @throws Throwable
	 */
	protected List<WebElement> getAllElements(String locatorName)
			throws Throwable {

		// WebDriverWait wait = new WebDriverWait(Driver, 100);
		List<WebElement> elements = new ArrayList<WebElement>();
		try {
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator(locatorName)));
			elements = Driver.findElements(byLocator(locatorName));
			return elements;

		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			System.out.println(e.getMessage());
			throw e;
		}

	}

	/**
	 * This method written to gettext from list by looping through
	 * 
	 * @param locatorName
	 *            : webelement having multiple elements
	 * @return list of webelements
	 * @throws Throwable
	 */
	@SuppressWarnings("null")
	public List<String> getAllTheText(String locator) throws Throwable {
		List<String> listWithText = new ArrayList<>();
		List<WebElement> l = getAllElements(locator);
		for (WebElement webElement : l) {
			listWithText.add(webElement.getText());
		}
		return listWithText;
	}

	/**
	 * This method written to gettext from list by looping through
	 * 
	 * @param locatorName
	 *            : webelement having multiple elements
	 * @return list of webelements
	 * @throws Throwable
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Set<String> getAllTheTextIntoSet(String locatorName)
			throws Throwable {
		// TODO Auto-generated method stub
		List<String> l = getAllTheText(locatorName);
		System.out.println(l);
		Set elements = new HashSet(l);
		return elements;
	}

	/**
	 * Binding to check Checkbox
	 *
	 * @param we
	 *            webElement of checkbox to check
	 */
	protected void check(final WebElement we) {
		if (!we.isSelected()) {
			we.click();
		}
	}

	/**
	 * Binding to check checkbox
	 *
	 * @param locator
	 *            locator of checkbox to check
	 */
	protected void check(final String locator) {
		check(getElement(locator));
	}

	/**
	 * Binding to clear text field and enter text
	 *
	 * @param we
	 *            webElement to type to
	 * @param value
	 *            value to type into the field
	 * @param clear
	 *            true to clear the field first; false to enter text without
	 *            clearing field
	 * @param keyClear
	 *            true to clean using keyboard shortcut; false without clean;
	 * @return webElement with edited text
	 */
	protected WebElement typeKeys(final WebElement we, final String value,
			final boolean clear, final boolean keyClear) {
		if (clear)
			we.clear();
		if (keyClear) {
			we.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			we.sendKeys(Keys.chord(Keys.DELETE));
		}
		we.sendKeys(value);
		return we;
	}

	/** this Method is get visible text */

	protected String getVisibleText(final String locator) throws Throwable {
		String text = "";
		try {
			text = getElement(locator).getText();
			return text;
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			System.out.println(e.getMessage());

		}
		return "";
	}

	/**
	 * Binding to select item in dropdown by value
	 *
	 * @param we
	 *            WebElement of the dropdown
	 * @param option
	 *            value to select in the dropdown
	 * @throws IOException 
	 */
	protected void selectDropDown(final String we, final String option) throws IOException {

		try {
			Select element = new Select(getElement(we));
			element.selectByVisibleText(option);
			logger.log(LogStatus.INFO, "Drop down selected option " + option);
			System.out.println("Drop down selected option " + option);

		} catch (Exception e) {
			// takeScreenshot();
			logger.log(LogStatus.ERROR, "Element is not available on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();

		}
	}

	/** This method is to select option from dropdown */

	public String selectedOptionDroDown(String locator) {

		Select select = new Select(getElement(locator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;

	}

	/**
	 * This method is used to get the selected dropdown option
	 */
	public String getDropdownSelectedValue(String locator) {

		Select select = new Select(getElement(locator));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;

	}

	/**
	 * This method is used to select an option from dropdown using visible text
	 * @throws IOException 
	 */
	protected boolean  selectDropDownByVisibleText(final String we,
			final String option) throws InterruptedException, IOException {
		boolean flag = false;
		Thread.sleep(1000);
		try {

			Select element = new Select(getElement(we));
			element.selectByVisibleText(option);
			logger.log(LogStatus.INFO, "Selected option from dropdown " + option);
			System.out.println("Selected option from dropdown " + option);
			flag = true;
		} catch (Exception e) {
			System.out.println("Drop down selection failed due to exception :" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();

		}
		return flag;
	}

	/**
	 * This method is used to select an option from dropdown using value
	 * @throws IOException 
	 */
	protected void selectDropDownByValue(final String we, final String option) throws IOException {

		try {
			Select element = new Select(getElement(we));
			element.selectByValue(option);
			logger.log(LogStatus.INFO, "Drop down selected option " + option);
			System.out.println("Drop down selected option " + option);
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		
		}
	}

	/**
	 * This method is used to select an option from dropdown using index
	 * @throws IOException 
	 */
	protected void selectDropDownByIndex(final String we, final int option) throws IOException {

		try {
			Select element = new Select(getElement(we));
			element.selectByIndex(option);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select dropdown due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get selected page to the element
	 */
	protected Select getSelect(final WebElement we) {

		return new Select(we);

	}

	/**
	 * This method is used to scroll web page to the element
	 * @throws IOException 
	 */
	protected void scrollElementIntoView(String locator) throws IOException {
		try {
			((JavascriptExecutor) Driver).executeScript(
					"arguments[0].scrollIntoView(true);", getElement(locator));

			logger.log(LogStatus.PASS, "Scrolled element to view");
			System.out.println("Scrolled element to view");

		}
		catch (Exception e) {
			logger.log(LogStatus.FAIL, "Element is not available on page due to exception" +e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" +e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to scroll web page to bottom
	 * 
	 * @throws Exception
	 */
	protected void scrollToBottom() throws Exception {
		try {
			((JavascriptExecutor) Driver)
					.executeScript("window.scrollBy(0,1500)");
			Thread.sleep(3000);
			logger.log(LogStatus.PASS, "Scrolled to bottom to view element");
			System.out.println("Scrolled to bottom to view element");
		}

		catch (Exception e) {
			System.out.println("Failed to scroll to bottom" + e);
			logger.log(LogStatus.PASS, "Scrolled to bottom to view element");
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to scroll web page to the element
	 * @throws Throwable 
	 */
	protected void scrollElementIntoView(WebElement elementToScroll) throws Throwable {
		try {
			((JavascriptExecutor) Driver).executeScript(
					"arguments[0].scrollIntoView(true);", elementToScroll);
			logger.log(LogStatus.PASS, "Scrolled to view element" +elementToScroll);
			System.out.println("Scrolled to view element" +elementToScroll);
		} catch (Exception e) {
			System.out.println("Unable perform Scrolling" + e);
			logger.log(LogStatus.PASS, "Scrolled to bottom to view element");
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to click on locator using Java script
	 * @throws Throwable 
	 */
	protected void JSClick(String locator) throws Throwable {

		try {
			WebElement element = getElement(locator);
			((JavascriptExecutor) Driver).executeScript(
					"arguments[0].click();", element);
		}

		catch (Exception e) {

			logger.log(LogStatus.ERROR, "Unable to click" +e);
			System.out.println("Unable to click due to" + e);
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to click on locator using Java script and report the
	 * log into the reports
	 */
	protected boolean JSClick(String locator, String elementName)
			throws Throwable {
		boolean flag = false;
		if (waitForElementToBeClickable(locator, 60)) {
			
			try {
				waitForElementToBeClickable(locator, 60);
				WebElement element = getElement(locator);
				((JavascriptExecutor) Driver).executeScript(
						"arguments[0].click();", element);
				logger.log(LogStatus.PASS, "Successfully clicked on -->"+ elementName);
				System.out.println("Successfully clicked on '"+ elementName + "'");
				flag = true;
				return flag;
			}

			catch (Exception e) {
				flag = false;
				logger.log(LogStatus.FAIL, "Failed to click on -->"+ elementName);
				logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
				System.out.println("Failed to click on -->" + elementName +" due to exeception "+ e);
				e.printStackTrace();
			}

		} else {
			logger.log(LogStatus.FAIL, "Element -->"+ elementName + "is not visible on page");
			logger.log(LogStatus.FAIL,logger.addScreenCapture(capture(Driver, "screenShot")));
			System.out.println("Element is not available on page due to exception" );
		}
		return false;
	}
	
	protected boolean clickIfclickable(String locator, String elementName) throws Throwable
	{
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(byLocator(locator)));
			waitForElementPresent(locator, 1);
			WebElement element = getElement(locator);((JavascriptExecutor) Driver).executeScript("arguments[0].click();", element);
			logger.log(LogStatus.PASS, "Successfully clicked on -->"+ elementName);
			System.out.println("Successfully clicked on '"+ elementName + "'");
			flag = true;
		} catch (Exception e) {			
			logger.log(LogStatus.FAIL, "Failed to click on -->"+ elementName +" "+e);
			System.out.println("Failed to click on -->" + elementName +" "+e);
		}
		return flag;
		
		
	}
	
	/**
	 * This method is used to switch to the frame
	 */

	protected void switchToFrame(String locator) {

		try {
			Driver.switchTo().frame(getElement(locator));
		}

		catch (Exception e) {

			logger.log(LogStatus.ERROR, e);
			System.out.println("Failed to switch frame" + e);
			Assert.fail("Unable to switch to element"  +e);

		}
	}

	/**
	 * This method is used to switch to the default frame
	 */
	protected void switchToDefaultFrame() {

		try {
			Driver.switchTo().defaultContent();
		}

		catch (Exception e) {

			e.printStackTrace();
			Assert.fail("Unable to switch to element"  +e);
		}
	}

	/**
	 * This method is generate random String of specific length
	 */

	public static String getRandomString(int length) {
		final String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder result = new StringBuilder();
		while (length > 0) {
			Random rand = new Random();
			result.append(characters.charAt(rand.nextInt(characters.length())));
			length--;
		}
		return result.toString();
	}

	/**
	 * This method is generate random int of specific length
	 */
	public static String getRandomInt(int length) {
		final String characters = "12345";
		StringBuilder result = new StringBuilder();
		while (length > 0) {
			Random rand = new Random();
			result.append(characters.charAt(rand.nextInt(characters.length())));
			length--;
		}
		return result.toString();
	}

	/**
	 * This method is generate random String for MAC specific length
	 */
	public static String getRandomStringforMAC(int length) {
		final String characters = "ABCDEF1234567890";
		StringBuilder result = new StringBuilder();
		while (length > 0) {
			Random rand = new Random();
			result.append(characters.charAt(rand.nextInt(characters.length())));
			length--;
		}
		return result.toString();
	}
	
}
