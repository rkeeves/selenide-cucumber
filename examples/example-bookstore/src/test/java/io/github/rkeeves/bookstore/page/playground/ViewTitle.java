package io.github.rkeeves.bookstore.page.playground;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ViewTitle {

    private final By viewTitleElement = By.cssSelector(".main-header");

    public void titleShouldBe(final String viewTitle) {
        $(viewTitleElement).shouldHave(Condition.text(viewTitle));
    }
}
