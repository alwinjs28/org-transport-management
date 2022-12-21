package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class TotalCollectionDto implements Serializable {
    private Double totalAmountCollected;
    private Double totalBalanceAmount;
    private Long totalStudentPaid;

    public TotalCollectionDto(){

    }

    public TotalCollectionDto(Double totalAmountCollected,Double totalBalanceAmount,Long totalStudentPaid){
        this.totalAmountCollected = totalAmountCollected;
        this.totalBalanceAmount = totalBalanceAmount;
        this.totalStudentPaid = totalStudentPaid;
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

    public Long getTotalStudentPaid() {
        return totalStudentPaid;
    }

    public void setTotalStudentPaid(Long totalStudentPaid) {
        this.totalStudentPaid = totalStudentPaid;
    }
}
