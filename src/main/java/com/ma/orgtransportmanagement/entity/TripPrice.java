package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "tripPrice")
public class TripPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "trip_price_id")
    private Long tripPriceId;

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "passenger_type")
    private String passengerType;

    @Column(name = "total_amount")
    private Double totalAmount;
    public TripPrice(){

    }

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
