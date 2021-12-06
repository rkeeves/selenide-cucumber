package io.github.rkeeves.bookstore.config;

import io.github.rkeeves.bookstore.page.playground.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public LoggedInUserInfo loggedInUserInfo() {
        return new LoggedInUserInfo();
    }

    @Bean
    public DetailsView detailsView() {
        return new DetailsView();
    }

    @Bean
    public ProfileView profileView(final ViewTitle viewTitle, final BookTable bookTable) {
        return new ProfileView(viewTitle, bookTable);
    }

    @Bean
    public BookStoreView bookStoreView(final ViewTitle viewTitle) {
        return new BookStoreView(viewTitle);
    }

    @Bean
    public LoginView loginView(final ViewTitle viewTitle) {
        return new LoginView(viewTitle);
    }

    @Bean
    public BookTable bookTable() {
        return new BookTable();
    }

    @Bean
    public Sidebar sidebar() {
        return new Sidebar();
    }

    @Bean
    public GoogleAd googleAd() {
        return new GoogleAd();
    }

    @Bean
    public ViewTitle viewTitle() {
        return new ViewTitle();
    }
}
