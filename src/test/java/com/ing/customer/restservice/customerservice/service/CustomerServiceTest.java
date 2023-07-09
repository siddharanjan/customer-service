package com.ing.customer.restservice.customerservice.service;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.entity.Customer;
import com.ing.customer.restservice.customerservice.exception.CustomerNotFoundException;
import com.ing.customer.restservice.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void testGetCustomerById() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("John Doe");
        customer.setAddress("123 Main Street");
        customer.setCreditScore("655");

        when(customerRepository.findByCustomerId(1L)).thenReturn(customer);
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals(customer.getCustomerId(), customerDTO.getId());
        assertEquals(customer.getName(), customerDTO.getName());
        assertEquals(customer.getAddress(), customerDTO.getAddress());
        assertEquals(customer.getCreditScore(), customerDTO.getCreditScore());
    }
}
