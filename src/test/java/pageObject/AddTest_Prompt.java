package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class AddTest_Prompt 
{


	private WindowsDriver driver;

    
    // Constructor
    public AddTest_Prompt(WindowsDriver driver) 
    {
        this.driver = driver;     
    }

    // Actions
    public void fill_TestDetails_ToCreateTest_Click_Add_Test() throws InterruptedException 
    {
        WebElement enterTestName = driver.findElementByName("Test Name");
        enterTestName.click();
        enterTestName.sendKeys("Test1");
        
        enterTestName.sendKeys(Keys.TAB);
        
        WebElement AddTestButton2 = driver.findElementByName("Add Test");
        AddTestButton2.sendKeys(Keys.ENTER);
       
        
      
        
      
         
    }

}
