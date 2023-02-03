package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.VehicleMileageDto;
import com.spangles.orgtransportmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleMileageWrapperDto;
import com.spangles.orgtransportmanagement.entity.Vehicle;
import com.spangles.orgtransportmanagement.entity.VehicleExpense;
import com.spangles.orgtransportmanagement.entity.VehicleMileage;
import com.spangles.orgtransportmanagement.repository.VehicleMileageRepository;
import com.spangles.orgtransportmanagement.service.VehicleMileageService;
import com.spangles.orgtransportmanagement.service.VehicleService;
import com.spangles.orgtransportmanagement.util.Constants;
import com.spangles.orgtransportmanagement.util.HttpStatus;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VehicleMileageServiceImpl implements VehicleMileageService {

    @Value("${km.per.liter}")
    private Integer kmPerLiter;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleMileageRepository vehicleMileageRepository;
    @Override
    public VehicleMileageDto getVehicleMileage(Long vehicleMileageId) {
        VehicleMileage vehicleMileage = vehicleMileageRepository.getVehicleMileage(vehicleMileageId);
        TransportUtil transportUtil = new TransportUtil();
        VehicleMileageDto vehicleMileageDto =transportUtil.convertingEntityToDto(vehicleMileage);

        return vehicleMileageDto;
    }

    @Override
    public VehicleMileageWrapperDto saveVehicleMileage(VehicleMileageDto vehicleMileageDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleMileageWrapperDto vehicleMileageWrapperDto = new VehicleMileageWrapperDto();
        VehicleMileage vehicleMileage = transportUtil.convertingDtoToEntity(vehicleMileageDto);
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        Vehicle vehicle = vehicleService.getVehicle(vehicleMileage.getVehicleId());

        if (vehicleMileage.getVehicleId() ==null){
            additionalHeaderDto.setMessage(Constants.INPUT_NOT_GIVEN);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleMileageWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        }else if(vehicle == null){
            additionalHeaderDto.setMessage(Constants.VEHICLE_ID_NOT_FOUND + vehicleMileage.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.NO_FOUND.statusCode());
            vehicleMileageWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        }else if (vehicleMileage.getKmPerLiter() < 0 ||vehicleMileage.getKmPerLiter() > kmPerLiter){
            additionalHeaderDto.setMessage(Constants.KM_PER_LITER + vehicleMileage.getKmPerLiter());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.NO_FOUND.statusCode());
            vehicleMileageWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        }else {
            TransportUtil transportUtilReference = new TransportUtil();
            Date todaysDate = new Date();
            vehicleMileage.setCreatedOn(todaysDate);
            VehicleMileage saveVehicleMileage = vehicleMileageRepository.save(vehicleMileage);
            VehicleMileageDto vehicleMileageDtoResponse = transportUtilReference.convertingEntityToDto(saveVehicleMileage);
            additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleMileage.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
            vehicleMileageWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            vehicleMileageWrapperDto.setVehicleMileageDto(vehicleMileageDtoResponse);
        }

        return vehicleMileageWrapperDto;
    }

    @Override
    public VehicleMileageDto updateVehicleMileage(VehicleMileageDto vehicleMileageDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleMileage vehicleMileage = transportUtil.convertingDtoToEntity(vehicleMileageDto);
        VehicleMileage vehicleMileageResponse = vehicleMileageRepository.save(vehicleMileage);
        VehicleMileageDto vehicleMileageDtoResponse = transportUtil.convertingEntityToDto(vehicleMileageResponse);
        return vehicleMileageDtoResponse;
    }

    @Override
    public void deleteVehicleMileage(VehicleMileageDto vehicleMileageDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleMileage vehicleMileage = transportUtil.convertingDtoToEntity(vehicleMileageDto);
        vehicleMileageRepository.delete(vehicleMileage);
    }
}
