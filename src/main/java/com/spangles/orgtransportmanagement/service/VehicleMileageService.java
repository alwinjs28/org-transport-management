package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.VehicleMileageDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleMileageWrapperDto;

public interface VehicleMileageService {

    public VehicleMileageDto getVehicleMileage(Long vehicleMileageId);
    public VehicleMileageWrapperDto saveVehicleMileage(VehicleMileageDto vehicleMileageDto);
    public VehicleMileageDto updateVehicleMileage(VehicleMileageDto vehicleMileageDto);
    public void deleteVehicleMileage(VehicleMileageDto vehicleMileageDto);
}
