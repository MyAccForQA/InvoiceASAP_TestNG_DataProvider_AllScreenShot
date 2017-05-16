package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// @FindBy(name = "email")
	@FindBy(id = "logInId")
	private WebElement username;

	// @FindBy(name = "password")
	@FindBy(id = "logInPassword")
	private WebElement password;

	@FindBy(xpath = "//input[@class = 'at_login_btn' and @name = 'btLogin' and @type = 'submit' and @value = 'LOG IN']")
	private WebElement logIn;
	
	@FindBy(xpath = "//a[@class = 'at_link' and contains(text(), 'New Customer?')]")
	private WebElement newCustomer;

	@FindBy(xpath = "//span[@class = 'at_error_msg']")
	private WebElement checkEmailAndPass;

	public LogInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_Username with name - [{0}]")
	public WebElement findAndFillInField_Username(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(username)).clear();
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(st);
		return username;
	}

	@Step("findAndFillInField_Password with pass - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		// password.clear();
		wait.until(ExpectedConditions.visibilityOf(password)).clear();
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(st);
		return password;
	}

	@Step("findButton_LogIn_isEnabled return boolean is isEnabled")
	public boolean findButton_LogIn_isEnabled() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return wait.until(ExpectedConditions.visibilityOf(logIn)).isEnabled();
	}

	@Step("findButton_LogIn_isDisplayed return boolean is isDisplayed")
	public boolean findButton_LogIn_isDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return wait.until(ExpectedConditions.visibilityOf(logIn)).isDisplayed();
	}

	@Step("findAndClickButton_LogIn")
	public WebElement findAndClickButton_LogIn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(logIn)).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return logIn;
	}
	
	
	@Step("findAndClickButton_newCustomer")
	public WebElement findAndClickButton_newCustomer() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(newCustomer)).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return newCustomer;
	}

	@Step("findError_checkEmailAndPass return String - Error")
	public String findError_checkEmailAndPass() {
		return wait.until(ExpectedConditions. visibilityOf(checkEmailAndPass)).getText();
	}
}