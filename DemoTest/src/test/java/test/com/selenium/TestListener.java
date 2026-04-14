package test.com.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private WebDriver driver;

    public TestListener(WebDriver driver) {
        this.driver = driver;
    }

     
    @Override 
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ScreenshotUtil.captureScreenshot(driver, testName);
        
    }

}
