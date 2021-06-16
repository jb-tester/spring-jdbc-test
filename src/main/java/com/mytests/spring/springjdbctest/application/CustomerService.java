package com.mytests.spring.springjdbctest.application;

import com.mytests.spring.springjdbctest.jdbcRepositories.CustomerRepository;
import com.mytests.spring.springjdbctest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    
    public void displayAllVips(){
        List<Customer> customers = repository.findCustomerByVip(true);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    public void displayCardsFromSpb(){
        List<String> cards = repository.findCardsFromCity("spb");
        for (String el:
             cards) {
            System.out.println("card = " + el);
        }
    }
    public void displayCreditForId(){
        Integer credit = repository.firstNamedQueryFromProperties(2);
        System.out.println("credit for customer 2 is "+credit);
    }
    public void displayAllCustomersWithBigCredit(){
        List<Customer> customers = repository.secondNamedQueryFromProperties();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
