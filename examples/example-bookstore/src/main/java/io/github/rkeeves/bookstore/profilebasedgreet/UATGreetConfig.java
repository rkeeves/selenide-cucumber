package io.github.rkeeves.bookstore.profilebasedgreet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("uat")
public class UATGreetConfig {

    @Bean
    Greeter provideGreeter(final Greet greet) {
        return new Greeter(greet);
    }

    @Bean
    Greet thisWholeGreetFluffWasMadeJustToProveThatYouCanWireComplexDependenciesHere() {
        return new Greet("Hi from uat!");
    }
}
