package com.ing.customer.restservice.customerservice.service;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.entity.Customer;
import com.ing.customer.restservice.customerservice.exception.CustomerNotFoundException;
import com.ing.customer.restservice.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The CustomerService class is a service class between the controller and repository interface
 * to retrieve customer details
 *
 * @author Sid
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Retrieve customer details from the repository
     *
     * @param id The id of the customer.
     * @return A CustomerDTO object with the customer details.
     */
    public CustomerDTO getCustomerById(long id) {
            Customer customer = customerRepository.findByCustomerId(id);

            //If the customer is not found using the id we throw customer not found exception with the message
            if (customer == null) {
                throw new CustomerNotFoundException();
            }
            return new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getAddress(), customer.getCreditScore(), 0.0);
     }
}
