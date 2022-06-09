package Logout;

import Login.LoginPage;
import Login.LoginPageTests;
import UserProfilePage.UserProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private static Dotenv dotenv = null;


    @BeforeAll
    static void setEnvFile(){
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
    }
    @BeforeEach
    public void setupClass() {
        System.setProperty("webdriver.chrome.driver", dotenv.get("LocationOfChromedriver"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        //driver.quit();
    }

    @Test
    public void Logout(){
        UserProfilePage profilePage = new UserProfilePage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait, dotenv.get("Real_Username"));
        loginPage.EnterPassword(wait,dotenv.get("Password"));
        loginPage.ClickOnLogInButton(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        profilePage.Logout(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login.jsp']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='/login.jsp']")).isDisplayed());
    }
}
