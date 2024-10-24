package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class SuitePanel 
{

	private WindowsDriver driver;

    
    // Constructor
    public SuitePanel(WindowsDriver driver) 
    {
        this.driver = driver;
    }

    // Actions
    public void click_addTest() throws InterruptedException 
    {
        WebElement AddTestButton1 = driver.findElementByName("Add Test");
        AddTestButton1.click();
         
    }

    // Actions
    public void click_Record() throws InterruptedException 
    {
        WebElement Record1 = driver.findElementByName("Record");
        Record1.click();     
    }


}
