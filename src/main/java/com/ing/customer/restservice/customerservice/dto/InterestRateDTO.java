package com.ing.customer.restservice.customerservice.dto;

/**
 * The InterestRateDTO class is a bean class that is used to store and transfer interest rate details
 *
 *
 * @author Sid
 */
public class InterestRateDTO {

    private String creditScore;
    private double interestRate;

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public InterestRateDTO(String creditScore, double interestRate) {
        this.creditScore = creditScore;
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "InterestRateDTO{" +
                "creditScore='" + creditScore + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }

    public InterestRateDTO() {
    }
}
