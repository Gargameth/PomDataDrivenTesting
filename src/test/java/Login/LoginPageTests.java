package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTests {
    private WebDriver driver;

    @BeforeEach
    public void setupClass() {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        System.setProperty("webdriver.chrome.driver", dotenv.get("LocationOfChromedriver"));
        WebDriverManager.chromedriver().setup();
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void LoginWithValidCredentials(){
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait,dotenv.get("Real_Username"));
        loginPage.EnterPassword(wait,dotenv.get("Password"));
        loginPage.ClickOnLogInButton(wait);
    }

    @Test
    public void LoginWithInvalidPassword(){
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait,dotenv.get("Real_Username"));
        loginPage.EnterPassword(wait,"Makumakakers");
        loginPage.ClickOnLogInButton(wait);
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
        }
    };
}