package Pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    Dotenv dotenv;
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait, Dotenv dotenv){
        this.driver = driver;
        this.wait = wait;
        this.dotenv = dotenv;
    }
}