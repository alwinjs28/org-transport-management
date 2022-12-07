package com.ma.orgtransportmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @Column(name = "vehicle_seating")
    private Integer vehicleSeating;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Integer getVehicleSeating() {
        return vehicleSeating;
    }

    public void setVehicleSeating(Integer vehicleSeating) {
        this.vehicleSeating = vehicleSeating;
    }
}
