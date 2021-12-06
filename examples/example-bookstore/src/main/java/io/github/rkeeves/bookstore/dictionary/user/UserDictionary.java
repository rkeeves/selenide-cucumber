package io.github.rkeeves.bookstore.dictionary.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "user-dictionary")
public class UserDictionary {

    private final Map<String, User> users = new HashMap<>();

    public User findByKeyOrThrow(String userDictionaryKey) {
        User user = users.get(userDictionaryKey);
        if (user == null) {
            throw new IllegalArgumentException("No user is configured to key "+userDictionaryKey);
        }
        return user;
    }
}
