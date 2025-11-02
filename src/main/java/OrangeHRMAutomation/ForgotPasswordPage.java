package OrangeHRMAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BaseClassforSRC {
	// public WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//div[contains(@class, 'orangehrm-card-container')]//h6")
	WebElement ResetText;

	@FindBy(xpath = "//button[contains(@class, 'orangehrm-forgot-password-button--cancel')]")
	WebElement CancelBtn;

	public boolean resetPassword() {
		return waitMethod(ResetText).isDisplayed();
	}

	public boolean requestPasswordResetCodeCheck() {
		String Url = driver.getCurrentUrl();
		if (Url.contains("requestPasswordResetCode")) {
			return true;
		} else {

			return false;
		}

	}

	public boolean VerifyUserNameField() {
		return waitMethod(usernameField).isDisplayed();
	}

	public void ClickCancelBtn() {
		waitMethod(CancelBtn).click();

	}

}
