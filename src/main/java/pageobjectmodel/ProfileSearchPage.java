package pageobjectmodel;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfileSearchPage {
    public static String url = "https://test.hapifyme.com/index.php";

    public SelenideElement searchField = $(By.id("search_text_input"));

    private SelenideElement firstResult = $("p#grey");

    private String resultSelector = "p#grey";
    private ElementsCollection results = $$("a > p#grey");

    //public SelenideElement profileUsername = $(".profile-username");

    public void searchUser(String username) {

        searchField.setValue(username).pressEnter();
    }

    public void clickFirstResult() {
        firstResult.parent().click();
    }

    public boolean isUsernameInFirstResult(String expectedUserName) {
        // găsește toate <p id="grey">
       // ElementsCollection results = $$("a > p#grey")
                results.shouldBe(CollectionCondition.sizeGreaterThan(0));

        SelenideElement first = results.first();

        String name = first.parent()
                .getText()
                .split("\n")[0]
                .trim();

        System.out.println("Compar: '" + name + "' vs '" + expectedUserName + "'");

        return name.equalsIgnoreCase(expectedUserName.trim());
    }
    }



