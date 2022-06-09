package CreateIssue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement CreateIssue(String projectName, String issueType, String summaryText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create_link"))).click();

        WebElement projectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-field")));
        projectField.click();
        projectField.sendKeys(projectName);
        projectField.sendKeys(Keys.ENTER);

        WebElement issueField = wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field")));
        issueField.click();
        issueField.sendKeys(issueType);
        issueField.sendKeys(Keys.ENTER);

        WebElement summaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
        summaryField.click();
        summaryField.sendKeys(summaryText);
        summaryField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("create-issue-submit"))).click();

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='issue-created-key issue-link']")));
    }
}
