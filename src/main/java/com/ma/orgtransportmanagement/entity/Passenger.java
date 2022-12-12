package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "passenger_type")
    private String passengerType;

    @Column(name = "id_number")
    private Long idNumber;

    @Column(name = "passenger_name")
    private String passengerName;

    public Passenger(){

    }

    public Passenger(Long passengerId,String passengerType,Long idNumber, String passengerName){
        this.passengerId = passengerId;
        this.passengerType = passengerType;
        this.idNumber = idNumber;
        this.passengerName = passengerName;
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
}
