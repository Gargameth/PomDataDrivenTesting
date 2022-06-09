package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By usernameField = By.xpath("//input[@id='login-form-username']");
    By passwordField = By.xpath("//input[@id='login-form-password']");
    By loginBtn = By.xpath("//input[@name='login']");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void Login(String username, String password) {
        driver.get("https://jira-auto.codecool.metastage.net/");
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}