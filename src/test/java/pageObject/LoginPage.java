package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.windows.WindowsDriver;

public class LoginPage 
{
	
	 private WindowsDriver driver;

	    

	    // Constructor
	    public LoginPage(WindowsDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterUsername(String username) {
	        WebElement usernameElement = driver.findElementByName("User name");
	        usernameElement.click();
	        usernameElement.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        WebElement passwordElement = driver.findElementByName("Password");
	        passwordElement.click();
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        WebElement loginButtonElement = driver.findElementByName("Log In");
	        loginButtonElement.click();
	    }

	    // Actions
	    public String getloginwindowID() 
	    {
	        String loginwindowhandle = driver.getWindowHandle();
	        return loginwindowhandle;
	       
	    }
}
