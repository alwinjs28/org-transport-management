package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.entity.TripPrice;
import com.ma.orgtransportmanagement.service.TripPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "TripPrice")
@RestController
public class TripPriceController {
    @Autowired
    TripPriceService tripPriceService;
    @RequestMapping(value = "g_trip_price",method = RequestMethod.GET)
    @ResponseBody
    public TripPriceDto getTripPrice(@RequestParam("trip_price_id") Long tripPriceId){
        return tripPriceService.getTripPrice(tripPriceId);
    }

    @RequestMapping(value = "s_trip_price",method = RequestMethod.POST)
    @ResponseBody
    public TripPriceDto saveTripPrice(@RequestBody TripPrice tripPrice){
        return tripPriceService.save(tripPrice);
    }

    @RequestMapping(value = "u_trip_price",method = RequestMethod.PUT)
    @ResponseBody
    public TripPriceDto updateTripPrice(@RequestBody TripPrice tripPrice){
        return tripPriceService.update(tripPrice);
    }

    @RequestMapping(value = "d_trip_price",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody TripPrice tripPrice){
        tripPriceService.delete(tripPrice);
    }
}
