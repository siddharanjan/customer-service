package com.ing.customer.restservice.customerservice.repository;

import com.ing.customer.restservice.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The CustomerRepository class is an interface for retrieving customer entity
 *
 *
 * @author Sid
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(long id);
}
