package com.ing.customer.restservice.customerservice.controller;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.dto.InterestRateDTO;
import com.ing.customer.restservice.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/")
public class CustomerServiceController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    public CustomerDTO getCustomerDetailsWithInterestRate(@PathVariable long id) {
        CustomerDTO customerDTO = getCustomerById(id);
        String url = "http://localhost:8080/api/v1/interest-rates/" + customerDTO.getCreditScore();
        InterestRateDTO interestRate = restTemplate.getForObject(url, InterestRateDTO.class);
        return interestRate;
        return null;
    }

    private CustomerDTO getCustomerById(long id) {
       return customerService.getCustomerById(id);
    }


}
