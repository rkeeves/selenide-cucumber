package io.github.rkeeves.bookstore.step;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.rkeeves.bookstore.dictionary.book.Book;
import io.github.rkeeves.bookstore.dictionary.user.User;
import io.github.rkeeves.bookstore.page.playground.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;

@RequiredArgsConstructor
public class WorkflowSteps {

    private final GoogleAd googleAd;

    private final Sidebar sidebar;

    private final LoginView loginView;

    private final BookStoreView bookStoreView;

    private final ProfileView profileView;

    private final BookTable bookTable;

    private final DetailsView detailsView;

    private final LoggedInUserInfo loggedInUserInfo;

    @Given("^browser is ready$")
    public void browserIsReady() {
        open();
    }

    @Given("on Profile view, logged in as {user}")
    public void fromColdBrowserLoginAs(final User user) {
        loginView.openInBrowser();
        loginView.shouldBeAt();
        loginView.loginAs(user);
        profileView.shouldBeAt();
        googleAd.closeIfVisible();
        bookTable.deleteAllBooks();
    }

    @When("user switches to Profile view")
    public void userSwitchesToProfileView() {
        sidebar.clickOnProfile();
        profileView.shouldBeAt();
        googleAd.closeIfVisible();
    }

    @When("user switches to Book Store view")
    public void userSwitchesToBookStoreView() {
        sidebar.clickOnBookStore();
        bookStoreView.shouldBeAt();
        googleAd.closeIfVisible();
    }

    @When("user visits {book} via book table")
    public void visitDetailsOfBook(final Book book) {
        bookTable.navigateToDetailsOf(book);
        detailsView.checkAtDetailsPageOf(book);
        googleAd.closeIfVisible();
    }

    @Then("user sees only {books} in book table")
    public void userSeesOnlyGitpocketInBookTable(final List<Book> books) {
        final List<String> expected = books.stream().map(Book::getTitle).collect(Collectors.toList());
        bookTable.shouldHaveBookTitles(expected);
    }

    @When("user successfully adds the detailed book to collection")
    public void userSuccessfullyAddsTheDetailedBookToCollection() {
        detailsView.pushAddButtonAndCloseAlert();
    }

    @When("user goes back to Book Store view from Details")
    public void userGoesBackToBookStoreView() {
        detailsView.pushBackToBookStore();
        bookStoreView.shouldBeAt();
    }

    @After
    public void cleanup(Scenario scenario) {
        final Optional<String> loggedInUserName = loggedInUserInfo.getLoggedInUserName();
        if (!loggedInUserName.isPresent()) {
            return;
        }
        profileView.shouldBeAt();
        bookTable.deleteAllBooks();
        loggedInUserInfo.pushLogout();
    }

    @When("user deletes {book} via book table")
    public void userDeletesBookViaBookTable(final Book book) {
        profileView.shouldBeAt();
        bookTable.deleteBook(book);
    }
}
