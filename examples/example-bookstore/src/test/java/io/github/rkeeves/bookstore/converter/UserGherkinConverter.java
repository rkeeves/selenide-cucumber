package io.github.rkeeves.bookstore.converter;

import io.cucumber.java.ParameterType;
import io.github.rkeeves.bookstore.dictionary.user.User;
import io.github.rkeeves.bookstore.dictionary.user.UserDictionary;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserGherkinConverter {

    private final UserDictionary userDictionary;

    @ParameterType(value = ".+", name = "user")
    public User user(String userKey) {
        return userDictionary.findByKeyOrThrow(userKey);
    }
}
