import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    String username;
    String password;
    By usernameField = By.xpath("//input[@id='login-form-username']");
    By passwordField = By.xpath("//input[@id='login-form-password']");
    By loginBtn = By.xpath("//input[@name='login']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void EnterPassword(String psw, By field) {

    }

    public void LoginWithValidCredentialsTest(WebDriverWait wait) {
        Dotenv dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        String username = dotenv.get("Real_Username");
        String password = dotenv.get("Password");
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
    }

    public void LoginWithInvalidPasswordTest(WebDriverWait wait){
        Dotenv dotenv;
        dotenv = Dotenv.configure().filename("streetCreds.env").load();
        driver.get("https://jira-auto.codecool.metastage.net/");
        username = dotenv.get("Real_Username");
        password = "makumakakers";
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assert.assertNotNull(errorMessage);
    }

    public void LoginWithNoUsernameAndPasswordTest(WebDriverWait wait){
        driver.get("https://jira-auto.codecool.metastage.net/");
        username = "";
        password = "";
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
        By errorMessage = By.xpath("//div[@class='aui-message aui-message-error']");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Assert.assertNotNull(errorMessage);
    }
}