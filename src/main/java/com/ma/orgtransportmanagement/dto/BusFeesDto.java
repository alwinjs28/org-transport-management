package com.ma.orgtransportmanagement.dto;

import java.io.Serializable;
import java.util.Date;

public class BusFeesDto implements Serializable {

    private Long busFeesId;
    private Long passengerId;
    private Double totalAmount;
    private Double paidAmount;
    private Double dueAmount;
    private Date paidDate;

    public BusFeesDto(){

    }
    public BusFeesDto(Long busFeesId,Long passengerId,Double totalAmount,Double paidAmount,Double dueAmount,Date paidDate){
        this.busFeesId = busFeesId;
        this.passengerId =passengerId;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.paidDate = paidDate;
    }


    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Long getBusFeesId() {
        return busFeesId;
    }

    public void setBusFeesId(Long busFeesId) {
        this.busFeesId = busFeesId;
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
