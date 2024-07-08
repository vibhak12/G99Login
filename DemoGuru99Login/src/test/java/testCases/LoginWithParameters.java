package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BaseSetup;
import pageObjects.LoginPage;
import utilities.Util;

public class LoginWithParameters {
	
	public static final String filepath="C:\\Users\\Vibha\\eclipse-workspace\\DemoGuru99Login\\TestData\\testData.xls";
	public static final String sheetname="Data";
	public static final String tablename="testData";
	String driverpath="D:\\Drivers\\geckodriver.exe";
	String url="https://www.demo.guru99.com/V4/";
	
	WebDriver driver;
	LoginPage page;
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.firefox.driver",driverpath);
		driver=new FirefoxDriver();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void TestMultipleLogin() throws IOException, Exception{
		
		
			String[][] TestData = Util.getDataFromExcel(filepath,sheetname);
	
		for (int i = 0; i < TestData.length; i++){
			String uname= TestData[i][0];
			String pass=TestData[i][1];
			
			 // Enter username
	    driver.findElement(By.name("uid")).clear();
	    driver.findElement(By.name("uid")).sendKeys(uname);

	    // Enter Password
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(pass);

	    // Click Login
	    driver.findElement(By.name("btnLogin")).click();
			
			
			try{
				
				Alert alt=driver.switchTo().alert(); 
				String actualBoxtitle = alt.getText(); // get content of the Alter Message
			alt.accept();
			if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
			    System.out.println("Test case SS[" + i + "]: Passed"); 
			} else {
			    System.out.println("Test case SS[" + i + "]: Failed");
			}	
				
			}
			catch(NoAlertPresentException Ex){
				
				String actualTitle = driver.getTitle();
				
			// On Successful login compare Actual Page Title with Expected Title
			if (actualTitle.contains(Util.EXPECT_TITLE)) {
			    System.out.println("Test case SS[" + i + "]: Passed");
			} else {
			    System.out.println("Test case SS[" + i + "]: Failed");
			}
				
			}
			
			
			
			
		}
		
		
	}
	

}
