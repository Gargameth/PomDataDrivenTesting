package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class ProjectPage extends BasePage{

    public ProjectPage(String url) throws MalformedURLException {
        super(url);
    }

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div[1]/div/div/div[2]/h1/div/div/a")
    public WebElement projectName;

    public String GetProjectName() {
        return projectName.getText();
    }
}
