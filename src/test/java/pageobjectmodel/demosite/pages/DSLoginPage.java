package pageobjectmodel.demosite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DSLoginPage {
	
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "FormsButton2")
	private WebElement submitCredentials;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status;

	public DSLoginPage() {
	}
	
	public void login(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitCredentials.click();
	}
	
	public String getStatus() {
		return this.status.getText();
	}

}
