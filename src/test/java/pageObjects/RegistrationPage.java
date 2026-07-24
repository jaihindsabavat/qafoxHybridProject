package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement accRegister;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "	//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement conPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement existUser;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement userCreated;

	// Actions
	public void clickMyAccout() {
		myAccount.click();
	}

	public void clickRegister() {
		accRegister.click();
	}

	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void enterMobile(String mobile) {
		telephone.sendKeys(mobile);
	}

	public void enterPass(String password) {
		this.password.sendKeys(password);
	}

	public void enterConPass(String conPassword) {
		this.conPassword.sendKeys(conPassword);
	}

	public void clickAgree() {
		agree.click();
	}

	public void clickSubmit() {
		submit.click();
	}

	public boolean emailInUse() {

		try {
			return existUser.isDisplayed();
		}catch (Exception e) {
			return false;
		}
		
	}

}
