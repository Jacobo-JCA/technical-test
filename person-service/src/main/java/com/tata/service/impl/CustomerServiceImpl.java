package com.tata.service.impl;

import com.tata.entity.Customer;
import com.tata.exception.ModelNotFoundException;
import com.tata.repository.CustomerRepo;
import com.tata.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo repo;

    public CustomerServiceImpl(CustomerRepo repo) {
        this.repo = repo;
    }
    @Override
    public Customer save(Customer customer) throws Exception {
        return repo.save(customer);
    }

    @Override
    public List<Customer> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Customer update(Customer customer, Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXISTS" + id));
        return repo.save(customer);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXISTS" + id));
        repo.deleteById(id);
    }
}
