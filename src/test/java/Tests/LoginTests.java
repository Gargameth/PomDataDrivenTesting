package Tests;

import Pages.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class LoginTests extends TestBase {

    @Test
    void LoginWithValidCredentialsTest() {
        String username = System.getenv("ValidUsername");
        String password = System.getenv("ValidPassword");
        loginPage.Login(username, password);
        profilePage.Navigate();
        Assertions.assertEquals(username, profilePage.GetUsername());
        profilePage.Logout();
    }

    @Test
    void LoginWithInvalidCredentialsTest() {
        loginPage.Login("username", "password");
        Assertions.assertTrue(loginPage.GetLoginErrorMessage());
        loginPage.Login(System.getenv("ValidUsername"), System.getenv("ValidPassword"));
        profilePage.Navigate();
        profilePage.Logout();
    }
}
