package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.entity.Vehicle;
import com.ma.orgtransportmanagement.repository.VehicleRepository;
import com.ma.orgtransportmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public Vehicle getVehicle(Long vehicleId) {
        return vehicleRepository.getVehicle(vehicleId);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
    @Override
    public List<Vehicle> getVehicleByVehicleType(String vehicleType){
       List <Vehicle> vehicles = vehicleRepository.getVehicleByVehicleType(vehicleType);
       List allVehicleDetails = new ArrayList<>();
       for (int i=0;i<vehicles.size();i++){
            Vehicle vehicle = vehicles.get(i);
            String vehicleTypes = vehicle.getVehicleType();
            Integer vehicleSeating = vehicle.getVehicleSeating();
            String vehicleName = vehicle.getVehicleName();
            allVehicleDetails.add(vehicleTypes);
            allVehicleDetails.add(vehicleSeating);
            allVehicleDetails.add(vehicleName);
       }
       return allVehicleDetails;
    }
}
