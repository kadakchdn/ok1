package testCases;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeTest;

import io.appium.java_client.windows.WindowsDriver;

public class BaseTestCase {

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
     driver = new WindowsDriver(url, capabilities);
    }
    
//  @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    }
