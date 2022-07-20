package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class ProfilePage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public ProfilePage(String url) throws MalformedURLException {
        super(url);
    }

    @FindBy(id = "user-options")
    WebElement userOptions;
    @FindBy(id = "up-d-username")
    WebElement usernameSign;

    public void Logout() {
        userOptions.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("log_out"))).click();
    }

    public String GetUsername() {
        return usernameSign.getText();
    }
}
