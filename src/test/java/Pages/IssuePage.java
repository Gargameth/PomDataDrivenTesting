package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuePage extends BasePage{

    public IssuePage(String url) {
        super(url);
    }


    @FindBy(id = "summary-val")
    public WebElement issueSummary;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/main/div/div[2]/div/header/div/div[2]/div/aui-dropdown-menu[1]/aui-section[6]/div/aui-item-link/a")
    public static WebElement deleteIssueButton;

    public String GetSummary() {
        return issueSummary.getText();
    }
    public void Delete() {
        driver.get(deleteIssueButton.getAttribute("href"));
    }
}
