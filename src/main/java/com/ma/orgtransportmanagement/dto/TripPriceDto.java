package com.ma.orgtransportmanagement.dto;

import java.io.Serializable;

public class TripPriceDto implements Serializable {
    private Long tripPriceId;
    private Long tripId;
    private String passengerType;
    private Double totalAmount;

    public Long getTripPriceId() {
        return tripPriceId;
    }

    public void setTripPriceId(Long tripPriceId) {
        this.tripPriceId = tripPriceId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
