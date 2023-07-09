package com.ing.customer.restservice.customerservice.controller;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.dto.InterestRateDTO;
import com.ing.customer.restservice.customerservice.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerServiceController customerServiceController;

    @Test
    public void testGetCustomerDetailsWithInterestRate() {

        // Given
        long id = 1L;
        CustomerDTO customerDTO = new CustomerDTO(id, "John Doe", "123 Main Street", "655", 4.0);
        InterestRateDTO interestRateDTO = new InterestRateDTO("655", 4.0);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("creditScore", customerDTO.getCreditScore());
        ResponseEntity<InterestRateDTO> response = new ResponseEntity<>(interestRateDTO, HttpStatus.OK);

        when(customerService.getCustomerById(id)).thenReturn(customerDTO);

        CustomerDTO customerWithInterestRate = customerServiceController.getCustomerDetailsWithInterestRate(id);

        // Then
        assertEquals(customerDTO.getId(), customerWithInterestRate.getId());
        assertEquals(customerDTO.getName(), customerWithInterestRate.getName());
        assertEquals(customerDTO.getAddress(), customerWithInterestRate.getAddress());
        assertEquals(customerDTO.getCreditScore(), customerWithInterestRate.getCreditScore());
        assertEquals(interestRateDTO.getInterestRate(), customerWithInterestRate.getInterestRate());
    }
}
