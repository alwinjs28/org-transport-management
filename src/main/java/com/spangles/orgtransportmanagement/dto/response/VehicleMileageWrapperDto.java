package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.VehicleMileageDto;

import java.io.Serializable;

public class VehicleMileageWrapperDto implements Serializable {
    private VehicleMileageDto vehicleMileageDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public VehicleMileageWrapperDto(){

    }
    public VehicleMileageWrapperDto(VehicleMileageDto vehicleMileageDto,AdditionalHeaderDto additionalHeaderDto){
        this.vehicleMileageDto = vehicleMileageDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public VehicleMileageDto getVehicleMileageDto() {
        return vehicleMileageDto;
    }

    public void setVehicleMileageDto(VehicleMileageDto vehicleMileageDto) {
        this.vehicleMileageDto = vehicleMileageDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
