package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle getVehicle(Long vehicleId);
    public Vehicle save(Vehicle vehicle);
    public  Vehicle update(Vehicle vehicle);
    public void delete(Vehicle vehicle);
    public List<Vehicle> getVehicleByVehicleType(String vehicleType);

}
