package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    public TripDto save(@RequestBody Trip trip){
        return tripService.save(trip);
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
