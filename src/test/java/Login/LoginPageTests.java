package Login;

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

public class LoginPageTests {
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
    public void LoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        UserProfilePage userProfilePage = new UserProfilePage();
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait,dotenv.get("Real_Username"));
        loginPage.EnterPassword(wait,dotenv.get("Password"));
        loginPage.ClickOnLogInButton(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        userProfilePage.NavigateToProfilePage(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(userProfilePage.username));
        Assertions.assertEquals(dotenv.get("Real_Username"), driver.findElement(userProfilePage.username).getText());
    }

    @Test
    public void LoginWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait,dotenv.get("Real_Username"));
        loginPage.EnterPassword(wait,"Makumakakers");
        loginPage.ClickOnLogInButton(wait);
        loginPage.LoginError(driver, wait);
        Assertions.assertTrue(driver.findElement(loginPage.errorMessage).isDisplayed());
    }

    @Test
    public void LoginWithNoCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToPage();
        loginPage.EnterUsername(wait,"");
        loginPage.EnterPassword(wait,"");
        loginPage.ClickOnLogInButton(wait);
        loginPage.LoginError(driver, wait);
        Assertions.assertTrue(driver.findElement(loginPage.errorMessage).isDisplayed());
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