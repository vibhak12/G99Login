package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginButton;
	
	      public LoginPage(WebDriver driver){
			  
			  this.driver=driver;
			  PageFactory.initElements(driver,this);
			  
		  }
		  
		
	public void setUserName(String username) {
		
	            userid.sendKeys(username);
		
	}

	
	public void setPassword(String pass) {
		
        password.sendKeys(pass);

    }
	
	public void clickOnLoginButton() {
		
		loginButton.click();
		
	}
	
	public String getPageTitle(){
		
		return driver.getTitle();
		
	}

	
}
