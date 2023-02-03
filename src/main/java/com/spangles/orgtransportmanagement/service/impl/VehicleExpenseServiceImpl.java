package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleExpenseWrapperDto;
import com.spangles.orgtransportmanagement.entity.Vehicle;
import com.spangles.orgtransportmanagement.entity.VehicleExpense;
import com.spangles.orgtransportmanagement.repository.VehicleExpenseRepository;
import com.spangles.orgtransportmanagement.service.TripService;
import com.spangles.orgtransportmanagement.service.VehicleExpenseService;
import com.spangles.orgtransportmanagement.service.VehicleService;
import com.spangles.orgtransportmanagement.util.Constants;
import com.spangles.orgtransportmanagement.util.HttpStatus;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j

@Service
public class VehicleExpenseServiceImpl implements VehicleExpenseService {
    @Autowired
    VehicleExpenseRepository vehicleExpenseRepository;
    @Value("${expense.names}")
    private String expenseNames;
    @Value("${fuel.limit}")
    private Integer fuelLimit;

    @Autowired
    VehicleService vehicleService;
    @Autowired
    TripService tripService;
    @Override
    public VehicleExpenseDto getVehicleExpense(Long expenseId) {
        VehicleExpense vehicleExpense = vehicleExpenseRepository.getVehiclesExpense(expenseId);
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpenseDto vehicleExpenseDto = transportUtil.convertingEntityToDto(vehicleExpense);
        return vehicleExpenseDto;
    }

    @Override
    public VehicleExpenseWrapperDto saveVehicleExpense(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);

        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        VehicleExpenseWrapperDto vehicleExpenseWrapperDto = new VehicleExpenseWrapperDto();
        TripDto tripDto = tripService.getTrip(vehicleExpense.getTripId());

        Vehicle vehicle = vehicleService.getVehicle(vehicleExpense.getVehicleId());
        if (vehicleExpense.getVehicleId() == null){
            additionalHeaderDto.setMessage(Constants.INPUT_NOT_GIVEN);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        }else if(vehicle == null) {

            additionalHeaderDto.setMessage(Constants.VEHICLE_ID_NOT_FOUND + vehicleExpense.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.NO_FOUND.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
        }else if(vehicleExpense.getTripId() != null && tripDto == null) {

            additionalHeaderDto.setMessage(Constants.TRIP_ID + vehicleExpense.getTripId());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        }
        else if (vehicleExpense.getAmount() != null && vehicleExpense.getAmount() < 0) {
            additionalHeaderDto.setMessage(Constants.BELOW_AMOUNT + vehicleExpense.getAmount());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else if (vehicleExpense.getFuel() != null && vehicleExpense.getFuel() > fuelLimit) {
            additionalHeaderDto.setMessage(Constants.THE_FUEL_LIMIT + vehicleExpense.getFuel());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else if (!checkExpenseName(vehicleExpense.getExpenseName())) {

            additionalHeaderDto.setMessage(Constants.EXPENSE_NAME + vehicleExpense.getExpenseName());
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

        } else {
            TransportUtil transportUtilReference = new TransportUtil();
            Date todaysDate = new Date();
            vehicleExpense.setCreatedOn(todaysDate);
            VehicleExpense saveVehicleExpense = vehicleExpenseRepository.save(vehicleExpense);
            VehicleExpenseDto vehicleExpenseDtoResponse = transportUtilReference.convertingEntityToDto(saveVehicleExpense);
            additionalHeaderDto.setMessage(Constants.VEHICLE_ID + vehicleExpense.getVehicleId());
            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
            vehicleExpenseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            vehicleExpenseWrapperDto.setVehicleExpenseDto(vehicleExpenseDtoResponse);
        }
        return vehicleExpenseWrapperDto;
    }



    @Override
    public VehicleExpenseDto updateVehicleExpense(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);
        VehicleExpense vehicleExpenseEntity = vehicleExpenseRepository.save(vehicleExpense);
        VehicleExpenseDto vehicleExpenseDtoResponse = transportUtil.convertingEntityToDto(vehicleExpenseEntity);
        return vehicleExpenseDtoResponse;
    }

    @Override
    public void delete(VehicleExpenseDto vehicleExpenseDto) {
        TransportUtil transportUtil = new TransportUtil();
        VehicleExpense vehicleExpense = transportUtil.convertDtoToEntity(vehicleExpenseDto);
        vehicleExpenseRepository.delete(vehicleExpense);
    }
    public boolean checkExpenseName(String expenseName){
        String splitExpenseName[] = expenseNames.split(",");
        boolean inputExpenseName = false;
        for (String expenseNames : splitExpenseName){
            log.info("name : {}", expenseName);
            if (expenseName.equals(expenseNames)) {
                inputExpenseName = true;
            }
        }
        return inputExpenseName;
    }
}
