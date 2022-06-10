package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
    private static final WebDriver driver = new ChromeDriver();

    private WebDriverHelper() {}

    public static WebDriver getInstance() {
        return driver;
    }
}
