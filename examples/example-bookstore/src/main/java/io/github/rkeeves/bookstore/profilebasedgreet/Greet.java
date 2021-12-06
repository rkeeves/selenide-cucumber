package io.github.rkeeves.bookstore.profilebasedgreet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Greet {

    private final String message;

    public String getMessage() {
        return String.format("\"%s\"", message);
    }
}
