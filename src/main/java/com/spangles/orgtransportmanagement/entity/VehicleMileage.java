package com.spangles.orgtransportmanagement.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;


@Entity
@Table(name = "vehicleMileage")
public class VehicleMileage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_mileage_id")
    private Long vehicleMileageId;
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "km_per_liter")
    private Float kmPerLiter;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "last_fc")
    private Date lastFc;

    public VehicleMileage(){

    }
    public VehicleMileage(Long vehicleMileageId,Long vehicleId,Float kmPerLiter,Date createdOn,Date lastFc){
        this.vehicleMileageId = vehicleMileageId;
        this.vehicleId = vehicleId;
        this.kmPerLiter = kmPerLiter;
        this.createdOn = createdOn;
        this.lastFc = lastFc;
    }

    public Long getVehicleMileageId() {
        return vehicleMileageId;
    }

    public void setVehicleMileageId(Long vehicleMileageId) {
        this.vehicleMileageId = vehicleMileageId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Float getKmPerLiter() {
        return kmPerLiter;
    }

    public void setKmPerLiter(Float kmPerLiter) {
        this.kmPerLiter = kmPerLiter;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastFc() {
        return lastFc;
    }

    public void setLastFc(Date lastFc) {
        this.lastFc = lastFc;
    }
}
