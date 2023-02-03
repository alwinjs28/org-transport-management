package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.PassengerDto;
import com.spangles.orgtransportmanagement.dto.response.PassengerResponseWrapperDto;
import com.spangles.orgtransportmanagement.dto.response.TotalCollectionWrapperDto;
import com.spangles.orgtransportmanagement.entity.Passenger;

public interface PassengerService {
    public PassengerResponseWrapperDto getPassenger(Long passengerId);
    public PassengerDto savePassenger(PassengerDto passengerDto);
    public PassengerDto updatePassenger(Passenger passenger);
    public void delete(Passenger passenger);
    public String getStudentName(Long passengerId);

    public String getStaffName(Long passengerId);
    public TotalCollectionWrapperDto getTotalCollection(String passengerType);
    public TotalCollectionWrapperDto getTotalCollectionByTripId(Long tripId);
}
