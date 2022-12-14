package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.entity.Passenger;

public interface PassengerService {
    public PassengerDto getPassenger(Long passengerId);
    public PassengerDto savePassenger(PassengerDto passengerDto);
    public PassengerDto updatePassenger(Passenger passenger);
    public void delete(Passenger passenger);
    public String getStudentName(Long passengerId);


}
