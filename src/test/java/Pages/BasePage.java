package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public abstract class BasePage {
    public WebDriver driver;
    public String siteUrl;

    public BasePage(String url) throws MalformedURLException {
        this.driver = Utils.GetDriver();
        this.siteUrl = url;
        PageFactory.initElements(driver, this); //ToDo Ajax
    }

    public void Navigate() {
        driver.get(siteUrl);
    }
}
