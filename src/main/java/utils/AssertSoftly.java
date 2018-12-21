package utils;

import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import com.relevantcodes.extentreports.LogStatus;

import accelerators.TestEngine;

public class AssertSoftly extends Assertion {
	
	// LinkedHashMap to preserve the order
    private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
    private String assertMessage = null;
    

    TestEngine obj = new TestEngine();
    
    
    @Override
    protected void doAssert(IAssert<?> a) {
    	
    	 
        onBeforeAssert(a);
        try {
            assertMessage = a.getMessage();
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
            try {     	
            	TestEngine.logger.log(LogStatus.FAIL,TestEngine.logger.addScreenCapture(obj.capture(TestEngine.Driver, assertMessage)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append("\n\t");
                sb.append(ae.getKey().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }


}
