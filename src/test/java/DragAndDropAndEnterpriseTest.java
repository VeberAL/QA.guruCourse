import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropAndEnterpriseTest {

    @BeforeAll
    static void resolutionAndUrl() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    //Первая часть дз
    void enterpriseTest(){
        open("https://github.com");
        $("[aria-label=Global]").$(withText("Solutions")).hover();
        $("div div.border-bottom a").click();
        $(".application-main ").shouldHave(text("To build, scale, and deliver secure software"));
        System.out.println("Успешный переход на страницу Enterprise.");
    }

    @Test
    //Вторая часть дз
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Кликаем и удерживаем -> переносим -> отпускаем
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();;
        $("#column-a").shouldBe(text("B"));
        System.out.println("Элементы успешно поменялись.");

        //DragAndDrop из коробки
        //$("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

    }

}
