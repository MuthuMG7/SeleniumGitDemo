package Framework_Scratch.Frameworks_E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.ForgotPasswordPage;
import com.pageobjects.LandingPage;
import com.pageobjects.LogInPage;
import com.resources.Base;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws Exception {
		driver = intializeDriver();

		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password, String text) throws Exception {

		driver.get(property.getProperty("url"));
		log.info("Navigated to HomePage");
		LandingPage landingPage = new LandingPage(driver);
		LogInPage loginPage = landingPage.getLogIn();
		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogIn().click();
		log.info(text);
        ForgotPasswordPage forgotPassword = loginPage.getForgotPassword();
        forgotPassword.getUserEmail().sendKeys("Muthupattu7@gmail.com");
        forgotPassword.getInstruction().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Muthupattu7@gamil.com";
		data[0][1] = "Muthugmail";
		data[0][2] = "Gmail";
		// Columns in the row are nothing but values for that particular
		// combination(row)

		// 2ND Set
		data[1][0] = "MuthuPattu7@yahoo.com";
		data[1][1] = "Muthuyahoo";
		data[1][2] = "Yahoo";
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
