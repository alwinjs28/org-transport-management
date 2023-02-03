package com.spangles.orgtransportmanagement.controller;

import com.spangles.orgtransportmanagement.dto.TripDto;
import com.spangles.orgtransportmanagement.dto.response.TripResponseWrapperDto;
import com.spangles.orgtransportmanagement.entity.Trip;
import com.spangles.orgtransportmanagement.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "trip")
@RestController
public class TripController {
    @Autowired
    TripService tripService;
    @RequestMapping(value = "/get_trip",method = RequestMethod.GET)
    @ResponseBody
    public TripDto getTripByQueryParam(@RequestParam("trip_id") Long tripId){
        return tripService.getTrip(tripId);
    }
    @RequestMapping(value = "/get_trip/{trip_id}",method = RequestMethod.GET)
    @ResponseBody
    public TripDto getTripByPathParam(@PathVariable("trip_id")Long tripId){
        return tripService.getTrip(tripId);
    }
    @RequestMapping(value = "/s_trip",method = RequestMethod.POST)
    @ResponseBody
    public TripResponseWrapperDto save(@RequestBody TripDto tripDto){
        return tripService.save(tripDto);
    }
    @RequestMapping(value = "/u_trip",method = RequestMethod.PUT)
    @ResponseBody
    public TripDto update(@RequestBody Trip trip){
        return tripService.update(trip);
    }
    @RequestMapping(value = "d_trip",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Trip trip){
        tripService.delete(trip);
    }
}
