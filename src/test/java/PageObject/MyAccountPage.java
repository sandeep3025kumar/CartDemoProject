package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div//h2[normalize-space()='My Account']")
	WebElement myAccountMSGHeading;

	public boolean isMyAccountPageISExist() {
		try {
			return (myAccountMSGHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		} 

	}
}
