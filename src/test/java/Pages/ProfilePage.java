package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    public ProfilePage(String url) {
        super(url);
    }

    @FindBy(id = "user-options")
    WebElement userOptions;
    @FindBy(id = "log_out")
    WebElement logoutButton;
    @FindBy(id = "up-d-username")
    WebElement usernameSign;

    public void Logout() {
        userOptions.click();
        logoutButton.click();
    }

    public String GetUsername() {
        return usernameSign.getText();
    }
}
