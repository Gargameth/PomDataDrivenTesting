package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.cdimascio.dotenv.Dotenv;


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

    public void CheckForLoginError(WebDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }

    /*public void LoginWithValidCredentialsTest(WebDriverWait wait) {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        username = dotenv.get("Real_Username");
        password = dotenv.get("Password");
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
    }

    public void LoginWithInvalidPasswordTest(WebDriverWait wait){
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        username = dotenv.get("Real_Username");
        password = "makumakakers";
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assert.assertNotNull(errorMessage);
    }

    public void LoginWithNoUsernameAndPasswordTest(WebDriverWait wait){
        driver.get("https://jira-auto.codecool.metastage.net/");
        username = "";
        password = "";
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assert.assertNotNull(errorMessage);
    }*/
}