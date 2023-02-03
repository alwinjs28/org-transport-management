package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.dto.response.TripResponseWrapperDto;
import com.spangles.orgtransportmanagement.entity.Trip;

public interface TripService {
    public TripDto getTrip(Long tripId);

    public TripResponseWrapperDto save(TripDto tripDto);
    public TripDto update(Trip trip);
    public void delete(Trip trip);
}
