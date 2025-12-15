package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjectmodel.LoginPage;
import pageobjectmodel.PostPage;

public class PostSteps {
    private PostPage postPage = new PostPage();
    private String postedMessage;
    @Given("user is already logged into app")
    public void userLogged() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("madalina.munteanu424@gmail.com", "Accidentat!_2025");
    }
    @When("user creates a post with text {string}")
    public void userCreatesPost(String text){
        postedMessage = text;
        postPage.createPost(text);
    }
    @Then("the post is visible")
    public void postIsVisible(){
        Assert.assertTrue(postPage.isPostVisible(postedMessage));
    }
}
