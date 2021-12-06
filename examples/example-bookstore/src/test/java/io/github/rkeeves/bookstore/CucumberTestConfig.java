package io.github.rkeeves.bookstore;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.rkeeves.bookstore.config.TestConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@CucumberContextConfiguration
@SpringBootTest
@Import(TestConfig.class)
public class CucumberTestConfig {

}
