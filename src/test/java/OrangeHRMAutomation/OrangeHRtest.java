package OrangeHRMAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRtest extends BaseTestClass {

	@Test(priority = 1)
	public void TestLogin() {

		Assert.assertTrue(lg.isuserPassExists());
		Assert.assertTrue(lg.isuserNameExists());
		Assert.assertTrue(lg.isSubmitBtnExists());
		Assert.assertTrue(lg.isLoginTextExists());
		Assert.assertTrue(lg.isforgotPassExists());
	}

	@Test(priority = 2)
	public void viewDashboard() {
		lg.loginUser(prop.getProperty("userID"), prop.getProperty("userPassword"));

		if (ds.isDasboardDispaly().equalsIgnoreCase("dashboard")) {
			Assert.assertTrue(true);

		}
	}

	@Test(priority = 3)
	public void invalidLoginIncorrectID() {

		lg.loginUser(prop.getProperty("incorrectUserId"), prop.getProperty("userPassword"));
		Assert.assertTrue(lg.isinvalidCreadentialsDispalyed());

	}

	@Test(priority = 4)
	public void invalidLoginIncorrectPass() {
		lg.loginUser(prop.getProperty("userID"), prop.getProperty("incorrectPasswordId"));

		Assert.assertTrue(lg.isinvalidCreadentialsDispalyed());

	}

	@Test(priority = 5)
	public void emptyUseridPassword() {
		lg.loginUser(prop.getProperty("emptyUserid"), prop.getProperty("emptyPass"));
		Assert.assertTrue(lg.isRequiredTextisDispalyedFirst() && lg.isRequiredTextisDispalyedSecond());

	}

	@Test(priority = 6)
	public void ResetPassword() {
		lg.forgotPassTest();

		Assert.assertTrue(fp.resetPassword());

	}

	@Test(priority = 7)
	public void CheckFrgotUrl() {
		lg.forgotPassTest();     
		Assert.assertTrue(fp.requestPasswordResetCodeCheck());

	}

	@Test(priority = 8)
	public void clickCancelBtn() {
		lg.forgotPassTest();
		fp.ClickCancelBtn();
		Assert.assertTrue(lg.isLoginTextExists());

	}

}
