package com.ma.orgtransportmanagement.dto;

import java.io.Serializable;

public class PassengerDto implements Serializable {
    private Long passengerId;
    private String passengerType;
    private Long idNumber;
    private String passengerName;
    private Long tripId;

    public PassengerDto(){

    }
    public PassengerDto(Long passengerId,String passengerType,Long idNumber,String passengerName,Long tripId){
        this.passengerId = passengerId;
        this.passengerType = passengerType;
        this.idNumber = idNumber;
        this.passengerName = passengerName;
        this.tripId = tripId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
