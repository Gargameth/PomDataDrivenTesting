package Tests;

import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.Utils;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

public abstract class TestBase {

    static public LoginPage loginPage;
    static public ProfilePage profilePage;
    public static Dotenv dotenv;

    @BeforeAll
    static void setupBase() throws MalformedURLException {
        dotenv = Dotenv.configure().filename("URLs.env").load();
        loginPage = new LoginPage(dotenv.get("login_url"));
        profilePage = new ProfilePage(dotenv.get("profile_url"));
    }

    @AfterAll
    static void CleanupAfterAll() {
        Utils.QuitDriver();
    }
}
