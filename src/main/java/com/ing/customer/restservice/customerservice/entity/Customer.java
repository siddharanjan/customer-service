package com.ing.customer.restservice.customerservice.entity;

import jakarta.persistence.*;

/**
 * The Customer class is an entity class that is used to store customer details in the database
 *
 *
 * @author Sid
 */
@Entity(name = "customer_details")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "credit_score")
    private String creditScore;

    public Customer() {
    }

    // Constructor without the customerId parameter
    public Customer(String name, String address, String creditScore) {
        this.name = name;
        this.address = address;
        this.creditScore = creditScore;
    }

    // Getters and setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", creditScore='" + creditScore + '\'' +
                '}';
    }
}
