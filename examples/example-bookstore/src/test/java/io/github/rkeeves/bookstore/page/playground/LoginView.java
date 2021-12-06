package io.github.rkeeves.bookstore.page.playground;

import io.github.rkeeves.bookstore.dictionary.user.User;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RequiredArgsConstructor
public class LoginView {

    private static final String URL = "https://demoqa.com/login";

    private final ViewTitle viewTitle;

    private final By userName = By.cssSelector("#userName");

    private final By password = By.cssSelector("#password");

    private final By login = By.cssSelector("#login");

    private final By alreadyLoggedInLabel = By.xpath("//label[starts-with(text(),'You are already logged in')]");

    public void openInBrowser() {
        open(URL);
    }

    public void shouldBeAt() {
        viewTitle.titleShouldBe("Login");
    }

    public boolean isAlreadyLoggedIn() {
        return $(alreadyLoggedInLabel).exists();
    }


    public void loginAs(final User user) {
        $(userName).setValue(user.getUsername());
        $(password).setValue(user.getPassword());
        $(login).click();
    }
}
