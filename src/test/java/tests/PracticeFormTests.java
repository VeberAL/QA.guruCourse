package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void fullFillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Veber");
        $("#userEmail").setValue("aleo83@rambler.ru");
        $(".col-md-9 div").$(withText("Male")).click();
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
        $(".table-responsive").shouldHave(text("Alexander Veber"));
        $(".table-responsive").shouldHave(text("aleo83@rambler.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7770658833"));
        $(".table-responsive").shouldHave(text("16 September,1993"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("121211.png"));
        $(".table-responsive").shouldHave(text("Baikonur, Street Shybnikova, d.3"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));
    }


    @Test
    void requiredFillFormTest() {

    }
}
