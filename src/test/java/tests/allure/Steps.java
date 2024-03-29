package tests.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {
    @Step("Открыть главную страницу сайта Github.")
    public void openMainPage() {
        open("https://www.github.com");
    }

    @Step("Искать репозиторий {repo} в поисковой строке сайта.")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).submit();
    }

    @Step("Кликнуть по ссылке репозитория {repo}.")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открыть вкладку 'Issues'.")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issues с номером #{issue}.")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
