package pageobjectmodel;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLandingPage {

    public final static String URL = "https://www.saucedemo.com/";

    private WebDriver driver;

    // 1
    public SauceDemoLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //2
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    //3
    @FindBy(id = "password")
    private WebElement passwordInput;

    //4
    @FindBy(className = "btn_action")
    private WebElement loginButton;

    //5
    @FindBys ({
        @FindBy(className = "login-box"),
        @FindBy(tagName = "form"),
        @FindBy(css = "*")
    })
    private List<WebElement> loginFormElements;

    //6
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    //7
    public boolean isError() {
        for(WebElement element : loginFormElements) {
            if(element.getAttribute("data-test") != null && element.getAttribute("data-test").equals("error")){
                return true;
            }
        }
        return false;
    }
}