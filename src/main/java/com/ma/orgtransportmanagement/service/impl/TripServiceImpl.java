package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.repository.TripRepository;
import com.ma.orgtransportmanagement.service.TripService;
import com.ma.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;

    public TripDto getTrip(Long tripId){
        Trip getTrip = tripRepository.getTrip(tripId);
        TransportUtil transportUtil = new TransportUtil();
        TripDto dtoGetResponse = transportUtil.convertEntityToDto(getTrip);
        return dtoGetResponse;
    }
    public TripDto save(Trip trip){
        Trip saveTrip = tripRepository.save(trip);
        TransportUtil transportUtil = new TransportUtil();
        TripDto dtoSaveResponse = transportUtil.convertEntityToDto(saveTrip);
        return dtoSaveResponse;
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
