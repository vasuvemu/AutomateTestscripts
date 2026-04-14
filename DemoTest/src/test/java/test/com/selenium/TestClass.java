package test.com.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class TestClass {
	
	
	public static WebDriver driver=null;

    @Test
    public void testExample() 
    {
    	 WebDriverManager.chromedriver.setup();
    	 
        driver.get("https://example.com");
        // Intentionally fail the test
        assert driver.getTitle().equals("Nonexistent Title");
       
        
        driver.quit();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
