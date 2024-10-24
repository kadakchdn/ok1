package testCases;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Psapi;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.IntByReference;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

import com.sun.jna.WString;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



import io.appium.java_client.pagefactory.Widget;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObject.AddTest_Prompt;
import pageObject.CreateSuite_Prompt;
import pageObject.HomePage;
import pageObject.LightCameraAction_Prompt;
import pageObject.LoginPage;
import pageObject.SuitePanel;

public class CreateSuiteTest  extends BaseTestCase 
{
	public LoginPage lp;
	public String loginwindowhandle;
	String homewindowhandle;
	String createSuitePromptWindowHandle;
	String SuitePanelWindowHandle;
    String addtestpromptWindowHandle ;

	@Test(priority = 1)
	public void login() throws InterruptedException 
	{

		Thread.sleep(10000);
		lp = new LoginPage(driver);
		loginwindowhandle=lp.getloginwindowID();
		System.out.println("login wh: "+loginwindowhandle);
		lp.enterUsername("123@gmail.com");
		lp.enterPassword("---------");
		lp.clickLoginButton();

		System.out.println("login button clicked");
	}

	@Test(priority = 2)
	public void createsuite() throws InterruptedException, MalformedURLException 
	{
		
		Thread.sleep(10000);
		HomePage hp = new HomePage(driver);
		
		homewindowhandle = hp.getHomeId();
		System.out.println("home wh"+homewindowhandle);
		//System.out.println("home window handle:"+ homewindowhandle);
		//List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		Set<String> windowHandles = driver.getWindowHandles();
		
	
		 
	    for (String windowHandle : windowHandles)
	    {
	    	
            if (!windowHandle.equals(loginwindowhandle))
            {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		
		hp.clickCreateSuiteButton();
		System.out.println("created suite button clicked");
		createSuitePromptWindowHandle = driver.getWindowHandle();	
		System.out.println("cspwh"+ createSuitePromptWindowHandle);
		Thread.sleep(30000);
		
		//Filling Details To Create Suite Prompt	
		CreateSuite_Prompt cp=new CreateSuite_Prompt(driver);
		cp.fill_SuiteDetails_ToCreateSuite_and_ClickingCreateSuite_Button();
		System.out.println("Suite detailed got filled and create suite button clicked"); 
		SuitePanelWindowHandle = driver.getWindowHandle();
		System.out.println("SuitePanelWindowHandle"+SuitePanelWindowHandle);
		Thread.sleep(20000);
		
		//Open Test prompt by clicking add test button
		//List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
		Set<String> Windowhandles2 = driver.getWindowHandles();
		
	    for (String windowHandle : Windowhandles2)
	    {
	    	
            if (!windowHandle.equals(createSuitePromptWindowHandle))
            {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		
		
		SuitePanel sp=new SuitePanel(driver);
		sp.click_addTest();
		System.out.println("Add Test button got clicked");
		
		//Filling details on add add test prompt
		AddTest_Prompt atp=new AddTest_Prompt(driver);
        atp.fill_TestDetails_ToCreateTest_Click_Add_Test();
        addtestpromptWindowHandle = driver.getWindowHandle();
        System.out.println("addtestpromptWindowHandle"+addtestpromptWindowHandle);
		
        //Start recording
        SuitePanel sp1=new SuitePanel(driver);
        sp1.click_Record();
        Set<String> Windowhandles3 = driver.getWindowHandles();
        
        for (String windowHandle : Windowhandles3)
	    {
	    	System.out.println(windowHandle);
        }
	    for (String windowHandle : Windowhandles3)
	    {
	    	
            if (!windowHandle.equals(SuitePanelWindowHandle)&&!windowHandle.equals(addtestpromptWindowHandle))
            {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //Enter final url start recording
        LightCameraAction_Prompt lcap=new LightCameraAction_Prompt(driver);
        String recordpromptwindowhandle=driver.getWindowHandle();
        System.out.println("recordpromptwindowhandle"+recordpromptwindowhandle);
        lcap.fill_Details_Start_Recording();

        
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).perform();
      System.out.println( driver.getTitle());
      
  
      
      
      String processName = "chromium.exe";
      long processId1 =getProcessId(processName);

      if (processId1 != -1) {
          System.out.println("Process ID for " + processName + ": " + processId1);
      } else {
          System.out.println("Process " + processName + " not found.");
      }
     
      long pid = 1234; // Replace with actual PID
      Optional<Integer> port = getRemoteDebuggingPort(processId1);
      
//      if (port.isPresent()) {
//    	    Integer actualport = port.get();
//    	   String strport = actualport.toString();
//    	    System.out.println("Port value: " + strport);
//    	} else {
//    	    System.out.println("port not found");
//    	}
      
      Integer actualport = port.get();
	   String strport = actualport.toString();
	    System.out.println("Port value: " + strport);
      
      // Configure ChromeOptions
      ChromeOptions options = new ChromeOptions();    
     String debuggerAddress = "localhost:" + strport;
      options.setExperimentalOption("debuggerAddress", debuggerAddress);
      
       driver.manage().window().maximize();
      WebDriver driver1=(ChromeDriver) new RemoteWebDriver(new URL("http://127.0.0.1:4443/wd/hub"), options);     
    
   
       
       
      
       
       
       
       
     Actions action=new Actions(driver1);
     action.moveToElement(driver1.findElement(By.id("drop1"))).click().perform();
  
       System.out.println("element got clicked");
     }
	
	//extra methods
	public static long getProcessId(String processName) {
        return ProcessHandle.allProcesses()  // Get a stream of all processes
                .filter(ph -> ph.info().command()  // Filter processes by command line name
                    .map(cmd -> cmd.contains(processName))
                    .orElse(false))
                .mapToLong(ProcessHandle::pid)  // Map the process to its PID
                .findFirst()  // Get the first matching PID
                .orElse(-1);  // Return -1 if no matching process is found
    }
	
    
	public static Optional<Integer> getRemoteDebuggingPort(long pid) {
        String command = "wmic process where ProcessId=" + pid + " get CommandLine";
        try {
            // Create a ProcessBuilder to run the command
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();

            // Read the command line output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Skip the header line
            reader.readLine(); 

            // Read the command line argument
            while ((line = reader.readLine()) != null) {
                if (line.contains("--remote-debugging-port=")) {
                    // Extract the port number
                    String[] parts = line.split("--remote-debugging-port=");
                    if (parts.length > 1) {
                        String portStr = parts[1].split(" ")[0];
                        try {
                            int port = Integer.parseInt(portStr);
                            return Optional.of(port);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
	


