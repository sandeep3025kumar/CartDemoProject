package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver driver) {
		super(driver);
		
	}
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_txt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd_txt;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement logIn_btn;
	
	//Action Methods
	
	public void set_Email(String email) {
		email_txt.sendKeys(email);
				
	}
	
	public void set_Password(String password) {
	   pwd_txt.sendKeys(password);
	}
	
	public void clickLogin() {
		logIn_btn.click();
	}

}
