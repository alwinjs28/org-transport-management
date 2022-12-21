package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "busFees")
public class BusFees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_fees_id")
    private Long busFeesId;

    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "due_amount")
    private Double dueAmount;
    @Column(name = "paid_date")
    private Date paidDate;

    public BusFees(){

    }
    public BusFees(Long busFeesId,Long passengerId,Double totalAmount,Double paidAmount,Double dueAmount,Date paidDate){
        this.busFeesId = busFeesId;
        this.passengerId = passengerId;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.paidDate = paidDate;
    }

    public Long getBusFeesId() {
        return busFeesId;
    }

    public void setBusFeesId(Long busFeesId) {
        this.busFeesId = busFeesId;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Long getBusTypeId() {
        return busFeesId;
    }

    public void setBusTypeId(Long busTypeId) {
        this.busFeesId = busTypeId;
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
