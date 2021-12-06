package io.github.rkeeves.bookstore.page.playground;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfileView {

    private final ViewTitle viewTitle;

    @Getter
    private final BookTable bookTable;

    public void shouldBeAt() {
        viewTitle.titleShouldBe("Profile");
    }
}
