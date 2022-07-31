package Tests;

import Pages.ProjectPage;
import Pages.Utils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class BrowseProjectTests extends TestBase {

    @BeforeEach
    void setupClass() {
        loginPage.Login(System.getenv("ValidUsername"), System.getenv("ValidPassword"));
    }

    @AfterEach
    void cleanUp() {
        profilePage.Logout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Projects.csv", numLinesToSkip = 1)
    void BrowseProjectsTest(@NotNull String project, String url) throws MalformedURLException {
        ProjectPage actualProject = new ProjectPage(url);
        actualProject.Navigate();
        Assertions.assertTrue(project.contains(actualProject.GetProjectName()));
    }
}
