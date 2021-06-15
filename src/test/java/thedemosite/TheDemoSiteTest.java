package thedemosite;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pageobjectmodel.demosite.DemoSitePortal;

public class TheDemoSiteTest {
	private static WebDriver driver;
	private static WebElement targ;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

	@Test
	public void testLogin() {
		// GIVEN - That I can access the demo site - RESOURCES
		DemoSitePortal theDemoSite = PageFactory.initElements(driver, DemoSitePortal.class);
		driver.get(DemoSitePortal.URL);
		// WHEN - I navigate to the add user page - ACTION
		theDemoSite.navAddUser();
		// AND - I enter and submit my user credentials
		theDemoSite.createUserPage.createUser("root", "root");
		// AND - I navigate to the login page
		theDemoSite.navLogin();
		// AND - I enter and submit my credentials
		theDemoSite.loginPage.login("root", "root");
		// THEN - I should have successfully logged in - ASSERTION
		String result = theDemoSite.loginPage.getStatus();
		assertEquals("**Successful Login**", result);

	}

	// RESOURCES

	// RULES
	// Mockito.when()
	// ACTIONS
	// String result = ""; //doThis()
	// ASSERTIONS
	// assertEquals("Expected", result);
	// Mockito.verify();

	@Test
	@Ignore
	public void testLoginAlt() {
		// GIVEN - That I can access the demo site - RESOURCES
		//driver.get(URL);
		// WHEN - I navigate to the add user page - ACTION
		targ = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		targ.click();
		// AND - I enter my user credentials
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("jbname");

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("pass");

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		targ.click();
		// AND - I navigate to the login page
		targ = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a"));
		targ.click();
		// AND - I enter my credentials
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("jbname");

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("pass");
		// AND - I submit my credentials
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		targ.click();
		// THEN - I should have successfully logged in - ASSERTION
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", targ.getText());
	}

	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
//		 cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}
}
