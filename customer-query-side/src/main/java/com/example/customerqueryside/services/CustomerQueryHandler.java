package com.example.customerqueryside.services;

import com.example.customerqueryside.entities.Customer;
import com.example.customerqueryside.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.query.GetAllCustomersQuery;
import org.sid.coreapi.query.GetCustomerByIdQuery;
import org.springframework.stereotype.Service;

import javax.annotation.security.DenyAll;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer customerList(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not fount"));
    }
}
