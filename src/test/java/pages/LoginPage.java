package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.CssValue;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement dropListState = $("#state");
    private final SelenideElement dropListCity = $("#city");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement checkResult = $(".table-responsive");
    private final SelenideElement checkErrorColorInput = $("#firstName");
    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public LoginPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public LoginPage setFirstName(String fname) {
        firstNameInput.setValue(fname);
        return this;
    }

    public LoginPage setLastName(String lname) {
        lastNameInput.setValue(lname);
        return this;
    }

    public LoginPage setEmail(String mail) {
        emailInput.setValue(mail);
        return this;
    }

    public LoginPage setGender(String gender) {
        genderWrapper.$(withText(gender)).click();
        return this;
    }

    public LoginPage setPhoneNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public LoginPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public LoginPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public LoginPage setHobbies(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    public LoginPage uploadPicture(String picName) {
        uploadPicture.uploadFromClasspath(picName);
        return this;
    }

    public LoginPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public LoginPage setState(String state) {
        dropListState.click();
        dropListState.$(byText(state)).click();
        return this;
    }

    public LoginPage setCity(String city) {
        dropListCity.click();
        dropListCity.$(byText(city)).click();
        return this;
    }

    public LoginPage clickButton() {
        $("#submit").click();
        return this;
    }

    //для проверки обязательных полей
    public LoginPage checkResult(String key, String value) {
        checkResult.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    //для проверки всех полей
    public void checkResultComponent(String Name, String email, String gender, String mobileNumber,
                                     String dateOfBirth, String subjects, String hobbies, String pictureName,
                                     String address, String stateAndCity) {
        checkResultComponent.getResultTable(Name, email, gender, mobileNumber, dateOfBirth, subjects, hobbies,
                pictureName, address, stateAndCity);
    }

    public void checkErrorColorInput(String color) {
        checkErrorColorInput.shouldHave(new CssValue("border-color", color));
    }
}
