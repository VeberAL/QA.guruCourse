package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    public void getResultTable(String Name, String email, String gender, String mobileNumber,
                               String dateOfBirth, String subjects, String hobbies, String pictureName,
                               String address, String stateAndCity) {
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(Name));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobileNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(pictureName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }
}
