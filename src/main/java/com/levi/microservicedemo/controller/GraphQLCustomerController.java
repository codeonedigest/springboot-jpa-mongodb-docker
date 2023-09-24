package com.levi.microservicedemo.controller;

import com.levi.microservicedemo.domain.Customer;
import com.levi.microservicedemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class GraphQLCustomerController {

    @Autowired
    CustomerService customerService;

    /*@GetMapping("/customers/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        log.info("Getting customer by name {} ", name);
        List customerList = customerService.getCustomerByName(name);
        log.info("Received {} customers by name {}", customerList.size(), name);
        return customerList;
    }*/

    @QueryMapping
    public Customer customerById(@Argument String id) {
        log.info("Quering customer in GraphQL Server by id {}", id);
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @QueryMapping
    public Customer customerByName(@Argument String name) {
        log.info("Quering customer in GraphQL Server by name {}", name);
        Customer customer = customerService.getCustomerByName(name).get(0);
        return customer;
    }



    /*@PostMapping("/customers/save")
    public Customer addCustomer(@RequestBody Customer customer) {
        log.info("Adding user {} to the Database", customer.getName());
        return customerService.addCustomer(customer);
    }*/
}
