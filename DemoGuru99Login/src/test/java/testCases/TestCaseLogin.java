package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseSetup;
import pageObjects.LoginPage;

public class TestCaseLogin extends BaseSetup{
	
	
	WebDriver driver;
	LoginPage page;
	
	@BeforeClass
	public void setup() {
		
		driver=OpenBrowser();
	}
	
	/*@Test
	public void TestValidLogin() {
		
		
		page=new LoginPage(driver);
		page.setUserName(username);
		page.setPassword(userpass);
		page.clickOnLoginButton();
		
		String title=page.getPageTitle();
		Assert.assertEquals(title,"Guru99 Bank Manager HomePage");
		
		
	}*/
	
	@Test
	@Parameters({"uname","pass"})
        public void TestValidLogin(String uid,String upass) {
		page=new LoginPage(driver);
		page.setUserName(uid);
		page.setPassword(upass);
		page.clickOnLoginButton();
		
		String title=page.getPageTitle();
		Assert.assertEquals(title,"Guru99 Bank Manager HomePage");
	
	}
	
	/*@Test
	public void EnterValidPassword() {
		
		page.setPassword("bAmEgEr");
		
	}
	
	@Test
	public void ClickonLoginButton() {
		
		page.clickOnLoginButton();
		
	} */

   @AfterClass
   public void closeBrowser() {
	   
	   driver.close();
   }

}
