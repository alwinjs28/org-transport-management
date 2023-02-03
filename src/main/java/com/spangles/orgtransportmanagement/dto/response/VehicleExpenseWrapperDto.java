package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;

import java.io.Serializable;

public class VehicleExpenseWrapperDto implements Serializable {
    private VehicleExpenseDto vehicleExpenseDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public VehicleExpenseWrapperDto(){

    }
    public VehicleExpenseWrapperDto(VehicleExpenseDto vehicleExpenseDto,AdditionalHeaderDto additionalHeaderDto){
        this.vehicleExpenseDto = vehicleExpenseDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public VehicleExpenseDto getVehicleExpenseDto() {
        return vehicleExpenseDto;
    }

    public void setVehicleExpenseDto(VehicleExpenseDto vehicleExpenseDto) {
        this.vehicleExpenseDto = vehicleExpenseDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
