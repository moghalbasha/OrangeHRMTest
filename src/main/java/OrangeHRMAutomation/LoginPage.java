package OrangeHRMAutomation;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClassforSRC{
	//public WebDriver driver;
	public Actions ac;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.ac=new Actions(driver);
		
		
	}
	@FindBy(xpath="//input[@name='username']") WebElement userId;
	@FindBy(name="password") WebElement userPassword;
	@FindBy(className="orangehrm-login-button") WebElement submitBtn;
	@FindBy(css="h5.orangehrm-login-title") WebElement lognText;
	@FindBy(xpath="//p[contains(@class, 'orangehrm-login-forgot-header')]") WebElement forgotPass;
	@FindBy(xpath="//div[@class='orangehrm-login-error']//p") WebElement invalidCredentialsText;
	@FindBy(css="span.oxd-input-group__message") List<WebElement> RequiredField;
	public void loginUser(String UserId,String password) {
		waitMethod(userId).sendKeys(UserId);
		waitMethod(userPassword).sendKeys(password);
		waitMethod(submitBtn).click();
		
	}
	public boolean isuserNameExists() {
		return waitMethod(userId).isDisplayed();
	}
	public boolean isuserPassExists() {
		return waitMethod(userPassword).isDisplayed();
	}
	public boolean isSubmitBtnExists() {
		return waitMethod(submitBtn).isDisplayed();
	}
	public boolean isLoginTextExists() {
		return waitMethod(lognText).isDisplayed();
	}
	public boolean isforgotPassExists() {
	//	ac.scrollToElement(forgotPass).perform();
		return waitMethod(forgotPass).isDisplayed();
	}
	public boolean isinvalidCreadentialsDispalyed() {
		return waitMethod(invalidCredentialsText).isDisplayed();
		}
	public boolean isRequiredTextisDispalyedFirst() {
		WebElement firstElemet=RequiredField.get(0);
		return waitMethod(firstElemet).isDisplayed();
			
		}
	public boolean isRequiredTextisDispalyedSecond() {
		WebElement secondElemet=RequiredField.get(1);
		return waitMethod(secondElemet).isDisplayed();
			
		}
	public void forgotPassTest() {
		waitMethod(forgotPass).click();
		//ac.scrollToElement(waitMethod(forgotPass)).click().perform();
		
		
	}
}
