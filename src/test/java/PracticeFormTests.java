import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void resolutionAndUrl() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Veber");
        $("#userEmail").setValue("aleo83@rambler.ru");
          $(".col-md-9 col-sm-12").$(byText("Male")).click();
        //$("input[type='radio'][name='gender']").selectRadio("gender-radio-1");
        $("#userNumber").setValue("7770658833");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__month").$(byText("16")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("121211.png");
        $("#currentAddress").setValue("Baikonur, Street Shybnikova, d.3");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        //проверить поля на заполнение и соответствие
        $(".table-responsive").shouldHave(text("Alexander Veber"),
                                                    (text("aleo83@rambler.ru")),
                                                    (text("Male")),
                                                    (text("7770658833")),
                                                    (text("16 September,1993")),
                                                    (text("English")),
                                                    (text("Music")),
                                                    (text("121211.png")),
                                                    (text("Baikonur, Street Shybnikova, d.3")),
                                                    (text("Haryana Panipat")));
    }
}
