package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePgae extends BasePage {

	public HomePgae(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']") 
	WebElement Registration;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement LogIn_Button;
	
	//Action methods
	
	public void myAccountDrpdown() {
		myAccount.click();
	}
	
	public void registrationtxt() {
		Registration.click();
	}
	public void loginbtn() {
		LogIn_Button.click();
	}

}
