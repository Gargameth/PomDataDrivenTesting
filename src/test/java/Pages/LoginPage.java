package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(String url) {
        super(url);
    }

    @FindBy(id = "login-form-username")
    public WebElement usernameField;
    @FindBy(id = "login-form-password")
    public WebElement passwordField;
    @FindBy(id = "login-form-submit")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='aui-message aui-message-error']")
    public WebElement loginErrorMessage;
    @FindBy(xpath = "//a[@class='aui-nav-link login-link']")
    public WebElement logoutNotificationMessage;

    public void Login(String username, String password) {
        Navigate();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
