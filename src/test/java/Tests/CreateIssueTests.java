package Tests;

import Pages.DashboardPage;
import Pages.IssuePage;
import Pages.Utils;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class CreateIssueTests extends TestBase {
    String newIssueUrl;
    IssuePage actualIssue;

    @BeforeEach
    void setupClass() throws IOException {
        List<String> credentials = Utils.ReadUsernameAndPasswordFromCSV();
        loginPage.Login(credentials.get(0), credentials.get(1));
    }

    @AfterEach
    void cleanUp() {
        actualIssue.Delete();
        profilePage.Logout();
    }

    @Test
    void CreateIssueTest() {
        DashboardPage dashboard = new DashboardPage(System.getenv("DASHBOARD_URL"));
        dashboard.Navigate();
        String summary = new Timestamp(System.currentTimeMillis()).toString();
        newIssueUrl = dashboard.CreateIssue("MTP", "Bug", summary);
        actualIssue = new IssuePage(newIssueUrl);
        actualIssue.Navigate();
        Assertions.assertEquals(summary, actualIssue.GetSummary());
    }
}
