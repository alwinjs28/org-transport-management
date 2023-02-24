package com.spangles.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class ProfitDto implements Serializable {
    private String tripName;
    private Double amount;
    private Double expense;
    private Double profit;
    private String vehicleName;
    private String vehicleNumber;

    public ProfitDto(){

    }

    public ProfitDto(String tripName, Double amount, Double expense, Double profit, String vehicleName, String vehicleNumber) {
        this.tripName = tripName;
        this.amount = amount;
        this.expense = expense;
        this.profit = profit;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
