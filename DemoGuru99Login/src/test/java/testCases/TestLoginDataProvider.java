package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import pageObjects.BaseSetup;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import utilities.Util;

public class TestLoginDataProvider extends BaseSetup{
	
	
	WebDriver driver;
	LoginPage page;
	Dashboard dash;
	
	@BeforeTest
	public void setup() {
		
		driver=OpenBrowser();
	}
	
	@DataProvider(name="SetUserDetails")
	public Object[][] UserDetails(){
		
		Object[][] data=new Object[4][2];
		
		data[0][0]=username;
		data[0][1]=userpass;
		
		data[1][0]="invalid";
		data[1][1]="invalid";
		
		data[2][0]="invalid";
		data[2][1]="invalid";
		
		data[3][0]="invalid";
		data[3][1]="invalid";
		
	return data;
	
	}
	
	@Test(dataProvider="SetUserDetails")
        public void TestValidLogin(String uid,String upass) throws IOException {
		page=new LoginPage(driver);
		page.setUserName(uid);
		page.setPassword(upass);
		page.clickOnLoginButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		try {
			
			Alert alt=driver.switchTo().alert();
			String actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			 // Compare Error Text with Expected Error Value					
			Assert.assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
			
		}catch(NoAlertPresentException Ex) {
			
			dash=new Dashboard(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
		//WebElement dashBoardText=driver.findElement(By.xpath("//tr[@class=\"heading3\"]/td"));
		String actualMgrId=dash.GetDashboardMsg();
		
		//String title=page.getPageTitle();
		//Assert.assertEquals(title,"Guru99 Bank Manager HomePage");
		
		Assert.assertTrue(actualMgrId.contains(uid));
		dash.ClickOnLogOut();
		driver.switchTo().alert().accept();
		}
		
	
	}
	
	@AfterTest
	   public void closeBrowser() {
		   
		   driver.quit();
	   }

}
