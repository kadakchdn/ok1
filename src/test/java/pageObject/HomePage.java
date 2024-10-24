package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.windows.WindowsDriver;

public class HomePage {
	

	 private WindowsDriver driver;

	    
	    // Constructor
	    public HomePage(WindowsDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void clickCreateSuiteButton() 
	    {
	        WebElement CreateSuiteButton1 = driver.findElementByName("Create Suite");
	        CreateSuiteButton1.click();
	     
	       
	    }

	    // Actions
	    public String getHomeId() 
	    {
	        String homewindowhandle = driver.getWindowHandle();
	        return homewindowhandle;
	       
	    }

}
