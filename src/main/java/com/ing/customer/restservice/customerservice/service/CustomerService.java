package com.ing.customer.restservice.customerservice.service;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.entity.Customer;
import com.ing.customer.restservice.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO getCustomerById(long id) {
        Customer customer = customerRepository.findByCustomerId(id);
        return new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getAddress(), customer.getCreditScore(), null);
    }
}
