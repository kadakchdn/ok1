package testCases;


import org.testng.annotations.Test;

import pageObject.LoginPage;

public class LoginTest extends BaseTestCase
{
	    @Test
	    public void testApp() throws InterruptedException
	    {
	        
	      Thread.sleep(30000);
	     LoginPage lp=new LoginPage(driver);
	      lp.enterUsername("akshay.kamble@orasi.com");
	      lp.enterPassword("bigdaddy");
	      lp.clickLoginButton();
	      

	      System.out.println("login success");
	    }
}
