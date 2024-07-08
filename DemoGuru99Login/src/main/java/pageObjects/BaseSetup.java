package pageObjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 


public class BaseSetup {
	
	WebDriver driver;
	String driverpath="D:\\Drivers\\chromedriver.exe";
	String url="http://www.demo.guru99.com/V4/";
	protected String username;
	protected String userpass;
	
	public BaseSetup() {
	try {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Vibha\\eclipse-workspace\\DemoGuru99Login\\src\\main\\java\\resources\\Datafile.properties"));
		
		//FileInputStream reader=new FileInputStream("C:\\Users\\Vibha\\eclipse-workspace\\DemoGuru99Login\\src\\main\\java\\resources\\Datafile.properties");
		
		Properties prop=new Properties();
		try {
			prop.load(reader);
		    username=prop.getProperty("userid");
		    userpass=prop.getProperty("password");
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
	public WebDriver OpenBrowser(){
		
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}

   
	
}
