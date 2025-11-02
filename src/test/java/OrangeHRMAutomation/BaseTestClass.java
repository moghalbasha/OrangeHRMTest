package OrangeHRMAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTestClass {

	public WebDriver driver;
	public Properties prop;
	public LoginPage lg;
	public Dashboard_Src ds;
	public ForgotPasswordPage fp;

	@BeforeMethod
	public void setupMethod() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String FilePath = System.getProperty("user.dir") + File.separator + "target" + File.separator
				+ "data.properties";
		FileInputStream fileio = new FileInputStream(FilePath);
		prop = new Properties();
		prop.load(fileio);
		ds = new Dashboard_Src(driver);
		lg = new LoginPage(driver);
		fp = new ForgotPasswordPage(driver);

	}

	@AfterMethod()
	public void TakeScreenshotandTearDown(ITestResult result) {
		if (result.getStatus() == 2) {
			
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				String TimeStamp = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
				String FileName = result.getName() + TimeStamp+".png";
				String FolderLocation = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "Screenshot"+File.separator+FileName;
				FileUtils.copyFile(srcFile, new File(FolderLocation));	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		driver.quit();
		
	}

}
