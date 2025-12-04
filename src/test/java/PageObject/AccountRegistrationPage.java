package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstNameTxt;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastNameTxt;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailTxt;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement mobileNumberTxt;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passWordTxt;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement conformPassWordTxt;

	@FindBy(xpath = "//input[@name='newsletter'][contains(@value,'1')]")
	WebElement subscribeYes;
	@FindBy(xpath = "//input[@name='newsletter'][contains(@value,'0')]")
	WebElement subscribeNO;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement confirmMessage;

	// Action methods
	public void set_FirstName(String firstName) {
		firstNameTxt.sendKeys(firstName);

	}

	public void set_LastName(String lastName) {
		lastNameTxt.sendKeys(lastName);

	}

	public void set_Emailid(String emailid) {
		emailTxt.sendKeys(emailid);

	}

	public void set_MobileNumber(String mblNumber) {
		mobileNumberTxt.sendKeys(mblNumber);

	}

	public void set_Password(String password) {
		passWordTxt.sendKeys(password);

	}

	public void set_ConfirmPassword(String confirmpassword) {
		conformPassWordTxt.sendKeys(confirmpassword);

	}

	public void verify_subscribeYes() {
		subscribeYes.click();

	}

	public void verify_subscribeNo() {
		subscribeNO.click();

	}

	public void select_CheckBox() {
		policyCheckBox.click();

	}

	public void click_ContinueBtn() {
		continueBtn.click();

	}

	public String get_ConfirmmationMessage() {
		try {
			return (confirmMessage.getText());

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
