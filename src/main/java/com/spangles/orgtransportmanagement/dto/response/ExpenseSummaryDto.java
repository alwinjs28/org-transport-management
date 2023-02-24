package com.spangles.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class ExpenseSummaryDto implements Serializable {
    private String tripNames;
    private String vehicleName;
    private String vehicleNumber;
    private Double expenseTotal;
    private Integer noOfExpense;

    public ExpenseSummaryDto(){

    }
    public ExpenseSummaryDto(String tripNames, String vehicleName, String vehicleNumber, Double expenseTotal, Integer noOfExpense){
        this.tripNames = tripNames;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.expenseTotal = expenseTotal;
        this.noOfExpense = noOfExpense;

    }

    public String getTripNames() {
        return tripNames;
    }

    public void setTripNames(String tripName) {
        this.tripNames = tripName;
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

    public Double getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(Double expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    public Integer getNoOfExpense() {
        return noOfExpense;
    }

    public void setNoOfExpense(Integer noOfExpense) {
        this.noOfExpense = noOfExpense;
    }
}
