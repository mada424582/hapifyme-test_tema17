package pageobjectmodel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PostPage {
    public SelenideElement postField = $(By.id("post_text"));
    public SelenideElement postButton = $("#post_button");

    public ElementsCollection posts = $$(".status_post");


    public void createPost(String text){
        postField.setValue(text);
        postButton.click();
        posts.first().should(Condition.exist);
        }



    public boolean isPostVisible(String expectedText){
        posts.findBy(Condition.text(expectedText))
                .shouldBe(Condition.visible);
        return true;
    }
}
