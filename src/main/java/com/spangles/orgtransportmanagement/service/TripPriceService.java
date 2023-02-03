package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.TripPriceDto;
import com.spangles.orgtransportmanagement.entity.TripPrice;

public interface TripPriceService {
    public TripPriceDto getTripPrice(Long tripPriceId);
    public TripPriceDto save(TripPrice tripPrice);
    public TripPriceDto update(TripPrice tripPrice);
    public void delete(TripPrice tripPrice);

    public TripPriceDto getTripPrice(String passengerType,Long tripId);

}
