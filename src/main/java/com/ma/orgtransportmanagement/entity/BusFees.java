package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "busFees")
public class BusFees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_type_id")
    private Long busTypeId;

    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "due_amount")
    private Double dueAmount;

    public BusFees(){

    }
    public BusFees(Long busTypeId,Long passengerId,Double totalAmount,Double paidAmount,Double dueAmount){
        this.busTypeId = busTypeId;
        this.passengerId = passengerId;
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
