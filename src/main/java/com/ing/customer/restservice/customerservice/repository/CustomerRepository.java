package com.ing.customer.restservice.customerservice.repository;

import com.ing.customer.restservice.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(long id);
}
