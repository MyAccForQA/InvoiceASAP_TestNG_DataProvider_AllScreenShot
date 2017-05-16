package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class AccPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "manage-users")
	private WebElement manageUsers;

	public AccPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findButton_manageUsers_isEnabled return boolean is isEnabled")
	public boolean findButton_manageUsers_isEnabled() {
		return wait.until(ExpectedConditions.visibilityOf(manageUsers)).isEnabled();
	}

	@Step("findButton_manageUsers_isDisplayed return boolean is isDisplayed")
	public boolean findButton_manageUsers_isDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(manageUsers)).isDisplayed();
	}
}