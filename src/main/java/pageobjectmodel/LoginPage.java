package pageobjectmodel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static String url = "https://test.hapifyme.com/login_register.php";

    //selectori Selenide
    public SelenideElement emailField = $(By.id("emailId"));
    public SelenideElement passwordField = $("#passwordId");
    public SelenideElement loginButton = $("input[name='login_button']");
    public SelenideElement errorMessage = $("#log_inv");

    public static String url2 = "https://test.hapifyme.com/index.php";

    // public By paOsswordField = By.name("password");
    // public By loginButton = By.cssSelector(".login-form > form >button");
    public static void openPage() {
        open(url);
    }
    public void login(String email, String pass){
        emailField.setValue(email);
        passwordField.setValue(pass);
        loginButton.shouldBe(Condition.visible).click();
    }

    //verify error message
    public boolean isErrorMessageVisible(){
        return errorMessage.isDisplayed();
    }
    public void loginAs(String email, String password){
        openPage();
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
    }

}
