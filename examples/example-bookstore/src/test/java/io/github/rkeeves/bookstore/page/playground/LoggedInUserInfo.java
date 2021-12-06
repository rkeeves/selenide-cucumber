package io.github.rkeeves.bookstore.page.playground;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

public class LoggedInUserInfo {

    private final By loggedInUserName = By.xpath("//label[text()='User Name : ']/following-sibling::label");

    private final By logoutButton = By.xpath("//label[text()='User Name : ']/following-sibling::button[text()='Log out']");

    public Optional<String> getLoggedInUserName() {
        final SelenideElement loggedInUser = $(loggedInUserName);
        return loggedInUser.exists() ? Optional.of(loggedInUser.text()) : Optional.empty();
    }

    public void pushLogout() {
        $(logoutButton).scrollIntoView(true).click();
    }
}
