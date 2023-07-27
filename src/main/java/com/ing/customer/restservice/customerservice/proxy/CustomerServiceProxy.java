package com.ing.customer.restservice.customerservice.proxy;

import com.ing.customer.restservice.customerservice.dto.InterestRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="interest-rate-service")
public interface CustomerServiceProxy {

    @GetMapping("/api/v1/interest-rates/{creditScore}")
    public ResponseEntity<InterestRateDTO> getInterestRate(@PathVariable String creditScore);
}
