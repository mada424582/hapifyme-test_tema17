package stepdefinition;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjectmodel.ProfileSearchPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class ProfileSearchSteps {
    private ProfileSearchPage registerProfile = new ProfileSearchPage();
    @When("user searches for {string}")
        public void userSearch(String username){

        registerProfile.searchUser(username);
        }
    @Then("the profile for {string} is displayed")
    public void profilePageDisplayed(String expectedUserName){

        // verifică că username-ul se găsește în lista de rezultate
        boolean found = registerProfile.isUsernameInFirstResult(expectedUserName);
        Assert.assertTrue(
                "Username '" + expectedUserName + "' nu a fost găsit în rezultate!",
                found
        );

        System.out.println("Test complet. Username găsit în rezultate: '" + expectedUserName + "'");
    };

}

