package io.github.rkeeves.bookstore.page.playground;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Sidebar {

    private static final String MENU_NAME = "Book Store Application";

    private final By accordionGroupToggle = By.xpath("//div[text()='"+MENU_NAME+"']");

    private final By menuItemList = By.xpath("//div[contains(@class, 'element-group') " +
            "and .//div[text()='"+ MENU_NAME+"']]//div[contains(@class, 'element-list')]");

    private final By loginMenuItem = By.xpath("//span[text()='Login']");

    private final By bookStoreMenuItem = By.xpath("//span[text()='Book Store']");

    private final By profileMenuItem = By.xpath("//span[text()='Profile']");

    public void clickOnLogin() {
        clickOnMenuItem(loginMenuItem);
    }

    public void clickOnBookStore() {
        clickOnMenuItem(bookStoreMenuItem);
    }

    public void clickOnProfile() {
        clickOnMenuItem(profileMenuItem);
    }

    private void clickOnMenuItem(By menuItem) {
        openListIfNecessary();
        $(menuItem).scrollIntoView(true).click();
    }

    private void openListIfNecessary() {
        if (!$(menuItemList).isDisplayed()) {
            $(accordionGroupToggle).click();
        }
    }
}
