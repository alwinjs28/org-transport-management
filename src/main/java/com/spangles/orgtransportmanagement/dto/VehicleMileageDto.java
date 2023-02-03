package com.spangles.orgtransportmanagement.dto;

import java.io.Serializable;
import java.util.Date;

public class VehicleMileageDto implements Serializable {
    private Long vehicleMileageId;
    private Long vehicleId;
    private Float kmPerLiter;
    private Date dateOfFc;
    private Date lastFc;

    public VehicleMileageDto(){

    }
    public VehicleMileageDto(Long vehicleMileageId,Long vehicleId,Float kmPerLiter,Date dateOfFc,Date lastFc){
        this.vehicleMileageId = vehicleMileageId;
        this.vehicleId = vehicleId;
        this.kmPerLiter = kmPerLiter;
        this.dateOfFc = dateOfFc;
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

    public Date getDateOfFc() {
        return dateOfFc;
    }

    public void setDateOfFc(Date dateOfFc) {
        this.dateOfFc = dateOfFc;
    }

    public Date getLastFc() {
        return lastFc;
    }

    public void setLastFc(Date lastFc) {
        this.lastFc = lastFc;
    }
}
