package testCases;

import org.testng.annotations.Test;

import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.dataProvider;

public class TestRegistration_001 extends BaseClass {

	@Test (dataProvider="loginData",  dataProviderClass = dataProvider.class )
	void registrationPage(String firstName,String lastName, String email, String mobile, String password) {

		logger.info("**Test Started**");

		RegistrationPage rp = new RegistrationPage(driver);

		try {
			logger.info("Clicked on my account");
			rp.clickMyAccout();
			logger.info("Clicked on register");
			rp.clickRegister();
			logger.info("Entered on name");
			rp.enterFirstName(firstName);
			rp.enterLastName(lastName);
			rp.enterEmail(email);
			rp.enterMobile(mobile);
			rp.enterPass(password);
			rp.enterConPass(password);
			rp.clickAgree();

			rp.clickSubmit();
			logger.info("Clicked on submit");

			// boolean erMess = rp.emailInUse();

			if (rp.emailInUse()) {

				System.out.println("Email already exists");
			} else {
				System.out.println("Registration successful");
			}
		} catch (Exception e) {

			logger.error("Test Failed");
		}

	}
}
