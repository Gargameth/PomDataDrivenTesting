package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogoutTests extends TestBase {

    @Test
    void LogoutTest() {
        String username = System.getenv("ValidUsername");
        String password = System.getenv("ValidPassword");
        loginPage.Login(username, password);
        profilePage.Logout();
        loginPage.Navigate();
        Assertions.assertTrue(loginPage.logoutNotificationMessage.isDisplayed());
    }
}
