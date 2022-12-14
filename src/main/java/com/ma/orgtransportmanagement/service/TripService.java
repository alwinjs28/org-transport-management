package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Trip;

public interface TripService {
    public TripDto getTrip(Long tripId);

    public TripDto save(Trip trip);
    public TripDto update(Trip trip);
    public void delete(Trip trip);
}
