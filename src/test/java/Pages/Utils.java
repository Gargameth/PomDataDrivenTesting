package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static RemoteWebDriver driver = null;

    private Utils(){}

    public static WebDriver GetDriver() throws MalformedURLException {
        if (driver == null) {
            String nodeURL = "http://172.21.0.6:5555";
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
        }
        return driver;
    }


    public static void QuitDriver() {
        driver.quit();
        driver = null;
    }

    public static List<String> ReadUsernameAndPasswordFromCSV() throws IOException {
        String s = Files.readAllLines(Paths.get("src/test/resources/ValidLoginData.csv")).get(2);
        return new ArrayList<>(Arrays.asList(s.split(",")));
    }
}
