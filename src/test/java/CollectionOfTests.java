import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollectionOfTests {
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    /*@Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        //WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void LoginWithValidCredentials() {
        LoginPage loginPageTests = new LoginPage(driver);
        Pages.UserProfilePage profilePage = new Pages.UserProfilePage(driver);
        loginPageTests.LoginWithValidCredentialsTest(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        profilePage.UserIsLoggedInAssertion(loginPageTests.username);
    }

    @Test
    public void LoginWithInvalidPassword(){
        LoginPage loginPageTests = new LoginPage(driver);
        loginPageTests.LoginWithInvalidPasswordTest(wait);
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
    };*/
}
