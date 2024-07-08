package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver driver;
	
	@FindBy(xpath="//tr[@class=\"heading3\"]/td")
	WebElement dashBoardText;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logOutButton;
	
	
	public Dashboard(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String GetDashboardMsg() throws IOException {
		
		
		
		File fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs,new File( "C:\\Users\\Vibha\\eclipse-workspace\\DemoGuru99Login\\screenshot.jpeg"));
		
		return dashBoardText.getText();
		
		
	}
	
	public void ClickOnLogOut() {
		
		logOutButton.click();
		
	}
	
	
}
