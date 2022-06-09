package UserProfilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    public By username = By.xpath("//dd[@id='up-d-username']");

    public void NavigateToProfilePage(WebDriver driver, WebDriverWait wait){
        String webPage = "https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='aui-avatar aui-avatar-small']")));
        driver.get(webPage);
    }
}