package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

public class CreateSuite_Prompt
{
	
	
	private WindowsDriver driver;

    
    // Constructor
    public CreateSuite_Prompt(WindowsDriver driver) 
    {
        this.driver = driver;
    }

    // Actions
    public void fill_SuiteDetails_ToCreateSuite_and_ClickingCreateSuite_Button() throws InterruptedException 
    {
        WebElement suitenamefield = driver.findElementByName("Suite Name");
        suitenamefield.click();
        suitenamefield.sendKeys("Auto1");   
        
        WebElement urlfield = driver.findElementByName("url");
        urlfield.click();
        urlfield.sendKeys("https://omayo.blogspot.com");   
        
        urlfield.sendKeys(Keys.TAB);
        
        
        
        Thread.sleep(5000);
        WebElement CreateSuiteButton2 = driver.findElementByName("Create Suite");
      
        CreateSuiteButton2.sendKeys(Keys.ENTER);
      
        Thread.sleep(10000);
    }



}
