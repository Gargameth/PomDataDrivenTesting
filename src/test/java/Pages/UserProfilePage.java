package Pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage extends BasePage {

    @FindBy(id = "up-d-username")
    public WebElement username;

    @FindBy(id = "log_out")
    WebElement logoutButton;

    @FindBy(xpath = "//span[@class='aui-avatar aui-avatar-small']")
    WebElement avatar;

    public UserProfilePage(WebDriver driver, WebDriverWait wait, Dotenv dotenv) {
        super(driver, wait, dotenv);
    }

    public void NavigateToProfilePage(){
        driver.get(dotenv.get("userProfileUrl"));
    }

    public void Logout() {
        avatar.click();
        logoutButton.click();
    }
}