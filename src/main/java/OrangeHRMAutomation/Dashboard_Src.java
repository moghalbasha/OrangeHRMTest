package OrangeHRMAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Src extends BaseClassforSRC {

	public Dashboard_Src(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="h6.oxd-topbar-header-breadcrumb-module")
	WebElement Dashboard;
	@FindBy(css="i.bi-chevron-left") WebElement SidemenuActive;
	public String isDasboardDispaly() {
		return waitMethod(Dashboard).getText();
	}
	
}
