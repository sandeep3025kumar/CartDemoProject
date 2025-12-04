package TestCases;

import org.testng.annotations.Test;

import PageObject.HomePgae;
import PageObject.LogInPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import junit.framework.Assert;

public class TC2_LogInTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_LogIn() {
		
		logger.info("******login Test started***********");
		
		try {
		logger.info("******HomePage***********");
		HomePgae hp= new HomePgae(driver);
		hp.myAccountDrpdown();
		hp.loginbtn();
		
		logger.info("******LogInPage***********");
		LogInPage lp=new LogInPage(driver);
		lp.set_Email(p.getProperty("email"));
		lp.set_Password(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("******MyAccountPage***********");
		MyAccountPage ma=new MyAccountPage(driver);
		boolean tagetpage=ma.isMyAccountPageISExist();
		Assert.assertTrue(tagetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******login Test  FInished***********");
		
	}

}
