package test.com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLocatorActions {
	
	public static  WebDriver driver;  // Instance variable for WebDriver
    private  WebElement ele;
    private final long timeout = 10;

    // Constructor to initialize WebDriver
    public PageLocatorActions(WebDriver driver) {
        this.driver = driver;
    }

   

    protected void waitForElementClickableByXpath(String xpath)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected WebElement explicitWaitOnElement(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return ele;
    }

    


    /**
     * User Actions  on Elements - methods
     **/

    protected void clickOnElementByXpath(String xpath)
    {
         ele = driver.findElement(By.xpath(xpath));
        if (ele.isDisplayed() && ele.isEnabled()) {
            ele.click();
        }
    }

    public void waitAndClickOnElementByXpath(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ele.click();
    }

    public void waitAndEnterTextByXpath(String xpath,String value)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ele.click();
        // Check if there is existing text, then clear it
        if (!ele.getText().isEmpty()) {
            ele.clear();
        }
        ele.sendKeys(value);
    }


    protected void enterTextByXpath(String xpath,String text)
    {
         ele = driver.findElement(By.xpath(xpath));
        if (ele.isDisplayed() && ele.isEnabled()) {
            ele.click();
            ele.sendKeys(text);
        }
    }

    
    public void byXpathAndSelectDropDownByValue(String xpath,String value)
    {
        ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        select.selectByValue(value);

    }

    public void byXpathAndSelectDropDownByVisibleText(String xpath,String textValue)
    {
        ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        select.selectByVisibleText(textValue);

    }

    public void selectMultipleValueDropDownByValueByXpath(String xpath, String[] values) {

        WebElement ele = driver.findElement(By.xpath(xpath));
        Select select = new Select(ele);
        // Check if the dropdown supports multiple selection
        if (select.isMultiple()) {
            // Iterate through each value and select it
            for (String value : values) {
                select.selectByValue(value);
            }
        } else {
            System.out.println("This dropdown does not support multiple selections.");
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
