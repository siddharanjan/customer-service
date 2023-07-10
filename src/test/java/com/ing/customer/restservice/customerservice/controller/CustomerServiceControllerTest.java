package com.ing.customer.restservice.customerservice.controller;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.dto.InterestRateDTO;
import com.ing.customer.restservice.customerservice.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private RestTemplate restTemplate;


    @InjectMocks
    private CustomerServiceController customerServiceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCustomerDetailsWithInterestRate() {

        //Set the interestRateServiceUrl property on the CustomerServiceController class
        customerServiceController.interestRateServiceUrl = "http://localhost:8000/api/v1/interest-rates";
        //Mock the customerService.getCustomerById() method to return a CustomerDTO object
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("John Doe");
        customerDTO.setAddress("123 Main Street");
        customerDTO.setCreditScore("655");
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customerDTO);

        //Mock the restTemplate.getForEntity() method to return a ResponseEntity object
        ResponseEntity<InterestRateDTO> responseEntity = new ResponseEntity<>(new InterestRateDTO("655", 4.0), null, 200);
        Mockito.when(restTemplate.getForEntity("http://localhost:8000/api/v1/interest-rates/655/", InterestRateDTO.class)).thenReturn(new ResponseEntity<>(new InterestRateDTO("655", 4.0), null, 200));

        //Call the getCustomerDetailsWithInterestRate() method
        CustomerDTO customerWithInterestRate = customerServiceController.getCustomerDetailsWithInterestRate(1L);

        //Verify that the customerService.getCustomerById() method was called once
        Mockito.verify(customerService, Mockito.times(1)).getCustomerById(1L);

        //Verify the returned CustomerDTO object
        assertEquals(customerDTO.getId(), customerWithInterestRate.getId());
        assertEquals(customerDTO.getName(), customerWithInterestRate.getName());
        assertEquals(customerDTO.getAddress(), customerWithInterestRate.getAddress());
        assertEquals(customerDTO.getCreditScore(), customerWithInterestRate.getCreditScore());
        assertEquals(4.0, customerWithInterestRate.getInterestRate());
    }

}
