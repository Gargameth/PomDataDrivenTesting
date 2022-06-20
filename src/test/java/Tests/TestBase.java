package Tests;

import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.Utils;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {

    static public LoginPage loginPage;
    static public ProfilePage profilePage;

    @BeforeAll
    static void setupBase() {
        loginPage = new LoginPage(Dotenv.configure().filename("URLs.env").load().get("login_url"));
        profilePage = new ProfilePage(Dotenv.configure().filename("URLs.env").load().get("profile_url"));
    }

    @AfterAll
    static void CleanupAfterAll() {
        Utils.QuitDriver();
    }
}
