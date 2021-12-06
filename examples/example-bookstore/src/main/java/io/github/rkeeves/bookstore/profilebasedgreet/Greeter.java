package io.github.rkeeves.bookstore.profilebasedgreet;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Greeter {

    Logger logger = LoggerFactory.getLogger(Greeter.class);

    private final Greet greet;

    public void performGreet() {
        logger.info("They instructed me, to tell you this : " + greet.getMessage());
    }
}
