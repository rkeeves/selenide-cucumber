package io.github.rkeeves.bookstore.profilebasedgreet;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Please note that we register this autoconfig class under
// src/main/resources/META-INF/spring.factories
// See the guide at:
// https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-auto-configuration
// See the code at:
// https://github.com/snicoll/spring-boot-master-auto-configuration/blob/main/hornetq-spring-boot-autoconfigure/src/main/resources/META-INF/spring.factories
@Configuration
public class DefaultGreetAutoConfig {

    @ConditionalOnMissingBean(Greeter.class)
    @Bean
    Greeter provideGreeter(final Greet greet) {
        return new Greeter(greet);
    }

    @ConditionalOnMissingBean(Greet.class)
    @Bean
    Greet thisWholeGreetFluffWasMadeJustToProveThatYouCanWireComplexDependenciesHere() {
        return new Greet("Hi! Only uat configures Greeter, so when you use other profiles the app defaults to me.");
    }
}
