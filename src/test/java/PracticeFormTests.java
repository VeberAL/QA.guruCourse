import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("87770658833");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__month").$(byText("9")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("121211.png");
        $("#currentAddress").setValue("Baikonur, Street Shybnikova, d.3");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();
    }
}
