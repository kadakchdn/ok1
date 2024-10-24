package pack1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppDriverTest {
	
	WindowsDriver driver;
	
	  
	    @BeforeTest
	    public void setUp() throws MalformedURLException
	    {
	    	DesiredCapabilities capabilities = new DesiredCapabilities();
	    	capabilities.setCapability("platformName", "Windows");
	    	capabilities.setCapability("deviceName", "WindowsPC");
	      capabilities.setCapability("app", "C:\\Program Files\\Alchemy\\Alchemy.exe");
	     capabilities.setCapability("automationName", "WinAppDriver");

	      URL url = new URL("http://localhost:4723");
	     driver =new  WindowsDriver(url, capabilities);
	     
	    
	    }

	   

		@Test
	    public void testApp() throws InterruptedException {
	        //Example: Interacting with an element in your application
	    	Thread.sleep(30000);
	        WebElement username=driver.findElementByAccessibilityId("JavaFX4");
	      System.out.println( username.isDisplayed()); 
	      if(username.isDisplayed())
	      {
	    	  username.click();
	    	  username.sendKeys("akshay");
	      }
	       
	    	System.out.println("Hi");
	    }

	  //  @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
