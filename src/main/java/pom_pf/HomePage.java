package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@class = 'btn btn-success free-trial-button free-trial-header-button' and contains(text(), 'free trial')]")
	private WebElement freeTrial;

	@FindBy(xpath = "//a[@class = 'login-link' and contains(text(), 'log in')]")
	private WebElement logIn;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickButton_freeTrial")
	public WebElement findAndClickButton_freeTrial() {
		// signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(freeTrial)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return freeTrial;
	}

	@Step("findAndClickButton_logIn")
	public WebElement findAndClickButton_logIn() {
		// signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(logIn)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return logIn;
	}
}