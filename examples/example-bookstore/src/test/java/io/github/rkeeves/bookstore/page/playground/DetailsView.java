package io.github.rkeeves.bookstore.page.playground;

import com.codeborne.selenide.Condition;
import io.github.rkeeves.bookstore.dictionary.book.Book;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;

public class DetailsView {

    private final By titleLabel = By.cssSelector("#title-wrapper #userName-value");

    private final By authorLabel = By.cssSelector("#author-wrapper #userName-value");

    private final By publisherLabel = By.cssSelector("#publisher-wrapper #userName-value");

    private final By addNewRecordButton = By.xpath("//button[text()='Add To Your Collection']");

    private final By backToBookStoreButton = By.xpath("//button[text()='Back To Book Store']");


    public void checkAtDetailsPageOf(final Book book) {
        $(titleLabel).shouldHave(Condition.text(book.getTitle()));
    }

    public void pushAddButtonAndCloseAlert() {
        $(addNewRecordButton).scrollIntoView(true).click();
        confirm("Book added to your collection.");
    }

    public void pushBackToBookStore() {
        $(backToBookStoreButton).scrollIntoView(true).click();
    }
}
