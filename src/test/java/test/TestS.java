package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom_pf.AccPage;
import pom_pf.HomePage;
import pom_pf.LogInPage;
import pom_pf.SignUpPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HP_Title")
	@Test(groups = { "ff", "ok" })
	public void test_HP_Title() {

		// ????????????????????????
		String exp = "Mobile Invoicing and Payments. Works with QuickBooks | InvoiceASAP | Easy mobile invoicing and payments that's integrated with QuickBooks for Apple iOS and Android devices.";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_Title - " + exp);
		}
	}

	// #2
	@Title("test_HP_ToGo_freeTrial")
	@Test(groups = { "ff", "ok" })
	public void test_HP_ToGo_freeTrial() {

		String exp = "Pricing";
		try {
			new HomePage(driver, wait).findAndClickButton_freeTrial();

			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_freeTrial " + exp);
		}
	}

	// #3
	@Title("test_HP_ToGo_LogIn")
	@Test(groups = { "ff", "ok" })
	public void test_HP_ToGo_LogIn() {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);

			boolean act = logIn.findButton_LogIn_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn " + exp);
		}
	}

	@DataProvider(name = "WrongEmail")
	public static String[][] wrongEmail() {
		String[][] str = { { "qwe", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@asd", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@asd.", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@asd.c", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@.com", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "qwe@.", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." } };
		return str;
	}

	// #4
	@Title("test_HP_ToGo_LogIn_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HP_ToGo_LogIn_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);
			logIn.findAndFillInField_Username(email);
			logIn.findAndFillInField_Password(pass);
			logIn.findAndClickButton_LogIn();

			String act = logIn.findError_checkEmailAndPass();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "WrongPass")
	public static String[][] wrongPass() {
		String[][] str = { { "qwerty@asdf.com", "q", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qw", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qwe", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qwea", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweas", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweasd", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweasdz", "The password must be at least 8 characters." } };
		return str;
	}

	// #5
	@Title("test_HP_ToGo_LogIn_WrongPass_ErrorValid")
	// @Test(groups = { "ff", "ok" }, dataProvider = "WrongPass")
	public void test_HP_ToGo_LogIn_WrongPass_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);
			logIn.findAndFillInField_Username(email);
			logIn.findAndFillInField_Password(pass);
			logIn.findAndClickButton_LogIn();

			String act = logIn.findError_checkEmailAndPass();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_WrongPass_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "IncorrectEmail")
	public static String[][] incorrectEmail() {
		String[][] str = { { "qwerty@asdf.com", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "asdfgh@asdf.com", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." },
				{ "zxcvbn@asdf.com", "qweasdzxc", "USERNAME OR PASSWORD IS INCORRECT." } };
		return str;
	}

	// #6
	@Title("test_HP_ToGo_LogIn_IncorrectEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "IncorrectEmail")
	public void test_HP_ToGo_LogIn_IncorrectEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);
			logIn.findAndFillInField_Username(email);
			logIn.findAndFillInField_Password(pass);
			logIn.findAndClickButton_LogIn();

			String act = logIn.findError_checkEmailAndPass();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_IncorrectEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "CorrectEmail")
	public static String[][] correctEmail() {
		String[][] str = { { "cufaza@envy17.com", "Zaq12wsx", "Qwe", "Asd" } };
		return str;
	}

	// #7
	@Title("test_HP_ToGo_NewCustomer_CorrectEmail")
	@Test(groups = { "ff", "ok" }, dataProvider = "CorrectEmail")
	public void test_HP_ToGo_NewCustomer_CorrectEmail(String email, String pass, String fname, String lname) {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);
			logIn.findAndClickButton_newCustomer();

			SignUpPage signUp = new SignUpPage(driver, wait);
			signUp.findAndFillInField_fName(fname);
			signUp.findAndFillInField_lName(lname);
			signUp.findAndFillInField_email(email);
			signUp.findAndFillInField_Password(pass);
			signUp.findAndFillInField_ConfirmPassword(pass);
			signUp.findAndClickButton_base();

			boolean act = signUp.findButton_base_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_NewCustomer_CorrectEmail - " + email + ":" + pass + " = " + exp);
		}
	}

	// #8
	@Title("test_HP_ToGo_LogIn_CorrectEmail")
	@Test(groups = { "ff", "ok" }, dataProvider = "CorrectEmail")
	public void test_HP_ToGo_LogIn_CorrectEmail(String email, String pass, String fname, String lname) {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage logIn = new LogInPage(driver, wait);
			logIn.findAndFillInField_Username(email);
			logIn.findAndFillInField_Password(pass);
			logIn.findAndClickButton_LogIn();

			AccPage accPage = new AccPage(driver, wait);

			boolean act = accPage.findButton_manageUsers_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_CorrectEmail - " + email + ":" + pass + " = " + exp);
		}
	}
}