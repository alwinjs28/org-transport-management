package com.spangles.orgtransportmanagement.controller;

import com.spangles.orgtransportmanagement.dto.VehicleMileageDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleMileageWrapperDto;
import com.spangles.orgtransportmanagement.service.VehicleMileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "vehicleMileage")
@RestController
public class VehicleMileageController {
    @Autowired
    VehicleMileageService vehicleMileageService;

    @RequestMapping(value = "g_vehicle_mileage/{vehicle_mileage_id}",method = RequestMethod.GET)
    @ResponseBody
    public VehicleMileageDto getVehicleMileage(@PathVariable("vehicle_mileage_id") Long vehicleMileageId){
        return vehicleMileageService.getVehicleMileage(vehicleMileageId);
    }
    @RequestMapping(value = "/s_vehicle_mileage",method = RequestMethod.POST)
    @ResponseBody
    public VehicleMileageWrapperDto saveVehicleMileage(@RequestBody VehicleMileageDto vehicleMileageDto){
        return vehicleMileageService.saveVehicleMileage(vehicleMileageDto);
    }
    @RequestMapping(value = "/u_vehicle_mileage",method = RequestMethod.PUT)
    @ResponseBody
    public VehicleMileageDto updateVehicleMileage(@RequestBody VehicleMileageDto vehicleMileageDto){
        return vehicleMileageService.updateVehicleMileage(vehicleMileageDto);
    }
    @RequestMapping(value = "/d_vehicle_mileage",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody VehicleMileageDto vehicleMileageDto){
        vehicleMileageService.deleteVehicleMileage(vehicleMileageDto);
    }
}
