package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DashboardPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public DashboardPage(String url) {
        super(url);
    }
    @FindBy(id = "create_link")
    WebElement createIssueButton;

    public String CreateIssue(String project, String issueType, String summary) {
        createIssueButton.click();
        WebElement createIssueProjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-field")));
            createIssueProjectField.click();
            createIssueProjectField.sendKeys(project);
            createIssueProjectField.sendKeys(Keys.TAB);
        WebElement issueTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field")));
            issueTypeField.click();
            issueTypeField.sendKeys(issueType);
            issueTypeField.sendKeys(Keys.TAB);
        WebElement issueSummaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
            issueSummaryField.sendKeys(summary);
        WebElement createIssueSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-issue-submit")));
            createIssueSubmitButton.click();
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/a"))).getAttribute("href"); //ToDo
    }
}
