package Tests;

import Pages.IssuePage;
import Pages.ProjectPage;
import Pages.Utils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.List;

public class BrowseIssueTests extends TestBase {

    @BeforeEach
    void setupClass() throws IOException {
        List<String> credentials = Utils.ReadUsernameAndPasswordFromCSV();
        loginPage.Login(credentials.get(0), credentials.get(1));
    }

    @AfterEach
    void cleanUp() {
        profilePage.Logout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Issues.csv", numLinesToSkip = 1)
    void BrowseProjectsTest(@NotNull String issue, String url) {
        IssuePage actualIssue = new IssuePage(url);
        actualIssue.Navigate();
        Assertions.assertTrue(issue.contains(actualIssue.GetSummary()));
    }
}
