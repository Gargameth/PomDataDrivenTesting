import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollectionOfTests {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void LoginWithValidCredentials() {
        Dotenv dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        String username = dotenv.get("Real_Username");
        String password = dotenv.get("Password");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login-form-username']"))).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login-form-password']"))).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
        Assert.assertEquals(driver.findElement(By.xpath("//dd[@id='up-d-username']")).getText(), username);
    }

    @Test
    public void LoginWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginWithInvalidPasswordTest(wait);
        LoginWithValidCredentials();
    }

    @Test
    public void LoginWithNoCredentials(){
        LoginPage loginPageTests = new LoginPage(driver);
        loginPageTests.LoginWithNoUsernameAndPasswordTest(wait);
        LoginWithValidCredentials();
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
