package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.entity.Vehicle;
import com.ma.orgtransportmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(path = "vehicle")
@RestController
public class VehicleController {
     @Autowired
     VehicleService vehicleService;
     @RequestMapping(value = "g_vehicle",method = RequestMethod.GET)
     @ResponseBody
     public Vehicle getVehicle(@RequestParam("vehicle_id") Long vehicleId){
          return vehicleService.getVehicle(vehicleId);
     }
     @RequestMapping(value = "s_vehicle",method = RequestMethod.POST)
     @ResponseBody
     public Vehicle save(@RequestBody Vehicle vehicle){
          return vehicleService.save(vehicle);
     }
     @RequestMapping(value = "u_vehicle",method = RequestMethod.PUT)
     @ResponseBody
     public Vehicle update(@RequestBody Vehicle vehicle){
          return vehicleService.update(vehicle);
     }
     @RequestMapping(value = "d_vehicle",method = RequestMethod.DELETE)
     @ResponseBody
     public void delete(@RequestBody Vehicle vehicle){
          vehicleService.delete(vehicle);
     }
     @RequestMapping(value = "g_vehicle_by_type",method = RequestMethod.GET)
     @ResponseBody
     public List<Vehicle> getVehicleByVehicleType(@RequestParam ("vehicle_type") String vehicleType){
          return vehicleService.getVehicleByVehicleType(vehicleType);
     }
}
