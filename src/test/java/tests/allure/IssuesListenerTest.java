package tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssuesListenerTest extends BaseTest {
    @Test
    public void githubIssuesListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://www.github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("VeberAL/QA.guruCourse").submit();
        $(linkText("VeberAL/QA.guruCourse")).click();
        $("#issues-tab").click();
        $(withText("#3")).should(Condition.exist);
    }
}
