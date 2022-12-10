package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.entity.TripPrice;

public interface TripPriceService {
    public TripPriceDto getTripPrice(Long tripPriceId);
    public TripPriceDto save(TripPrice tripPrice);
    public TripPriceDto update(TripPrice tripPrice);
    public void delete(TripPrice tripPrice);

}
