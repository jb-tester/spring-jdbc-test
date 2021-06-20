package com.mytests.spring.springjdbctest.application;

import com.mytests.spring.springjdbctest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * *
 * <p>Created by irina on 16.06.2021.</p>
 * <p>Project: spring-jdbc-test</p>
 * *
 */
@Service
public class CustomerServiceUsingJdbcTemplate {

    @Autowired
    private JdbcTemplate template; 
    @Autowired
    private JdbcOperations operations;
     @Autowired
    NamedParameterJdbcTemplate namedParameterTemplate;
    public void addAndDeleteCustomer(){
        System.out.println("add new customer.....");
        operations.update("insert into customer(id, firstname, lastname, birthday, city, street, building, card, mobilephone, homephone, credit, vip)"+"values (13,'vasya','pupkin','29.02.1984','msk','krasnaya pl','0','666666','+76666666','+70000000',0,true)");
        for (Map<String, Object> map : operations.queryForList("select * from customer")) {
            System.out.println(map.toString());
        }
        operations.execute("update customer set credit = 1000 where id=13");
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 13);
        System.out.println(namedParameterTemplate.queryForObject("select firstname from customer where id=:id",
                namedParameters, String.class));
        template.update("delete from customer where id=13");
        for (Map<String, Object> map : operations.queryForList("select * from customer")) {
            System.out.println(map.toString());
        }
        // no SQL injected here
        System.out.println(operations.queryForStream("select * from customer", null));
    }
}
