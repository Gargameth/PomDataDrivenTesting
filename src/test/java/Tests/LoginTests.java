package Tests;

import Pages.LoginPage;
import Pages.UserProfilePage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {
    private static WebDriver driver;
    private WebDriverWait wait;
    private static Dotenv dotenv;
    private LoginPage loginPage;
    private UserProfilePage profilePage;

    @BeforeAll
    static void setupEnv() {
        dotenv = Dotenv.configure().filename("externalSource.env").load();
        //driver = WebDriverHelper.getInstance();
    }

    @BeforeEach
    public void setupClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait, dotenv);
        profilePage = new UserProfilePage(driver, wait, dotenv);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, profilePage);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
        //profilePage.NavigateToProfilePage();
        //profilePage.Logout();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/loginData.csv", numLinesToSkip = 1)
    void LoginTest(String username, String password) {
        loginPage.Login(username, password);
        loginPage.NavigateToCheckSuccessfulLogin(profilePage);
        Assertions.assertEquals(dotenv.get("username"), profilePage.username.getText());
    }

    @Test
    public void LoginWithValidPasswordTest() {
        loginPage.Login(dotenv.get("username"), dotenv.get("password"));
        loginPage.NavigateToCheckSuccessfulLogin(profilePage);
        Assertions.assertEquals(dotenv.get("username"), profilePage.username.getText());
    }

    @Test
    public void LoginWithInvalidPasswordTest() {
        loginPage.Login(dotenv.get("username"), "Makumakakers");
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assertions.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }

    @Test
    public void LoginWithNoCredentialsTest() {
        loginPage.Login("", "");
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assertions.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }

    @Test
    public void LogoutTest() {
        loginPage.Login(dotenv.get("username"), dotenv.get("password"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        profilePage.Logout();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login.jsp']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='/login.jsp']")).isDisplayed());
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