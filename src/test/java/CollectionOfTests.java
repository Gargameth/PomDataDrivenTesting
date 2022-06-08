import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollectionOfTests {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void LoginWithValidCredentials() {
        LoginPage loginPageTests = new LoginPage(driver);
        UserProfilePage profilePage = new UserProfilePage(driver);
        loginPageTests.LoginWithValidCredentialsTest(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        profilePage.UserIsLoggedInAssertion(loginPageTests.username);
    }
}
