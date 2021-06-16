package com.mytests.spring.springjdbctest.jdbcRepositories;

import com.mytests.spring.springjdbctest.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findCustomerByVip(boolean vip);

    @Query("select card from customer where city = :city")
    List<String> findCardsFromCity(String city);
    
   Integer firstNamedQueryFromProperties(Integer id);
   
    @Query(name = "Customer.secondNamedQueryFromProperties")
    List<Customer> secondNamedQueryFromProperties();

}
