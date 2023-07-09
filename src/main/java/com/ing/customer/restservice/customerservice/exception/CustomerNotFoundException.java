package com.ing.customer.restservice.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The CustomerNotFoundException class is an exception class used to return message if a customer is not found
 *
 *
 * @author Sid
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Customer details not found for the customer id";
    public CustomerNotFoundException() {
        super(MESSAGE);
    }
}
