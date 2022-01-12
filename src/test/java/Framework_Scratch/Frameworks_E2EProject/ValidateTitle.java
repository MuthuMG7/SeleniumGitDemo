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

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	LandingPage landingPage;

	@BeforeTest
	public void initialize() throws Exception {
		driver = intializeDriver();
		log.info("Driver is Intialized");
		driver.get(property.getProperty("url"));
		log.info("Navigated to HomePage");
		driver.manage().window().maximize();
	}

	@Test
	public void validateAppTitle() {
		landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfullu Validated Text Message");

	}

	@Test
	public void validateHeader() {
		// landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	//	log.info("Successfullu Validated Text Message");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
