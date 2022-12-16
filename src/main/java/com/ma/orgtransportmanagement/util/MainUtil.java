package com.ma.orgtransportmanagement.util;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.entity.Trip;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainUtil {
    public TripDto convertEntityToDto(Trip trip){

        log.info("Main Util convertEntityToDto Tip called");
        TripDto tripDto = new TripDto();

        tripDto.setTripId(trip.getTripId());
        return tripDto;
    }

    public PassengerDto convertEntityToDto(Passenger passenger) {
        return null;
    }

}
