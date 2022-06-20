package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogoutTests extends TestBase {

    @ParameterizedTest
    @CsvFileSource(resources = "/ValidLoginData.csv", numLinesToSkip = 1)
    void LogoutTest(String username, String password) {
        loginPage.Login(username, password);
        profilePage.Logout();
        loginPage.Navigate();
        Assertions.assertTrue(loginPage.logoutNotificationMessage.isDisplayed());
    }
}
