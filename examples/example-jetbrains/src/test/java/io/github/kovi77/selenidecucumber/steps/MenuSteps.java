package io.github.kovi77.selenidecucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.kovi77.selenidecucumber.pages.IDEDefaultPage;
import io.github.kovi77.selenidecucumber.pages.MainPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.ownText;

public class MenuSteps {
    private MainPage mainPage;
    private IDEDefaultPage ideDefaultPage;

    public MenuSteps(MainPage homepage, IDEDefaultPage ideDefaultPage) {
        this.mainPage = homepage;
        this.ideDefaultPage = ideDefaultPage;
    }

    @Then("the start page of the IDE should be loaded")
    public void theStartPageOfTheIDEShouldBeLoaded() {
        ideDefaultPage.title.should(exist);
        ideDefaultPage.title.shouldHave(ownText(mainPage.selectedSubMenu));
    }

    @When("the {string} is selected from the {string} menu")
    public void theIsSelectedFromTheMenu(String arg0, String arg1) {
        mainPage.selectMenu(arg1);
        mainPage.selectSubMenu(arg0);
    }
}
