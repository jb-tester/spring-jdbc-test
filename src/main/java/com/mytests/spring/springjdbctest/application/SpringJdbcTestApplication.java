package com.mytests.spring.springjdbctest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.mytests.spring.springjdbctest.jdbcRepositories",namedQueriesLocation = "META-INF/jdbc-named-queries.properties")
public class SpringJdbcTestApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerServiceUsingJdbcTemplate customerServiceUsingJdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       customerService.displayAllVips(); 
       customerService.displayCardsFromSpb(); 
       customerService.displayCreditForId(); 
       customerService.displayAllCustomersWithBigCredit(); 
       customerServiceUsingJdbcTemplate.addAndDeleteCustomer();
    }
}
