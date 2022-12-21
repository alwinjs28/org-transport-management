package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.response.ResponseWrapperDto;
import com.ma.orgtransportmanagement.service.BusFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "busFees")
@RestController
public class BusFeesController {

        @Autowired
        BusFeesService busFeesService;
        @RequestMapping(value = "g_bus_fees/{bus_fees_id}",method = RequestMethod.GET)
        @ResponseBody
        public BusFeesDto getBusFees(@PathVariable("bus_fees_id")Long busFeesId){
            return busFeesService.getBusFees(busFeesId);
        }

        @RequestMapping(value = "s_bus_fees",method = RequestMethod.POST)
        @ResponseBody
        public BusFeesDto saveBusFees(@RequestBody BusFeesDto busFeesDto){
            return busFeesService.saveBusFees(busFeesDto);
        }

        @RequestMapping(value = "u_bus_fees",method = RequestMethod.PUT)
        @ResponseBody
        public BusFeesDto updateBusFees(@RequestBody BusFeesDto busFeesDto){
            return busFeesService.updateBusFees(busFeesDto);
        }

        @RequestMapping(value = "d_bus_fees",method = RequestMethod.DELETE)
        @ResponseBody
        public void deleteBusFees(@RequestBody BusFeesDto busFeesDto){
            busFeesService.deleteBusFees(busFeesDto);
        }

        @RequestMapping(value = "s_total_amount",method = RequestMethod.POST)
        @ResponseBody
        public ResponseWrapperDto saveTotalAmount(@RequestBody BusFeesDto busFeesDto){
            return busFeesService.saveTotalAmount(busFeesDto);
        }

    }


