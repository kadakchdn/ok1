package basicprogram;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class OpenEmulator
{
	public static void main(String[] args)
	{
		// Define the DesiredCapabilities for the Android emulator
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
       capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium_Phone_API_35"); // Use the name of your emulator
       capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
       // Set YouTube app package and activity
       capabilities.setCapability("appPackage", "com.google.android.youtube"); // YouTube package name
       capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity"); // YouTube main activity


     
       // Define the URL for the Appium server
       URL appiumServerUrl = null;
       try {
           appiumServerUrl = new URL("http://127.0.0.1:4723/"); // Appium server URL
       } catch (MalformedURLException e) {
           e.printStackTrace();
       }
       // Initialize the AndroidDriver
       AndroidDriver<AndroidElement> driver = null;
       try {
           driver = new AndroidDriver<>(appiumServerUrl, capabilities);
           // Wait for the YouTube app to load
           Thread.sleep(20000); // Adjust as needed
           // Get device information
           String deviceName = driver.getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();
           String platformVersion = driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_VERSION).toString();

           System.out.println("Device Name: " + deviceName);
           System.out.println("Platform Version: " + platformVersion);
           Thread.sleep(20000);
           // Interact with the "Allow" button using resource-id
           AndroidElement allowButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
           allowButton.click();
           Thread.sleep(20000);
           driver.findElement(By.xpath("//node[@content-desc='Search YouTube']")).click();
           driver.findElement(By.xpath("//node[@content-desc='Search YouTube']")).sendKeys("Movies");
           

           
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           if (driver != null) {
               driver.quit(); // Close the Appium session
           }
       }
	}
}
