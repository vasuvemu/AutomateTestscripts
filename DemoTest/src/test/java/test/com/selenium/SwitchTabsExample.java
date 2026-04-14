package test.com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTabsExample {
	
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
       driver = new ChromeDriver();
        
        // Open first tab
        driver.get("https://www.google.com");
        
        driver.manage().window().maximize();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com','_blank');");
        
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.yahoo.com','_blank');");

        // Get all window handles
        Set<String> handles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);

        // Switch to second tab
        driver.switchTo().window(tabs.get(1));
        System.out.println("Title in 2nd tab: " + driver.getTitle());
        
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        driver.switchTo().window(tabs.get(2));
        System.out.println("Title in 3rd tab: " + driver.getTitle());
        Thread.sleep(5000);

        // Switch back to first tab
        driver.switchTo().window(tabs.get(0));
        System.out.println("Title in 1st tab: " + driver.getTitle());
        
        Thread.sleep(5000);

        driver.quit();
		
		
		
		

	}

}
