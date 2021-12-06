package io.github.rkeeves.bookstore.dictionary.user;

import lombok.Data;

@Data
public class User {

    private String firstname;

    private String lastname;

    private String username;

    private String password;
}
