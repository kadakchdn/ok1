package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

public class LightCameraAction_Prompt 
{
private WindowsDriver driver;

    
    // Constructor
    public LightCameraAction_Prompt(WindowsDriver driver) 
    {
        this.driver = driver;     
    }

    // Actions
    public void fill_Details_Start_Recording() throws InterruptedException 
    {
      // WebElement enterFinalURL = driver.findElementByName("Starting URL");
     //enterFinalURL.click();
     
     Thread.sleep(3000);
     
     Actions actions = new Actions(driver);
//    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.TAB).build().perform();
    actions.sendKeys(Keys.TAB).build().perform();
//     Thread.sleep(3000);
//     
//     enterFinalURL.sendKeys("https://omayo.blogspot.com");        
   //  enterFinalURL.sendKeys(Keys.TAB);
    
        Thread.sleep(10000);
        WebElement Record2 = driver.findElementByName("Record");
        Record2.sendKeys(Keys.ENTER);
    }

}
