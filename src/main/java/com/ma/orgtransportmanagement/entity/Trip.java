package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "trip_table")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "from_place")
    private String fromPlace;

    @Column(name = "to_place")
    private String toPlace;

    @Column(name = "number_of_km")
    private Double numberOfKm;

    @Column(name = "no_of_passenger")
    private Integer noOfPassenger;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Double getNumberOfKm() {
        return numberOfKm;
    }

    public void setNumberOfKm(Double numberOfKm) {
        this.numberOfKm = numberOfKm;
    }

    public Integer getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(Integer noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }
}
