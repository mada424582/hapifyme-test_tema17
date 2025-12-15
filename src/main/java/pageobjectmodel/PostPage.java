package pageobjectmodel;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PostPage {
    public SelenideElement postField = $(By.id("post_text"));
    public SelenideElement postButton = $("#post_button");
   // public SelenideElement firstPost = $(".post");
    public ElementsCollection posts = $$(".status_post");


    public void createPost(String text){
        postField.setValue(text);

            executeJavaScript("window.scrollTo(0, 0);");

            postButton.scrollIntoView(true);

            executeJavaScript("arguments[0].click();", postButton);

            posts.first().should(Condition.exist);
        }



    public boolean isPostVisible(String expectedText){
        return posts.asFixedIterable().stream()
                .anyMatch(post ->post.getText().contains(expectedText));
               // .getText().contains(expectedText);
    }
}
