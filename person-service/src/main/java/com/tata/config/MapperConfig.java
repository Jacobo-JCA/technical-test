package com.tata.config;

import com.tata.dto.CustomerDTO;
import com.tata.entity.Customer;
import com.tata.entity.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("customerMapper")
    public ModelMapper mapperCustomer() {
        ModelMapper mapperCustomer = new ModelMapper();
        TypeMap<CustomerDTO, Customer> typeMapCustomer = mapperCustomer.createTypeMap(CustomerDTO.class, Customer.class);
        typeMapCustomer.addMappings(mapper -> {
            mapper.map(CustomerDTO::getIdCustomer, Customer::setIdCustomer);
            mapper.map(CustomerDTO::getName, Customer::setName);
            mapper.map(CustomerDTO::getGenre, Customer::setGenre);
            mapper.map(CustomerDTO::getAge, Customer::setAge);
            mapper.map(CustomerDTO::getCi, Customer::setCi);
            mapper.map(CustomerDTO::getAddress, Customer::setAddress);
            mapper.map(CustomerDTO::getTelephone, Customer::setTelephone);
            mapper.map(CustomerDTO::getPassword, Customer::setPassword);
        });

        TypeMap<Customer, CustomerDTO> typeMapCustomerDTO = mapperCustomer.createTypeMap(Customer.class, CustomerDTO.class);
        typeMapCustomerDTO.addMappings(mapper -> {
            mapper.map(Customer::getIdCustomer, CustomerDTO::setIdCustomer);
            mapper.map(Customer::getName, CustomerDTO::setName);
            mapper.map(Customer::getGenre, CustomerDTO::setGenre);
            mapper.map(Customer::getAge, CustomerDTO::setAge);
            mapper.map(Customer::getCi, CustomerDTO::setCi);
            mapper.map(Customer::getAddress, CustomerDTO::setAddress);
            mapper.map(Customer::getTelephone, CustomerDTO::setTelephone);
            mapper.map(Customer::getPassword, CustomerDTO::setPassword);
        });

        return mapperCustomer;
    }

}
