import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void LoginTests() {
        LoginPageTests loginPageTests = new LoginPageTests(driver);
        loginPageTests.LoginWithValidCredentialsTest(wait);
    }
}
