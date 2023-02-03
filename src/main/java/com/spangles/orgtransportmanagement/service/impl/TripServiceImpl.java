package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgtransportmanagement.dto.response.TripResponseWrapperDto;
import com.spangles.orgtransportmanagement.entity.Trip;
import com.spangles.orgtransportmanagement.entity.Vehicle;
import com.spangles.orgtransportmanagement.repository.TripRepository;
import com.spangles.orgtransportmanagement.service.TripService;
import com.spangles.orgtransportmanagement.service.VehicleService;
import com.spangles.orgtransportmanagement.util.Constants;
import com.spangles.orgtransportmanagement.util.HttpStatus;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;
    @Autowired
    VehicleService vehicleService;
    @Value("${numberOfPassengerLimit}")
    private Integer numberOfPassengerLimit;

    public TripDto getTrip(Long tripId){
        Trip trip = tripRepository.getTrip(tripId);
        TripDto tripDto = null;
        if(trip != null) {
            TransportUtil transportUtil = new TransportUtil();
            tripDto = transportUtil.convertEntityToDto(trip);
        }
        return tripDto;
    }
    public TripResponseWrapperDto save(TripDto tripDto){
        TransportUtil transportUtil = new TransportUtil();
        Trip trip = transportUtil.convertDtoToEntity(tripDto);

        Vehicle vehicle = vehicleService.getVehicle(trip.getVehicleId());

        TripResponseWrapperDto tripResponseWrapperDto = new TripResponseWrapperDto();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        if(vehicle != null) {
            if (vehicle.getVehicleId() == null || trip.getVehicleId() > vehicle.getVehicleId()) {
                additionalHeaderDto.setMessage(Constants.VEHICLE_ID_NOT_FOUND + trip.getVehicleId());
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                tripResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            } else if (trip.getNoOfPassenger() > numberOfPassengerLimit) {
                additionalHeaderDto.setMessage(Constants.ABOVE_PASSENGER_LIMIT + trip.getNoOfPassenger());
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                tripResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            } else if (trip.getNoOfPassenger() < 0) {
                additionalHeaderDto.setMessage(Constants.BELOW_PASSENGER_LIMIT + trip.getNoOfPassenger());
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                tripResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            } else {
                TransportUtil transportReference = new TransportUtil();
                Trip saveTrip = tripRepository.save(trip);
                TripDto dtoSaveResponse = transportReference.convertEntityToDto(saveTrip);
                additionalHeaderDto.setMessage(Constants.VEHICLE_ID + saveTrip.getVehicleId());
                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
                tripResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                tripResponseWrapperDto.setTripDto(dtoSaveResponse);

            }
        }

        return tripResponseWrapperDto;
    }
    public TripDto update(Trip trip){
        Trip updateTrip = tripRepository.save(trip);
        TransportUtil transportUtil = new TransportUtil();
        TripDto dtoUpdateResponse = transportUtil.convertEntityToDto(updateTrip);
        return dtoUpdateResponse;
    }
    public void delete(Trip trip){
        tripRepository.delete(trip);
    }


}
