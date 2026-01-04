package stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjectmodel.LoginPage;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {
     private LoginPage loginPage = new LoginPage();
    @Given("user is on the login page")

        public void userOnLoginPage(){
            loginPage.openPage();
        }
    @When("user logins with {string} and {string}")
    public void user_enters_credentials(String email, String pass) {
        loginPage.loginAs(email, pass);
    }
    @Then("user is redirected to the new page")
    public void successLogin(){

        $("body").shouldBe(Condition.visible);
        String currentUrl = com.codeborne.selenide.WebDriverRunner.url();
        Assert.assertEquals("URL should match after successful login", LoginPage.url2, currentUrl);
    }
    @Then("an error message is displayed")
    public void loginFailed(){
        loginPage.errorMessage.should(appear.because("Error message must appear after failed login"));
        String actualText = loginPage.errorMessage.getText();
        Assert.assertEquals("Email or password was incorrect", actualText);
    }
    @Then("user sees results accordingly")
    public void userResultsAccordingly(){
        if (loginPage.isErrorMessageVisible()) {

            System.out.println("Error message visible");
        } else {
            System.out.println("LoginSuccessfully");
        }
    }

        @When("user enters the following credentials")
        public void userEntersCredentials (DataTable dataTable){
            List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

            for (Map<String, String> row : credentials) {
                String email = row.get("email");
                String password = row.get("password");

                loginPage.openPage();
                loginPage.login(email, password);

                Assert.assertTrue(
                        "Expected error message for user: " + email,
                        loginPage.isErrorMessageVisible()
                );

                System.out.println("Login failed as expected for user: " + email);
            }
        }
    }




