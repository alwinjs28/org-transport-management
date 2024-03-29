package com.spangles.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class SummaryDto implements Serializable {
    private Double totalAmountCollected;
    private Double totalBalanceAmount;
    private Long totalPersonsPaid;
    private Double totalAmount;

    public SummaryDto(){

    }

    public SummaryDto(Double totalAmountCollected, Double totalBalanceAmount, Long totalPersonsPaid, Double totalAmount){
        this.totalAmountCollected = totalAmountCollected;
        this.totalBalanceAmount = totalBalanceAmount;
        this.totalPersonsPaid = totalPersonsPaid;
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public void setTotalAmountCollected(Double totalAmountCollected) {
        this.totalAmountCollected = totalAmountCollected;
    }

    public Double getTotalBalanceAmount() {
        return totalBalanceAmount;
    }

    public void setTotalBalanceAmount(Double totalBalanceAmount) {
        this.totalBalanceAmount = totalBalanceAmount;
    }

    public Long getTotalPersonsPaid() {
        return totalPersonsPaid;
    }

    public void setTotalPersonsPaid(Long totalPersonsPaid) {
        this.totalPersonsPaid = totalPersonsPaid;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
