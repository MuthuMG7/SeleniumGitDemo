package Framework_Scratch.Frameworks_E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.LandingPage;
import com.resources.Base;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws Exception {
		driver = intializeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void validateAppNavBar() {

		LandingPage landingPage = new LandingPage(driver);

		Assert.assertTrue(landingPage.getNavBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
