package com.ing.customer.restservice.customerservice.repository;

import com.ing.customer.restservice.customerservice.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findByCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);

        when(customerRepository.findByCustomerId(1L)).thenReturn(customer);

        Customer foundCustomer = customerRepository.findByCustomerId(1L);

        assertEquals(customer, foundCustomer);
    }
}
