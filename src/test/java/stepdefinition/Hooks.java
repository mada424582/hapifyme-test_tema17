package stepdefinition;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before("@UI")
    public void setupBefore() {
        System.out.println("Driver initialisation");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pageLoadTimeout = 15000;

    }

    @After("@UI")
    public void tearDownAfter() {
        System.out.println("Inchidem driverul");
        closeWebDriver();
    }
}
