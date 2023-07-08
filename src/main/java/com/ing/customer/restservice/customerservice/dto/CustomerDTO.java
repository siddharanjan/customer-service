package com.ing.customer.restservice.customerservice.dto;

public class CustomerDTO {
    private long id;
    private String name;
    private String address;
    private String creditScore;
    private String interestRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public CustomerDTO(long id, String name, String address, String creditScore, String interestRate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creditScore = creditScore;
        this.interestRate = interestRate;
    }
}
