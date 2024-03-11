package tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssuesLambdaTest extends BaseTest {
    private static final String REPOSITORY = "VeberAL/QA.guruCourse";
    private static final int ISSUE = 3;

    @Test
    public void githubIssuesStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу сайта Github", () -> open("https://www.github.com"));
        step("Искать репозиторий " + REPOSITORY + " в поисковой строке сайта.", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });
        step("Кликнуть по ссылке репозитория" + REPOSITORY + ".", () -> $(linkText(REPOSITORY)).click());
        step("Открыть вкладку 'Issues'", () -> $("#issues-tab").click());
        step("Проверить наличие Issues с номером #" + ISSUE + ".", () -> $(withText("#" + ISSUE)).should(Condition.exist));
    }
}
