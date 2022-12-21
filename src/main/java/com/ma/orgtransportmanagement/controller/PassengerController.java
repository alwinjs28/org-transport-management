package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.response.PassengerResponseWrapperDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "passenger")
@RestController
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @RequestMapping(value = "g_passenger",method = RequestMethod.GET)
    @ResponseBody
    public PassengerResponseWrapperDto getPassenger(@RequestParam("passenger_id")Long passengerId){
        return passengerService.getPassenger(passengerId);
    }

    @RequestMapping(value = "s_passenger",method = RequestMethod.POST)
    @ResponseBody
    public PassengerDto savePassenger(@RequestBody PassengerDto passengerDto){
        return passengerService.savePassenger(passengerDto);
    }

    @RequestMapping(value = "u_passenger",method = RequestMethod.PUT)
    @ResponseBody
    public PassengerDto updatePassenger(@RequestBody Passenger passenger){
        return passengerService.updatePassenger(passenger);
    }

    @RequestMapping(value = "d_passenger",method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePassenger(@RequestBody Passenger passenger){
        passengerService.delete(passenger);
    }

}

