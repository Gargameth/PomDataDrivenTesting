package CreateIssue;

import Login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class CreateIssueTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private static Dotenv dotenv;
    private LoginPage loginPage;


    @BeforeAll
    static void setupEnv() {
        dotenv = Dotenv.configure().filename("externalSource.env").load();
        System.setProperty("webdriver.chrome.driver", dotenv.get("LocationOfChromedriver"));
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setupClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    /*@Test
    public void GeneralTest() {
        loginPage.Login(dotenv.get("username"), dotenv.get("password"));
    }*/

    @Test
    public void CreateIssueTest() {
        loginPage.Login(dotenv.get("username"), dotenv.get("password"));

        try (BufferedReader br = new BufferedReader(new FileReader("CreateIssueData.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[0]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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