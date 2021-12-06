package io.github.rkeeves.bookstore;

import io.github.rkeeves.bookstore.dictionary.book.BookDictionary;
import io.github.rkeeves.bookstore.dictionary.user.UserDictionary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        UserDictionary.class,
        BookDictionary.class})
public class BookstoreTestApp {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreTestApp.class, args);
    }

}