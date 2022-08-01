package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {
    private static RemoteWebDriver driver = null;

    private Utils(){}

    public static WebDriver GetDriver() throws MalformedURLException {
        if (driver == null) {
            String nodeURL = "https://selenium:" + System.getenv("ValidPassword") + "@seleniumhub.codecool.metastage.net/wd/hub";
            System.out.println(nodeURL);
            ChromeOptions chromeOptions = new ChromeOptions();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if ("firefox".equals(System.getenv("browserName"))) {
                driver = new RemoteWebDriver(new URL(nodeURL), firefoxOptions);
            } else {
                driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
            }
        }
        return driver;
    }

    public static void QuitDriver() {
        driver.quit();
        driver = null;
    }
}
