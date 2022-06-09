package UserProfilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    public By username = By.xpath("//dd[@id='up-d-username']");
    public String path = "https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa";
    private final By logoutButton = By.xpath("//a[@id='log_out']");

    public void NavigateToProfilePage(WebDriver driver){
        driver.get(path);
    }

    public void Logout(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton)).click();
        }
}