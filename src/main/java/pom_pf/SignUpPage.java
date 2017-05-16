package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SignUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@class = 'txtbox' and @placeholder = 'First Name']")
	private WebElement fname;

	@FindBy(xpath = "//input[@class = 'txtbox' and @placeholder = 'Last Name']")
	private WebElement lname;

	// @FindBy(name = "email")
	@FindBy(xpath = "//input[@class = 'txtbox' and @placeholder = 'your@email.com']")
	private WebElement username;

	// @FindBy(name = "password")
	@FindBy(xpath = "//input[@class = 'txtbox' and @placeholder = 'Password']")
	private WebElement password;

	@FindBy(xpath = "//input[@class = 'txtbox' and @placeholder = 'Confirm Password']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@class = 'btnPlanOrange' and @name = 'myButton_base-monthly']")
	private WebElement base;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_fName with name - [{0}]")
	public WebElement findAndFillInField_fName(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(fname)).clear();
		wait.until(ExpectedConditions.visibilityOf(fname)).sendKeys(st);
		return fname;
	}

	@Step("findAndFillInField_lName with name - [{0}]")
	public WebElement findAndFillInField_lName(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(lname)).clear();
		wait.until(ExpectedConditions.visibilityOf(lname)).sendKeys(st);
		return lname;
	}

	@Step("findAndFillInField_Username with name - [{0}]")
	public WebElement findAndFillInField_email(String st) {
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
	
	@Step("findAndFillInField_ConfirmPassword with pass - [{0}]")
	public WebElement findAndFillInField_ConfirmPassword(String st) {
		// password.clear();
		wait.until(ExpectedConditions.visibilityOf(confirmPassword)).clear();
		wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(st);
		return confirmPassword;
	}

	@Step("findButton_buttonbase_isEnabled return boolean is isEnabled")
	public boolean findButton_buttonbase_isEnabled() {
		return wait.until(ExpectedConditions.visibilityOf(base)).isEnabled();
	}

	@Step("findButton_base_isDisplayed return boolean is isDisplayed")
	public boolean findButton_base_isDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(base)).isDisplayed();
	}

	@Step("findAndClickButton_base")
	public WebElement findAndClickButton_base() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(base)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return base;
	}
}