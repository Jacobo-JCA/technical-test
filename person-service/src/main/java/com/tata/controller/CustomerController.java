package com.tata.controller;

import com.tata.dto.CustomerDTO;
import com.tata.entity.Customer;
import com.tata.service.CustomerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CustomerController {
    private final CustomerService service;
    private final ModelMapper mapper;

    public CustomerController(CustomerService service, @Qualifier("customerMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/public/customers")
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO dto) throws Exception {
        Customer obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/public/customers")
    public ResponseEntity<List<CustomerDTO>> readAll() throws Exception {
        List<CustomerDTO> list = service.readAll().stream()
                .map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/admin/customer/{customerId}")
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable Integer customerId)
            throws Exception {
        customerDTO.setIdCustomer(customerId);
        Customer obj = service.update(this.convertToEntity(customerDTO), customerId);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin/customer/{customerId}")
    public ResponseEntity<CustomerDTO> deleteCategory(@PathVariable Integer customerId) throws Exception {
        service.delete(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CustomerDTO convertToDto(Customer obj) {
        return mapper.map(obj, CustomerDTO.class);
    }
    private Customer convertToEntity(CustomerDTO dto) {
        return mapper.map(dto, Customer.class);
    }
}
