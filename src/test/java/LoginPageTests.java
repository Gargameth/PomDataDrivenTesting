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


public class LoginPageTests {
    WebDriver driver;
    By usernameField = By.id("login-form-username");
    By passwordField = By.id("login-form-password");
    By loginBtn = By.name("login");

    public LoginPageTests(WebDriver driver){
        this.driver = driver;
    }

    public void LoginWithValidCredentialsTest(WebDriverWait wait) {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        String username = dotenv.get("Real_Username");
        String password = dotenv.get("Password");
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
    }
}