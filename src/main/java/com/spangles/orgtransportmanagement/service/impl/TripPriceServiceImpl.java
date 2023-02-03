package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.TripPriceDto;
import com.spangles.orgtransportmanagement.entity.TripPrice;
import com.spangles.orgtransportmanagement.repository.TripPriceRepository;
import com.spangles.orgtransportmanagement.service.TripPriceService;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripPriceServiceImpl implements TripPriceService {

    @Autowired
    TripPriceRepository tripPriceRepository;

    public TripPriceDto getTripPrice(Long tripPriceId){
        TripPrice getTripPrice = tripPriceRepository.getTripPrice(tripPriceId);
        TransportUtil transportUtil = new TransportUtil();
        TripPriceDto dtoGetResponse = transportUtil.convertEntityToDto(getTripPrice);

        return dtoGetResponse;
    }

    public TripPriceDto save(TripPrice tripPrice){
        TripPrice saveTripPrice = tripPriceRepository.save(tripPrice);
        TransportUtil transportUtil = new TransportUtil();
        TripPriceDto dtoSaveResponse = transportUtil.convertEntityToDto(saveTripPrice);

        return dtoSaveResponse;
    }

    @Override
    public TripPriceDto update(TripPrice tripPrice) {
        TripPrice updateTripPrice = tripPriceRepository.save(tripPrice);
        TransportUtil transportUtil = new TransportUtil();
        TripPriceDto dtoUpdateResponse = transportUtil.convertEntityToDto(updateTripPrice);
        return dtoUpdateResponse;
    }

    @Override
    public void delete(TripPrice tripPrice) {
        tripPriceRepository.delete(tripPrice);

    }

    @Override
    public TripPriceDto getTripPrice(String passengerType, Long tripId) {
        String s = "Hello";
        TripPrice tripPrice = tripPriceRepository.getTripPrice(passengerType,tripId);
        TransportUtil transportUtil = new TransportUtil();
        TripPriceDto dtoResponse = transportUtil.convertEntityToDto(tripPrice);

        return dtoResponse;
    }
}
