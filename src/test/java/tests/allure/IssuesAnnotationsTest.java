package tests.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssuesAnnotationsTest extends BaseTest {
    private static final String REPOSITORY = "VeberAL/QA.guruCourse";
    private static final int ISSUE = 3;

    @Test
    @DisplayName("Проверка созданного Issue #" + ISSUE + " в проекте " + REPOSITORY)
    @Feature("Issue в репозитории.")
    @Story("Проверка Issue.")
    @Owner("Вебер А.Л.")
    public void githubIssuesAnnotatedStepTest() {
        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
