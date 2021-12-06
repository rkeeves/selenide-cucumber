package io.github.rkeeves.bookstore.page.playground;

import io.github.rkeeves.bookstore.dictionary.book.Book;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class BookTable {

    private final By deleteAllBooksButton = By.xpath("//button[text()='Delete All Books']");

    private final By modalOkButton = By.id("closeSmallModal-ok");

    private final By modalCancelButton = By.id("closeSmallModal-cancel");

    public void navigateToDetailsOf(final Book book) {
        By locator = By.xpath("//span[starts-with(@id, 'see-book-')]/a[text()='"+book.getTitle()+"']");
        $(locator).scrollIntoView(true).click();
    }

    public void shouldHaveBookTitles(List<String> expected) {
        if (expected.isEmpty()) {
            $$(By.xpath("//span[starts-with(@id, 'see-book-')]/a")).shouldBe(empty);
        } else {
            $$(By.xpath("//span[starts-with(@id, 'see-book-')]/a")).shouldHave(texts(expected));
        }
    }

    public void deleteBook(final Book book) {
        By locator = By.xpath("//div[@role='row' and .//a[text()='"+book.getTitle()+"']]//span[@title='Delete']");
        $(locator).scrollIntoView(true).click();
        $(modalOkButton).click();
        confirm();
    }

    public void deleteAllBooks() {
        $(deleteAllBooksButton).scrollIntoView(true).click();
        $(modalOkButton).click();
        confirm();
    }
}
