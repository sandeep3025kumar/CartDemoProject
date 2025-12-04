package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AccountRegistrationPage;
import PageObject.HomePgae;
import TestBase.BaseClass;

public class TC1_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verify_AccountRegistration() {
		
		logger.info("*** Started TC1 TestCase********");
		try {

			// we password and confirm password both should be same so we have to give same
			// for both.
			
			HomePgae hp = new HomePgae(driver);
			hp.myAccountDrpdown();
			hp.registrationtxt();
			AccountRegistrationPage ap = new AccountRegistrationPage(driver);
			logger.info("**** Registered details added****");
			ap.set_FirstName(aplabetbets());
			ap.set_LastName(aplabetbets());

			logger.info("**** Email details added****");
			ap.set_Emailid(alphaNumeric() + "gmail.com");
			ap.set_MobileNumber(numeric());
			
			String password = alphaNumeric();
			ap.set_Password(password);
			ap.set_ConfirmPassword(password);
			ap.verify_subscribeYes();
			ap.select_CheckBox();
			ap.click_ContinueBtn();

			logger.info("****Confirm validation added****");
			String cmfmMsg = ap.get_ConfirmmationMessage();

			if (cmfmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();

		}
		logger.info("*** Finished TC1 TestCase********");

	}

}
