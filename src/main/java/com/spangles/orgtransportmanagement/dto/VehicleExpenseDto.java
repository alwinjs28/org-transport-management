package com.spangles.orgtransportmanagement.dto;

import java.io.Serializable;
import java.util.Date;

public class VehicleExpenseDto implements Serializable {
    private Long expenseId;
    private Long vehicleId;
    private Long tripId;
    private String expenseName;
    private Double amount;
    private String createdBy;
    private Date createdOn;
    private Float fuel;

    public VehicleExpenseDto(){

    }
    public VehicleExpenseDto(Long expenseId,Long vehicleId,Long tripId,String expenseName,Double amount,String createdBy,Date createdOn,Float fuel){
        this.expenseId = expenseId;
        this.vehicleId = vehicleId;
        this.tripId = tripId;
        this.expenseName = expenseName;
        this.amount = amount;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.fuel = fuel;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Float getFuel() {
        return fuel;
    }

    public void setFuel(Float fuel) {
        this.fuel = fuel;
    }
}
