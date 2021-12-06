package io.github.rkeeves.bookstore.page.playground;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleAd {

    private final By googleAdBanner = By.id("close-fixedban");

    public void closeIfVisible() {
        final SelenideElement googleAdBannerElement = $(googleAdBanner);
        if (googleAdBannerElement.isDisplayed()) {
            googleAdBannerElement.click();
        }
    }
}
