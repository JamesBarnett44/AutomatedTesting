package shoppingwebsite;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShoppingWebsiteTest {
	private static WebDriver driver;
	private static WebElement targ;
	private static String URL = "https://automationpractice.com/index.php";

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
	public void testSearch() {
		// home page
		driver.get(URL);
		targ = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));			
		targ.click();
	
		
		targ = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		assertEquals("Printed Dress", targ.getText());
	}

	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
//	public static ChromeOptions chromeCfg() {
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		ChromeOptions cOptions = new ChromeOptions();
//
//		// Settings
//		prefs.put("profile.default_content_setting_values.cookies", 2);
//		prefs.put("network.cookie.cookieBehavior", 2);
//		prefs.put("profile.block_third_party_cookies", true);
//
//		// Create ChromeOptions to disable Cookies pop-up
////		 cOptions.setExperimentalOption("prefs", prefs);
//
//		return cOptions;
//	}
 }
