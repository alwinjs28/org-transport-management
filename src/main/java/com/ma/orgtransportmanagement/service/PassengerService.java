package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.dto.response.PassengerResponseWrapperDto;
import com.ma.orgtransportmanagement.entity.Passenger;

public interface PassengerService {
    public PassengerResponseWrapperDto getPassenger(Long passengerId);
    public PassengerDto savePassenger(PassengerDto passengerDto);
    public PassengerDto updatePassenger(Passenger passenger);
    public void delete(Passenger passenger);
    public String getStudentName(Long passengerId);

    public String getStaffName(Long passengerId);
}
