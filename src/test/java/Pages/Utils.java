package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static WebDriver driver = null;

    private Utils(){}

    public static WebDriver GetDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
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
