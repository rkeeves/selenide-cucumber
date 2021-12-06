package io.github.rkeeves.bookstore.page.playground;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookStoreView {

    private final ViewTitle viewTitle;

    public void shouldBeAt() {
        viewTitle.titleShouldBe("Book Store");
    }
}
