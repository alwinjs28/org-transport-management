package com.ma.orgtransportmanagement.util;

import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Trip;


public class TransportUtil {

    public TripDto convertEntityToDto(Trip trip){
       TripDto tripDto = new TripDto();

       tripDto.setTripId(trip.getTripId());
       tripDto.setVehicleId(trip.getVehicleId());
       tripDto.setTripName(trip.getTripName());
       tripDto.setFromPlace(trip.getFromPlace());
       tripDto.setToPlace(trip.getToPlace());
       tripDto.setNumberOfKm(trip.getNumberOfKm());
       tripDto.setNoOfPassenger(trip.getNoOfPassenger());
       return tripDto;
    }
}
