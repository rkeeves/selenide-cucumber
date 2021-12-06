package io.github.rkeeves.bookstore.converter;

import io.cucumber.java.ParameterType;
import io.github.rkeeves.bookstore.dictionary.book.Book;
import io.github.rkeeves.bookstore.dictionary.book.BookDictionary;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookGherkinConverter {

    private final BookDictionary bookDictionary;

    @ParameterType(value = "book([0-9]+)", name = "book")
    public Book book(String captureGroup1) {
        return bookDictionary.findByIndexOrThrow(Integer.parseInt(captureGroup1));
    }

    @ParameterType(value = "\\[(.*)\\]", name = "books")
    public List<Book> books(String booksCommaWithSpaceSeparated) {
        return Arrays.stream(booksCommaWithSpaceSeparated.split(", "))
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(4))
                .map(Integer::parseInt)
                .map(bookDictionary::findByIndexOrThrow)
                .collect(Collectors.toList());
    }
}
