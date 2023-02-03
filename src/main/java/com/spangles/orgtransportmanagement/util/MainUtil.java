package com.spangles.orgtransportmanagement.util;

import com.spangles.orgtransportmanagement.dto.PassengerDto;
import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.entity.Passenger;
import com.spangles.orgtransportmanagement.entity.Trip;
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
