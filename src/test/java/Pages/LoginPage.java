package Pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "login-form-username")
    WebElement usernameField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait, Dotenv dotenv) {
        super(driver, wait, dotenv);
    }

    public void Login(String username, String password) {
        driver.get(dotenv.get("baseUrl"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public void NavigateToCheckSuccessfulLogin(UserProfilePage profilePage) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        profilePage.NavigateToProfilePage();
    }
}