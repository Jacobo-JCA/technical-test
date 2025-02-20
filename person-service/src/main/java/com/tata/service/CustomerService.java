package com.tata.service;

import com.tata.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer) throws Exception;
    List<Customer> readAll() throws Exception;
    Customer update(Customer customer, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
