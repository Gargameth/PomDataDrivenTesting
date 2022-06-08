import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {

    WebDriver driver;

    By username = By.xpath("//dd[@id='up-d-username']");

    public UserProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public void UserIsLoggedInAssertion(String userTryingToEnter){
        driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
        Assert.assertEquals(driver.findElement(username).getText(), userTryingToEnter);
    }
}
