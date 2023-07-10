package com.ing.customer.restservice.customerservice.controller;

import com.ing.customer.restservice.customerservice.dto.CustomerDTO;
import com.ing.customer.restservice.customerservice.dto.InterestRateDTO;
import com.ing.customer.restservice.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * The CustomerServiceController class is a REST controller that provides endpoints for
 * retrieving customer details along with interest rates
 *
 * @author Sid
 */
@RestController
@RequestMapping("/api/v1/")
public class CustomerServiceController {

    @Autowired
    private CustomerService customerService;

    @Value("${interestRateServiceUrl}")
    public String interestRateServiceUrl;

    /**
     * Gets the customer details
     *
     * @param id The id of the customer.
     * @return A CustomerDTO object with the customer details.
     */
    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerDetailsWithInterestRate(@PathVariable long id) {

        //Get customer details from database
        CustomerDTO customerDTO = getCustomerById(id);

        //Using rest template for consuming interest rate service
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("creditScore", customerDTO.getCreditScore());
        String url = interestRateServiceUrl + "/{creditScore}";
        ResponseEntity<InterestRateDTO> response = new RestTemplate().getForEntity(url, InterestRateDTO.class, uriVariables);
        InterestRateDTO interestRateDTO = response.getBody();
        return new CustomerDTO(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getCreditScore(), interestRateDTO.getInterestRate());
    }



    /**
     * Gets the customer details from customer service
     *
     * @param id The id of the customer.
     * @return A CustomerDTO object with the customer details.
     */
    private CustomerDTO getCustomerById(long id) {
       return customerService.getCustomerById(id);
    }


}
