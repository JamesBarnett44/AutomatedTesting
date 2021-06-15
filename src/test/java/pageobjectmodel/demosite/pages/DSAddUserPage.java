package pageobjectmodel.demosite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DSAddUserPage {
	
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "FormsButton2")
	private WebElement submitCredentials;

	public DSAddUserPage() {
		super();
	}
	
	public void createUser(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitCredentials.click();
	}

}
