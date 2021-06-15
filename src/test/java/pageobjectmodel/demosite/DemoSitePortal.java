package pageobjectmodel.demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobjectmodel.demosite.pages.DSAddUserPage;
import pageobjectmodel.demosite.pages.DSLoginPage;

public class DemoSitePortal {
	
	public static final String URL = "https://thedemosite.co.uk/";

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserLnk;

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginLnk;

	public final DSAddUserPage createUserPage;
	public final DSLoginPage loginPage;
	
	public DemoSitePortal(WebDriver driver) {
		createUserPage = PageFactory.initElements(driver, DSAddUserPage.class);
		loginPage = PageFactory.initElements(driver, DSLoginPage.class);
	}

	public void navAddUser() {
		this.addUserLnk.click();
	}

	public void navLogin() {
		this.loginLnk.click();
	}
	
	

}
