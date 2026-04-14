package test.com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JQuerySelectDropdown_Test extends PageLocatorActions {
	
	
	 private static final String URL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";

	    public JQuerySelectDropdown_Test() {
	        super(driver);
	    }

	    @BeforeClass
	    public void setup() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
	        driver.manage().deleteAllCookies();
	    }

	    @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    @Test
	    public void testSingleDropdownSelection() {
	        driver.get(URL);
	        byXpathAndSelectDropDownByValue("//select[@id='country']", "India");
	    }

	    @Test
	    public void testDropdownWithSearch() {
	        driver.get(URL);
	        String searchText = "Australia";
	        waitAndClickOnElementByXpath("(//span[contains(@role,'combobox')])[1]");
	        waitAndEnterTextByXpath("(//input[contains(@role,'textbox')])[2]", searchText);
	        waitAndClickOnElementByXpath("//li[contains(@role,'treeitem')][normalize-space()='" + searchText + "']");
	    }

	    @Test
	    public void testMultipleValuesDropdownSelection() {
	        driver.get(URL);
	        WebElement ele_multiple = driver.findElement(By.xpath("//select[@class='js-example-basic-multiple pl-10 select2-hidden-accessible']"));
	        Select select = new Select(ele_multiple);
	        if (select.isMultiple()) {
	            select.selectByValue("AZ");
	            select.selectByValue("CA");
	            select.selectByValue("FL");
	        }
	    }

	    @Test
	    public void testDeSelectMultipleValuesDropdownSelection() {
	        driver.get(URL);
	        WebElement ele_multiple = driver.findElement(By.xpath("//select[@class='js-example-basic-multiple pl-10 select2-hidden-accessible']"));
	        Select select = new Select(ele_multiple);
	        if (select.isMultiple()) {
	            select.selectByValue("AZ");
	            select.selectByValue("CA");
	            select.selectByValue("FL");
	        }
	        select.deselectAll();
	    }

	    @Test
	    public void testMultipleValuesSelectionUsingMethod() {
	        driver.get(URL);
	        String[] values = {"AZ", "CA", "FL"};
	        selectMultipleValueDropDownByValueByXpath("//select[@class='js-example-basic-multiple pl-10 select2-hidden-accessible']", values);
	    }

	    @Test
	    public void testMultipleValuesSelectionWithSearch() {
	        driver.get(URL);
	        String[] options = {"Alaska", "Alabama", "California"};
	        for (String option : options) {
	            enterTextByXpath("//input[@class='select2-search__field']", option);
	            waitAndClickOnElementByXpath("//li[normalize-space()='" + option + "']");
	        }
	    }

	    @Test
	    public void testDisabledDropdownOption() {
	        driver.get(URL);
	        String valueDisable = "GU";
	        WebElement ele = driver.findElement(By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']"));
	        Select select_disable = new Select(ele);

	        boolean isOptionFound = false;

	        for (WebElement option : select_disable.getOptions()) {
	            if (option.getAttribute("value").equals(valueDisable)) {
	                isOptionFound = true;
	                if (option.isEnabled()) {
	                    select_disable.selectByValue(valueDisable);
	                    System.out.println("Selected value: " + valueDisable);
	                } else {
	                    System.out.println("The option with value '" + valueDisable + "' is disabled and cannot be selected.");
	                }
	                break;
	            }
	        }

	        if (!isOptionFound) {
	            System.out.println("The option with value '" + valueDisable + "' is not available in the dropdown.");
	        }
	    }

	    @Test
	    public void testCategoryDropdownSelection() {
	        driver.get(URL);
	        byXpathAndSelectDropDownByVisibleText("//select[@id='files']", "PHP");
	        byXpathAndSelectDropDownByVisibleText("//select[@id='files']", "Java");
	    }



}
