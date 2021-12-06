package io.github.rkeeves.bookstore.dictionary.book;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "book-dictionary")
public class BookDictionary {

    private final List<Book> books = new ArrayList<>();

    public Book findByIndexOrThrow(int bookIdx) {
        if (bookIdx < 0 || bookIdx > books.size()) {
            throw new IllegalArgumentException("No book is configured to index "+bookIdx);
        }
        return books.get(bookIdx);
    }
}
