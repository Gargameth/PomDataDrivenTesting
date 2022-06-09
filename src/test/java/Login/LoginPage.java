package Login;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    By usernameField = By.xpath("//input[@id='login-form-username']");
    By passwordField = By.xpath("//input[@id='login-form-password']");
    By loginBtn = By.xpath("//input[@name='login']");
    By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void NavigateToPage(){
        driver.get("https://jira-auto.codecool.metastage.net/");
    }
    public void EnterUsername(WebDriverWait wait, String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
    }

    public void EnterPassword(WebDriverWait wait, String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
    }

    public void ClickOnLogInButton(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
    }

    public void LoginError(WebDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
    }
}