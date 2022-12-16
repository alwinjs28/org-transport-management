package com.ma.orgtransportmanagement.dto;

import java.io.Serializable;

public class BusFeesDto implements Serializable {

    private Long busTypeId;
    private Long passengerId;
    private Double totalAmount;
    private Double paidAmount;
    private Double dueAmount;

    public BusFeesDto(){

    }
    public BusFeesDto(Long busTypeId,Long passengerId,Double totalAmount,Double paidAmount,Double dueAmount){
        this.busTypeId = busTypeId;
        this.passengerId =passengerId;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
    }

    public Long getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(Long busTypeId) {
        this.busTypeId = busTypeId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }
}
