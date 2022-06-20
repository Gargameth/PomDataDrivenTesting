package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTests extends TestBase {

    @ParameterizedTest
    @CsvFileSource(resources = "/ValidLoginData.csv", numLinesToSkip = 1)
    void LoginWithValidCredentialsTest(String username, String password) {
        loginPage.Login(username, password);
        profilePage.Navigate();
        Assertions.assertEquals(username, profilePage.GetUsername());
        profilePage.Logout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidLoginData.csv", numLinesToSkip = 1)
    void LoginWithInvalidCredentialsTest(String username, String password) {
        loginPage.Login(username, password);
        Assertions.assertTrue(loginPage.loginErrorMessage.isDisplayed());
    }
}
